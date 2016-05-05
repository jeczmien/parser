package pl.parser.nbp.service;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.parser.nbp.model.ParametersModel;

public class ParametersParser {
	private static final Logger logger = LoggerFactory.getLogger(ParametersParser.class);
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private static final int PARAM_NUMBER = 3;
	private static final int CURRENCY_INDEX = 0;
	private static final int START_DATE_INDEX = 1;
	private static final int END_DATE_INDEX = 2;

	private ParametersModel model = new ParametersModel();

	private ParametersParser() {
		//
	}

	public static ParametersModel parseParameters(String[] args) {
		ParametersParser parser = new ParametersParser();
		if (ArrayUtils.isNotEmpty(args) && args.length == PARAM_NUMBER) {
			parser.withCurrency(args[CURRENCY_INDEX]).withStartDate(args[START_DATE_INDEX])
					.withEndDate(args[END_DATE_INDEX]);
		} else {
			logger.error("Invalid parameters count");
		}
		return parser.build();
	}

	private ParametersParser withCurrency(String currency) {
		if (StringUtils.length(currency) == 3) {
			model.setCurrency(currency);
		} else {
			logger.error("Invalid currency parameter: ", currency);
		}
		return this;
	}

	private ParametersParser withStartDate(String date) {
		model.setStartDate(parseDate(date));
		return this;
	}

	private ParametersParser withEndDate(String date) {
		model.setEndDate(parseDate(date));
		return this;
	}

	private ParametersModel build() {
		return model;
	}

	private static Date parseDate(String date) {
		try {
			return DateUtils.parseDate(date, DATE_FORMAT);
		} catch (ParseException e) {
			logger.error("Error parsing date " + date, e);
		}
		return null;
	}
}
