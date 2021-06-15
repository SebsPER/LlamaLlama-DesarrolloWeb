import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-crud-productos',
  templateUrl: './crud-productos.component.html',
  styleUrls: ['./crud-productos.component.css']
})
export class CrudProductosComponent implements OnInit {

  //valores temporales hasta conectar con backend. revisar servicios y funciones para
  stores: string[] = ['t1', 't2', 't3']
  products: string[] = ['p1', 'p2', 'p3' , 'p4', 'p5']
  productId: string;
  storeId: string;
  price: number;
  stock: number;
  discount: number;

  constructor() { }

  ngOnInit(): void {
  }

  registrar(idp:string, idt: string, price:number, stock:number) {
    console.log('id_product:' + idp, 'id_tienda:' + idt)
    console.log('precio:'+ price, 'stock:' + stock)
  }

}
