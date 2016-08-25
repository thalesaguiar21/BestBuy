import java.util.LinkedList;
import java.util.List;

import org.jsoup.nodes.Document;

public abstract class Picareta {

	protected String baseUrl;
	protected static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    protected List<String> links = new LinkedList<String>();
    protected Document htmlDocument;


    /**
     * This performs all the work. It makes an HTTP request, checks the response, and then gathers
     * up all the links on the page. Perform a searchForWord after the successful crawl
     * 
     * @param url
     *            - The URL to visit
     * @return whether or not the crawl was successful
     */
    public abstract boolean crawl(String url);


    /**
     * Performs a search on the body of on the HTML document that is retrieved. This method should
     * only be called after a successful crawl.
     * 
     * @param searchWord
     *            - The word or string to look for
     * @return whether or not the word was found
     */
    public abstract float searchForWord(String searchWord);


    public List<String> getLinks()
    {
        return this.links;
    }
    
    public void esvaziarLinks(){
    	this.links.clear();
    }

}
