package tp03.ejercicio1;

import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class ContadorArbol {
	
	private ArbolBinario<Integer> arbol;
	
	public ContadorArbol(){
		arbol = GenerarArboles.completo();
	}
	
	private static boolean esPar(int n){
		return n%2 == 0;
	}
	
	private void numerosParesPreOrder(ArbolBinario<Integer> a, ListaDeEnterosEnlazada lista){
		
		//proceso Raiz
		if (esPar(a.getDatoRaiz())){
			lista.agregarFinal(a.getDatoRaiz());
		}

		//hijo Izquierdo		
		if (!a.getHijoIzquierdo().esVacio()){
			numerosParesPreOrder(a.getHijoIzquierdo(), lista);
		}
		
		//hijo Derecho
		if (!a.getHijoDerecho().esVacio()){
			numerosParesPreOrder(a.getHijoDerecho(), lista);
		}
	}
	
	private void numerosParesInOrder(ArbolBinario<Integer> a, ListaDeEnterosEnlazada lista){
		
		//hijo Izquierdo
		if (!a.getHijoIzquierdo().esVacio()){
			numerosParesInOrder(a.getHijoIzquierdo(), lista);
		}
		
		//proceso Raiz
		if (esPar(a.getDatoRaiz())){
			lista.agregarFinal(a.getDatoRaiz());
		}
		
		//hijo Derecho
		if (!arbol.getHijoDerecho().esVacio()){
			numerosParesInOrder(a.getHijoDerecho(), lista);
		}
	}
	
	public ListaDeEnteros numerosPares(){
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		this.numerosParesInOrder(arbol, lista);
		//this.numerosParesPreOrder(arbol, lista);
		return lista;
	}
	
	public static void main(String args[]){
		
		ContadorArbol contador = new ContadorArbol();
		ListaDeEnteros resultados = contador.numerosPares();
		
		System.out.println("Lista de valores");
		resultados.imprimirValores();

			
	}
}
