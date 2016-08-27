import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Minerador {
	
	  private static final int MAX_PAGES_TO_SEARCH = 10000;
	  private Set<String> pagesVisited = new HashSet<String>();
	  private List<String> pagesToVisit = new LinkedList<String>();


	  /**
	   * Our main launching point for the Spider's functionality. Internally it creates spider legs
	   * that make an HTTP request and parse the response (the web page).
	   * 
	   * @param url
	   *            - The starting point of the spider
	   * @param searchWord
	   *            - The word or string that you are searching for
	   */
	  public void minerar(Picareta leg)
	  {
		  if(leg.baseUrl != ""){
			  String currentUrl;
		      while(this.pagesVisited.size() < MAX_PAGES_TO_SEARCH){
		          if(this.pagesToVisit.isEmpty()){
		              currentUrl = leg.baseUrl;
		              this.pagesVisited.add(leg.baseUrl);
		          }
		          else{
		              currentUrl = this.nextUrl();
		              if(currentUrl.equals("")){
		            	  break;
		              }
		          }
		          leg.crawl(currentUrl);
		          float success = leg.searchForWord();
		          if(success != -1f){
		              System.out.println(String.format("**Success** Word found at %s", currentUrl));
		              //System.out.println("Gold = " + success);
		              //break;
		          }
		          this.pagesToVisit.addAll(leg.getLinks());
		          leg.esvaziarLinks();
		      }
		      System.out.println("\n**Done** Visited " + this.pagesVisited.size() + " web page(s)");
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
	    	  if(pagesToVisit.size() == 0){
	    		  return "";
	    	  }
	          nextUrl = this.pagesToVisit.remove(0);
	      } while(this.pagesVisited.contains(nextUrl));
	      this.pagesVisited.add(nextUrl);
	      return nextUrl;
	  }
}
