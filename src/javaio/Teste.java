package javaio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class Teste {

	public static void main(String[] args) throws IOException {
//		leitura();
//		escrita();
//		copiar();
		outras();
		
	}

	public static void leitura() throws IOException {
		String arquivo = "lorem.txt";
		FileInputStream fis = new FileInputStream(arquivo);//bytes
		InputStreamReader isr = new InputStreamReader(fis);//array de char
		BufferedReader br = new BufferedReader(isr);
		
		String linha = br.readLine();
		
		while(linha !=null) {
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
		//configurando strings com o nome dos arquivos		
		String arquivoOrigem = "lorem.txt";
		String arquivoDestino = "lorem2.txt";

		//configurando a entrada que lerá o arquivo
		FileInputStream fis = new FileInputStream(arquivoOrigem);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		//configurando a saida que irá escrever o conteúdo do arquivo origem no arquivo destino
		OutputStream os = new FileOutputStream(arquivoDestino);
		Writer w = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(w);
		
		String linha = br.readLine();
		
		while(linha!=null) {
			bw.write(linha);
			linha = br.readLine();
			bw.newLine();
		}
		bw.close();
		br.close();
		
	}
	
	public static void outras() throws IOException {
		//configurando strings com o nome dos arquivos		
		//String arquivoOrigem = "lorem.txt";
		//String arquivoDestino = "lorem2.txt";
		
		//instanciando um socket
		
		Socket s = new Socket("200.129.19.40",27289);
		
		//configurando a entrada que lerá o arquivo
		InputStream fis = 
		//s.getInputStream(); 
		System.in;
		//new FileInputStream(arquivoOrigem);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		//configurando a saida que irá escrever o conteúdo do arquivo origem no arquivo destino
		OutputStream os = s.getOutputStream(); 
		//System.out;
		//new FileOutputStream(arquivoDestino);
		Writer w = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(w);
		
		String linha = br.readLine();
		
		while(linha!=null && !linha.isEmpty()) {
			bw.write(linha);
			bw.newLine();
			bw.flush();
			linha = br.readLine();
		}
		
		bw.close();
		br.close();
		s.close();
		
	}

}
