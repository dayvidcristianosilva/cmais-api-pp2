package br.com.ifpe.cmaisapipp2.modelo.produto;

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
@Table(name = "produto")
@Where(clause = "habilitado = true")
public class Produto extends EntidadeAuditavel {

  @Column
  private int CodigoDeBarrasDoProduto;

  @Column
  private String Descrição;

  @Column
  private LocalDate DataDeFabricação;

  @Column
  private LocalDate DataDeValidade;

  @Column
  private int Quantidade;

  @Column
  private String Observações;

  @Column
  private String AnexeAquiUmaOuMaisImagensDoProduto;

}
