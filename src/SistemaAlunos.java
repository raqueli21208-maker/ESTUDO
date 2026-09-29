import java.util.Scanner;

public class SistemaAlunos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] nomes = new String[10];
        double[] notas = new double[10];

        int cadastrados = 0;
        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n===== SISTEMA DE ALUNOS =====");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Consultar aluno");
            System.out.println("4 - Alterar nota");
            System.out.println("5 - Calcular media da turma");
            System.out.println("6 - Mostrar maior e menor nota");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opcao:");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    if (cadastrados == 10) {
                        System.out.println("Limite de alunos atingido!");
                    } else {

                        System.out.println("Digite o nome do aluno:");
                        String nome = sc.next();

                        System.out.println("Digite a nota do aluno:");
                        double nota = sc.nextDouble();

                        if (nota < 0 || nota > 10) {
                            System.out.println("Nota invalida!");
                        } else {
                            nomes[cadastrados] = nome;
                            notas[cadastrados] = nota;

                            cadastrados++;

                            System.out.println("Aluno cadastrado com sucesso!");
                        }
                    }
                    break;

                case 2:
                    if (cadastrados == 0) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {

                        System.out.println("\n===== ALUNOS CADASTRADOS =====");

                        for (int i = 0; i < cadastrados; i++) {
                            System.out.println((i + 1) + " - " + nomes[i] + ": " + notas[i]);
                        }
                    }
                    break;

                case 3:
                    if (cadastrados == 0) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {

                        System.out.println("Digite o numero do aluno:");
                        int numero = sc.nextInt();

                        if (numero < 1 || numero > cadastrados) {
                            System.out.println("Aluno nao encontrado.");
                        } else {

                            int pos = numero - 1;

                            System.out.println("Nome: " + nomes[pos]);
                            System.out.println("Nota: " + notas[pos]);
                        }
                    }
                    break;

                case 4:
                    if (cadastrados == 0) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {

                        System.out.println("Digite o numero do aluno:");
                        int numero = sc.nextInt();

                        if (numero < 1 || numero > cadastrados) {
                            System.out.println("Aluno nao encontrado.");
                        } else {

                            int pos = numero - 1;

                            System.out.println("Digite a nova nota:");
                            double novaNota = sc.nextDouble();

                            if (novaNota < 0 || novaNota > 10) {
                                System.out.println("Nota invalida!");
                            } else {
                                notas[pos] = novaNota;

                                System.out.println("Nota alterada com sucesso!");
                            }
                        }
                    }
                    break;

                case 5:
                    if (cadastrados == 0) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {

                        double soma = 0;

                        for (int i = 0; i < cadastrados; i++) {
                            soma = soma + notas[i];
                        }

                        double media = soma / cadastrados;

                        System.out.println("Media da turma: " + media);
                    }
                    break;

                case 6:
                    if (cadastrados == 0) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {

                        double maior = notas[0];
                        double menor = notas[0];

                        int posMaior = 0;
                        int posMenor = 0;

                        for (int i = 1; i < cadastrados; i++) {

                            if (notas[i] > maior) {
                                maior = notas[i];
                                posMaior = i;
                            }

                            if (notas[i] < menor) {
                                menor = notas[i];
                                posMenor = i;
                            }
                        }

                        System.out.println("Maior nota: " + maior);
                        System.out.println("Aluno: " + nomes[posMaior]);

                        System.out.println("Menor nota: " + menor);
                        System.out.println("Aluno: " + nomes[posMenor]);
                    }
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;
            }
        }
    }
}

