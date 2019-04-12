package encoding;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class TesteUnicodeEEncoding {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "ç";
		//saber em que posição esta na tabela de encoding o caractere
		System.out.println(s.codePointAt(0));
		
		
		//mostrar o tipo de charset que está sendo usado no sistema operacional
		Charset charset = Charset.defaultCharset();
		System.out.println(charset.displayName());
		
		
		//saber quantos bytes são usados para representar um caractere
		String encoding = "windows-1252";
		byte[] bytes = s.getBytes(encoding);
		System.out.println(bytes.length + " , " + encoding);
		encoding = "utf8";
		bytes = s.getBytes(encoding);
		System.out.println(bytes.length + " , " + encoding);
		encoding = "utf16";
		bytes = s.getBytes(encoding);
		System.out.println(bytes.length + " , " + encoding);
		encoding = "ascii";
		bytes = s.getBytes(encoding);
		System.out.println(bytes.length + " , " + encoding);
	}

}
