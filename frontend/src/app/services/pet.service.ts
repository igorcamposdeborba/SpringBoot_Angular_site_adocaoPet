import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_CONFIG } from '../config/api.config';
import { Observable } from 'rxjs';
import { Pet } from '../models/pet';


@Injectable({
  providedIn: 'root'
})
export class PetService {

constructor(private http: HttpClient) { // objeto para fazer requisições Http
}

findAll(): Observable<Pet[]> {
  return this.http.get<Pet[]>(`${API_CONFIG.baseUrl}/catalog`)
}

findById(id: number): Observable<Pet> {
  return this.http.get<Pet>(`${API_CONFIG.baseUrl}/catalog/pets/${id}`)
}

}
