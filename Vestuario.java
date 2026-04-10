public class Vestuario extends Loja {
    private boolean produtosImportados;

    public Vestuario(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                    Endereco endereco, Data dataFundacao, boolean produtosImportados,
                    int tamanhoEstoque) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanhoEstoque);
        this.produtosImportados = produtosImportados;
    }

    public Vestuario(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                    Endereco endereco, Data dataFundacao, boolean produtosImportados) {
        this(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, produtosImportados, 10);
    }

    public boolean getProdutosImportados() {
        return produtosImportados;
    }

    public void setProdutosImportados(boolean produtosImportados) {
        this.produtosImportados = produtosImportados;
    }

    @Override
    public String toString() {
        return super.toString() + "\nProdutos Importados: " + produtosImportados;
    }
}