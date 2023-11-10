package br.com.ifpe.cmaisapipp2.api.instituicao;

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

import br.com.ifpe.cmaisapipp2.modelo.instituicao.Instituicao;
import br.com.ifpe.cmaisapipp2.modelo.instituicao.InstituicaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/instituicao")
@CrossOrigin
public class InstituicaoController {

  @Autowired
  private InstituicaoService ongService;

  @ApiOperation(value = "Serviço responsável por salvar uma ong no sistema.")
  @PostMapping
  public ResponseEntity<Instituicao> save(@RequestBody @Valid InstituicaoRequest request) {

    Instituicao ong = ongService.save(request.build());
    return new ResponseEntity<Instituicao>(ong, HttpStatus.CREATED);
  }

  @ApiOperation(value = "Serviço responsável por listar todas as instituição do sistema.")
  @GetMapping
  public List<Instituicao> findAll() {

    return ongService.findAll();
  }

  @ApiOperation(value = "Serviço responsável por obter uma instituição referente ao Id passado na URL.")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Retorna  a instituição."),
      @ApiResponse(code = 401, message = "Acesso não autorizado."),
      @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
      @ApiResponse(code = 404, message = "Não foi encontrado um registro para o Id informado."),
      @ApiResponse(code = 500, message = "Foi gerado um erro no servidor."),
  })
  @GetMapping("/{id}")
  public Instituicao findById(@PathVariable Long id) {

    return ongService.findById(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Instituicao> update(@PathVariable("id") Long id, @RequestBody InstituicaoRequest request) {

    ongService.update(id, request.build());
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {

    ongService.delete(id);
    return ResponseEntity.ok().build();
  }

}