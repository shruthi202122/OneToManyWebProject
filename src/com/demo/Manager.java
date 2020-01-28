package com.demo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the manager database table.
 * 
 */
@Entity
@NamedQuery(name="Manager.findAll", query="SELECT m FROM Manager m")
public class Manager implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int mid;

	private String name;

	//bi-directional many-to-one association to Employee2
	@OneToMany(mappedBy="manager",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Employee2> employees;

	public Manager() {
	}

	public int getMid() {
		return this.mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee2> getEmployees() {
		return this.employees;
	}

	public void setEmployee2s(List<Employee2> employees) {
		this.employees = employees;
	}

	public Employee2 addEmployee2(Employee2 employee2) {
		getEmployees().add(employee2);
		employee2.setManager(this);

		return employee2;
	}

	public Employee2 removeEmployee2(Employee2 employee2) {
		getEmployees().remove(employee2);
		employee2.setManager(null);

		return employee2;
	}

}