package tp02.ejercicioPila;

import tp02.ejercicio2.*;

public  class PilaGenerica<T> {
	
	private ListaGenerica<T> datos;
	private int primerPosicion;
	
	public PilaGenerica(){
		datos = new ListaEnlazadaGenerica<T>();
	}
	
	public void apilar(T dato){
		datos.agregarFinal(dato);
	}
	
	public T desapilar(){
		T elem = datos.elemento(datos.tamanio());
		datos.eliminarEn(datos.tamanio());
		return elem;
	}
	
	public T tope(){
		return datos.elemento(datos.tamanio());  
	}
	
	public boolean esVacia(){
		return datos.esVacia();
	}
	
}
