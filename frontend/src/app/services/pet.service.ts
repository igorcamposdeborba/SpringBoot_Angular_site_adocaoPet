import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_CONFIG } from '../config/api.config';
import { Observable } from 'rxjs';
import { Ong, Pet } from '../models/pet';


@Injectable({
  providedIn: 'root'
})
export class PetService {

  constructor(private http: HttpClient) { // objeto para fazer requisições Http
  }
// Aqui você faz a requisição para obter os dados da Ong usando o ID da Ong do objeto Pet
// Inclui os dados da Ong dentro do objeto Pet
/*findAll(): Observable<any> {
  return this.http.get<Pet[]>(`${API_CONFIG.baseUrl}/pets`).pipe(
    map((pets: Pet[]) => {
      const petObservables: Observable<Pet>[] = [];
      // Aqui você faz a requisição para obter os dados da Ong usando o ID da Ong do objeto Pet
      pets.forEach((pet: Pet) => {
        const ongId = pet.ong.id;
        const ongObservable = this.http.get<Ong>(`${API_CONFIG.baseUrl}/ongs/${ongId}`).pipe(
          map((ong: Ong) => {
            pet.ong = ong; // Inclui os dados da Ong dentro do objeto Pet
            return pet;
          })
        );
        petObservables.push(ongObservable);
      });
      return petObservables; // Combina todos os Observables em um único Observable
                                       // para retornar a lista completa de Pets com as informações da Ong
    })
  );
}*/
findAll(): Observable<Pet[]> {
  return this.http.get<Pet[]>(`${API_CONFIG.baseUrl}/catalog`)
}

findById(id: number): Observable<Pet> {
  return this.http.get<Pet>(`${API_CONFIG.baseUrl}/catalog/pets/${id}`)
}

}
