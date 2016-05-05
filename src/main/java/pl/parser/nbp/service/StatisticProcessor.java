package pl.parser.nbp.service;

import java.util.List;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import pl.parser.nbp.model.KursModel;

public class StatisticProcessor {
	private SummaryStatistics kursKupna = new SummaryStatistics();
	private SummaryStatistics kursSprzedazy = new SummaryStatistics();

	public void fillKursy(List<KursModel> kursyList) {
		for (KursModel kurs : kursyList) {
			kursKupna.addValue(kurs.getKursKupna().doubleValue());
			kursSprzedazy.addValue(kurs.getKursSprzedazy().doubleValue());
		}
	}

	public double getMeanKursKupna() {
		return kursKupna.getMean();
	}

	public double getStandardDeviationKursSprzedazy() {
		return kursSprzedazy.getStandardDeviation();
	}
}
