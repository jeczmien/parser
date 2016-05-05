package pl.parser.nbp.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.parser.nbp.model.DirectoryEntryModel;
import pl.parser.nbp.model.DirectoryModel;
import pl.parser.nbp.xml.TabelaKursow;

public class KursyLoader {

	private static final Logger logger = LoggerFactory.getLogger(KursyLoader.class);

	public List<TabelaKursow> getKursy(List<DirectoryModel> directories) {
		List<TabelaKursow> retVal = new ArrayList<>();
		for (DirectoryModel model : directories) {
			retVal.addAll(getEntries(model));
		}
		return retVal;
	}

	private List<TabelaKursow> getEntries(DirectoryModel model) {
		List<TabelaKursow> retVal = new ArrayList<>();
		for (DirectoryEntryModel entry : model.getEntries().values()) {
			try {
				URL url = createUrl(entry);
				TabelaKursow kursy = parseTabelaKursow(url);
				if (kursy != null) {
					retVal.add(kursy);
				}
			} catch (MalformedURLException e) {
				logger.error("Error creating URL", e);
			}
		}
		return retVal;
	}

	private URL createUrl(DirectoryEntryModel entry) throws MalformedURLException {
		return new URL(BaseNetworkParams.XML_FILE.format(new Object[] { entry.getEntry() }, new StringBuffer(), null)
				.toString());
	}

	private TabelaKursow parseTabelaKursow(URL url) {
		try {
			JAXBContext jc = JAXBContext.newInstance(TabelaKursow.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			return (TabelaKursow) unmarshaller.unmarshal(url);
		} catch (JAXBException e) {
			logger.error("Error loading jaxb context", e);
		}
		return null;
	}
}
