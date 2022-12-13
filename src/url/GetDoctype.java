package url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class GetDoctype {
	
public static void main(String[] args) throws Exception {
    // O URL da página que deseja ler
    URL url = new URL("http://www.exemplo.com/pagina.html");

    // Cria um novo BufferedReader para ler o conteúdo da página
    BufferedReader reader = new BufferedReader(
      new InputStreamReader(url.openStream())
    );

    // Lê a primeira linha da página, que deve conter o !DOCTYPE
    String doctype = reader.readLine();

    // Exibe o !DOCTYPE na tela
    System.out.println(doctype);
  }
}

