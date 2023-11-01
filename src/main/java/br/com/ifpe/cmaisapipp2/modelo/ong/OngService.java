package br.com.ifpe.cmaisapipp2.modelo.ong;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OngService {
  @Autowired
  private OngRepository repository;

  @Transactional
  public Ong save(Ong ong) {

    ong.setHabilitado(Boolean.TRUE);
    ong.setVersao(1L);
    ong.setDataCriacao(LocalDate.now());
    return repository.save(ong);
  }

  public List<Ong> findAll() {

    return repository.findAll();
  }

  public Ong findById(Long id) {

    return repository.findById(id).get();
  }

  @Transactional
  public void update(Long id, Ong ongAlterado) {

    Ong ong = repository.findById(id).get();
    ong.setNomeInstituicao(ongAlterado.getNomeInstituicao());
    ong.setCNPJInstituicao(ongAlterado.getCNPJInstituicao());
    ong.setEnderecoInstituicao(ongAlterado.getEnderecoInstituicao());
    ong.setTelefoneInstituicao(ongAlterado.getTelefoneInstituicao());
    ong.setEmailInstituicao(ongAlterado.getEmailInstituicao());
    ong.setRedesSociaisIntituicao(ongAlterado.getRedesSociaisIntituicao());
    ong.setDataConstituicao(ongAlterado.getDataConstituicao());
    ong.setComprovanteCadastro(ongAlterado.getComprovanteCadastro());
    ong.setNomeResponsavel(ongAlterado.getNomeResponsavel());
    ong.setCpfReponsavel(ongAlterado.getCpfReponsavel());
    ong.setTelefoneResponsavel(ongAlterado.getTelefoneResponsavel());
    ong.setEmailResponsavel(ongAlterado.getEmailResponsavel());
    ong.setSenhaAcesso(ongAlterado.getSenhaAcesso());

    ong.setVersao(ong.getVersao() + 1);
    repository.save(ong);
  }

  @Transactional
  public void delete(Long id) {

    Ong ong = repository.findById(id).get();
    ong.setHabilitado(Boolean.FALSE);
    ong.setVersao(ong.getVersao() + 1);

    repository.save(ong);
  }
}
