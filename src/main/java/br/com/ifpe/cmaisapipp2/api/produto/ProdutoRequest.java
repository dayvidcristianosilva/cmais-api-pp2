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
  private int CodigoDeBarrasDoProduto;

  private String Descrição;

  private LocalDate DataDeFabricação;

  private LocalDate DataDeValidade;

  private int Quantidade;

  private String Observações;

  private String AnexeAquiUmaOuMaisImagensDoProduto;

  public Produto build() {

    return Produto.builder()
        .CodigoDeBarrasDoProduto(CodigoDeBarrasDoProduto)
        .Descrição(Descrição)
        .DataDeFabricação(DataDeFabricação)
        .DataDeValidade(DataDeValidade)
        .Quantidade(Quantidade)
        .Observações(Observações)
        .AnexeAquiUmaOuMaisImagensDoProduto(AnexeAquiUmaOuMaisImagensDoProduto)
        .build();
  }
}