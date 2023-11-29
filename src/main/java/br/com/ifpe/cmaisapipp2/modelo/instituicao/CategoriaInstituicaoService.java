package br.com.ifpe.cmaisapipp2.modelo.instituicao;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaInstituicaoService {

  @Autowired
  private CategoriaInstituicaoRepository repository;

  @Transactional
  public CategoriaInstituicao save(CategoriaInstituicao categoriaInstituicao) {

    categoriaInstituicao.setHabilitado(Boolean.TRUE);
    categoriaInstituicao.setVersao(1L);
    categoriaInstituicao.setDataCriacao(LocalDate.now());
    return repository.save(categoriaInstituicao);
  }

  public List<CategoriaInstituicao> listarTodos() {

    return repository.findAll();
  }

  public CategoriaInstituicao obterPorID(Long id) {

    return repository.findById(id).get();
  }

  @Transactional
  public void update(Long id, CategoriaInstituicao categoriaInstituicaoAlterado) {

    CategoriaInstituicao categoriaInstituicao = repository.findById(id).get();
    categoriaInstituicao.setDescricao(categoriaInstituicaoAlterado.getDescricao());

    categoriaInstituicao.setVersao(categoriaInstituicao.getVersao() + 1);
    repository.save(categoriaInstituicao);
  }

  @Transactional
  public void delete(Long id) {

    CategoriaInstituicao categoriaInstituicao = repository.findById(id).get();
    categoriaInstituicao.setHabilitado(Boolean.FALSE);
    categoriaInstituicao.setVersao(categoriaInstituicao.getVersao() + 1);

    repository.save(categoriaInstituicao);
  }

}