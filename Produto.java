public class Produto {
    private String nome;
    private double preco;
    private Data dataValidade;

    public Produto(String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = null;
    }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public Data getDataValidade() { return dataValidade; }
    public void setDataValidade(Data dataValidade) { this.dataValidade = dataValidade; }

    public boolean estaVencido(Data dataAtual) {
        
        if (this.dataValidade == null) return false;

        if (this.dataValidade.getAno() < dataAtual.getAno()) return true;
        if (this.dataValidade.getAno() == dataAtual.getAno()) {
            if (this.dataValidade.getMes() < dataAtual.getMes()) return true;
            if (this.dataValidade.getMes() == dataAtual.getMes()) {
                return this.dataValidade.getDia() < dataAtual.getDia();
            }
        }
        return false;
    }

    public String toString() {
        return "Produto: " + nome + 
               "\nPreço: " + preco + 
               "\nValidade: " + (dataValidade != null ? dataValidade : "Sem validade");
    }
}
