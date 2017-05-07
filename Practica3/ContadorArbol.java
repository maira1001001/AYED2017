package tp03.ejercicio1;

import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class ContadorArbol {
	
	private ArbolBinario<Integer> arbol;
	
	private ArbolBinario<Integer> generarArbol(){
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
		
		return e;
				
				//              30
				//             /   \
				//            15    44
				//           / \    /  \
				//          7  20  36  50
				//               \     /
				//               25    47	
	}
	
	public ContadorArbol(){
		arbol = generarArbol();
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
