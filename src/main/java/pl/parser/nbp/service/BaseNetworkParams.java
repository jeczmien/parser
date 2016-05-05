package pl.parser.nbp.service;

import java.text.MessageFormat;

class BaseNetworkParams {
	static final String MAIN_URL = "http://www.nbp.pl/kursy/xml/";
	static final MessageFormat DIRECTORY = new MessageFormat(MAIN_URL + "dir{0}.txt");
	static final MessageFormat XML_FILE = new MessageFormat(MAIN_URL + "{0}.xml");
}
