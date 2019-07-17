package jcg.zheng.demo.groovyspring.service.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jcg.zheng.demo.groovyspring.model.BudgetType;
//import jcg.zheng.demo.groovyspring.model.GDepartment;
//import jcg.zheng.demo.groovyspring.model.GEmployee;
import jcg.zheng.demo.groovyspring.model.JDepartment;
import jcg.zheng.demo.groovyspring.model.JEmployee;
import jcg.zheng.demo.groovyspring.service.Payroll;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPayrollImpTest {

	@Autowired
	@Qualifier("javaPayroll")
	private Payroll javaPayroll;

	@Test
	public void test_JavaPayroll_caculateBudget_for_JDepartment_yearly() {
		JDepartment dept = new JDepartment();

		List<JEmployee> reports = new ArrayList<>();
		reports.add(buildJEmployee("Mary", "Zheng", new BigDecimal(20)));
		reports.add(buildJEmployee("Alex", "Zheng", new BigDecimal(10)));
		reports.add(buildJEmployee("Allen", "Zheng", new BigDecimal(8)));

		dept.setEmployees(reports);

		BigDecimal budget = javaPayroll.caculateBudget(dept, BudgetType.YEARLY);
		assertTrue(budget.compareTo(new BigDecimal(1520)) == 0);
	}


	private JEmployee buildJEmployee(String fname, String lname, BigDecimal money) {
		JEmployee mary = new JEmployee();
		mary.setFirstName(fname);
		mary.setLastName(lname);
		mary.setHourlyRate(money);
		return mary;
	}

}
