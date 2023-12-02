package br.com.ifpe.cmaisapipp2.modelo.instituicao;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.ifpe.cmaisapipp2.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "instituicao")
@Where(clause = "habilitado = true")

public class Instituicao extends EntidadeAuditavel {

  @Column
  private String nomeInstituicao;

  @Column
  private String cnpjInstituicao;

  @Column
  private String enderecoInstituicao;

  @Column
  private String telefoneInstituicao;

  @Column
  private String finalidade;

  @Column
  private String emailInstituicao;

  @Column
  private String redesSociaisIntituicao;

  @Column
  private LocalDate dataConstituicao;

  @Column
  private String comprovanteCadastro;

  @Column
  private String nomeResponsavel;

  @Column
  private String cpfReponsavel;

  @Column
  private String telefoneResponsavel;

  @Column
  private String emailResponsavel;

  @Column
  private String cargoReponsavel;

  @Column
  private String senhaAcesso;

}
