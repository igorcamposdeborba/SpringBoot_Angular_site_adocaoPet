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

  ngOnInit(): void { // ciclo de vida: ao iniciar o componente
    AdoptionProcessBannerComponent;
  }

  scrollToTop() {
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }
}