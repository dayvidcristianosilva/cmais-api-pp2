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
  private String NomeInstituicao;

  @Column
  private String CNPJInstituicao;

  @Column
  private String EnderecoInstituicao;

  @Column
  private int TelefoneInstituicao;
  @Column
  private int Finalidade;

  @Column
  private String EmailInstituicao;

  @Column
  private String RedesSociaisIntituicao;

  @Column
  private LocalDate DataConstituicao;

  @Column
  private String ComprovanteCadastro;

  @Column
  private String NomeResponsavel;

  @Column
  private int CpfReponsavel;

  @Column
  private int TelefoneResponsavel;

  @Column
  private String EmailResponsavel;

  @Column
  private String CargoReponsavel;

  @Column
  private String SenhaAcesso;
}
