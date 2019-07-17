package jcg.zheng.demo.groovyspring

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext

import jcg.zheng.demo.groovyspring.component.AddressService
import jcg.zheng.demo.groovyspring.model.BudgetType
import jcg.zheng.demo.groovyspring.model.GCountry
import jcg.zheng.demo.groovyspring.model.GDepartment
import jcg.zheng.demo.groovyspring.model.GEmployee
import jcg.zheng.demo.groovyspring.model.GState
import jcg.zheng.demo.groovyspring.service.Payroll

@SpringBootApplication
public class GroovySpringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GroovySpringApplication.class, args)
		
		printYearlyBudget(context)
	
		printAddress(context)
	}

	private static printYearlyBudget(ConfigurableApplicationContext context) {
		GDepartment department = new GDepartment(id:1)

		List<GEmployee> reports = [
			new GEmployee(firstName:"Mary", lastName:"Zheng", hourlyRate:new BigDecimal(20)),
			new GEmployee(firstName:"Alex", lastName:"Zheng", hourlyRate:new BigDecimal(10)),
			new GEmployee(firstName:"Allen", lastName:"Zheng", hourlyRate:new BigDecimal(8))
		]

		department.setEmployees(reports)
		Payroll payroll = context.getBean("javaPayroll")
		println "Departement 1 yearly budget: " + payroll.caculateBudget(department, BudgetType.YEARLY)
	}

	private static printAddress(ConfigurableApplicationContext context) {
		AddressService addressService = context.getBean(AddressService.class)
		List<GCountry> countries = addressService.getCountries()
		def usa = countries.find{it.get("alpha3_code").equalsIgnoreCase("USA")}
		println "Found USA " + usa

		List<GState> usStates = addressService.getStates("USA")
		println "US States :" + usStates
	}
}
