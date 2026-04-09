package com.ProvaBussola.Bussola.Controller;

import com.ProvaBussola.Bussola.Entidy.Acessorio;
import com.ProvaBussola.Bussola.Entidy.Veiculo;
import com.ProvaBussola.Bussola.Service.ServiceAcessorio;
import com.ProvaBussola.Bussola.Service.ServiceVeiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@RequestMapping("/Acessorio")
@CrossOrigin("*")
public class ControllerAcessorio {

    @Autowired
    private ServiceAcessorio serviceAcessorio;

    public List<Acessorio> buscarAcessorio(){
        return this.buscarAcessorio();
    }

    @PostMapping
    public Acessorio salvarAcessorio(@PathVariable Acessorio acessorio){
        return this.salvarAcessorio(acessorio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcessorio(@PathVariable Long id) {
        serviceAcessorio.deletarAcessorio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
