package br.com.ifpe.cmaisapipp2.api.produto;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.ifpe.cmaisapipp2.modelo.produto.Produto;
import br.com.ifpe.cmaisapipp2.modelo.produto.ProdutoService;
import br.com.ifpe.cmaisapipp2.util.Util;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @ApiOperation(value = "Serviço responsável por salvar um produto no sistema.")
    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody @Valid ProdutoRequest request) {

        Produto produtoSalvo = produtoService.save(request.build());
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }

    @PutMapping("/adicionarimagem/{id}")
    public ResponseEntity<Produto> adicionarImagem(@PathVariable("id") Long id,
            @RequestParam(value = "arquivo", required = true) MultipartFile arquivo) {

        Produto produto = produtoService.findById(id);

        if (Util.fazerUploadImagem(arquivo)) {
            produto.setImagem(Util.obterMomentoAtual() + " - " + arquivo.getOriginalFilename());
        }

        produtoService.update(id, produto);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Serviço responsável por listar todos os produtos do sistema.")
    @GetMapping
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @ApiOperation(value = "Serviço responsável por obter um produto referente ao Id passado na URL.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o produto."),
            @ApiResponse(code = 401, message = "Acesso não autorizado."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
            @ApiResponse(code = 404, message = "Não foi encontrado um registro para o Id informado."),
            @ApiResponse(code = 500, message = "Foi gerado um erro no servidor."),
    })
    @GetMapping("/{id}")
    public Produto findById(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody ProdutoRequest request) {
        produtoService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
