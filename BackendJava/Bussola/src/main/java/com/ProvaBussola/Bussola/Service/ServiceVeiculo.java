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

    public List<Veiculo> listarVeiculo(){
        return this.repositoryVeiculo.findAll();
    }

    public Veiculo salvarVeiculo(Veiculo veiculo){
        return this.repositoryVeiculo.save(veiculo);
    }

    public Veiculo VeiculoById(Long id){
        return repositoryVeiculo.findById(id).orElse(null);
    }

    public Veiculo atualizarVeiculo(Long id, Veiculo veiculo) {
        return repositoryVeiculo.findById(id).map(veiculo1 -> {

            veiculo1.setModelo(veiculo.getModelo());
            veiculo1.setPlaca(veiculo.getPlaca());
            veiculo1.setAnoFabricacao(veiculo.getAnoFabricacao());

            veiculo1.setAcessorios(veiculo.getAcessorios());

            return repositoryVeiculo.save(veiculo1);

        }).orElse(null);
    }

    public void deletarVeiculo(Long id) {
        this.repositoryVeiculo.deleteById(id);
    }

}
