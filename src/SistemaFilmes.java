import java.util.Scanner;

public class SistemaFilmes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] filmes = new String[6];
        int[] estoque = new int[6];

        int cadastrados = 0;
        int opcao = -1;

        while (opcao != 0) {

            System.out.println(" SISTEMA DE FILMES");
            System.out.println("1- Cadastra filmes");
            System.out.println("2- Listar filmes");
            System.out.println("3- Alugar filme");
            System.out.println("4- Devolver filme");
            System.out.println("5- Consultar filme");
            System.out.println("6- Total de filmes disponiveis");
            System.out.println("0- Sair");
            System.out.println("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    if (cadastrados == 6) {
                        System.out.println("Limite de filmes atingido!");
                    } else {
                        System.out.println("Digite o nome do filme: ");
                        String nome = sc.next();

                        System.out.println("Digite a quantidade inicial");
                        int quantidade = sc.nextInt();

                        if (quantidade < 0) {
                            System.out.println("Quantidade invalida!");
                        } else {
                            filmes[cadastrados] = nome;
                            estoque[cadastrados] = quantidade;
                            cadastrados++;

                            System.out.println("Filmes cadastrados com sucesso!");
                        }
                    }
                    break;

                case 2:
                    if (cadastrados == 0) {
                        System.out.println("Nenhum filme cadastrado");
                    } else {
                        System.out.println(" FILMES CADASTRADOS ");

                        for (int i = 0; i < cadastrados; i++) {
                            System.out.println((i + 1) + "-" + filmes[i] + ": " + estoque[i] + "disponiveis ");
                        }
                    }
                    break;

                case 3:
                    if (cadastrados == 0) {
                        System.out.println("Nenhum filme cadstrado");
                    } else {

                        for (int i = 0; i < cadastrados; i++) {
                            System.out.println((i + 1) + "-" + filmes[i] + ": " + estoque[i] + "disponiveis ");
                        }
                        System.out.println("Digite o número do filme: ");
                        int numero = sc.nextInt();

                        if (numero < 1 || numero > cadastrados) {
                            System.out.println("Filme não encontrado");
                        } else {

                            int pos = numero - 1;
                            System.out.println("Digite a quantidade para alugar");
                            int qntAlugar = sc.nextInt();

                            if (qntAlugar <= 0) {
                                System.out.println("Quantidade inválida!");
                            } else if (qntAlugar > estoque[pos]) {
                                System.out.println("Estoque insuficiente!");
                            } else {

                                estoque[pos] = estoque[pos] - qntAlugar;

                                System.out.println("Aluguel realizado com sucesso");
                                System.out.println("Filmes disponiveis: " + estoque[pos]);
                            }
                        }
                    }
                    break;

                case 4:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum filme cadastrado");
                    } else {

                        for (int i = 0; i < cadastrados; i++) {
                            System.out.println((i + 1) + " - " + filmes[i] + ": " + estoque[i] + " disponiveis ");
                        }
                        System.out.println("Digite o numero do filme: ");
                        int numero = sc.nextInt();

                        if (numero < 1 || numero > cadastrados) {
                            System.out.println("Filme nao encontrado");
                        } else {

                            int pos = numero - 1;

                            System.out.println("Digite a quantidade para devolver: ");
                            int qtdDevolver = sc.nextInt();

                            if (qtdDevolver <= 0) {
                                System.out.println("Quantidade invalida!");
                            } else {

                                estoque[pos] = estoque[pos] + qtdDevolver;

                                System.out.println("Devolucao realizada com sucesso!");
                                System.out.println("Filmes disponiveis: " + estoque[pos]);
                            }
                        }
                    }

                    break;

                case 5:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum filme cadastrado");
                    } else {

                        System.out.println("Digite o numero do filme: ");
                        int numero = sc.nextInt();

                        if (numero < 1 || numero > cadastrados) {
                            System.out.println("Filme nao encontrado");
                        } else {

                            int pos = numero - 1;

                            System.out.println("Filme: " + filmes[pos]);
                            System.out.println("Disponiveis: " + estoque[pos]);
                        }
                    }

                    break;

                case 6:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum filme cadastrado");
                    } else {

                        int total = 0;

                        for (int i = 0; i < cadastrados; i++) {
                            total = total + estoque[i];
                        }

                        System.out.println("Total de filmes disponiveis: " + total);
                    }

                    break;

                case 0:

                    System.out.println("Programa encerrado");

                    break;
            }
        }
    }
}

