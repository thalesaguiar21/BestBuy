
public class PicaretaDeBFamilia extends Picareta{
	
	public float searchForWord(String searchWord)
	{
	    if(this.htmlDocument.body() == null)
	    {
	        System.out.println("ERROR! Call crawl() before performing analysis on the document");
	        return -1f;
	    }
	    System.out.println("Searching for the word " + searchWord + "...");
	    String bodyText = this.htmlDocument.body().text();
	    if(bodyText.contains(searchWord)){
	    	int i = bodyText.indexOf(searchWord) + searchWord.length();
	    	String str = bodyText.substring(i, i + 15);
	    	str = str.replaceAll("[^\\d,]", "");
	    	str = str.replace(",", ".");
	    	System.out.println("\"" + str + "\"");
	    	return Float.parseFloat(str);
	    }
	    else{
	    	return -1f;
	    }
	}
}
