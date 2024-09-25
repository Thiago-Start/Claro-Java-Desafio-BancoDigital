import java.util.HashMap;
import java.util.Map;

public class Banco {
    private Map<Integer, Conta> contas = new HashMap<>();

    public void adicionarConta(Conta conta) {
        contas.put(conta.getNumeroConta(), conta);
    }

    public Conta buscarContas(int numeroConta) {
        return contas.get(numeroConta);
    }

    public void listarContas() {
        for (Conta conta : contas.values()) {
            conta.imprimirInfoConta();
        }
    }
}
