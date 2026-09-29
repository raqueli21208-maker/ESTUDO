import java.util.Scanner;

public class SistemaDeLivros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] livros = new String[5];
        int[] exemplares = new int[5];

        int cadastrados = 0;
        int opcao = -1;

        while (opcao != 0) {

            System.out.println(" SISTEMA DE CONTROLE DE BIBLIOTECA ");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar acervo");
            System.out.println("3 - Empréstimo de livro");
            System.out.println("4 - Devolução / Reposição de livro");
            System.out.println("5 - Consultar e alterar nome do livro");
            System.out.println("6 - Relatório geral do acervo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:

                    if (cadastrados == 5) {
                        System.out.println("Capacidade máxima atingida (5 livros)!");
                    } else {
                        System.out.print("Digite o nome do livro: ");
                        String nome = sc.next();

                        System.out.print("Digite a quantidade inicial de exemplares: ");
                        int qtd = sc.nextInt();

                        if (qtd < 0) {
                            System.out.println("Quantidade inválida!");
                        } else {
                            livros[cadastrados] = nome;
                            exemplares[cadastrados] = qtd;

                            cadastrados++;

                            System.out.println("Livro cadastrado com sucesso!");
                        }
                    }

                    break;

                case 2:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        System.out.println(" ACERVO CADASTRADO ");

                        for (int i = 0; i < cadastrados; i++) {
                            System.out.println((i + 1) + " - " + livros[i] + ": " + exemplares[i] + " exemplares");
                        }
                    }

                    break;

                case 3:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {

                        System.out.println(" EMPRÉSTIMO DE LIVRO ");

                        for (int i = 0; i < cadastrados; i++) {
                            System.out.println((i + 1) + " - " + livros[i] + " (" + exemplares[i] + " disponíveis)");
                        }

                        System.out.print("Digite o número do livro: ");
                        int num = sc.nextInt();

                        if (num < 1 || num > cadastrados) {
                            System.out.println("Escolha inválida!");
                        } else {
                            System.out.print("Quantidade para empréstimo: ");
                            int qtdEmp = sc.nextInt();

                            int pos = num - 1;

                            if (qtdEmp <= 0) {
                                System.out.println("Quantidade inválida!");
                            } else if (qtdEmp > exemplares[pos]) {
                                System.out.println("Estoque insuficiente!");
                            } else {
                                exemplares[pos] = exemplares[pos] - qtdEmp;

                                System.out.println("Empréstimo realizado! " + livros[pos] + " agora tem " + exemplares[pos] + " exemplares.");
                            }
                        }
                    }

                    break;

                case 4:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {

                        System.out.println(" DEVOLUÇÃO / REPOSIÇÃO ");

                        for (int i = 0; i < cadastrados; i++) {
                            System.out.println((i + 1) + " - " + livros[i] + " (" + exemplares[i] + " exemplares)");
                        }

                        System.out.print("Digite o número do livro: ");
                        int num = sc.nextInt();

                        if (num < 1 || num > cadastrados) {
                            System.out.println("Escolha inválida!");
                        } else {
                            System.out.print("Quantidade a adicionar: ");
                            int qtdDev = sc.nextInt();

                            int pos = num - 1;

                            if (qtdDev <= 0) {
                                System.out.println("Quantidade inválida!");
                            } else {
                                exemplares[pos] = exemplares[pos] + qtdDev;

                                System.out.println("Estoque atualizado! " + livros[pos] + " agora tem " + exemplares[pos] + " exemplares.");
                            }
                        }
                    }

                    break;

                case 5:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        System.out.print("Digite o número do livro para alterar o nome: ");
                        int num = sc.nextInt();

                        if (num < 1 || num > cadastrados) {
                            System.out.println("Livro não encontrado!");
                        } else {
                            int pos = num - 1;

                            System.out.println("Nome atual: " + livros[pos]);

                            System.out.print("Digite o novo nome: ");
                            String novoNome = sc.next();

                            livros[pos] = novoNome;

                            System.out.println("Nome alterado com sucesso!");
                        }
                    }

                    break;

                case 6:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        int totalExemplares = 0;
                        int maiorQtd = exemplares[0];
                        int posMaior = 0;

                        for (int i = 0; i < cadastrados; i++) {

                            totalExemplares = totalExemplares + exemplares[i];

                            if (exemplares[i] > maiorQtd) {
                                maiorQtd = exemplares[i];
                                posMaior = i;
                            }
                        }

                        double media = (double) totalExemplares / cadastrados;

                        System.out.println(" RELATÓRIO DO ACERVO ");
                        System.out.println("Total de exemplares no acervo: " + totalExemplares);
                        System.out.println("Média de exemplares por título: " + media);
                        System.out.println("Livro com maior estoque: " + livros[posMaior] + " (" + maiorQtd + " exemplares)");
                    }

                    break;
            }
        }
    }
}

