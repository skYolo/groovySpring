package jcg.zheng.demo.groovyspring.model;

import java.util.List;

public class JDepartment {
	private int id;

	private List<JEmployee> employees;

	public List<JEmployee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<JEmployee> employees) {
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
