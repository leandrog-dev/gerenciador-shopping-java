import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Loja loja = null;
        Produto produto = null;
        int opcao;

        do {
            System.out.println("\nMENU:");
            System.out.println("(1) Criar uma loja");
            System.out.println("(2) Criar um produto");
            System.out.println("(3) Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    loja = criarLoja(sc);
                    break;
                case 2:
                   produto = criarProduto(sc, loja); // Agora passando a loja como parâmetro
                   verificarProduto(produto, loja);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);
        sc.close();
    }

    private static Loja criarLoja(Scanner sc) {
        System.out.println("\n--- Criação de Loja ---");
        System.out.print("Nome da loja: ");
        String nomeLoja = sc.nextLine();
        
        System.out.print("Quantidade de funcionários: ");
        int qtdFunc = sc.nextInt();
        
        System.out.print("Salário base (digite -1 se não souber): ");
        double salario = sc.nextDouble();
        sc.nextLine(); // Limpar buffer
        
        Endereco endereco = criarEndereco(sc);
        Data fundacao = criarData(sc, "Data de fundação (dd/mm/aaaa): ");
        
        System.out.print("Tamanho do estoque (padrão 10): ");
        int tamanhoEstoque = sc.nextInt();
        sc.nextLine(); // Limpar buffer
        
        Loja novaLoja;
        if (salario == -1) {
            novaLoja = new Loja(nomeLoja, qtdFunc, endereco, fundacao, tamanhoEstoque);
        } else {
            novaLoja = new Loja(nomeLoja, qtdFunc, salario, endereco, fundacao, tamanhoEstoque);
        }
        
        System.out.println("Loja criada com sucesso!");
        return novaLoja;
    }

    private static Endereco criarEndereco(Scanner sc) {
        System.out.println("\n--- Endereço da Loja ---");
        System.out.print("Rua: ");
        String rua = sc.nextLine();
        
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();
        
        System.out.print("Estado: ");
        String estado = sc.nextLine();
        
        System.out.print("País: ");
        String pais = sc.nextLine();
        
        System.out.print("CEP: ");
        String cep = sc.nextLine();
        
        System.out.print("Número: ");
        String numero = sc.nextLine();
        
        System.out.print("Complemento: ");
        String complemento = sc.nextLine();
        
        return new Endereco(rua, cidade, estado, pais, cep, numero, complemento);
    }

    private static Data criarData(Scanner sc, String mensagem) {
        System.out.print(mensagem);
        String dataStr = sc.nextLine();
        String[] partes = dataStr.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);
        return new Data(dia, mes, ano);
    }

    private static Produto criarProduto(Scanner sc, Loja loja) {
    System.out.println("\n--- Criação de Produto ---");
    System.out.print("Nome do produto: ");
    String nomeProduto = sc.nextLine();
    
    System.out.print("Preço: ");
    double preco = sc.nextDouble();
    sc.nextLine(); 
    
    Data validade = criarData(sc, "Data de validade (dd/mm/aaaa): ");
    
    Produto novoProduto = new Produto(nomeProduto, preco, validade);
    
    if (loja != null) {
        boolean adicionado = loja.insereProduto(novoProduto);
        if (!adicionado) {
            System.out.println("Não foi possível adicionar o produto - estoque cheio!");
        }
    }
    
    return novoProduto;
    }

    private static void verificarProduto(Produto produto, Loja loja) {
        Data dataReferencia = new Data(20, 10, 2023); 
        
        System.out.println("\n--- Status do Produto ---");
        if (produto.estaVencido(dataReferencia)) {
            System.out.println("ATENÇÃO: PRODUTO VENCIDO");
        } else {
            System.out.println("PRODUTO DENTRO DO PRAZO");
        }
        
        System.out.println("\n--- Informações da Loja ---");
        if (loja != null) {
            System.out.println(loja);
        } else {
            System.out.println("Nenhuma loja cadastrada ainda.");
        }
    }
}