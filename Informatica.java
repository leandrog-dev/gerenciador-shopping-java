public class Informatica extends Loja {
    private double seguroEletronicos;

    public Informatica(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                      Endereco endereco, Data dataFundacao, double seguroEletronicos,
                      int tamanhoEstoque) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanhoEstoque);
        this.seguroEletronicos = seguroEletronicos;
    }

    public Informatica(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                      Endereco endereco, Data dataFundacao, double seguroEletronicos) {
        this(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, seguroEletronicos, 10);
    }

    public double getSeguroEletronicos() {
        return seguroEletronicos;
    }

    public void setSeguroEletronicos(double seguroEletronicos) {
        this.seguroEletronicos = seguroEletronicos;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSeguro Eletrônico: R$" + seguroEletronicos;
    }
}