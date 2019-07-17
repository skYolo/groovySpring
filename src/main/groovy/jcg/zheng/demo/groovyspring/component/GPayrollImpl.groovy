package jcg.zheng.demo.groovyspring.component

import java.time.Duration
import java.util.ArrayList
import java.util.List

import org.springframework.stereotype.Component

import groovy.time.TimeCategory
import groovy.time.TimeDuration
import jcg.zheng.demo.groovyspring.model.BudgetType
import jcg.zheng.demo.groovyspring.model.GDepartment
import jcg.zheng.demo.groovyspring.model.JDepartment
import jcg.zheng.demo.groovyspring.service.Payroll

@Component("groovyPayroll")
class GPayrollImpl implements Payroll{

	@Override
	public BigDecimal caculateBudget(JDepartment department, BudgetType type) {
		def timeStart = new Date()
		List<BigDecimal> values = new ArrayList<>()

		department.getEmployees().each { 
			values.add(it.caculatePay(type.workingHours()))}

		def timeStop = new Date()
		TimeDuration duration = TimeCategory.minus(timeStop, timeStart)
		println "Groovy caculateBudget for JDepartment took " + duration

		values.sum();
	}

	@Override
	public BigDecimal caculateBudget(GDepartment department, BudgetType type) {
		def timeStart = new Date()
		List<BigDecimal> values = new ArrayList<>()

		department.getEmployees().each {
			values.add(it.caculatePay(type.workingHours()))}

		def timeStop = new Date()
		TimeDuration duration = TimeCategory.minus(timeStop, timeStart)
		println "Groovy caculateBudget for GDepartment took " + duration
		values.sum();
	}
}
