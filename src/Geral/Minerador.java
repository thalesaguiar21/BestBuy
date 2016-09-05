package Geral;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Minerador {
	
	  private static final int MAX_PAGES_TO_SEARCH = 10000;
	  private Set<String> pagVisitadas = new HashSet<String>();
	  private List<String> pagParaVisitar = new LinkedList<String>();


	  /**
	   * Ponto principal das funcionalidades do Spider(Minerador). Cria as legs(Picaretas) para fazer
	   * as requisições HTTP e analisar a página web.
	   * 
	   * @param picareta
	   *            - O tipo de picareta que será usado na busca
	   */
	  public boolean minerar(Picareta picareta)
	  {
		  if(picareta != null && picareta.getBaseUrl() != ""){
			  String currentUrl;
		      while(this.pagVisitadas.size() < MAX_PAGES_TO_SEARCH){
		          if(this.pagParaVisitar.isEmpty()){
		              currentUrl = picareta.getBaseUrl();
		              this.pagVisitadas.add(picareta.getBaseUrl());
		          }
		          else{
		              currentUrl = this.nextUrl();
		              if(currentUrl.equals("")){
		            	  break;
		              }
		          }
		          picareta.crawl(currentUrl);
		          float success = picareta.searchForWord();
		          if(success != -1f){
		              System.out.println(String.format("**Sucesso**. Palavra encontrada em %s", currentUrl));
		          }
		          this.pagParaVisitar.addAll(picareta.getLinks());
		          picareta.esvaziarLinks();
		      }
		      System.out.println("\n**Fim**  " + this.pagVisitadas.size() + " página(s) visitada(s)");
		  } else {return false;}
		return true;
	  }


	  /**
	   * Retorna a próxima URL a ser visitada, na ordem em que foi adicionada.
	   * 
	   * @return
	   */
	  private String nextUrl()
	  {
	      String nextUrl;
	      do
	      {
	    	  if(pagParaVisitar.size() == 0){
	    		  return "";
	    	  }
	          nextUrl = this.pagParaVisitar.remove(0);
	      } while(this.pagVisitadas.contains(nextUrl));
	      this.pagVisitadas.add(nextUrl);
	      return nextUrl;
	  }
}
