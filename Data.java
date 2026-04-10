public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (dataValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data inválida! Usando data padrão 01/01/2000.");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    private boolean dataValida(int d, int m, int a) {
        if (m < 1 || m > 12 || d < 1) return false;
        int[] diasMes = { 31, (verificaAnoBissexto(a) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        return d <= diasMes[m - 1];
    }

    public boolean verificaAnoBissexto() {
        return verificaAnoBissexto(this.ano);
    }

    private boolean verificaAnoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    public int getDia() { return dia; }
    public int getMes() { return mes; }
    public int getAno() { return ano; }

    // ✅ CORREÇÃO: validação nos setters
    public void setDia(int dia) {
        if (dataValida(dia, this.mes, this.ano)) {
            this.dia = dia;
        }
    }

    public void setMes(int mes) {
        if (dataValida(this.dia, mes, this.ano)) {
            this.mes = mes;
        }
    }

    public void setAno(int ano) {
        if (dataValida(this.dia, this.mes, ano)) {
            this.ano = ano;
        }
    }

    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}