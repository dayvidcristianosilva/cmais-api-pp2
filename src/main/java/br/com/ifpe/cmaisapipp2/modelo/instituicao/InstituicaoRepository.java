package br.com.ifpe.cmaisapipp2.modelo.instituicao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {

  // Exemplo de uma busca exata
  @Query(value = "SELECT p FROM Instituicao p WHERE p.enderecoInstituicao = :enderecoInstituicao")
  List<Instituicao>consultarPorenderecoInstituicao(String enderecoInstituicao);

  // Exemplo de uma busca aproximada com ordenação:
  // @Query(value = "SELECT p FROM Produto p WHERE p.titulo like %:titulo% ORDER
  // BY p.titulo")
  // List<Produto> consultarPorTitulo(String titulo);
  List<Instituicao>findByNomeInstituicaoContainingIgnoreCaseOrderByNomeInstituicaoAsc(String nomeInstituicao);

  // Exemplo de uma busca exata como um atributo de relacionamento
  @Query(value = "SELECT p FROM Instituicao p WHERE p.categoria.id = :idCategoria")
  List<Instituicao> consultarPorCategoria(Long idCategoria);

  // Exemplo de uma busca com mais de um atributo
  @Query(value = "SELECT p FROM Instituicao p WHERE p.nomeInstituicao like %:nomeInstituicao% AND p.categoria.id = :idCategoria")
  List<Instituicao>  consultarPornomeInstituicaoECategoria(String nomeInstituicao, Long idCategoria);
}