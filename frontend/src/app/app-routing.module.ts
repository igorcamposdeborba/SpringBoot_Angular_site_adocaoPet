import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavComponent } from './components/nav/nav.component';
import { HomeComponent } from './components/home/home.component';
import { PetCatalogComponent } from './components/pet/pet-catalog/pet-catalog.component';
import { PetsComponent } from './components/pets/pets.component';

const routes: Routes = [
  {
    path: "", // rota (URL)
    component: NavComponent, // Componente renderizado pela rota (url). MENU
    children: [ { // CHILDREN insere componente dentro do outro (home dentro do menu) porque o conteúdo da home é uma rota filha do nav
        path: "",                                                                // porque o menu aparece em todas as páginas 
        component: HomeComponent // Componente HOME
      }, 
      {
        path: "catalog",
        component: PetCatalogComponent
      },
      {
        path: `catalog/pets/:id`,
        component: PetsComponent
      }
    ]
  }, 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
