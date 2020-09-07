import { Component, OnInit } from '@angular/core';
import { ClientenodeService } from 'src/app/service/clientenode.service';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css']
})
export class ProductoComponent implements OnInit {

  title = 'PRODUCTOS'

  constructor(public servc:ClientenodeService) { 
    this.servc.getProductos().subscribe(r=>{
      console.table(r.productos);
    })
  }

  ngOnInit(): void {
  }

}
