package jcg.zheng.demo.groovyspring.model

import groovy.transform.*

@Canonical
class GEmployee {
	String firstName
	String lastName
	int id
	BigDecimal hourlyRate
	
	public BigDecimal caculatePay(BigDecimal hours) {
		hourlyRate.multiply(hours)
	}
}
