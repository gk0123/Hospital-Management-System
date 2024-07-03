import { Component } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { Medicine } from '../medicine';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-medicine',
  templateUrl: './create-medicine.component.html',
  styleUrl: './create-medicine.component.css',
})
export class CreateMedicineComponent {
  constructor(
    private medicineServices: MedicineService,
    private router: Router
  ) {}
  medicine: Medicine = new Medicine();

  saveMedicine() {
    this.medicineServices.createMedicine(this.medicine).subscribe((data) => {
      this.medicine = data;
      console.log(data);
      this.goToViewMedicine();
    });
  }

  onSubmit() {
    this.saveMedicine();
  }

  goToViewMedicine() {
    this.router.navigate(['/view-medicine']);
  }
}
