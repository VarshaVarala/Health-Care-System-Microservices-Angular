import { Component, OnInit } from '@angular/core';
import { Appointment, Test, DiagnosticCentre, AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-approve-appointments',
  templateUrl: './approve-appointments.component.html',
  styleUrls: ['./approve-appointments.component.css']
})
export class ApproveAppointmentsComponent implements OnInit {
  
  app:Appointment;
  test:Test;
  center:DiagnosticCentre;
  status:string;
  appointment:string;

  constructor(private appService:AppointmentService,private router: Router) { }

  ngOnInit(): void {
    this.getAllAppointments();
  }
  getAllAppointments() {
    //getting data of all appointments

    console.log(this.app)
    this.appService.displayAppointments().subscribe(
     response =>this.handleSuccessfulResponseCenter(response),
    );
  }
  handleSuccessfulResponseCenter(response)
  {
     this.app=response;
  }


  onClick(app){
    console.log(app);
    app.approved=true;
    console.log(app);
    this.appService.approveAppointment(app).subscribe((data) =>this.appointment = data);

  }

statusCheck(){
  if (this.app.approved=false){
    status="awaiting confirmation"
}else {
status="Your Appointment is scheduled!"
}
}

}

