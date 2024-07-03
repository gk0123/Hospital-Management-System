import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Medicine } from './medicine';

@Injectable({
  providedIn: 'root',
})
export class MedicineService {
  medicine: Medicine = new Medicine();
  constructor(private httpClient: HttpClient) {}

  private baseUrl = 'http://localhost:8080/api/v3/medicine';

  getMedicines(): Observable<Medicine[]> {
    return this.httpClient.get<Medicine[]>(`${this.baseUrl}`);
  }
  createMedicine(medicine:Medicine): Observable<Medicine> {
    return this.httpClient.post<Medicine>(`${this.baseUrl}`,medicine);
  }
  getMedicineById(id:number):Observable<Medicine>{
    return this.httpClient.get<Medicine>(`${this.baseUrl}/${id}`);
  }
  updateMedicine(id:number, medicine:Medicine):Observable<Object>{
    return this.httpClient.put<Medicine>(`${this.baseUrl}/${id}`,medicine);
  }
  deleteMedicine(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
