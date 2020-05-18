package com.pdw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdw.daoI.AppointmentDaoI;
import com.pdw.entity.Appointment;


//
@Service
public class AdminViewService implements AdminViewServiceI{
	@Autowired
	AppointmentDaoI appointmentDao;
	
	@Override
	public List<Appointment> AppointmentList() {
		List<Appointment> appointmentList=appointmentDao.findAll(); 
		// using data jpa we're using find all method to get the values
		return appointmentList;
	}

	@Override
	public String approveAppointment(Appointment appointment) {
		Appointment updatedAppointment= appointmentDao.save(appointment);
		return "Appointment is updated";
	}


}
