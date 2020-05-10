package com.pdw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdw.daoI.AppointmentDaoI;
import com.pdw.daoI.CenterDaoI;
import com.pdw.daoI.TestDaoI;
import com.pdw.entity.Appointments;
import com.pdw.entity.DiagnosticCenter;
import com.pdw.entity.Tests;
@Service
public class UserAppointmentService implements UserAppointmentServiceI  {

	
	@Autowired
	TestDaoI testDao;
	
	@Autowired
	AppointmentDaoI appointmentDao;
	@Autowired
	CenterDaoI centerListDao;
	
	@Override
	public List<DiagnosticCenter> DiagnosticCenterList() {
		List<DiagnosticCenter> CenterList=centerListDao.findAll();
		return CenterList;
	}

	
	@Override
	public List<Tests> TestsList(String centreId) {
		List<Tests> testList=centerListDao.getOne(centreId).getListOfTests();
		return testList;
	}

	@Override
	public String makeAppointment(Appointments app) {
		Appointments updatedApp= appointmentDao.save(app);
		
		return "Appointment is registered, please await for confirmation";
	}


	}

