import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Categoria } from '../models/categoria.model';
import { Producto } from '../models/producto.model';

@Injectable({
  providedIn: 'root'
})
export class ExplorerService {

  private API = 'http://localhost:8080/llamallama/v1/';

  constructor(private http:HttpClient) { }


  getProductos(){
    return this.http.get(this.API+ 'products')
  }

  getProductosByName(nombre: Producto){
    return this.http.get(this.API+'productn'+'/'+ nombre)
  }


}

