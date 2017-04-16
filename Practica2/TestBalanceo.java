package tp02.ejercicio4;
import tp02.ejercicioPila.*;

public class TestBalanceo {
	
	private String abiertosConjunto[];
	private String paresConjunto[];
	
	public TestBalanceo(){
		abiertosConjunto = new String[]{"(", "[", "{"};
		paresConjunto    = new String[]{"()", "[]", "{}"};
	}
	
	private boolean esVacio(String str){
		return (str.length() == 0);
	}
	
	private boolean cantidadImpar(String str){
		return (str.length()%2 != 0);
	}
	
	
	
	public boolean estaBalanceado(String str){
		if (esVacio(str)) return true;
		if (cantidadImpar(str)) return false;
		else{
			int pos = 0;
			int tamanio = str.length();
			PilaGenerica<String> pila = new PilaGenerica<String>();
			while(pos < tamanio){ 
				String ultimoLeido = String.valueOf(str.charAt(pos));//voy leyendo el string, caracter por caracter
				if (pertenece(ultimoLeido, abiertosConjunto)) pila.apilar(ultimoLeido);
				else{
					if (pila.esVacia()) return false;
					else{
						String anteriorLeido = pila.tope();
						if (pertenece(anteriorLeido+ultimoLeido, paresConjunto)){
							pila.desapilar();
						}
						else return false;
					}
				}
				pos++;
			}
			return true;
		}
	}
	
	private boolean pertenece(String elem, String[] conjunto){
		for(String e : conjunto){
			if (e.equals(elem)) return true;
		}
		return false;
	}
	
	public static void main(String args[]){
		String s1,s2,s3,s4,s5, s6;
		s1 = ""; //true: balanceado
		s2 = "(([]))"; //true: balanceado
		s3 = "[}}}"; // false: no balanceado
		s4 = "[{)}]"; //false: no balanceado
		s5 = "}{()"; //false: no balanceado
		s6 = "{}[]()"; //true: balanceado
		
		TestBalanceo  test = new TestBalanceo();
		boolean result1 = test.estaBalanceado(s1);
		System.out.println("El string vacio, Resultado: "+ result1);
		boolean result2 = test.estaBalanceado(s2);
		System.out.println("El string (([])) Resultado: "+ result2);
		boolean result3 = test.estaBalanceado(s3);
		System.out.println("El string [}}} Resultado: "+ result3);
		boolean result4 = test.estaBalanceado(s4);
		System.out.println("El string [{)}]  Resultado: "+ result4);
		boolean result5 = test.estaBalanceado(s5);
		System.out.println("El string }{()  Resultado: "+ result5);
		boolean result6 = test.estaBalanceado(s6);
		System.out.println("El string {}[]() Resultado: "+ result6);
		
	}
}
