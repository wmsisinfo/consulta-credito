import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Credito } from '../models/credito.model';

@Injectable({ providedIn: 'root' })
export class CreditoService {
  private apiUrl = 'http://localhost:8080/api/creditos';

  constructor(private http: HttpClient) {}

  buscarPorChave(chave: string): Observable<Credito[]> {
    return this.http.get<Credito[]>(`${this.apiUrl}/${chave}`);
  }
}