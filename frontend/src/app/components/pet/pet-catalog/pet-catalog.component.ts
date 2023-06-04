import { Component, OnInit } from '@angular/core';
import { Ong, Pet } from 'src/app/models/pet';
import { PetService } from 'src/app/services/pet.service';
import { AdoptionProcessBannerComponent } from '../../elements/adoption-process-banner/adoption-process-banner.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pet-catalog',
  templateUrl: './pet-catalog.component.html',
  styleUrls: ['./pet-catalog.component.css']
})
export class PetCatalogComponent implements OnInit {

  // Dados fixos do MOCK
  ELEMENT_DATA_ONG: Ong[] = []
  
  ELEMENT_DATA_PET: Pet[] = []

  constructor(private service: PetService, private router: Router){
    this.findAll();
  }
  
  findAll(){ // View chama requisição do service.
    this.service.findAll().subscribe(response => {
      this.ELEMENT_DATA_PET = response;
    }); 
  }
  /*
  findAll(){ // View chama requisição do service.
    this.service.findAll().subscribe(response => {
    const petsWithImages = this.convertBase64ToImage(response);
    this.ELEMENT_DATA_PET = petsWithImages;
    });
  }

  // converter imagem no formato base64 para a url da imagem
  convertBase64ToImage(array: Pet[]): Pet[] {
    return array.map(function(objeto) {
      let base64String = objeto.image;
      let decodedData = atob(base64String);
      let buffer = new ArrayBuffer(decodedData.length);
      let view = new Uint8Array(buffer);
      for (let i = 0; i < decodedData.length; i++) {
        view[i] = decodedData.charCodeAt(i);
      }
      let blob = new Blob([view], { type: "image/jpeg" });
      let imageUrl = URL.createObjectURL(blob);
  
      objeto.image = imageUrl; // Substitui o valor base64 pela URL da imagem
  
      return objeto;
    });
  }*/

  ngOnInit(): void { // ciclo de vida: ao iniciar o componente
    AdoptionProcessBannerComponent;
  }
}