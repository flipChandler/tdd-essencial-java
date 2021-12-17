import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CamelCaseConverterTest {
	
	private static CamelCaseConverter camelCase;
	
	@BeforeAll
	public static void setup() {
		camelCase = new CamelCaseConverter();
	}
		
	@Test
	public void deveConverterNomeSimples() throws Exception {
		assertEquals("Lionel", camelCase.converter("lionel"));
	}
	
	@Test
	public void deveConverterNomeSimplesMisturadoMaiusculoEMinusculo() throws Exception {
		assertEquals("Lionel Messi", camelCase.converter("liONeL mEssi"));
	}	
}
