import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


export class DiagnosticCentre{
  constructor(
    public centreId:string,
    public centreName:string,
    public listOfTests:any){
  }

}
export class Test{
  constructor(
    public testId:string,
    public testName:string){
  }
}

export class Appointment
{
  constructor(
    public dateTimeSlot:string,
    public approved:boolean,
    public userId:string,
    public test:any,
    public center:any)
  {}
}


@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  constructor(private http:HttpClient) { }

  public displayCenters(){
    return this.http.get<DiagnosticCentre>("http://localhost:1111/User/FetchCenterList");
  }
  public displayTests(selectedCenterId){
    return this.http.get<Test>("http://localhost:1111/User/FetchTestList/"+selectedCenterId,{responseType:'json'});

  }
  public makeAppointment(app){

    return this.http.post<any>("http://localhost:1111/User/makeAppointment",app,{responseType:'json'});

  }
public displayAppointments(){
  return this.http.get<Appointment>("http://localhost:1110/User/FetchAppList");
}

public approveAppointment(app){
  return this.http.put<any>("http://localhost:1112/Admin/approveAppointment",app,{responseType:'json'});

}


}

