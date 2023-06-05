import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// Importado formulário do Angular
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
// Importado para fazer requisições HTTP para back-end
import { HttpClientModule } from '@angular/common/http';

// Importados componentes do Angular Material Design no projeto
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { MatRadioModule } from '@angular/material/radio';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';

// Componentes do projeto
import { NavComponent } from './components/nav/nav.component';
import { HomeComponent } from './components/home/home.component';
import { FooterComponent } from './components/footer/footer.component';
import { PetCatalogComponent } from './components/pet/pet-catalog/pet-catalog.component';
import { MiniBannerComponent } from './components/elements/mini-banner/mini-banner.component';
import { AdoptionProcessBannerComponent } from './components/elements/adoption-process-banner/adoption-process-banner.component';
import { PetsComponent } from './components/pets/pets.component';
import { DoacaoComponent } from './components/static-pages/doacao/doacao.component';



@NgModule({
  declarations: [
    AppComponent,
    NavComponent, // declarado componente (no caso do Angular)
    HomeComponent,
    FooterComponent,
    PetCatalogComponent,
    MiniBannerComponent,
    AdoptionProcessBannerComponent,
    PetsComponent,
    DoacaoComponent 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    // Formulário
    FormsModule,
    ReactiveFormsModule,
    // Requisições http
    HttpClientModule,
    // Angular Material Design
    MatButtonModule,
    MatFormFieldModule,
    MatPaginatorModule,
    MatCheckboxModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatSidenavModule,
    MatSelectModule,
    MatInputModule,
    MatRadioModule,
    MatTableModule,
    MatIconModule,
    MatListModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
