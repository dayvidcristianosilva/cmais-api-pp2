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

  @Column
  private String nomeEmpreendimento;

  @Column
  private String cnpjEmpreendimento;

  @Column
  private String tipoEmpreendimento;

  @Column
  private String telefoneContato;

  @Column
  private String endereco;

  @Column
  private String redesSociais;

  @Column
  private String nomeCompletoResponsavel;

  @Column
  private String cargoResponsavel;

  @Column
  private String senhaDeAcesso;

}
