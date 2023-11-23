package br.com.ifpe.cmaisapipp2.api.produto;

import java.time.LocalDate;

import br.com.ifpe.cmaisapipp2.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {
  
    private String codigoDeBarras;

    private String descricao;

    private LocalDate dataDeFabricacao;

    private LocalDate dataDeValidade;

    private int quantidade;

    private String observacao;

    public Produto build() {
        return Produto.builder()
                .codigoDeBarras(codigoDeBarras)
                .descricao(descricao)
                .dataDeFabricacao(dataDeFabricacao)
                .dataDeValidade(dataDeValidade)
                .quantidade(quantidade)
                .observacao(observacao)
                .build();
    }
}
