// src/app/components/consulta-credito/consulta-credito.component.ts
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CreditoService } from '../../services/credito.service';
import { Credito } from '../../models/credito.model';

@Component({
  selector: 'app-consulta-credito',
  templateUrl: './consulta-credito.component.html',
  styleUrls: ['./consulta-credito.component.scss'],
  standalone: true,
  imports: [
    FormsModule,
    CommonModule
  ]
})
export class ConsultaCreditoComponent {
  chaveBusca: string = '';
  creditos: Credito[] = [];
  carregando: boolean = false;
  erro: string = '';

  constructor(private creditoService: CreditoService) {}

  // ✅ Método onSubmit adicionado aqui
  onSubmit() {
    if (!this.chaveBusca.trim()) return;

    this.carregando = true;
    this.erro = '';
    this.creditos = [];

    this.creditoService.buscarPorChave(this.chaveBusca).subscribe({
      next: (data) => {
        this.creditos = data;
        this.carregando = false;
      },
      error: () => {
        this.erro = 'Nenhum crédito encontrado ou ocorreu um erro.';
        this.carregando = false;
      }
    });
  }
}