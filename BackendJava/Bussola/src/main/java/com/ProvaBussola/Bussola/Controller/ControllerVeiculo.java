package com.ProvaBussola.Bussola.Controller;

import com.ProvaBussola.Bussola.Entidy.Veiculo;
import com.ProvaBussola.Bussola.Service.ServiceVeiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@RequestMapping("/livro")
public class ControllerVeiculo {

  private final ServiceVeiculo serviceVeiculo;

  @Autowired
  public ControllerVeiculo(Veiculo veiculo) {
    this.serviceVeiculo = new ServiceVeiculo(veiculo) ;
  }

  @PostMapping
  public List<Veiculo> listarVeiculo() {
    return this.listarVeiculo();
  }


  @PostMapping
  public ResponseEntity<Veiculo> salvarVeiculo(@RequestBody Veiculo veiculo){
    Veiculo Novoveiculo = serviceVeiculo.salvarVeiculo(veiculo);
    return new ResponseEntity<>(Novoveiculo, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<List<Veiculo>> atualizarVeiculo(@PathVariable Long id,@RequestBody Veiculo veiculo) {
    return atualizarVeiculo(id, veiculo);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteVeiculo(@PathVariable Long id) {
    serviceVeiculo.deletarVeiculo(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
