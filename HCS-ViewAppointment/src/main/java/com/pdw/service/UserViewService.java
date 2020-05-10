package com.pdw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdw.dao.AppointmentDaoI;
import com.pdw.entity.Appointments;

@Service
public class UserViewService implements UserViewServiceI {
	
	@Autowired
	AppointmentDaoI appointmentDao;
	
	@Override
	public List<Appointments> AppointmentList() {
		List<Appointments> appList=appointmentDao.findAll(); 
		// using data jpa find all method to get the values
		return appList;
	}


}
