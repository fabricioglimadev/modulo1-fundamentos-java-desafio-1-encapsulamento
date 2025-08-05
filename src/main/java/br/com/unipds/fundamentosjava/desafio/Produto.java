package br.com.unipds.fundamentosjava.desafio;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

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

    private void validarId() {
        if(id <=0){
            throw new RuntimeException("O id do produto deve ser maior que zero");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        validarNome();
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
        validarPreco();
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        validarEstoque();
    }

    @Override
    public String toString() {
        return "Produto [ID=" + id + ", Nome=" + nome + ", Preço=" + preco + ", Estoque=" + quantidadeEmEstoque + "]";
    }

    private void validarNome(){
        if(nome == null || nome.isEmpty()){
            throw new RuntimeException("Nome do produto deve ser informado");
        }
    }

    private void validarPreco(){
        if(preco <= 0){
            throw new RuntimeException("Preço de deve ser maior que zero");
        }
    }

    private void validarEstoque(){
        if(quantidadeEmEstoque < 0.0){
            throw new RuntimeException("Quantidade em estoque não pode ser negativo");
        }
    }

}
