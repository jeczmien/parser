package pl.parser.nbp.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.parser.nbp.Utils;
import pl.parser.nbp.model.DirectoryEntryModel;
import pl.parser.nbp.model.DirectoryModel;

public class DirectoryParser {
	private static final Logger logger = LoggerFactory.getLogger(DirectoryParser.class);

	private static final String SEPARATOR = "z";
	private static final String START_CODE = "c";
	private static final String DATE_FORMAT = "yyMMdd";

	private DirectoryParser() {
		//
	}

	public static DirectoryModel parse(List<String> list, Date startDate, Date endDate) {
		DirectoryModel retVal = new DirectoryModel();
		for (String line : list) {
			if (isValidCode(line)) {
				DirectoryEntryModel entry = convert(line);
				if (entry.isValid() && isValidDate(entry.getTableDate(), startDate, endDate)) {
					retVal.getEntries().put(entry.getTableDate(), entry);
				}
			}
		}
		if (retVal.getEntries().size() > 0) {
			retVal.setYear(Utils.getYear(retVal.getEntries().keySet().iterator().next()));
		}
		return retVal;
	}

	private static boolean isValidCode(String line) {
		return StringUtils.startsWith(line, START_CODE);
	}

	private static boolean isValidDate(Date parsedDate, Date startDate, Date endDate) {
		return !startDate.after(parsedDate) && !parsedDate.after(endDate);
	}

	private static DirectoryEntryModel convert(String line) {
		DirectoryEntryModel retVal = new DirectoryEntryModel();
		String[] buffer = StringUtils.split(line, SEPARATOR);
		retVal.setEntry(line);
		if (buffer.length > 1) {
			retVal.setTableDate(parseDate(buffer[1]));
		}
		return retVal;
	}

	private static Date parseDate(String date) {
		try {
			return DateUtils.parseDate(date, DATE_FORMAT);
		} catch (ParseException e) {
			logger.error("error parsing date: " + date, e);
		}
		return null;
	}
}
