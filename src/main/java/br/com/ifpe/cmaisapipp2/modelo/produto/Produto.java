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

@Entity
@Table(name = "Produto")
@Where(clause = "habilitado = true")

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Produto extends EntidadeAuditavel {

  @Column
  private String codigoDeBarras;

  @Column
  private String descricao;

  @Column
  private LocalDate dataDeFabricacao;

  @Column
  private LocalDate dataDeValidade;

  @Column
  private String quantidade;

  @Column
  private String observacoes;

}
