public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void extrato() {
        System.out.println("___________________________");
        System.out.println("Extrato Conta Poupança");
        System.out.println("___________________________");
        super.imprimirInfoConta();

    }
}
