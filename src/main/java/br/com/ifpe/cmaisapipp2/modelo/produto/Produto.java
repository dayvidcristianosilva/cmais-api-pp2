package br.com.ifpe.cmaisapipp2.modelo.produto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
  @ManyToOne
  private CategoriaProduto categoria;

  @Column(nullable = false, length = 100)
  private String titulo;

  @Column
  private String CodigoDeBarrasDoProduto;

  @Column
  private String Descricao;

  @Column
  private LocalDate DataDeFabricacao;

  @Column
  private LocalDate DataDeValidade;

  @Column
  private int Quantidade;

  @Column
  private String Observacoes;

  @Column
  private String AnexeAquiUmaOuMaisImagensDoProduto;

}
