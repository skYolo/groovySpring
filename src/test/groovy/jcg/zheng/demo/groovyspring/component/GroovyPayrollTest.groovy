package jcg.zheng.demo.groovyspring.component

import static org.junit.Assert.assertTrue

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import jcg.zheng.demo.groovyspring.model.BudgetType
import jcg.zheng.demo.groovyspring.model.GDepartment
import jcg.zheng.demo.groovyspring.model.GEmployee
import jcg.zheng.demo.groovyspring.model.JDepartment
import jcg.zheng.demo.groovyspring.model.JEmployee
import jcg.zheng.demo.groovyspring.service.Payroll

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroovyPayrollTest {

	@Autowired
	@Qualifier("groovyPayroll")
	private Payroll groovyPayroll

	@Test
	public void test_GroovyPayroll_caculateBudget_for_GDepartment_yearly() {
		GDepartment department = new GDepartment()

		List<GEmployee> reports = [
			new GEmployee(firstName:"Mary", lastName:"Zheng", hourlyRate:new BigDecimal(20)),
			new GEmployee(firstName:"Alex", lastName:"Zheng", hourlyRate:new BigDecimal(10)),
			new GEmployee(firstName:"Allen", lastName:"Zheng", hourlyRate:new BigDecimal(8))
		]

		department.setEmployees(reports);

		def ret = groovyPayroll.caculateBudget(department, BudgetType.YEARLY)
		assertTrue(ret.compareTo(new BigDecimal(1520)) == 0);
	}

	@Test
	public void test_GroovyPayroll_caculateBudget_for_JDepartment_yearly() {
		JDepartment department = new JDepartment()

		List<JEmployee> reports = [
			new JEmployee(firstName:"Mary", lastName:"Zheng", hourlyRate:new BigDecimal(20)),
			new JEmployee(firstName:"Alex", lastName:"Zheng", hourlyRate:new BigDecimal(10)),
			new JEmployee(firstName:"Allen", lastName:"Zheng", hourlyRate:new BigDecimal(8))
		]

		department.setEmployees(reports);

		def ret = groovyPayroll.caculateBudget(department, BudgetType.YEARLY)
		assertTrue(ret.compareTo(new BigDecimal(1520)) == 0);
	}
}
