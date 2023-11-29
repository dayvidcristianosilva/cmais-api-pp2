package br.com.ifpe.cmaisapipp2.modelo.mercado;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MercadoService {
    @Autowired
    private MercadoRepository repository;

    @Transactional
    public Mercado save(Mercado mercado) {

        mercado.setHabilitado(Boolean.TRUE);
        mercado.setVersao(1L);
        mercado.setDataCriacao(LocalDate.now());
        return repository.save(mercado);
    }

    public List<Mercado> findAll() {

        return repository.findAll();
    }

    public Mercado findById(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Mercado mercadoAlterado) {

        Mercado mercado = repository.findById(id).get();
        mercado.setNomeDoEmpreendimento(mercadoAlterado.getNomeDoEmpreendimento());
        mercado.setCNPJ(mercadoAlterado.getCNPJ());
        mercado.setTipoDeEmpreendimento(mercadoAlterado.getTipoDeEmpreendimento());
        mercado.setTelefoneParaContato(mercadoAlterado.getTelefoneParaContato());
        mercado.setEndereco(mercadoAlterado.getEndereco());
        mercado.setRedesSocias(mercadoAlterado.getRedesSocias());
        mercado.setNomeCompletoDoResponsavelPorCadastrar(mercadoAlterado.getNomeCompletoDoResponsavelPorCadastrar());
        mercado.setCargo(mercadoAlterado.getCargo());
        mercado.setSenhaDeAcesso(mercadoAlterado.getSenhaDeAcesso());

        mercado.setVersao(mercado.getVersao() + 1);
        repository.save(mercado);
    }

    @Transactional
    public void delete(Long id) {

        Mercado mercado = repository.findById(id).get();
        mercado.setHabilitado(Boolean.FALSE);
        mercado.setVersao(mercado.getVersao() + 1);

        repository.save(mercado);
    }
}
