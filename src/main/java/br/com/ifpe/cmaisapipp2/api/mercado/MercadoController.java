package br.com.ifpe.cmaisapipp2.api.mercado;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.

RestController;

import br.com.ifpe.cmaisapipp2.modelo.mercado.Mercado;
import br.com.ifpe.cmaisapipp2.modelo.mercado.MercadoService;

@RestController
@RequestMapping("/api/mercado")
@CrossOrigin
public class MercadoController {

   @Autowired
   private MercadoService mercadoService;

   @PostMapping
   public ResponseEntity<Mercado> save(@RequestBody @Valid MercadoRequest request) {

       Mercado mercado = mercadoService.save(request.build());
       return new ResponseEntity<Mercado>(mercado, HttpStatus.CREATED);
   }
    @GetMapping
    public List<Mercado> findAll() {
  
        return mercadoService.findAll();
    }

    @GetMapping("/{id}")
    public Mercado findById(@PathVariable Long id) {

        return mercadoService.findById(id);
    }
    
     @PutMapping("/{id}")
   public ResponseEntity<Mercado> update(@PathVariable("id") Long id, @RequestBody MercadoRequest request) {

       mercadoService.update(id, request.build());
       return ResponseEntity.ok().build();
   }
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       mercadoService.delete(id);
       return ResponseEntity.ok().build();
   }


}