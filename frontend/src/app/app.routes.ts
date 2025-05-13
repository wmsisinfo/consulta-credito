// src/app/app.routes.ts
import { Routes } from '@angular/router';
import { ConsultaCreditoComponent } from './components/consulta-credito/consulta-credito.component';

export const routes: Routes = [
  { path: '', component: ConsultaCreditoComponent },
  { path: '**', redirectTo: '' } 
];