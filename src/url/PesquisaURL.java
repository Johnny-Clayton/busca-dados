package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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
		
		String html = pegarVersaoHTML(url);
		String title = pegarTituloPagina(document);
		Integer[] link = pegarLinkExternoInterno(document);

		Integer linkExterno = link[0];
		Integer linkInterno = link[1];
		
		System.out.println("Versão HTML: " + html);
		System.out.println("Titulo da Pagína: " + title);
		System.out.println("Link Externo: " + linkExterno);
		System.out.println("Link Interno: " + linkInterno);

	}
	public static String pegarVersaoHTML(String urlSite) {

		try {

			URL url = new URL(urlSite);

		    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

		    String doctype = reader.readLine();
		    if(doctype.equalsIgnoreCase("<!DOCTYPE html>"))
		    	return "HTML 5";
		    
		    return "HTML";

		} catch (Exception e) {
			e.printStackTrace(); 
	
			return "Erro para pegar a versão HTML da pagina.";
		}
	}
	
	public static String pegarTituloPagina(Document document) {
		
		String title = "";
		try {
			title = document.title();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro para pegar o titulo da pagina.");
		}
		return title;
	}
	
	public static Integer[] pegarLinkExternoInterno(Document document) {
		
		int linkExterno = 0; 
		int linkInterno = 0;
		
		try {
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
			e.printStackTrace();
			System.out.println("Erro para pegar os links internos e externos da pagina.");
		}
		
		Integer[] link = new Integer[2];
		link[0] = linkExterno;
		link[1] = linkInterno;
		
		return link;
	}
}
