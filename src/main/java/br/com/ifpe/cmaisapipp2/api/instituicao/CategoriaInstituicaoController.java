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
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.cmaisapipp2.modelo.instituicao.CategoriaInstituicao;
import br.com.ifpe.cmaisapipp2.modelo.instituicao.CategoriaInstituicaoService;

@RestController
@RequestMapping("/api/categoriaInstituicao")
@CrossOrigin
public class CategoriaInstituicaoController {

  @Autowired
  private CategoriaInstituicaoService categoriaInstituicaoService;

  @PostMapping
  public ResponseEntity<CategoriaInstituicao> save(@RequestBody @Valid CategoriaInstituicaoRequest request) {

    CategoriaInstituicao categoriaInstituicaoNovo = request.build();
    CategoriaInstituicao categoriaInstituicao = categoriaInstituicaoService.save(categoriaInstituicaoNovo);
    return new ResponseEntity<CategoriaInstituicao>(categoriaInstituicao, HttpStatus.CREATED);
  }

  @GetMapping
  public List<CategoriaInstituicao> listarTodos() {

    return categoriaInstituicaoService.listarTodos();
  }

  @GetMapping("/{id}")
  public CategoriaInstituicao obterPorID(@PathVariable Long id) {

    return categoriaInstituicaoService.obterPorID(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CategoriaInstituicao> update(@PathVariable("id") Long id,
      @RequestBody CategoriaInstituicaoRequest request) {

    categoriaInstituicaoService.update(id, request.build());
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {

    categoriaInstituicaoService.delete(id);
    return ResponseEntity.ok().build();
  }

}
