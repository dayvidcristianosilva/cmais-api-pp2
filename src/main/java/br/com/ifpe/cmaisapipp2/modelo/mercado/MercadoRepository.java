package br.com.ifpe.cmaisapipp2.modelo.mercado;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MercadoRepository extends JpaRepository<Mercado, Long> {

    @Query(value = "SELECT p FROM Mercado p WHERE LOWER(p.nomeEmpreendimento) LIKE %:nomeEmpreendimento% ORDER BY p.nomeEmpreendimento ASC")
    List<Mercado> findByNomeEmpreendimentoContainingIgnoreCaseOrderByNomeEmpreendimentoAsc(String nomeEmpreendimento);

    @Query(value = "SELECT p FROM Mercado p WHERE LOWER(p.endereco) LIKE %:endereco% ORDER BY p.endereco ASC")
    List<Mercado> consultarPorendereco(String endereco);

}
