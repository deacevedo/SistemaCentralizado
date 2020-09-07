import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Categoria } from "./Categoria";
import { Producto } from "./Producto";

@Injectable({
  providedIn: 'root'
})
export class ClientenodeService {

  URL = "https://demongodb.herokuapp.com/api/";
  constructor(private httpc: HttpClient) {

  }
    getCategorias(): Observable<Categoria> {
      return this.httpc.get<Categoria>(this.URL+'categoria');
    }

    addCategoria(nombreF:string){
      let objetoCategoria = {nombre: nombreF}
      return this.httpc.post(this.URL+'categoria',objetoCategoria);
    }
    
    getProductos(): Observable<Producto> {
      return this.httpc.get<Producto>(this.URL+'producto');
    }
}
