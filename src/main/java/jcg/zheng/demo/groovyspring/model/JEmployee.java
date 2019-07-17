package jcg.zheng.demo.groovyspring.model;

import java.math.BigDecimal;

public class JEmployee {
	public JEmployee() {
		super();
	}

	private String firstName;
	private String lastName;
	private int id;
	private BigDecimal hourlyRate;

	public BigDecimal caculatePay(BigDecimal hours) {
		return hourlyRate.multiply(hours);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(BigDecimal hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

}
