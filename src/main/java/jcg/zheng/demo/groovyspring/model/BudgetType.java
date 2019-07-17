package jcg.zheng.demo.groovyspring.model;

import java.math.BigDecimal;

public enum BudgetType {

	YEARLY, QUARTERLY, MONTHLY, WEEKLY;

	public BigDecimal workingHours() {
		BigDecimal workingHours = new BigDecimal(0);
		switch (this) {
		case YEARLY:
			workingHours = new BigDecimal(2080);
		case QUARTERLY:
			workingHours = new BigDecimal(520);
		case MONTHLY:
			workingHours = new BigDecimal(173.34);
		case WEEKLY:
			workingHours = new BigDecimal(40);
		}
		return workingHours;
	}

}
