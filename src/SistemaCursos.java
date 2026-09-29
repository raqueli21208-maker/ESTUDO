import java.util.Scanner;

public class SistemaCursos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] cursos = new String[8];
        int[] vagas = new int[8];

        int cadastrados = 0;
        int opcao = -1;

        while (opcao != 0) {

            System.out.println(" SISTEMA DE CURSOS ");
            System.out.println("1 - Cadastrar curso");
            System.out.println("2 - Listar cursos");
            System.out.println("3 - Consultar curso");
            System.out.println("4 - Alterar numero de vagas");
            System.out.println("5 - Calcular total de vagas");
            System.out.println("6 - Mostrar curso com mais vagas");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opcao:");

            opcao = sc.nextInt();

            switch (opcao) {

                case 0:
                    System.out.println("Programa encerrado.");

                    break;

                case 1:

                    if (cadastrados == 8) {
                        System.out.println("Limite de cursos atingido!");
                    } else {
                        System.out.println("Digite o nome do curso:");
                        String nome = sc.next();

                        System.out.println("Digite o numero de vagas:");
                        int quantidade = sc.nextInt();

                        if (quantidade < 0) {
                            System.out.println("Numero de vagas invalido!");
                        } else {
                            cursos[cadastrados] = nome;
                            vagas[cadastrados] = quantidade;

                            cadastrados++;

                            System.out.println("Curso cadastrado com sucesso!");
                        }
                    }

                    break;

                case 2:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum curso cadastrado.");
                    } else {

                        System.out.println(" CURSOS CADASTRADOS ");

                        for (int i = 0; i < cadastrados; i++) {
                            System.out.println((i + 1) + " - " + cursos[i] + ": " + vagas[i] + " vagas");
                        }
                    }

                    break;

                case 3:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum curso cadastrado.");
                    } else {

                        System.out.println("Digite o numero do curso:");
                        int numero = sc.nextInt();

                        if (numero < 1 || numero > cadastrados) {
                            System.out.println("Curso nao encontrado.");
                        } else {

                            int pos = numero - 1;

                            System.out.println("Curso: " + cursos[pos]);
                            System.out.println("Vagas: " + vagas[pos]);
                        }
                    }

                    break;

                case 4:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum curso cadastrado.");
                    } else {

                        System.out.println("Digite o numero do curso:");
                        int numero = sc.nextInt();

                        if (numero < 1 || numero > cadastrados) {
                            System.out.println("Curso nao encontrado.");
                        } else {

                            int pos = numero - 1;

                            System.out.println("Digite o novo numero de vagas:");
                            int novasVagas = sc.nextInt();

                            if (novasVagas < 0) {
                                System.out.println("Numero de vagas invalido!");
                            } else {

                                vagas[pos] = novasVagas;

                                System.out.println("Numero de vagas alterado com sucesso!");
                            }
                        }
                    }

                    break;

                case 5:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum curso cadastrado.");
                    } else {

                        int total = 0;

                        for (int i = 0; i < cadastrados; i++) {
                            total = total + vagas[i];
                        }

                        System.out.println("Total de vagas: " + total);
                    }

                    break;

                case 6:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum curso cadastrado.");
                    } else {

                        int maior = vagas[0];
                        int posMaior = 0;

                        for (int i = 1; i < cadastrados; i++) {

                            if (vagas[i] > maior) {
                                maior = vagas[i];
                                posMaior = i;
                            }
                        }

                        System.out.println("Curso com mais vagas: " + cursos[posMaior]);
                        System.out.println("Quantidade de vagas: " + maior);
                    }

                    break;
            }
        }
    }
}

