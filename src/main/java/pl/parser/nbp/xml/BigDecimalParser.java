package pl.parser.nbp.xml;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigDecimalParser {
	private static final Logger logger = LoggerFactory.getLogger(BigDecimalParser.class);

	private static DecimalFormat format;

	static {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(',');
		format = new DecimalFormat("#,#", symbols);
		format.setParseBigDecimal(true);
	}

	private BigDecimalParser() {
		//
	}

	public static String printBigDecimal(BigDecimal value) {
		if (value != null) {
			return format.format(value.doubleValue());
		}
		return null;
	}

	public static BigDecimal parseBigDecimal(String value) {
		try {
			return BigDecimal.valueOf(format.parse(value).doubleValue());
		} catch (ParseException e) {
			logger.error("Error parsing value: " + value, e);
		}
		return null;
	}

}
