package pl.parser.nbp;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

import pl.parser.nbp.model.DirectoryModel;
import pl.parser.nbp.model.KursModel;
import pl.parser.nbp.model.ParametersModel;
import pl.parser.nbp.service.DirectoryLoader;
import pl.parser.nbp.service.KursSelector;
import pl.parser.nbp.service.KursyLoader;
import pl.parser.nbp.service.ParametersParser;
import pl.parser.nbp.service.StatisticProcessor;
import pl.parser.nbp.xml.TabelaKursow;

public class MainClass {

	private DirectoryLoader directoryLoader;
	private KursyLoader kursyLoader;
	private KursSelector kursSelector;
	private DecimalFormat formatter;

	private MainClass() {
		directoryLoader = new DirectoryLoader();
		kursyLoader = new KursyLoader();
		kursSelector = new KursSelector();
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(',');
		formatter = new DecimalFormat("0.0000", symbols);
	}

	public static void main(String[] args) {
		ParametersModel parameters = ParametersParser.parseParameters(args);
		if (parameters.isValid()) {
			MainClass main = new MainClass();
			main.process(parameters);
		}
	}

	private void process(ParametersModel parameters) {
		List<DirectoryModel> directories = getDirectories(parameters);
		List<TabelaKursow> tabela = getTabelaKursow(directories);
		List<KursModel> kursy = selectKurs(tabela, parameters.getCurrency());
		StatisticProcessor processor = new StatisticProcessor();
		processor.fillKursy(kursy);
		System.out.println(formatter.format(processor.getMeanKursKupna()));
		System.out.println(formatter.format(processor.getStandardDeviationKursSprzedazy()));
	}

	private List<DirectoryModel> getDirectories(ParametersModel parameters) {
		return directoryLoader.getDirectories(parameters.getStartDate(), parameters.getEndDate());
	}

	private List<TabelaKursow> getTabelaKursow(List<DirectoryModel> directories) {
		return kursyLoader.getKursy(directories);
	}

	private List<KursModel> selectKurs(List<TabelaKursow> tabela, String currency) {
		return kursSelector.selectKurs(tabela, currency);
	}
}
