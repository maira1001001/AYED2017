package tp03.ejercicio5;

import tp02.ejercicio2.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp03.ejercicio4.GenerarArboles;

public class ProfundidadDeArbolBinario {
	
	private ArbolBinario<Integer> arbol;
	
	public ProfundidadDeArbolBinario(){
		arbol = GenerarArboles.completo();
	}
	
	public int sumaElementosProfundidad(int p){
		if (arbol.esVacio()) return 0;
		if (arbol.esHoja()) return arbol.getDatoRaiz();
		return sumaElementosProfundid(p);
	}
	
	private int sumaElementosProfundid(int p){
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		cola.encolar(arbol);
		cola.encolar(null);
		int nivel = 0;
		int suma = 0;
		while(!cola.esVacia() && nivel < p){
			ArbolBinario<Integer> a = cola.desencolar();
			if(a!=null){
				if(!a.getHijoDerecho().esVacio()) cola.encolar(a.getHijoDerecho());
				if(!a.getHijoIzquierdo().esVacio()) cola.encolar(a.getHijoIzquierdo());
			} else {
				if(!cola.esVacia()){
					nivel++;
					if(nivel < p) cola.encolar(null);
				}
			}
		}
		
		if(nivel == p){
			while(!cola.esVacia()){
				ArbolBinario<Integer>  a = cola.desencolar();
				suma =+ a.getDatoRaiz();
			}
		}
		return suma;
	}
}
