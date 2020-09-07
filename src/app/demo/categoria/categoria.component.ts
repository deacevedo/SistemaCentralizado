import { Component, OnInit } from '@angular/core';
import { ClientenodeService } from 'src/app/service/clientenode.service';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent implements OnInit {

  title= 'CATEGORIAS'
  categorias:any
  myFormCategoria: FormGroup;

  constructor(public servc:ClientenodeService) { 
 //   this.servc.getCategorias().subscribe(r=>{
//    console.table(r.categorias);
//    })
  }

  ngOnInit(): void {
    this.obtenerCategorias();
    this.myFormCategoria = new FormGroup({
      nombreF: new FormControl(''),
    });
  }

  obtenerCategorias(){
    this.servc.getCategorias().subscribe(r=>{
      return this.categorias=r.categorias
    })
  }

  ingresarCategorias(){
    let nombre = this.myFormCategoria.value.nombreF;

    this.servc.addCategoria(nombre).subscribe(r=>{
      this.obtenerCategorias()
      this.myFormCategoria = new FormGroup({
        nombreF: new FormControl('')
      });
    })
  }

}
