package br.com.ifpe.cmaisapipp2.api.instituicao;

import java.time.LocalDate;

//import org.springframework.web.multipart.MultipartFile;

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

  private LocalDate dataConstituicao;

  private String emailInstituicao;

  private String redesSociaisInstituicao;

  //private MultipartFile comprovanteCadastro;

  private String nomeResponsavel;

  private String cpfResponsavel;

  private String telefoneResponsavel;

  private String emailResponsavel;

  private String cargoResponsavel;

  private String senhaAcesso;

  public Instituicao build() {

    return Instituicao.builder()
        .nomeInstituicao(nomeInstituicao)
        .cnpjInstituicao(cnpjInstituicao)
        .enderecoInstituicao(enderecoInstituicao)
        .telefoneInstituicao(telefoneInstituicao)
        .finalidade(finalidade)
        .dataConstituicao(dataConstituicao)
        .emailInstituicao(emailInstituicao)
        .redesSociaisInstituicao(redesSociaisInstituicao)
        //.comprovanteCadastro(comprovanteCadastro)
        .nomeResponsavel(nomeResponsavel)
        .cpfResponsavel(cpfResponsavel)
        .telefoneResponsavel(telefoneResponsavel)
        .emailResponsavel(emailResponsavel)
        .cargoResponsavel(cargoResponsavel)
        .senhaAcesso(senhaAcesso)
        .build();
  }

}
