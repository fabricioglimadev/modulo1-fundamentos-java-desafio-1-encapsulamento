package br.com.unipds.fundamentosjava.desafio;

import org.junit.jupiter.api.Test; // Importação obrigatória para os testes

import static org.junit.jupiter.api.Assertions.*; // Importação para assertions

class ProdutoTest {

  @Test
  void deveCriarProdutoValido() {
    // Arrange
    int id = 1;
    String nome = "Notebook";
    double preco = 4500.00;
    int quantidade = 10;

    // Act
    Produto produto = new Produto(id, nome, preco, quantidade);

    // Assert
    assertEquals(id, produto.getId());
    assertEquals(nome, produto.getNome());
    assertEquals(preco, produto.getPreco());
    assertEquals(quantidade, produto.getQuantidadeEmEstoque());
  }

  @Test
  void deveLancarExceptionParaEstoqueNegativo() {
    // Arrange
    int id = 1;
    String nome = "Notebook";
    double preco = 4500.00;
    int quantidade = -5;

    // Act & Assert
    Exception exception = assertThrows(EstoqueNegativoException.class, () ->
            new Produto(id, nome, preco, quantidade)
    );

    assertEquals("Quantidade em estoque não pode ser negativa", exception.getMessage());
  }

  @Test
  void deveLancarExceptionParaPrecoNegativo(){
    int id = 1;
    String nome = "Notebook";
    double preco = -4500.0;
    int quantidade = 10;


    Exception exception = assertThrows(PrecoZeroOuNegativoException.class, () ->
            new Produto(id, nome, preco, quantidade)
    );

    assertEquals("Preço deve ser maior que zero", exception.getMessage());
  }

  @Test
  void deveLancarExceptionParaPrecoIgualZero(){
    int id = 1;
    String nome = "Notebook";
    double preco = 0.0;
    int quantidade = 10;


    Exception exception = assertThrows(PrecoZeroOuNegativoException.class, () ->
            new Produto(id, nome, preco, quantidade)
    );

    assertEquals("Preço deve ser maior que zero", exception.getMessage());
  }

  @Test
  void deveLancarExceptionParaNomeNull(){
    int id = 1;
    String nome = null;
    double preco = 4500.00;
    int quantidade = 10;

    Exception exception = assertThrows(NomeObrigatorioException.class, () ->
            new Produto(id, nome, preco, quantidade)
    );

    assertEquals("Nome do produto deve ser informado", exception.getMessage());

  }

  @Test
  void deveLancarExceptionParaNomeVazio(){
    int id = 1;
    String nome = "";
    double preco = 4500.00;
    int quantidade = 10;

    Exception exception = assertThrows(NomeObrigatorioException.class, () ->
            new Produto(id, nome, preco, quantidade)
    );

    assertEquals("Nome do produto deve ser informado", exception.getMessage());

  }

  @Test
  void deveLancarExceptionParaNomeContentoEspacoBranco(){
    int id = 1;
    String nome = "    ";
    double preco = 4500.00;
    int quantidade = 10;

    Exception exception = assertThrows(NomeObrigatorioException.class, () ->
            new Produto(id, nome, preco, quantidade)
    );

    assertEquals("Nome do produto deve ser informado", exception.getMessage());

  }

  @Test
  void deveLancarExceptionParaIdIgualZero(){
    int id = 0;
    String nome = "Notebook";
    double preco = 4500.00;
    int quantidade = 10;

    Exception exception = assertThrows(IdNegativoOuZeroException.class, () ->
            new Produto(id, nome, preco, quantidade)
    );

    assertEquals("O id do produto deve ser maior que zero", exception.getMessage());
  }

  @Test
  void deveLancarExceptionParaIdNegativo(){
    int id = -1;
    String nome = "Notebook";
    double preco = 4500.00;
    int quantidade = 10;

    Exception exception = assertThrows(IdNegativoOuZeroException.class, () ->
            new Produto(id, nome, preco, quantidade)
    );

    assertEquals("O id do produto deve ser maior que zero", exception.getMessage());
  }

  @Test
  void deveRetornarToString(){
    int id = 1;
    String nome = "Notebook";
    double preco = 4500.00;
    int quantidade = 10;


    Produto produto = new Produto(id, nome, preco, quantidade);

    assertEquals("Produto [ID=" + id + ", Nome=" + nome + ", Preço=" + preco + ", Estoque=" + quantidade + "]", produto.toString());
  }


}