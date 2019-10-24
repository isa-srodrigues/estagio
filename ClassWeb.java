/**
* @author Isadora Santos Rodrigues
* Data de Entrega: 25/10/2019
* Exercício 2 - Web Scraper
*/

//Bibliotecas --------------------------------------------------------
import java.util.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//--------------------------------------------------------------------
class Produto{
	private String nomeProduto;
	private String valorProduto;
	private String descricao;
	private int avaliacao;

	/*
	   *Construtor padrão
    */
	public Produto(){
		this.nomeProduto = null;
		this.valorProduto = null;
		this.descricao = null;
		this.avaliacao = 0;
	}

	
	/**
		* Metodo construtor	
		* @param recebe os valores dos atributos no parametro
	*/
	public Produto(String nomeProduto, String valorProduto, String descricao, int avaliacao){
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
		this.descricao = descricao;
		this.avaliacao = avaliacao;
	}
	

	//---------------Guetters & Setters---------------------

	public String getnomeProduto(){
		return nomeProduto;
	}
	public void setnomeProduto(String nomeProduto){
		this.nomeProduto = nomeProduto;
	}
	public String getvalorProduto(){
		return valorProduto;
	}
	public void setvalorProduto(String valorProduto){
		this.valorProduto = valorProduto;
	}
	public String getdescricao(){
		return descricao;
	}
	public void setdescricao(String descricao){
		this.descricao = descricao;
	}
	public int getavaliacao(){
		return avaliacao;
	}
	public void setavaliacao(int avaliacao){
		this.avaliacao = avaliacao;
	}

	//---------------------------------------------------------

	public String toString() {
		return 	"*Nome do Produto: "+nomeProduto+"\n"+
				"*Descricao: "+descricao+"\n"+
				"*Avaliacao: "+avaliacao+"\n"+
				"*Valor: "+valorProduto+"\n";
	}
}


class ClassWeb{
	public static void main(String [] args){
		String link = "https://www.kabum.com.br/computadores/scanners";
		Produto[] produtosLidos = lerHTML(link);

		for(int i = 0; i < produtosLidos.length; i++) {
			if(produtosLidos[i] != null) {
				System.out.println(produtosLidos[i].toString());
			}
		}
	}

	public static Produto[] lerHTML(String link) {
		Produto[] produtosLidos = new Produto[1000];
		int i = 0;

		try {
			Document page = Jsoup.connect(link).get(); // abre pagina no jSoup
			Elements produtos = page.select(".listagem-box"); //seleciona todos os divs de classe 'listagem-box' (cada div 'listagem-box' contem um produto)
			for(Element prod : produtos) { //para cada div de produto

				//--------------------------------------
				//--------------------------------------
				//-------------LER DADOS----------------
				//--------------------------------------
				//--------------------------------------

				String produtoNome;
				String produtoDescricao;
				String produtoValor;
				int produtoAvaliacao;
				//'prod' eh um div contendo dados do produto

				//nome
				Elements nome = prod.select(".H-titulo a"); //seleciona todos os divs 'a' que estao dentro de um div 'H-titulo', dentro do 'prod'
				produtoNome = nome.get(0).text(); //pega o conteudo do div a, que eh o nome

				//desc
				Elements desc = prod.select(".H-subtitulo"); //seleciona todos os divs 'H-subtitulo', dentro do 'prod'
				produtoDescricao = desc.get(0).text(); //pega o conteudo do div H-subtitulo, que eh a desc

				//valor
				Elements valor = prod.select(".listagem-precoavista b"); //seleciona todos os divs 'b' que estao dentro de um div 'listagem-precoavista', dentro do 'prod'
				produtoValor = valor.get(0).text(); //pega o conteudo do div b, que eh o valor

				//aval
				Elements aval = prod.select(".notas"); //seleciona todos os divs 'notas' dentro do 'prod'
				Element estrelas = aval.get(0).child(0); //pega o primeiro elemento dentro do div 'notas', para checar de qual classe ele eh (a quantidade de estrelas q aparecem depende da classe)
				String qualClasse = estrelas.attr("class");
				//se classe for "H-estrelas e5" = 5 estrelas
				//se classe for "H-estrelas e4" = 4 estrelas
				//...
				//se classe for "H-estrelas e" = 0 estrelas
				if(qualClasse.equals("H-estrelas e5")) {
					produtoAvaliacao = 5;
				} else if(qualClasse.equals("H-estrelas e4")) {
					produtoAvaliacao = 4;
				} else if(qualClasse.equals("H-estrelas e3")) {
					produtoAvaliacao = 3;
				} else if(qualClasse.equals("H-estrelas e2")) {
					produtoAvaliacao = 2;
				} else if(qualClasse.equals("H-estrelas e1")) {
					produtoAvaliacao = 1;
				} else {
					produtoAvaliacao = 0;
				}

				//----------------------------------------
				//----------------------------------------
				//-------------CRIAR OBJETO---------------
				//----------------------------------------
				//----------------------------------------

				Produto p = new Produto(produtoNome, produtoValor, produtoDescricao, produtoAvaliacao);
				produtosLidos[i] = p;
				i++;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return produtosLidos;
	}
}