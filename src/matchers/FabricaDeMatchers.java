package matchers;

public class FabricaDeMatchers {
	
	public static Matcher criarMatcher(EnumMatchers type){
		switch (type) {
		case V_B_FAMILIA:
			return new MatcherDadosFederais();
		default:
			System.out.println("N�o existe um verificador para o numero " + type);
			return null;
		}
	}

}
