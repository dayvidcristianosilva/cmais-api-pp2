package br.com.ifpe.cmaisapipp2.api.produto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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

  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dataDeFabricação;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dataDeValidade;

  private String quantidade;

  private String observacoes;

  private String anexoImagem;

  public Produto build() {

    return Produto.builder()
        .codigoDeBarras(codigoDeBarras)
        .descricao(descricao)
        .dataDeFabricacao(dataDeFabricação)
        .dataDeValidade(dataDeValidade)
        .quantidade(anexoImagem)
        .observacoes(observacoes)
        .build();
  }
}