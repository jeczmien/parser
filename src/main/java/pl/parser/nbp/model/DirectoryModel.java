package pl.parser.nbp.model;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class DirectoryModel {
	private int year;
	private final Map<Date, DirectoryEntryModel> entries = new TreeMap<>();

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Map<Date, DirectoryEntryModel> getEntries() {
		return entries;
	}

}
