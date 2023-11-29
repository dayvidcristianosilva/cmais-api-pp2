package br.com.ifpe.cmaisapipp2.modelo.produto;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
  @Autowired
  private ProdutoRepository repository;

  @Transactional
  public Produto save(Produto produto) {

    produto.setHabilitado(Boolean.TRUE);
    produto.setVersao(1L);
    produto.setDataCriacao(LocalDate.now());
    return repository.save(produto);
  }

  public List<Produto> findAll() {

    return repository.findAll();
  }

  public Produto findById(Long id) {

    return repository.findById(id).get();
  }

  public List<Produto> filtrar(String CodigoDeBarrasDoProduto, String titulo, Long idCategoria) {

    List<Produto> listaProdutos = repository.findAll();

    if ((CodigoDeBarrasDoProduto != null && !"".equals(CodigoDeBarrasDoProduto)) &&
        (titulo == null || "".equals(titulo)) &&
        (idCategoria == null)) {
      listaProdutos = repository.consultarPorCodigo(CodigoDeBarrasDoProduto);
    } else if ((CodigoDeBarrasDoProduto == null || "".equals(CodigoDeBarrasDoProduto)) &&
        (titulo != null && !"".equals(titulo)) &&
        (idCategoria == null)) {
      listaProdutos = repository.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo);
    } else if ((CodigoDeBarrasDoProduto == null || "".equals(CodigoDeBarrasDoProduto)) &&
        (titulo == null || "".equals(titulo)) &&
        (idCategoria != null)) {
      listaProdutos = repository.consultarPorCategoria(idCategoria);
    } else if ((CodigoDeBarrasDoProduto == null || "".equals(CodigoDeBarrasDoProduto)) &&
        (titulo != null && !"".equals(titulo)) &&
        (idCategoria != null)) {
      listaProdutos = repository.consultarPorTituloECategoria(titulo, idCategoria);
    }

    return listaProdutos;
  }

  @Transactional
  public void update(Long id, Produto produtoAlterado) {

    Produto produto = repository.findById(id).get();
    produto.setTitulo(produtoAlterado.getTitulo());
    produto.setCodigoDeBarrasDoProduto(produtoAlterado.getCodigoDeBarrasDoProduto());
    produto.setDescricao(produtoAlterado.getDescricao());
    produto.setDataDeFabricacao(produtoAlterado.getDataDeFabricacao());
    produto.setDataDeValidade(produtoAlterado.getDataDeValidade());
    produto.setQuantidade(produtoAlterado.getQuantidade());
    produto.setObservacoes(produtoAlterado.getObservacoes());
    produto.setAnexeAquiUmaOuMaisImagensDoProduto(produtoAlterado.getAnexeAquiUmaOuMaisImagensDoProduto());

    produto.setVersao(produto.getVersao() + 1);
    repository.save(produto);
  }

  @Transactional
  public void delete(Long id) {

    Produto produto = repository.findById(id).get();
    produto.setHabilitado(Boolean.FALSE);
    produto.setVersao(produto.getVersao() + 1);

    repository.save(produto);
  }
}