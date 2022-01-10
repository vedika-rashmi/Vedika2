package com.milestone5.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="Gender")
	private String gender;
	@Column(name="Age")
	private int age;
	@Column(name="Preffered_Food")
	private String prefferedFood;
	
	public Customer() {
		
	}
	
	public Customer(String name, String gender, int age, String prefferedFood) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.prefferedFood = prefferedFood;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPrefferedFood() {
		return prefferedFood;
	}
	public void setPrefferedFood(String prefferedFood) {
		this.prefferedFood = prefferedFood;
	}
	
	
}
