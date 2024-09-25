public interface Operacao {

    void deposito(double valor);
    void sacar(double valor);
    void transferir(double valor, Conta contaDestino);
    void extrato();
}
