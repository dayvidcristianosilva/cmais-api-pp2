package br.com.ifpe.cmaisapipp2.api.instituicao;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.cmaisapipp2.modelo.acesso.Usuario;
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

  @NotBlank(message = "O e-mail é de preenchimento obrigatório")
  @Email
  private String emailInstituicao;

  private String redesSociaisIntituicao;

  private String nomeResponsavel;

  private String cpfReponsavel;

  private String telefoneResponsavel;

  private String emailResponsavel;

  private String cargoReponsavel;

  @NotBlank(message = "A senha é de preenchimento obrigatório")
  private String senhaAcesso;

  public Instituicao build() {

    return Instituicao.builder()
        .usuario(buildUsuario())
        .nomeInstituicao(nomeInstituicao)
        .cnpjInstituicao(cnpjInstituicao)
        .enderecoInstituicao(enderecoInstituicao)
        .telefoneInstituicao(telefoneInstituicao)
        .dataConstituicao(dataConstituicao)
        .emailInstituicao(emailInstituicao)
        .redesSociaisIntituicao(redesSociaisIntituicao)
        .nomeResponsavel(nomeResponsavel)
        .cpfReponsavel(cpfReponsavel)
        .telefoneResponsavel(telefoneResponsavel)
        .emailResponsavel(emailResponsavel)
        .cargoReponsavel(cargoReponsavel)
        .senhaAcesso(senhaAcesso)
        .build();
  }

  public Usuario buildUsuario() {

    return Usuario.builder()
        .username(emailInstituicao)
        .password(senhaAcesso)
        .roles(java.util.Arrays.asList(Usuario.ROLE_CLIENTE))
        .build();
  }

}