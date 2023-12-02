package br.com.ifpe.cmaisapipp2.api.instituicao;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.cmaisapipp2.modelo.instituicao.Instituicao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class InstituicaoRequest {

  private String nomeInstituicao;

  private String cnpjInstituicao;

  private String enderecoInstituicao;

  private String telefoneInstituicao;

  private String finalidade;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dataConstituicao;

  private String emailInstituicao;

  private String redesSociaisIntituicao;

  private String nomeResponsavel;

  private String cpfReponsavel;

  private String telefoneResponsavel;

  private String emailResponsavel;

  private String cargoReponsavel;

  private String senhaAcesso;

  public Instituicao build() {

    return Instituicao.builder()
        .nomeInstituicao(nomeInstituicao)
        .cnpjInstituicao(cnpjInstituicao)
        .enderecoInstituicao(enderecoInstituicao)
        .telefoneInstituicao(telefoneInstituicao)
        .dataConstituicao(dataConstituicao)
        .emailInstituicao(emailInstituicao)
        .redesSociaisIntituicao(redesSociaisIntituicao)
        //.ComprovanteCadastro(ComprovanteCadastro)
        .nomeResponsavel(nomeResponsavel)
        .cpfReponsavel(cpfReponsavel)
        .telefoneResponsavel(telefoneResponsavel)
        .emailResponsavel(emailResponsavel)
        .cargoReponsavel(cargoReponsavel)
        .senhaAcesso(senhaAcesso)
        .build();
  }

}
