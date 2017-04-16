package tp02.ejercicio1;

public class SecuenciaInversa {
	
	public static void imprimeInverso(ListaDeEnterosConArreglos lista, int pos){
		if(pos>0){
			System.out.println(lista.elemento(pos));
			imprimeInverso(lista, --pos);
		}	
	}
	
	public static void main(String args[]){
		ListaDeEnterosConArreglos l = new ListaDeEnterosConArreglos();
		l.agregarInicio(22);
		l.agregarInicio(3);
		l.agregarInicio(42);
		l.agregarInicio(26);
		l.agregarInicio(78);
		l.agregarInicio(322);
		l.agregarInicio(98);
		l.agregarInicio(452);
		System.out.println("Ejercicio que imprime una secuencia de numeros en sentido inverso");
		SecuenciaInversa.imprimeInverso(l, l.tamanio());
		
	}

}
