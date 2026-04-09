package com.ProvaBussola.Bussola.Service;

import com.ProvaBussola.Bussola.Entidy.Acessorio;
import com.ProvaBussola.Bussola.Repository.RepositoryAcessorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAcessorio {

    @Autowired
    private  RepositoryAcessorio repositoryAcessorio;

    public List<Acessorio> buscarAcessorio(){
        return this.repositoryAcessorio.findAll();
    }

    public Acessorio salvarAcessorio(Acessorio acessorio){
        return this.repositoryAcessorio.save(acessorio);
    }

    public void deletarAcessorio(Long acessorio){
        this.repositoryAcessorio.delete(acessorio);
    }


}
