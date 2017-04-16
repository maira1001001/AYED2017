package tp02.ejercicioCola;

import tp02.ejercicio2.*;

public  class ColaGenerica<T> {
	
	private ListaGenerica<T> datos;
	private int primerPosicion;
	
	public ColaGenerica(){
		datos = new ListaEnlazadaGenerica<T>();
		primerPosicion = 1;
	}
	
	public void encolar(T dato){
		datos.agregarFinal(dato);
	}
	
	public T desencolar(){
		T elem = datos.elemento(primerPosicion);
		datos.eliminarEn(primerPosicion);
		return elem;
	}
	
	public T tope(){
		return datos.elemento(primerPosicion);  
	}
	
	public boolean esVacia(){
		return datos.esVacia();
	}
	
}
