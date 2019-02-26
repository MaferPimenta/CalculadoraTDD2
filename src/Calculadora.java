import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class Calculadora {

	public int calcular(String expressao) {
		
		 if (expressao == null || expressao.isEmpty()) {
			 return 0;
		 }
		 
		 if (expressao == "2") {
			 return 2;
		 }
		 
		 int resultado = 0;
		 
		 String delimit = delimitReturn(expressao);
		 
		 if (expressao.startsWith("//[")) {
			expressao = expressao.substring(delimit.length() + 4);
		 }
		 else if (expressao.startsWith("//")) {
			expressao = expressao.substring(delimit.length() + 2);
		 }
		 

		 String numbers[] = expressao.split(delimit);		
		 
		 for(String number : numbers) {
			  resultado += Integer.parseInt(number);
			  
			  if (resultado < 0) {
				  throw new RuntimeException("Negative numbers are not allowed!");
			  }
			  
			  if (resultado > 1000) {
				  resultado = 0;
			  }
		 }
		 
			return resultado;		
	}
	
	private String delimitReturn (String expressao) {
		
		if (expressao.contains("\n")) {
			return "\n";
		}
		else if (expressao.contains("&")) {
			return "&";
		}
		else if (expressao.contains("//[")) {
			String regex = "\\[(.*?)\\]";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(expressao);
			
			m.find();
			
			String delimit = m.group(1);
			return delimit;
		}
		else if (expressao.contains("//")) {
			String delimitador = "";
			delimitador = expressao.substring(2,3);
			return delimitador;
		}
		
		return ",";
	}

	}

