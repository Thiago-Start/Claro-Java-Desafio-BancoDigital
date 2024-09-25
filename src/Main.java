import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nBem-Vindo ao DIO Bank!");
            System.out.println("1. Criar nova conta Corrente");
            System.out.println("2. Criar nova conta Poupança");
            System.out.println("3. Acessar conta existente");
            System.out.println("4. Listar todas as contas");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:

                    System.out.println("Digite o nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.println("Digite a idade do Cliente: ");
                    int idadeCliente = scanner.nextInt();
                    if (idadeCliente >= 18) {
                        Cliente cliente = new Cliente(nomeCliente, idadeCliente);
                        Conta novaContaCorrente = new Conta(cliente);
                        banco.adicionarConta(novaContaCorrente);
                        System.out.println("Conta criada com sucesso! Número da conta: " + novaContaCorrente.getNumeroConta());
                    } else {
                        System.out.println("Desculpe " + nomeCliente + ", não podemos criar uma conta para você.");
                        System.out.println("Para criar uma conta você precisa ter 18 anos ou mais.");
                    }
                    break;

                case 2:

                    System.out.println("Digite o nome do Cliente: ");
                    String nomeCliente2 = scanner.nextLine();
                    System.out.println("Digite a idade do Cliente: ");
                    int idadeCliente2 = scanner.nextInt();
                    if (idadeCliente2 >= 18) {
                        Cliente cliente = new Cliente(nomeCliente2, idadeCliente2);
                        Conta novaContaPoupanca = new Conta(cliente);
                        banco.adicionarConta(novaContaPoupanca);
                        System.out.println("Conta criada com sucesso! Número da conta: " + novaContaPoupanca.getNumeroConta());
                    } else {
                        System.out.println("Desculpe " + nomeCliente2 + ", não podemos criar uma conta para você.");
                        System.out.println("Para criar uma conta você precisa ter 18 anos ou mais.");
                    }
                    break;

                case 3:

                    System.out.println("Digite o número da conta: ");
                    int numeroConta = scanner.nextInt();
                    Conta contaExistente = banco.buscarContas(numeroConta);
                    if (contaExistente != null) {
                        int opcaoConta;
                        do {
                            System.out.println("\nConta: " + numeroConta);
                            System.out.println("1. Ver Saldo");
                            System.out.println("2. Depositar");
                            System.out.println("3. Sacar");
                            System.out.println("4. Transferir");
                            System.out.println("5. Voltar ao menu principal");
                            System.out.println("Escollha uma opção: ");
                            opcaoConta = scanner.nextInt();

                            switch (opcaoConta) {
                                case 1:
                                    contaExistente.imprimirInfoConta();
                                    break;

                                case 2:
                                    System.out.println("Digite o valor a depositar: ");
                                    double valorDeposito = scanner.nextDouble();
                                    contaExistente.deposito(valorDeposito);
                                    System.out.println("Depósito realizado com sucesso!");
                                    break;

                                case 3:
                                    System.out.println("Digite o valor a sacar: ");
                                    double valorSaque = scanner.nextDouble();
                                    contaExistente.sacar(valorSaque);
                                    break;

                                case 4:
                                    System.out.println("Digite o número da conta de destino: ");
                                    int numeroContaDestino = scanner.nextInt();
                                    Conta contaDestino = banco.buscarContas(numeroContaDestino);

                                    if (contaDestino != null) {
                                        System.out.println("Digite o valor a transferir: ");
                                        double valorTransferencia = scanner.nextDouble();
                                        contaExistente.transferir(valorTransferencia, contaDestino);
                                        System.out.println("Transferência realizada com sucesso!");
                                    } else {
                                        System.out.println("Conta de destino não encontrada.");
                                    }
                                    break;

                                case 5:
                                    System.out.println("Voltando ao menu principal...");
                                    break;

                                default:
                                    System.out.println("Opção Inválida!");
                            }
                        } while (opcaoConta != 5);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    banco.listarContas();
                    break;

                case 5:
                    System.out.println("Obrigado por utilizar o DIO Bank. Até logo!");
                    break;

                default:
                    System.out.println("Opção Inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}