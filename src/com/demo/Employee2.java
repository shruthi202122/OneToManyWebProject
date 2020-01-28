package com.demo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the employee2 database table.
 * 
 */
@Entity
@NamedQuery(name="Employee2.findAll", query="SELECT e FROM Employee2 e")
public class Employee2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int eno;

	private String name;

	//bi-directional many-to-one association to Manager
	@ManyToOne
	@JoinColumn(name="mno")
	private Manager manager;

	public Employee2() {
	}
	
	public int getEno() {
		return this.eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

}