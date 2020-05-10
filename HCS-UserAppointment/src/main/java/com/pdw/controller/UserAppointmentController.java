package com.pdw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pdw.entity.Appointments;
import com.pdw.entity.DiagnosticCenter;
import com.pdw.entity.Tests;
import com.pdw.service.UserAppointmentServiceI;

@RestController
@RequestMapping("/User")
@CrossOrigin("http://localhost:4200")
public class UserAppointmentController {
	
	@Autowired
	UserAppointmentServiceI userAppointmnetS;
	
	 @GetMapping("/FetchCenterList")
	   public List<DiagnosticCenter> getCenterList(){
		   List<DiagnosticCenter> center=userAppointmnetS.DiagnosticCenterList();
		   return center; 
	   }
	 
	 
	 @GetMapping("/FetchTestList/{centerId}")
	   public List<Tests> getTestList(@PathVariable("centerId")String centerId ){
		 List<Tests> dCenter=userAppointmnetS.TestsList(centerId);
		   return dCenter; 
	   }
	 
	 @PostMapping("/makeAppointment")
	 public String updateAppointment(@RequestBody Appointments app) {
		 System.out.println(app.toString());
		 String updateMsg =  userAppointmnetS.makeAppointment(app);
		 return updateMsg;
	 }

	
}
