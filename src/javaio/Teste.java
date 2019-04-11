package javaio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) throws Exception {
//		leitura();
//		escrita();
//		copiar();
//		outras();
//		TesteEscrita2();
//		TesteEscrita3();
		testeLeitura2();
//		testeLeitura3();
//		escrevendoArquivo();

	}

	private static void testeLeitura2() throws IOException {
		Scanner scanner = new Scanner(new File("json.csv"));
		while (scanner.hasNext()) {
			String linha = scanner.nextLine();
			Scanner linhaScanner = new Scanner(linha);
			linhaScanner.useDelimiter(",");
			while(linhaScanner.hasNext()) {
				String campoLinha = linhaScanner.next(); 
				System.out.print(campoLinha + " + ");
			}
			System.out.println();
			linhaScanner.close();			
		}
		scanner.close();
	}

	private static void escrevendoArquivo() throws Exception {
		Scanner s = new Scanner(System.in);
		PrintStream ps = new PrintStream("lorem3.txt");
		while (s.hasNextLine()) {
			String linha = s.nextLine();
			if(linha.isEmpty()) break;
			ps.println(linha);
		}
		s.close();
		ps.close();
	}


	public static void testeEscrita5() throws IOException {
		// PrintStream ps = new PrintStream(new File("lorem2.txt"));
		PrintWriter ps = new PrintWriter("lorem2.txt");
		ps.println("testando2");
		ps.close();
	}

	public static void testeEscrita2() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));
		bw.write("Lorem ipsum dolor sit kamet, consecteter adipiscing elit, sed do eiusmod");
		bw.newLine();
		bw.newLine();
		bw.newLine();
		bw.newLine();
		bw.write("Lorem ipsum dolor sit kamet, consecteter adipiscing elit, sed do eiusmod");
		bw.close();
	}

	public static void leitura() throws IOException {
		String arquivo = "lorem.txt";
		FileInputStream fis = new FileInputStream(arquivo);// bytes
		InputStreamReader isr = new InputStreamReader(fis);// array de char
		BufferedReader br = new BufferedReader(isr);

		String linha = br.readLine();

		while (linha != null) {
			linha = br.readLine();
			System.out.println(linha);
		}

		br.close();
	}

	public static void escrita() throws IOException {
		String arquivo = "lorem2.txt";
		OutputStream os = new FileOutputStream(arquivo);
		Writer w = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(w);

		bw.write("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, ");
		bw.newLine();
		bw.write("asdkkd jd kkdkdl laçsld , ");
		bw.close();
	}

	public static void copiar() throws IOException {
		// configurando strings com o nome dos arquivos
		String arquivoOrigem = "lorem.txt";
		String arquivoDestino = "lorem2.txt";

		// configurando a entrada que lerá o arquivo
		FileInputStream fis = new FileInputStream(arquivoOrigem);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		// configurando a saida que irá escrever o conteúdo do arquivo origem no arquivo
		// destino
		OutputStream os = new FileOutputStream(arquivoDestino);
		Writer w = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(w);

		String linha = br.readLine();

		while (linha != null) {
			bw.write(linha);
			linha = br.readLine();
			bw.newLine();
		}
		bw.close();
		br.close();

	}

	public static void outras() {
		// configurando strings com o nome dos arquivos
		// String arquivoOrigem = "lorem.txt";
		// String arquivoDestino = "lorem2.txt";

		// instanciando um socket

		BufferedReader admin = new BufferedReader(new InputStreamReader(System.in));

		Socket s = null;
		try {
			s = new Socket("200.129.19.40", 27289);

			PrintStream saida = new PrintStream(s.getOutputStream());

			BufferedReader entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));

			saida.println("setStatus(0)");
			saida.flush();
			saida.println("setNome(testando)");
			saida.flush();

			saida.println("taVivo()");
			saida.flush();
			System.out.println("Iniciando");
			String msgAdm = "msg";
			while (s.isConnected()) {
				if (msgAdm.isEmpty()) {
					break;
				}
				// enviar comando
				System.out.println("digite o comando : ");
				msgAdm = admin.readLine();
				saida.println(msgAdm);
				saida.flush();
				System.out.println(msgAdm);

				// comandos recebidos

				String msg = entrada.readLine();
				System.out.println(msg);

				switch (msg) {
				case "desligar()":
					System.out.println("desligando");
					break;
				case "desbloqueia(aula, 28800)":
					System.out.println("deixando em modo aula");
					break;
				default:
					break;
				}

				if (msg.equals("atualizar()")) {
					System.out.println("atualizando...");
				}
			}

			System.out.println("conexão fechada");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO: handle exception
			try {
				s.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		// configurando a entrada que lerá o arquivo
//		InputStream fis = s.getInputStream(); 
		// s.getInputStream();
		// System.in;
		// new FileInputStream(arquivoOrigem);
//		InputStreamReader isr = new InputStreamReader(fis);
//		BufferedReader br = new BufferedReader(isr);

		// configurando a saida que irá escrever o conteúdo do arquivo origem no arquivo
		// destino

		// System.out;
		// new FileOutputStream(arquivoDestino);

//		String linha = br.readLine();

//		while(s.isConnected()) {
//			
//		}

//		while(linha!=null && !linha.isEmpty()) {
//			bw.write(linha);
//			bw.newLine();
//			bw.flush();
//			linha = br.readLine();
//		}
//		

	}

}
