package url;

import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class PesquisaURL {
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe url: ");
		String url = sc.nextLine();
//		String url = "https://www.beecrowd.com.br";
		//https://en.wikipedia.org/
		
		Document document = Jsoup.connect(url).get();
		
		String html = pegarVersaoHTML(document);
		String title = pegarTituloPagina(document);
		Integer linkExterno = pegarLinkExternoInterno(document);
		Integer linkInterno = pegarLinkExternoInterno(document);
		
		System.out.println("Versão HTML: " + html);
		System.out.println("Titulo da Pagína: " + title);
		System.out.println("Link Externo: " + linkExterno);
		System.out.println("Link Interno: " + linkInterno);

	}
	public static String pegarVersaoHTML(Document document) {
		
		String html = "";
		try {
			// Trabalhar o para pegar o HTML aqui.
		} catch (Exception e) {
			e.printStackTrace(); //mudar para logeer
			System.out.println("Erro para pegar a versão HTML da pagina.");
		}
		
		return html;
	}
	
	public static String pegarTituloPagina(Document document) {
		
		String title = "";
		try {
			title = document.title();
		} catch (Exception e) {
			e.printStackTrace();//mudar para logeer
			System.out.println("Erro para pegar o titulo da pagina.");
		}
		
		return title;
	}
	
	public static Integer pegarLinkExternoInterno(Document document) {
		
		int linkExterno = 0; 
		int linkInterno = 0;
		
		try {
			// Trabalhar o para pegar o link Externo aqui.
			Elements links = document.select("a");
			
			for(Element e : links)
			{
				String href = e.attr("href");
				if (href.startsWith("http")){
					linkExterno++;
				
				} else {
					linkInterno++;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();//mudar para logeer
			System.out.println("Erro para pegar os links internos e externos da pagina.");
		}
		return linkExterno;
	}
	
	public static String pegarLinkInterno(Document document) {
		String linkInterno = "";
		try {
			// Trabalhar o para pegar o link Interno aqui.
		} catch (Exception e) {
			e.printStackTrace();//mudar para logeer
			System.out.println("Erro para pegar os links internos da pagina.");
		}
		return linkInterno;
	}

}
