package com.pdw.service;


import java.util.List;

import com.pdw.entity.Appointments;
import com.pdw.entity.DiagnosticCenter;
import com.pdw.entity.Tests;


public interface UserAppointmentServiceI {
	List<DiagnosticCenter> DiagnosticCenterList();
	List<Tests> TestsList(String centreId);
	String makeAppointment(Appointments app);

}
