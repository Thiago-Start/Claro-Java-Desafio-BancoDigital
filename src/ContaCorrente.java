public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public void extrato() {
        System.out.println("___________________________");
        System.out.println("Extrato Conta Corrente");
        System.out.println("___________________________");
        super.imprimirInfoConta();
    }
}
