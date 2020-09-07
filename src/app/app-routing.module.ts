import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProductoComponent } from './demo/producto/producto.component';
import { CategoriaComponent } from './demo/categoria/categoria.component';

const routes: Routes = [
  { path: 'productos', component: ProductoComponent},
  { path: 'categorias', component: CategoriaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
