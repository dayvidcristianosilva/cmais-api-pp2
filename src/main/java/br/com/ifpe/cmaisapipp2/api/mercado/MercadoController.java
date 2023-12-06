package br.com.ifpe.cmaisapipp2.api.mercado;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(mercado, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Serviço responsável por listar todos os mercados do sistema.")
    @GetMapping
    public List<Mercado> findAll() {
        return mercadoService.findAll();
    }

    @ApiOperation(value = "Serviço responsável por filtrar mercados com base no nome do empreendimento e/ou endereço.")
    @GetMapping("/filtrar")
    public List<Mercado> filtrar(
            @RequestParam(value = "nomeEmpreendimento", required = false) String nomeEmpreendimento,
            @RequestParam(value = "endereco", required = false) String endereco) {
        return mercadoService.filtrar(nomeEmpreendimento, endereco);
    }

    @ApiOperation(value = "Serviço responsável por obter um mercado referente ao Id passado na URL.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o mercado."),
            @ApiResponse(code = 401, message = "Acesso não autorizado."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
            @ApiResponse(code = 404, message = "Não foi encontrado um registro para o Id informado."),
            @ApiResponse(code = 500, message = "Foi gerado um erro no servidor."),
    })
    @GetMapping("/{id}")
    public Mercado findById(@PathVariable Long id) {
        return mercadoService.findById(id);
    }

    @ApiOperation(value = "Serviço responsável por atualizar um mercado no sistema.")
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid MercadoRequest request) {
        mercadoService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Serviço responsável por excluir um mercado do sistema.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mercadoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
