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
  private String titulo;

  private String CodigoDeBarrasDoProduto;

  private String Descricao;

  private LocalDate DataDeFabricacao;

  private LocalDate DataDeValidade;

  private int Quantidade;

  private String Observacoes;

  private String AnexeAquiUmaOuMaisImagensDoProduto;

  public Produto build() {

    return Produto.builder()
        .titulo(titulo)
        .CodigoDeBarrasDoProduto(CodigoDeBarrasDoProduto)
        .Descricao(Descricao)
        .DataDeFabricacao(DataDeFabricacao)
        .DataDeValidade(DataDeValidade)
        .Quantidade(Quantidade)
        .Observacoes(Observacoes)
        .AnexeAquiUmaOuMaisImagensDoProduto(AnexeAquiUmaOuMaisImagensDoProduto)
        .build();
  }
}