package br.com.ifpe.cmaisapipp2.modelo.mercado;

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
@Table(name = "mercado")
@Where(clause = "habilitado = true")
public class Mercado extends EntidadeAuditavel {

 @Column(nullable = false, length = 100)
  private String NomeDoEmpreendimento;

  @Column(unique = true)
  private Boolean CNPJ;

  @Column
  private String TipoDeEmpreendimento;

  @Column
  private int TelefoneParaContato;

  @Column
  private String Endereco;

  @Column
  private String RedesSocias;

  @Column
  private String NomeCompletoDoResponsavelPorCadastrar;

  @Column
  private String Cargo;

  @Column
  private String SenhaDeAcesso;

}
