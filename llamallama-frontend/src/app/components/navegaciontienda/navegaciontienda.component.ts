import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/producto.model';
import { Tienda } from 'src/app/models/tienda.model';
import { Tienda_producto } from 'src/app/models/tienda_producto.model';
import { ExplorerService } from 'src/app/services/explorer.service';

@Component({
  selector: 'app-navegaciontienda',
  templateUrl: './navegaciontienda.component.html',
  styleUrls: ['./navegaciontienda.component.css']
})
export class NavegaciontiendaComponent implements OnInit {

  public productos: Producto[];
  

  constructor(private explorerservice:ExplorerService) { }

  ngOnInit(): void {
    this.explorerservice.getProductos().subscribe((result:any)=>{
      console.log(result.data);
      this.productos = result.data;
    })
  }
}
