import { Component } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';
import { Router } from '@angular/router';
import { DocauthService } from '../docauth.service';

@Component({
  selector: 'app-docdash',
  templateUrl: './docdash.component.html',
  styleUrl: './docdash.component.css',
})
export class DocdashComponent {
  patients: Patient[] = [];
  constructor(private patientService: PatientService, private router: Router, private docauthSevice:DocauthService) {}

  ngOnInit(): void {
    this.getPatients();
  }

  getPatients() {
    this.patientService.getPatientList().subscribe((data) => {
      this.patients = data;
    });
  }

  delete(id: number) {
    this.patientService.deletePatient(id).subscribe((data) => {
      console.log(data);
      this.getPatients();
    });
  }

  update(id: number) {
    this.router.navigate(['update-patient', id]);
  }

  view(id:number){
    this.router.navigate(['view-patient',id]);
  }

  logout(){
    this.router.navigate(['home']);
    this.docauthSevice.logout();
  }
}
