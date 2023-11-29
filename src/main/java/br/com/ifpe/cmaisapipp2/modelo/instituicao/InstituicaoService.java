package br.com.ifpe.cmaisapipp2.modelo.instituicao;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituicaoService {
  @Autowired
  private InstituicaoRepository repository;

  @Transactional
  public Instituicao save(Instituicao instituicao) {

    instituicao.setHabilitado(Boolean.TRUE);
    instituicao.setVersao(1L);
    instituicao.setDataCriacao(LocalDate.now());
    return repository.save(instituicao);
  }

  public List<Instituicao> findAll() {

    return repository.findAll();
  }

  public Instituicao findById(Long id) {

    return repository.findById(id).get();
  }

  public List<Instituicao> filtrar(String enderecoInstituicao, String nomeInstituicao, Long idCategoria) {

    List<Instituicao> listaProdutos = repository.findAll();

    if ((enderecoInstituicao != null && !"".equals(enderecoInstituicao)) &&
        (nomeInstituicao == null || "".equals(nomeInstituicao)) &&
        (idCategoria == null)) {
      listaProdutos = repository.consultarPorenderecoInstituicao(enderecoInstituicao);
    } else if ((enderecoInstituicao == null || "".equals(enderecoInstituicao)) &&
        (nomeInstituicao != null && !"".equals(nomeInstituicao)) &&
        (idCategoria == null)) {
      listaProdutos = repository.findByNomeInstituicaoContainingIgnoreCaseOrderByNomeInstituicaoAsc(nomeInstituicao);
    } else if ((enderecoInstituicao == null || "".equals(enderecoInstituicao)) &&
        (nomeInstituicao == null || "".equals(nomeInstituicao)) &&
        (idCategoria != null)) {
      listaProdutos = repository.consultarPorCategoria(idCategoria);
    } else if ((enderecoInstituicao == null || "".equals(enderecoInstituicao)) &&
        (nomeInstituicao != null && !"".equals(nomeInstituicao)) &&
        (idCategoria != null)) {
      listaProdutos = repository.consultarPornomeInstituicaoECategoria(nomeInstituicao, idCategoria);
    }

    return listaProdutos;
  }

  @Transactional
  public void update(Long id, Instituicao instituicaoAlterado) {

    Instituicao instituicao = repository.findById(id).get();
    instituicao.setNomeInstituicao(instituicaoAlterado.getNomeInstituicao());
    instituicao.setCNPJInstituicao(instituicaoAlterado.getCNPJInstituicao());
    instituicao.setEnderecoInstituicao(instituicaoAlterado.getEnderecoInstituicao());
    instituicao.setTelefoneInstituicao(instituicaoAlterado.getTelefoneInstituicao());
    instituicao.setFinalidade(instituicaoAlterado.getFinalidade());
    instituicao.setEmailInstituicao(instituicaoAlterado.getEmailInstituicao());
    instituicao.setRedesSociaisIntituicao(instituicaoAlterado.getRedesSociaisIntituicao());
    instituicao.setDataConstituicao(instituicaoAlterado.getDataConstituicao());
    instituicao.setComprovanteCadastro(instituicaoAlterado.getComprovanteCadastro());
    instituicao.setNomeResponsavel(instituicaoAlterado.getNomeResponsavel());
    instituicao.setCpfReponsavel(instituicaoAlterado.getCpfReponsavel());
    instituicao.setTelefoneResponsavel(instituicaoAlterado.getTelefoneResponsavel());
    instituicao.setEmailResponsavel(instituicaoAlterado.getEmailResponsavel());
    instituicao.setSenhaAcesso(instituicaoAlterado.getSenhaAcesso());

    instituicao.setVersao(instituicao.getVersao() + 1);
    repository.save(instituicao);
  }

  @Transactional
  public void delete(Long id) {

    Instituicao instituicao = repository.findById(id).get();
    instituicao.setHabilitado(Boolean.FALSE);
    instituicao.setVersao(instituicao.getVersao() + 1);

    repository.save(instituicao);
  }
}
