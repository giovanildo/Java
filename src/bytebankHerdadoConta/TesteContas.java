package bytebankHerdadoConta;

import java.util.ArrayList;
import java.util.Comparator;

public class TesteContas {

	public static void main(String[] args) throws SaldoInsuficienteException {
		ArrayList<ContaCorrente> lista = new ArrayList<>();			
		
		ContaCorrente cc1 = new ContaCorrente(111, 111);
		ContaCorrente cc2 = new ContaCorrente(111, 444);
		ContaCorrente cc3 = new ContaCorrente(111, 333);
		ContaCorrente cc4 = new ContaCorrente(111, 222);
		ContaCorrente cc5 = new ContaCorrente(111, 443);
		ContaCorrente cc6 = new ContaCorrente(111, 123);
		ContaCorrente cc7 = new ContaCorrente(111, 343);
		ContaCorrente cc8 = new ContaCorrente(111, 112);
		
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		lista.add(cc4);
		lista.add(cc5);
		lista.add(cc6);
		lista.add(cc7);
		lista.add(cc8);
		
		for (ContaCorrente contaCorrente : lista) {
			System.out.println(contaCorrente.getNumero());			
		}
		lista.sort(new Classificar());
		System.out.println("--------------------------");
		
		for (ContaCorrente contaCorrente : lista) {
			System.out.println(contaCorrente.getNumero());			
		}
		
		
	}

}

class Classificar implements Comparator<Conta>{
	@Override
	public int compare(Conta o1, Conta o2) {
		if (o1.getNumero()< o2.getNumero()) {
			return -1;
		}
		if (o1.getNumero()> o2.getNumero()) {
			return 1;
		}
		return 0;
	}
	
	
}