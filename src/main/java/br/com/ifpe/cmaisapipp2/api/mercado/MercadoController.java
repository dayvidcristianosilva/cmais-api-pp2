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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/mercado")
@CrossOrigin
public class MercadoController {

    @Autowired
    private MercadoService mercadoService;

    @ApiOperation(value = "Serviço responsável por salvar um mercado no sistema.")

    @PostMapping
    public ResponseEntity<Mercado> save(@RequestBody @Valid MercadoRequest request) {

        Mercado mercado = mercadoService.save(request.build());
        return new ResponseEntity<Mercado>(mercado, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Serviço responsável por listar todos os mercados do sistema.")
    @GetMapping
    public List<Mercado> findAll() {

        return mercadoService.findAll();
    }

    @ApiOperation(value = "Serviço responsável por obter um mercado referente ao Id passado na URL.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna  o mercado."),
            @ApiResponse(code = 401, message = "Acesso não autorizado."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
            @ApiResponse(code = 404, message = "Não foi encontrado um registro para o Id informado."),
            @ApiResponse(code = 500, message = "Foi gerado um erro no servidor."),
    })

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