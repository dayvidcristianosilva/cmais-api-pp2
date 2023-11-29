package br.com.ifpe.cmaisapipp2.api.instituicao;

import br.com.ifpe.cmaisapipp2.modelo.instituicao.CategoriaInstituicao;

public class CategoriaInstituicaoRequest {
  private String Descricao;

  public CategoriaInstituicao build() {

    return CategoriaInstituicao.builder()
        .Descricao(Descricao)
        .build();
  }

}
