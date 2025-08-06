package br.com.unipds.fundamentosjava.desafio;

public class Produto {

    private final int id;
    private final String nome;
    private final double preco;
    private final int quantidadeEmEstoque;

    public Produto(int id, String nome, double preco, int quantidadeEmEstoque) {
        this.id = id;
        validarId();

        this.nome = nome;
        validarNome();

        this.preco = preco;
        validarPreco();

        this.quantidadeEmEstoque = quantidadeEmEstoque;
        validarEstoque();
    }



    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }


    public double getPreco() {
        return preco;
    }


    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    @Override
    public String toString() {
        return "Produto [ID=" + id + ", Nome=" + nome + ", Preço=" + preco + ", Estoque=" + quantidadeEmEstoque + "]";
    }

    private void validarId() {
        if(id <=0){
            throw new IdNegativoOuZeroException("O id do produto deve ser maior que zero");
        }
    }

    private void validarNome(){
        if(nome == null || nome.isEmpty()){
            throw new NomeObrigatorioException("Nome do produto deve ser informado");
        }
    }

    private void validarPreco(){
        if(preco <= 0){
            throw new PrecoZeroOuNegativoException("Preço deve ser maior que zero");
        }
    }

    private void validarEstoque(){
        if(quantidadeEmEstoque < 0.0){
            throw new EstoqueNegativoException("Quantidade em estoque não pode ser negativo");
        }
    }

}
