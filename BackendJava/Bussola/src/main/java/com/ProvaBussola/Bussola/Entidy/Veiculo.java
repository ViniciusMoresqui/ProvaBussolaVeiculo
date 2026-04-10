package com.ProvaBussola.Bussola.Entidy;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Veiculo {

   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   private Long id;

   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   @JoinColumn(name = "veiculo_id")
   private List<Acessorio> acessorios = new ArrayList<>();

    private String modelo;
    private int anoFabricacao;
    private String placa;

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public Veiculo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
