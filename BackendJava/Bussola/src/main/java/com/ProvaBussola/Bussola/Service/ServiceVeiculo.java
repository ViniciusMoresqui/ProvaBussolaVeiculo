package com.ProvaBussola.Bussola.Service;

import com.ProvaBussola.Bussola.Entidy.Veiculo;
import com.ProvaBussola.Bussola.Repository.RepositoryVeiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceVeiculo {
    @Autowired
    private RepositoryVeiculo repositoryVeiculo;

    public ServiceVeiculo(Veiculo veiculo) {
        this.repositoryVeiculo = repositoryVeiculo ;
    }

    public List<Veiculo> listarVeiculo(){
        return this.repositoryVeiculo.findAll();
    }

    public Veiculo salvarVeiculo(Veiculo veiculo){
        return this.repositoryVeiculo.save(veiculo);
    }

    public Veiculo VeiculoById(Long id){
        return repositoryVeiculo.findById(id).orElse(null);
    }

    public Veiculo atualizarVeiculo(Long id, Veiculo veiculo){
        Veiculo veiculo1 = repositoryVeiculo.findById(id).orElse(null);
        if(veiculo1 != null){
            veiculo1.setModelo(atualizarVeiculo(id,veiculo).getModelo());
            veiculo1.setPlaca(atualizarVeiculo(id, veiculo).getPlaca());
            veiculo1.setAnoFabricacao(atualizarVeiculo(id, veiculo).getAnoFabricacao());
        }
        return veiculo1;
    }

    public void deletarVeiculo(Long id) {
        this.repositoryVeiculo.deleteById(id);
    }

}
