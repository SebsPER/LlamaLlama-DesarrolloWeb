import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { MaterialModule } from '../material/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HeaderclienteComponent } from './headercliente/headercliente.component';
import { NavegaciontiendaComponent } from './navegaciontienda/navegaciontienda.component';
import { CompracComponent } from './comprac/comprac.component';



@NgModule({
  declarations: [
    HeaderComponent,
    HeaderclienteComponent,
    NavegaciontiendaComponent,
    CompracComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule
  ],
  exports: [
    HeaderComponent,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class ComponentModule { }
