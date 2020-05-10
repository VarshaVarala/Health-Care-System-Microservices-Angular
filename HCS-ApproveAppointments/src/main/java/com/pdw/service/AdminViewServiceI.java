package com.pdw.service;

import java.util.List;

import com.pdw.entity.Appointments;

public interface AdminViewServiceI {
	List<Appointments> AppointmentList();

	String approveAppointment(Appointments app);

}
