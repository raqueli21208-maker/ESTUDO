import java.util.Scanner;

public class SistemaProdutos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] produtos = new String[5];
        int[] quantidade = new int[5];

        int cadastrados = 0;
        int opcao = -1;

        while (opcao != 0) {

            System.out.println("   SISTEMA DE PRODUTOS  ");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Consultar produto");
            System.out.println("4 - Alterar estoque");
            System.out.println("5 - Calcular total de unidades");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opcao:");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:

                    if (cadastrados == 5) {
                        System.out.println("Estoque cheio!");
                    } else {
                        System.out.println("Nome do produto:");
                        String nome = sc.next();

                        System.out.println("Quantidade inicial:");
                        int qtd = sc.nextInt();

                        if (qtd < 0) {
                            System.out.println("Quantidade invalida!");
                        } else {
                            produtos[cadastrados] = nome;
                            quantidade[cadastrados] = qtd;
                            cadastrados++;

                            System.out.println("Produto cadastrado com sucesso!");
                        }
                    }

                    break;

                case 2:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        System.out.println(" PRODUTOS CADASTRADOS ");

                        for (int i = 0; i < cadastrados; i++) {
                            System.out.println((i + 1) + " - " + produtos[i] + ": " + quantidade[i] + " unidades");
                        }
                    }

                    break;

                case 3:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        System.out.println("Digite o numero do produto:");
                        int numero = sc.nextInt();

                        if (numero < 1 || numero > cadastrados) {
                            System.out.println("Produto nao encontrado!");
                        } else {
                            int pos = numero - 1;

                            System.out.println(produtos[pos] + ": " + quantidade[pos] + " unidades");
                        }
                    }

                    break;

                case 4:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        System.out.println("Digite o numero do produto:");
                        int numero = sc.nextInt();

                        if (numero < 1 || numero > cadastrados) {
                            System.out.println("Produto nao encontrado!");
                        } else {
                            System.out.println("Digite a nova quantidade:");
                            int novaQuantidade = sc.nextInt();

                            if (novaQuantidade < 0) {
                                System.out.println("Quantidade invalida!");
                            } else {
                                int pos = numero - 1;

                                quantidade[pos] = novaQuantidade;

                                System.out.println("Estoque alterado com sucesso!");
                            }
                        }
                    }

                    break;

                case 5:

                    int total = 0;

                    for (int i = 0; i < cadastrados; i++) {
                        total = total + quantidade[i];
                    }

                    System.out.println("Total de unidades: " + total);

                    break;

                case 0:

                    System.out.println("Programa encerrado.");

                    break;

                default:

                    System.out.println("Opcao invalida!");
            }
        }
    }
}