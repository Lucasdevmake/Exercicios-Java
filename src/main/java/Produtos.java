public class Produtos {
    private double valor; //atributos da classe
    private String nome;

    public Produtos (String nome, double valor) { // construtor da classe para criar novos objetos
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() { // metodo get retorna o nome
        return nome;
    }

    public double getValor() { //metodo get retorna o valor
        return valor;
    }
}
