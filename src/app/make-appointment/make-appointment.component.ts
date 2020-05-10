import { Component, OnInit } from '@angular/core';
import { AppointmentService, Test, DiagnosticCentre, Appointment } from '../appointment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-make-appointment',
  templateUrl: './make-appointment.component.html',
  styleUrls: ['./make-appointment.component.css']
})
export class MakeAppointmentComponent implements OnInit {
  selectedTest: Test;
  test_details: any
  checkTests: boolean = false
  centre: DiagnosticCentre
  tests: Test
  selectedCenterId: string;
  selectedDate: string
  dateCheck: boolean = false;
  userIdCheck: boolean = false;
  appointment: string;
  confirmation: boolean;

  user: DiagnosticCentre = new DiagnosticCentre("", "", []);
  tester: Test = new Test("", "");

  app: Appointment = new Appointment("", false, "", "", "")

  constructor(private appService: AppointmentService, private router: Router) { }

  ngOnInit(): void {
    this.getAllCenters();
  }

  onSelect(user: DiagnosticCentre) {
    this.selectedCenterId = user.centreId;
    this.appService.displayTests(this.selectedCenterId).subscribe(
      response => this.handleSuccessfulResponseTest(response),
    );
    this.app.center = user.centreName;
  }

  handleSuccessfulResponseTest(response) {
    this.tests = response;
  }

  onTest(tester) {
    this.dateCheck = true;
    this.app.test = tester.testName;
  }

  onDate() {
    if (this.app.dateTimeSlot == "") {
      window.alert("Please select a valid date and time");

    } else {
      this.userIdCheck = true;
      this.app.approved = false;
    }
  }

  onConfirm() {

    if (this.app.userId == "") {
      window.alert("Please enter a valid userId");

    } else {
      this.appService.makeAppointment(this.app)
      .subscribe(data => {
        if(data){
          this.dateCheck=false;
          this.userIdCheck=false;
          this.confirmation=true;
       alert("Appointment added successfully! Please check View Appointments");
        }else{
          alert("user ID already exists!! This user already made an appointment");
        }
      });
    }
  }

  getAllCenters() {
    //getting data of all Centers

    this.appService.displayCenters().subscribe(
      response => this.handleSuccessfulResponseCenter(response),
    );
  }
  handleSuccessfulResponseCenter(response) {
    this.centre = response;
  }


}
