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
	   * as requisi��es HTTP e analisar a p�gina web.
	   * 
	   * @param picareta
	   *            - O tipo de picareta que ser� usado na busca
	   */
	  public void minerar(Picareta picareta)
	  {
		  if(picareta.baseUrl != ""){
			  String currentUrl;
		      while(this.pagVisitadas.size() < MAX_PAGES_TO_SEARCH){
		          if(this.pagParaVisitar.isEmpty()){
		              currentUrl = picareta.baseUrl;
		              this.pagVisitadas.add(picareta.baseUrl);
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
		              System.out.println(String.format("**Sucesso** palavra encontrada em %s", currentUrl));
		          }
		          this.pagParaVisitar.addAll(picareta.getLinks());
		          picareta.esvaziarLinks();
		      }
		      System.out.println("\n**FIm**  " + this.pagVisitadas.size() + " p�ginas visitada(s)");
		  }
	  }


	  /**
	   * Returns the next URL to visit (in the order that they were found). We also do a check to make
	   * sure this method doesn't return a URL that has already been visited.
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
