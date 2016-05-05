package pl.parser.nbp.service;

import java.util.ArrayList;
import java.util.List;

import pl.parser.nbp.model.KursModel;
import pl.parser.nbp.xml.TabelaKursow;

public class KursSelector {

	public List<KursModel> selectKurs(List<TabelaKursow> kursy, String currency) {
		List<KursModel> retVal = new ArrayList<>();
		for (TabelaKursow tabela : kursy) {
			TabelaKursow.Pozycja pozycja = selectPozycja(tabela, currency);
			if (pozycja != null) {
				KursModel model = new KursModel();
				model.setKursKupna(pozycja.getKursKupna());
				model.setKursSprzedazy(pozycja.getKursSprzedazy());
				retVal.add(model);
			}
		}
		return retVal;
	}

	private TabelaKursow.Pozycja selectPozycja(TabelaKursow tabela, String currency) {
		for (TabelaKursow.Pozycja pozycja : tabela.getPozycja()) {
			if (pozycja.getKodWaluty().equalsIgnoreCase(currency)) {
				return pozycja;
			}
		}
		return null;
	}
}
