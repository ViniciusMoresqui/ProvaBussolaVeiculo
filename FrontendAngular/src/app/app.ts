import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { appService } from './app.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html'
})
export class App {

  veiculos: any[] = [];

  veiculo: any = {
    id: null,
    modelo: '',
    anoFabricacao: 0,
    placa: '',
    acessorios: []
  };

  novoAcessorio: string = '';

  constructor(private service: appService) {
    this.listar();
  }

  listar() {
    this.service.listarVeiculos().subscribe((dados: any) => {
      this.veiculos = dados;
    });
  }

  addAcessorio() {
    let objAcessorio = { nome: this.novoAcessorio };
    this.veiculo.acessorios.push(objAcessorio);
    this.novoAcessorio = '';
  }

  removerAcessorio(i: number) {
    this.veiculo.acessorios.splice(i, 1);
  }

  salvar() {
    if (this.veiculo.id != null) {
      this.service.atualizarVeiculo(this.veiculo.id, this.veiculo).subscribe((res: any) => {
        this.listar();

        this.veiculo.id = null;
        this.veiculo.modelo = '';
        this.veiculo.anoFabricacao = 0;
        this.veiculo.placa = '';
        this.veiculo.acessorios = [];
      });
    }
  }

  deletar(id: number) {
    this.service.deletarVeiculo(id).subscribe((res: any) => {
      this.listar();
    });
  }
}
