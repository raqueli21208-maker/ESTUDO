import java.util.Scanner;

public class SistemaFuncionarios {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nomes = new String[10];
        double[] salario = new double[10];

        int cadastrados = 0;
        int opcao = -1;

        while (opcao != 0) {

            System.out.println("0- Sair");
            System.out.println("1- Cadastrar funcionários");
            System.out.println("2- Listar funcionários");
            System.out.println("3- Consultar funcionário");
            System.out.println("4- Alterar salário");
            System.out.println("5- Calcular média salariar");
            System.out.println("6- Maior salário");
            System.out.println("Escolha uma opcao: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Programa encerrado.");

                    break;
                case 1:
                    if (cadastrados == 10) {
                        System.out.println("Limite de funcionarios atingido!");
                    } else {
                        System.out.println("Nome do funcionario:");
                        String nome = sc.next();

                        System.out.println("Salario:");
                        double valor = sc.nextDouble();

                        nomes[cadastrados] = nome;
                        salario[cadastrados] = valor;

                        cadastrados++;

                        System.out.println("Funcionario cadastrado com sucesso!");
                    }

                    break;
                case 2:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum funcionário cadstrados");
                    } else {
                        for (int i = 0; i < cadastrados; i++) {
                            System.out.println((i + 1) + " - " + nomes[i] + ": R$ " + salario[i]);
                        }
                    }

                    break;
                case 3:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum funcionario cadastrado.");
                    } else {
                        System.out.println("Digite o numero do funcionario:");
                        int numero = sc.nextInt();

                        if (numero < 1 || numero > cadastrados) {
                            System.out.println("Funcionario nao encontrado.");
                        } else {
                            int pos = numero - 1;

                            System.out.println(nomes[pos] + ": R$ " + salario[pos]);
                        }
                    }

                    break;
                case 4:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum funcionario cadastrado.");
                    } else {
                        System.out.println("Digite o numero do funcionario:");
                        int numero = sc.nextInt();

                        if (numero < 1 || numero > cadastrados) {
                            System.out.println("Funcionario nao encontrado.");
                        } else {
                            int pos = numero - 1;

                            System.out.println("Digite o novo salario:");
                            double novoSalario = sc.nextDouble();

                            salario[pos] = novoSalario;

                            System.out.println("Salario alterado com sucesso!");
                        }
                    }

                    break;
                case 5:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum funcionario cadastrado.");
                    } else {
                        double soma = 0;

                        for (int i = 0; i < cadastrados; i++) {
                            soma = soma + salario[i];
                        }

                        double media = soma / cadastrados;

                        System.out.println("Media salarial: R$ " + media);
                    }

                    break;
                case 6:

                    if (cadastrados == 0) {
                        System.out.println("Nenhum funcionario cadastrado.");
                    } else {
                        double maior = salario[0];

                        for (int i = 1; i < cadastrados; i++) {
                            if (salario[i] > maior) {
                                maior = salario[i];
                            }
                        }

                        System.out.println("Maior salario: R$ " + maior);
                    }

                    break;
             }
          }
     }
 }
