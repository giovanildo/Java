package propriedades;

import java.io.FileWriter;
import java.util.Properties;

public class TesteProperties {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.setProperty("login", "giovanildo");
		props.setProperty("senha","senha");
		props.setProperty("servidor", "www.giovanildo.com.br");
		
		props.store(new FileWriter("config.ini"), "testando aqui");
		
		
	}

}
