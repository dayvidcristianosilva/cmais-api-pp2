package br.com.ifpe.cmaisapipp2.api.produto;

import br.com.ifpe.cmaisapipp2.modelo.produto.CategoriaProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutoRequest {

  private String Descricao;

  public CategoriaProduto build() {

    return CategoriaProduto.builder()
        .Descricao(Descricao)
        .build();
  }

}