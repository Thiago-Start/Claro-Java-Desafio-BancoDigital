public class Conta implements Operacao{

    private static final int AGENCIA_PADRAO = 1234;
    private static int SEQUENCIAL = 1;

    protected int numeroConta;
    protected int agencia;
    protected double saldo;
    Cliente cliente;

    public Conta(Cliente cliente) {
        this.numeroConta = SEQUENCIAL++;
        this.agencia = AGENCIA_PADRAO;
        this.cliente = cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void deposito(double valor) {
       if (valor > 0) {
           this.saldo = saldo + valor;
       } else {
           System.out.println("Valor de depósito inválido.this.saldo = saldo + valor;");
       }
    }

    @Override
    public void sacar(double valor) {
        if(this.saldo >= valor) {
            this.saldo = saldo - valor;
            System.out.println(String.format("Seu novo saldo é: %.2f", this.saldo));
        } else {
            System.out.println("Operação Negada: Saldo Indisponivel.");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(valor <= this.saldo) {
           this.sacar(valor);
           contaDestino.deposito(valor);
        } else {
            System.out.println("Operção Negada: Saldo Insuficiente.");
        }
    }

    @Override
    public void extrato() {
        System.out.println(String.format("Extrato: Saldo Atual: %.2f", this.saldo));
    }

    protected void imprimirInfoConta(){
        System.out.println(String.format("Titular da Conta: %s", this.cliente.getNome()));
        System.out.println(String.format("Número da Conta: %d", this.numeroConta));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
