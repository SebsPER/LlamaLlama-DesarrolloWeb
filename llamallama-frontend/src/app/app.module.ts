import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';

import { MatFormFieldModule} from '@angular/material/form-field';
import { RegisterComponent } from './components/register/register.component'
import { HeaderclienteComponent } from './components/headercliente/headercliente.component';
import { HeaderComponent } from './components/header/header.component';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIcon, MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { NavegaciontiendaComponent } from './components/navegaciontienda/navegaciontienda.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HeaderclienteComponent,
    HeaderComponent,
    NavegaciontiendaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatFormFieldModule,
    FormsModule,
    MatButtonModule,
    MatToolbarModule,
    HttpClientModule,
    MatIconModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
