import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { Compra } from 'src/app/models/compra.model';
import { Compra_producto } from 'src/app/models/compra_producto.model';
import { Producto } from 'src/app/models/producto.model';
import { CompraserviceService } from 'src/app/services/compraservice.service';

@Component({
  selector: 'app-comprac',
  templateUrl: './comprac.component.html',
  styleUrls: ['./comprac.component.css']
})
export class CompracComponent implements OnInit {
  
  public comprapro: FormGroup;
  public productos =  new Producto();
  public compras = new Compra();
  private idproducto: number;
  private idcompra: number;
  constructor(public dialog: MatDialog,
    private fb:FormBuilder,
    private compraservice: CompraserviceService,
    private route:ActivatedRoute,
    private router:Router) { }

  getProducto(){

  }
  ngOnInit(): void {
    this.idproducto = Number(this.route.snapshot.paramMap.get('id'))
    this.getProducto();
    this.idcompra= Number(this.route.snapshot.paramMap.get('id'))
    this.getCompra()
  }

}
