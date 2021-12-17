
public class CamelCaseConverter {

	public String converter(String nome) {
		return nome.substring(0,1) // pega do 1ª caracter até o 1º caracter 
				.toUpperCase() // para UpperCase
				+ nome.substring(1); // concatena a partir do 2º caracter
	}

}
