package com.pdw.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "diagnostic_centre")
public class DiagnosticCenter {
	@Id
	@Column(length=20)
	private String center_Id;
	private String centerName;
	@OneToMany
	@JoinColumn(name ="tests_center")
	private List<Tests> listOfTests = new ArrayList<Tests>();
	@OneToMany
	@JoinColumn(name ="appointment_center")
	private List<Appointments> appointmentList = new ArrayList<Appointments>();

	public String getCenter_Id() {
		return center_Id;
	}

	public void setCenterId(String centreId) {
		this.center_Id = center_Id;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centreName) {
		this.centerName = centerName;
	}

	public List<Tests> getListOfTests() {
		return listOfTests;
	}

	public void setListOfTests(List<Tests> listOfTests) {
		this.listOfTests = listOfTests;
	}

	public List<Appointments> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointments> appointmentList) {
		this.appointmentList = appointmentList;
	}
public DiagnosticCenter () {
	
}
	@Override
	public String toString() {
		return "DiagnosticCenter [centreId=" + center_Id + ", centreName=" + centerName + ", listOfTests=" + listOfTests
				+ "]";
	}


	
}

