package collections;

public final class Teste {
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com colecoes", 24));
        
        System.out.println(javaColecoes.getTempoTotal());
        System.out.println(javaColecoes.getTempoTotalMap());
        // tentando adicionar da maneira "antiga". Podemos fazer isso? Teste:
        //javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));
        
       // System.out.println(javaColecoes.getAulas());
        
        
	}

}
