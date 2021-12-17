import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CamelCaseConverterTest {
	
	@Test
	void deveCriarObjetoCamelCaseConverter() throws Exception {
		CamelCaseConverter camelCase = new CamelCaseConverter();
	}
	
	@Test
	public void deveConverterNomeSimples() throws Exception {
		CamelCaseConverter camelCase = new CamelCaseConverter();
		assertEquals("Lionel", camelCase.converter("lionel"));
	}
}
