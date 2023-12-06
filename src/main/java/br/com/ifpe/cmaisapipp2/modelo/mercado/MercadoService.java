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
        // Validação de entrada pode ser adicionada aqui, se necessário
        mercado.setHabilitado(Boolean.TRUE);
        mercado.setVersao(1L);
        mercado.setDataCriacao(LocalDate.now());
        return repository.save(mercado);
    }

    public List<Mercado> findAll() {
        return repository.findAll();
    }

    public Mercado findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Mercado> filtrar(String nomeEmpreendimento, String endereco) {
        List<Mercado> listaMercados;

        if ((nomeEmpreendimento != null && !nomeEmpreendimento.isEmpty()) &&
            (endereco != null && !endereco.isEmpty())) {
            listaMercados = repository.findByNomeEmpreendimentoContainingIgnoreCaseOrderByNomeEmpreendimentoAsc(nomeEmpreendimento);
        } else if ((nomeEmpreendimento == null || nomeEmpreendimento.isEmpty()) &&
                   (endereco != null && !endereco.isEmpty())) {
            listaMercados = repository.consultarPorendereco(endereco);
        } else {
            listaMercados = repository.findAll();
        }

        return listaMercados;
    }

    @Transactional
    public void update(Long id, Mercado mercadoAlterado) {
        Mercado mercado = repository.findById(id).orElse(null);
        if (mercado != null) {
            if (mercado.getVersao().equals(mercadoAlterado.getVersao())) {
                mercado.setNomeEmpreendimento(mercadoAlterado.getNomeEmpreendimento());
                mercado.setTipoEmpreendimento(mercadoAlterado.getTipoEmpreendimento());
                mercado.setTelefoneContato(mercadoAlterado.getTelefoneContato());
                mercado.setEndereco(mercadoAlterado.getEndereco());
                mercado.setRedesSociais(mercadoAlterado.getRedesSociais());
                mercado.setNomeCompletoResponsavel(mercadoAlterado.getNomeCompletoResponsavel());
                mercado.setCargoResponsavel(mercadoAlterado.getCargoResponsavel());
                mercado.setSenhaDeAcesso(mercadoAlterado.getSenhaDeAcesso());

                mercado.setVersao(mercado.getVersao() + 1);
                repository.save(mercado);
            } else {
                throw new IllegalStateException("O objeto foi modificado por outra transação. Atualização não permitida.");
            }
        }
    }

    @Transactional
    public void delete(Long id) {
        Mercado mercado = repository.findById(id).orElse(null);
        if (mercado != null) {
            mercado.setHabilitado(Boolean.FALSE);
            mercado.setVersao(mercado.getVersao() + 1);
            repository.save(mercado);
        }
    }
}
