package pl.parser.nbp.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DirectoryEntryModel {
	private String entry;
	private Date tableDate;
	
	public boolean isValid() {
		return tableDate != null && StringUtils.isNotBlank(entry);
	}
	
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	public Date getTableDate() {
		return tableDate;
	}
	public void setTableDate(Date tableDate) {
		this.tableDate = tableDate;
	}
}
