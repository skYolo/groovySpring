package jcg.zheng.demo.groovyspring.service;

import java.math.BigDecimal;

import jcg.zheng.demo.groovyspring.model.BudgetType;
//import jcg.zheng.demo.groovyspring.model.GDepartment;
import jcg.zheng.demo.groovyspring.model.JDepartment;

public interface Payroll {

	BigDecimal caculateBudget(JDepartment department, BudgetType type);
	//BigDecimal caculateBudget(GDepartment department, BudgetType type);

}
