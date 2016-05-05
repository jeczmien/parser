package pl.parser.nbp.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.CharSequenceReader;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.parser.nbp.Utils;
import pl.parser.nbp.model.DirectoryModel;

public class DirectoryLoader {

	private static final Logger logger = LoggerFactory.getLogger(DirectoryLoader.class);
	private static final int CURRENT_YEAR = Utils.getYear(new Date());

	public List<DirectoryModel> getDirectories(Date startDate, Date endDate) {
		List<DirectoryModel> retVal = new ArrayList<>();
		for (int i = Utils.getYear(startDate); i <= Utils.getYear(endDate); i++) {
			List<String> file = getDirectory(i);
			DirectoryModel model = DirectoryParser.parse(file, startDate, endDate);
			if (!model.getEntries().isEmpty()) {
				retVal.add(model);
			}
		}
		return retVal;
	}

	private List<String> getDirectory(int year) {
		URL url;
		List<String> retVal = Collections.emptyList();
		try {
			url = new URL(BaseNetworkParams.DIRECTORY.format(new Object[] { getYear(year) }, new StringBuffer(), null)
					.toString());
			byte[] buffer = IOUtils.toByteArray(url);
			retVal = IOUtils.readLines(new CharSequenceReader(new String(buffer)));
		} catch (MalformedURLException e) {
			logger.error("Error building url", e);
		} catch (IOException e) {
			logger.error("Error reading data", e);
		}
		return retVal;
	}

	private String getYear(int year) {
		if (year == CURRENT_YEAR) {
			return StringUtils.EMPTY;
		}
		return StringUtils.EMPTY + year;
	}
}
