import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class appService {

  private apiUrl = 'http://localhost:8090/api/veiculos';

  constructor( private http: HttpClient) { }

  listarVeiculos(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  salvarVeiculo(veiculo: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, veiculo);
  }

  atualizarVeiculo(id: number, veiculo: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, veiculo);
  }

  deletarVeiculo(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

}
