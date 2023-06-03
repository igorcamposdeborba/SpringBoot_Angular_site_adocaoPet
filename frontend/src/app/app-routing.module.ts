import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavComponent } from './components/nav/nav.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  {
    path: "", // rota (URL)
    component: NavComponent, // Componente renderizado pela rota (url). MENU
    children: [ { // CHILDREN insere componente dentro do outro (home dentro do menu) porque o conteúdo da home é uma rota filha do nav
      path: "",                                                                // porque o menu aparece em todas as páginas 
      component: HomeComponent // Componente HOME
    }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
