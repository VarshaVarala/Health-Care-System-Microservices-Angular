package com.pdw.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class Tests implements Serializable {
	@Id 
	@Column(length=20)
	private String test_Id;
	@Column(length=20)
	private String testName;

	
	
	public String getTest_Id() {
		return test_Id;
	}
	public void setTest_Id(String test_Id) {
		this.test_Id = test_Id;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public Tests() {
		}
	@Override
	public String toString() {
		return "Tests [test_Id=" + test_Id + ", testName=" + testName + "]";
	}


}

