public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos;
    private int produtosCadastrados;
    
    // Construtores principais
    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco,
            Data dataFundacao, int tamanhoEstoque) {
        this(nome, quantidadeFuncionarios, -1.0, endereco, dataFundacao, tamanhoEstoque);
    }

    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
            Endereco endereco, Data dataFundacao, int tamanhoEstoque) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        // ✅ Correção: evitar tamanho inválido
        this.estoqueProdutos = new Produto[tamanhoEstoque > 0 ? tamanhoEstoque : 10];
        this.produtosCadastrados = 0;
    }
    
    // Construtores sobrecarregados
    public Loja(String nome, int quantidadeFuncionarios) {
        this(nome, quantidadeFuncionarios, -1, null, null, 10);
    }

    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario) {
        this(nome, quantidadeFuncionarios, salarioBaseFuncionario, null, null, 10);
    }

    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao) {
        this(nome, quantidadeFuncionarios, -1, endereco, dataFundacao, 10);
    }

    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
            Endereco endereco, Data dataFundacao) {
        this(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, 10);
    }

    public boolean insereProduto(Produto p) {
        if (produtosCadastrados < estoqueProdutos.length) {
            estoqueProdutos[produtosCadastrados] = p;
            produtosCadastrados++;
            return true;
        }
        return false;
    }

    public boolean removeProduto(String nomeProduto) {
        for (int i = 0; i < produtosCadastrados; i++) {
            // ✅ Correção: evitar NullPointerException
            if (estoqueProdutos[i] != null &&
                estoqueProdutos[i].getNome() != null &&
                nomeProduto != null &&
                nomeProduto.equalsIgnoreCase(estoqueProdutos[i].getNome())) {

                System.arraycopy(estoqueProdutos, i+1, estoqueProdutos, i,
                        produtosCadastrados - i - 1);

                estoqueProdutos[--produtosCadastrados] = null;
                return true;
            }
        }
        return false;
    }

    public Produto[] getEstoqueProdutos() {
        return estoqueProdutos;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getQuantidadeFuncionarios() { return quantidadeFuncionarios; }
    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public double getSalarioBaseFuncionario() { return salarioBaseFuncionario; }
    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public Data getDataFundacao() { return dataFundacao; }
    public void setDataFundacao(Data dataFundacao) { this.dataFundacao = dataFundacao; }

    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
        if (estoqueProdutos != null) {
            produtosCadastrados = 0;
            for (int i = 0; i < estoqueProdutos.length; i++) {
                if (estoqueProdutos[i] != null) produtosCadastrados++;
            }
        } else {
            produtosCadastrados = 0;
        }
    }
    
    public double gastosComSalario() {
        if (salarioBaseFuncionario == -1) return -1;
        return quantidadeFuncionarios * salarioBaseFuncionario;
    }

    public void imprimeProdutos() {
        if (estoqueProdutos == null || produtosCadastrados == 0) {
            System.out.println("A loja não possui produtos no estoque.");
            return;
        }
        System.out.println("=== Produtos no Estoque ===");
        for (int i = 0; i < produtosCadastrados; i++) {
            if (estoqueProdutos[i] != null) {
                System.out.println(estoqueProdutos[i].toString());
            }
        }
    }

    public char tamanhoDaLoja() {
        if (quantidadeFuncionarios < 10) return 'P';
        else if (quantidadeFuncionarios <= 30) return 'M';
        else return 'G';
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nFuncionários: " + quantidadeFuncionarios +
               "\nSalário base: " + salarioBaseFuncionario +
               "\nEndereço: " + endereco +
               "\nData de fundação: " + dataFundacao +
               "\nTamanho do estoque: " + (estoqueProdutos != null ? estoqueProdutos.length : 0) +
               "\nProdutos cadastrados: " + produtosCadastrados;
    }
}