public class Alimentacao extends Loja {
    private Data dataAlvara;
   
    public Alimentacao(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                     Endereco endereco, Data dataFundacao, Data dataAlvara,
                     int tamanhoEstoque) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanhoEstoque);
        this.dataAlvara = dataAlvara;
    }

    public Alimentacao(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                     Endereco endereco, Data dataFundacao, Data dataAlvara) {
        this(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, dataAlvara, 10);
    }

    public Data getDataAlvara() {
        return dataAlvara;
    }

    public void setDataAlvara(Data dataAlvara) {
        this.dataAlvara = dataAlvara;
    }

    @Override
    public String toString() {
        return super.toString() + "\nData do Alvará: " + dataAlvara.toString();
    }
}