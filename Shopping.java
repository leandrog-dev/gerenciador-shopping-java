public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int qtdMaxLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[qtdMaxLojas];
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public Loja[] getLojas() { return lojas; }
    public void setLojas(Loja[] lojas) { this.lojas = lojas; }

    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nome) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equalsIgnoreCase(nome)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipo) {
    int count = 0;
    for (Loja loja : lojas) {
        if (loja != null) {
            
            if ((tipo.equalsIgnoreCase("Cosmético") && loja instanceof Cosmetico) ||
                (tipo.equalsIgnoreCase("Vestuário") && loja instanceof Vestuario) ||
                (tipo.equalsIgnoreCase("Bijuteria") && loja instanceof Bijuteria) ||
                (tipo.equalsIgnoreCase("Alimentação") && loja instanceof Alimentacao) ||
                (tipo.equalsIgnoreCase("Informática") && loja instanceof Informatica)) {
                count++;
            }
        }
    }
    
    return (tipo.equalsIgnoreCase("Cosmético") || 
            tipo.equalsIgnoreCase("Vestuário") || 
            tipo.equalsIgnoreCase("Bijuteria") ||
            tipo.equalsIgnoreCase("Alimentação") || 
            tipo.equalsIgnoreCase("Informática")) ? count : -1;
}

    public Informatica lojaSeguroMaisCaro() {
        Informatica maisCara = null;
        for (Loja loja : lojas) {
            if (loja instanceof Informatica) {
                Informatica info = (Informatica) loja;
                if (maisCara == null || info.getSeguroEletronicos() > maisCara.getSeguroEletronicos()) {
                    maisCara = info;
                }
            }
        }
        return maisCara;
    }

    public String toString() {
        String s = "Shopping: " + nome + "\nEndereço: " + endereco + "\nLojas:\n";
        for (Loja loja : lojas) {
            if (loja != null) {
                s += loja.toString() + "\n---------------------\n";
            }
        }
        return s;
    }
}
    
