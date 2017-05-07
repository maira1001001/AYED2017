package tp03.ejercicio3;

import tp03.ejercicio1.ArbolBinario;
import tp03.ejercicio4.GenerarArboles;

//Una red binaria es una red que posee una topología de árbol binario lleno
public class RedBinariaLlena {
	
	private ArbolBinario<Integer> arbol;
	
	public RedBinariaLlena() {
		arbol = GenerarArboles.lleno();
	}
	
	public int retardo(){
		return retardo(arbol);
	}
	
	private boolean tieneDosHijosHojas(ArbolBinario<Integer> a){
		return !a.getHijoIzquierdo().esVacio() 
				&& a.getHijoIzquierdo().esHoja() 
				&& !a.getHijoDerecho().esVacio() 
				&& a.getHijoDerecho().esHoja();
	}
	
	private int retardo(ArbolBinario<Integer> a){
		int suma = a.getDatoRaiz();
		if(!this.tieneDosHijosHojas(a)){
			int sumaHD = 0, sumaHI = 0;
			if(!a.getHijoIzquierdo().esVacio()){
				sumaHI = this.retardo(a.getHijoIzquierdo());  
			}
			if(!a.getHijoDerecho().esVacio()){
				sumaHD = this.retardo(a.getHijoDerecho());  
			}
			if (sumaHI>sumaHD) suma += sumaHI; 
			else suma += sumaHD;
		}
		return suma;
	}
	
}
