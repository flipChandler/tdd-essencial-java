
public class CamelCaseConverter {

	public String converter(String nome) {
		String[] partes = {};
		if (nome.contains(" ")) {
			 partes = nome.split(" ");
		} else {
			return nome.substring(0,1)
					.toUpperCase()
					+ nome.substring(1)
					.toLowerCase();
		}
		
		String nomeCamelCase = "";
		
		int i = 0;
		while (i < partes.length) {
			nomeCamelCase += partes[i].substring(0,1) // pega do 1ª caracter até o 1º caracter 
			.toUpperCase() 							  // para UpperCase
			+ partes[i].substring(1) 					  // concatena a partir do 2º caracter
			.toLowerCase(); 						  // para minusculo			
			i++;
			if (i < partes.length) {
				nomeCamelCase += " "; 				  // não acrescenta espaço na ultima palavra
			}
		}		
		return nomeCamelCase;	
	}

}
