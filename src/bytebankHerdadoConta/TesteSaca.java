package bytebankHerdadoConta;

public class TesteSaca {

	public static void main(String[] args) {
		Conta conta = new ContaCorrente(767, 74098);
		conta.deposita(200.0);
		conta.saca(200.0);
		
		System.out.println(conta.getSaldo());
	}

}
