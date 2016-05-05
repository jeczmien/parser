package pl.parser.nbp.model;

import java.math.BigDecimal;

public class KursModel {
	private BigDecimal kursKupna;
	private BigDecimal kursSprzedazy;

	public BigDecimal getKursKupna() {
		return kursKupna;
	}

	public void setKursKupna(BigDecimal kursKupna) {
		this.kursKupna = kursKupna;
	}

	public BigDecimal getKursSprzedazy() {
		return kursSprzedazy;
	}

	public void setKursSprzedazy(BigDecimal kursSprzedazy) {
		this.kursSprzedazy = kursSprzedazy;
	}
}
