package jcg.zheng.demo.groovyspring.service.impl;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jcg.zheng.demo.groovyspring.model.BudgetType;
//import jcg.zheng.demo.groovyspring.model.GDepartment;
import jcg.zheng.demo.groovyspring.model.JDepartment;
import jcg.zheng.demo.groovyspring.service.Payroll;

@Component("javaPayroll")
public class JPayrollImp implements Payroll {

	@Override
	public BigDecimal caculateBudget(JDepartment department, BudgetType type) {
		Instant start = Instant.now();

		List<BigDecimal> values = new ArrayList<>();
		department.getEmployees().forEach(emp -> values.add(emp.caculatePay(type.workingHours())));

		BigDecimal result = values.stream().reduce(BigDecimal::add).get();

		Instant end = Instant.now();

		System.out.println("Java caculateBudget for JDepartment took " + Duration.between(start, end));

		return result;

	}

}
