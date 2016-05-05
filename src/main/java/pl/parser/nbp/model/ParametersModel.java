package pl.parser.nbp.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class ParametersModel {
	private String currency;
	private Date startDate;
	private Date endDate;
	
	public boolean isValid() {
		return !StringUtils.isBlank(currency) && startDate != null && endDate != null;
	}
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
