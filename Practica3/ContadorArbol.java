package tp03.ejercicio1;

import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class ContadorArbol {

	
	private static boolean esPar(int n){
		return n%2 == 0;
	}
	
	public static void numerosParesPreOrder(ArbolBinario<Integer> arbol, ListaDeEnterosEnlazada lista){
		
		//proceso Raiz
		if (esPar(arbol.getDatoRaiz())){
			lista.agregarFinal(arbol.getDatoRaiz());
		}

		//hijo Izquierdo		
		if (!arbol.getHijoIzquierdo().esVacio()){
			numerosParesPreOrder(arbol.getHijoIzquierdo(), lista);
		}
		
		//hijo Derecho
		if (!arbol.getHijoDerecho().esVacio()){
			numerosParesPreOrder(arbol.getHijoDerecho(), lista);
		}
	}
	
	public static void numerosParesInOrder(ArbolBinario<Integer> arbol, ListaDeEnterosEnlazada lista){
		
		//hijo Izquierdo
		if (!arbol.getHijoIzquierdo().esVacio()){
			numerosParesInOrder(arbol.getHijoIzquierdo(), lista);
		}
		
		//proceso Raiz
		if (esPar(arbol.getDatoRaiz())){
			lista.agregarFinal(arbol.getDatoRaiz());
		}
		
		//hijo Derecho
		if (!arbol.getHijoDerecho().esVacio()){
			numerosParesInOrder(arbol.getHijoDerecho(), lista);
		}
	}
	
	public static void main(String args[]){
		
		//creo el arbol de prueba
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(new Integer(7));
		ArbolBinario<Integer> b = new ArbolBinario<Integer>(new Integer(15));
		ArbolBinario<Integer> c = new ArbolBinario<Integer>(new Integer(20));
		ArbolBinario<Integer> d = new ArbolBinario<Integer>(new Integer(25));
		ArbolBinario<Integer> e = new ArbolBinario<Integer>(new Integer(30));
		ArbolBinario<Integer> f = new ArbolBinario<Integer>(new Integer(36));
		ArbolBinario<Integer> g = new ArbolBinario<Integer>(new Integer(44));
		ArbolBinario<Integer> h = new ArbolBinario<Integer>(new Integer(47));
		ArbolBinario<Integer> i = new ArbolBinario<Integer>(new Integer(50));
		
		//e RAIZ
		e.agregarHijoIzquierdo(b); 
		e.agregarHijoDerecho(g); 
		b.agregarHijoIzquierdo(a);  
		b.agregarHijoDerecho(c);
		g.agregarHijoIzquierdo(f);
		g.agregarHijoDerecho(i);
		c.agregarHijoDerecho(d);
		i.agregarHijoIzquierdo(h);
		
		//              30
		//            /    \
		//           15     44
		//          / \     / \
		//          7  20  36  50
		//               \    /
		//              25   47
		
		ListaDeEnterosEnlazada listaInOrder = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada listaPreOrder = new ListaDeEnterosEnlazada();
		
		ContadorArbol.numerosParesInOrder(e, listaInOrder);
		//listaInOrder -> (izquierda, raiz, derecha)
		//resultado: 20, 30, 36, 44, 50
		
		ContadorArbol.numerosParesPreOrder(e, listaPreOrder);
		//listaPreOrder -> (raiz, izquierda, derecha)
		//resultado: 30, 20, 44, 36, 50
		
		System.out.println("Lista de valores PreOrder");
		listaPreOrder.imprimirValores();
		
		System.out.println("\r\n Lista de valores InOrder");
		listaInOrder.imprimirValores();
		
	}
}
