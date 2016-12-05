package framework.match;

import matchers.BestBuyMatcher;

public class FabricaDeMatchers {
	
	public static Matcher criarMatcher(EnumMatchers type){
		switch (type) {
		case V_BUY:
			return new BestBuyMatcher();
		default:
			System.out.println("Não existe um verificador para o numero " + type);
			return null;
		}
	}

}
