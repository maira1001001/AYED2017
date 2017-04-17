package tp03.ejercicio1;
import tp02.ejercicio2.*;
import tp02.ejercicioCola.*;

public class ArbolBinario<T> {

	private NodoBinario<T> raiz;
	private ColaGenerica<ArbolBinario<T>> cola; //esta COLA la uso para recorrer el arbol por niveles
	
	private void inicializarCola(){
		cola = new ColaGenerica<ArbolBinario<T>>();
	}

	public ArbolBinario(T dato) {
		this.raiz = new NodoBinario<T>(dato);
	}

	private ArbolBinario(NodoBinario<T> nodo) {
		this.raiz = nodo;
	}

	private NodoBinario<T> getRaiz() {
		return raiz;
	}

	public T getDatoRaiz() {
		if (this.getRaiz() != null) {
			return this.getRaiz().getDato();
		} else {
			return null;
		}
	}

	public ArbolBinario<T> getHijoIzquierdo() {
		return new ArbolBinario<T>(this.raiz.getHijoIzquierdo());
	}

	public ArbolBinario<T> getHijoDerecho() {
		return new ArbolBinario<T>(this.raiz.getHijoDerecho());
	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}

	public void eliminarHijoIzquierdo() {
		this.raiz.setHijoIzquierdo(null);
	}

	public void eliminarHijoDerecho() {
		this.raiz.setHijoDerecho(null);
	}

	public boolean esVacio() {
		return this.getDatoRaiz() == null;
	}

	public boolean esHoja() {
		return this.getDatoRaiz() != null && this.getHijoIzquierdo().esVacio() && this.getHijoDerecho().esVacio();
	}
		
	public int contarHojas(){
		int cantHojas = 0;
		if (this.esHoja()){
			cantHojas++;
		} else {
			if (!this.getHijoIzquierdo().esVacio()){
				cantHojas =+ this.getHijoIzquierdo().contarHojas();
			}
			if (!this.getHijoDerecho().esVacio()){
				cantHojas =+ this.getHijoDerecho().contarHojas();
			}
		}
		return cantHojas;
	}

	private void swapHijos(){
		ArbolBinario<T> d = this.getHijoDerecho();
		ArbolBinario<T> i = this.getHijoIzquierdo();
		this.agregarHijoDerecho(i);
		this.agregarHijoIzquierdo(d);
	}
	
	public ArbolBinario<T> espejo(){
		if (!this.esHoja()) {	
			this.swapHijos();
			if (!this.getHijoDerecho().esVacio()) this.getHijoDerecho().espejo();
			if (!this.getHijoIzquierdo().esVacio()) this.getHijoIzquierdo().espejo();
		}
		return this;
	}
	
	public void recorridoPorNiveles(){
		if(!this.esVacio()){
			int nivel = 0;
			ArbolBinario<T> a ;
			inicializarCola();
			encolarRaiz();
			while(!cola.esVacia()){
				a = cola.desencolar();
				imprimirNivel(nivel);
				while(a!=null){
					imprimirDato(a.getDatoRaiz());
					encolarHijos(a);
					a = cola.desencolar();
					marcaNivel(a);
				}
				nivel++;
			}
		} else {
			System.out.println("Arbol vacio. No posee elementos.");
		}
	}
	
	private void encolarRaiz(){
		cola.encolar(this);
		cola.encolar(null);//marca cambio de nivel
	}
	
	private void encolarHijos(ArbolBinario<T> a){
		if (!a.getHijoDerecho().esVacio()){
			cola.encolar(a.getHijoDerecho());
		}
		if (!a.getHijoIzquierdo().esVacio()){
			cola.encolar(a.getHijoIzquierdo());
		}
	}
	
	private void marcaNivel(ArbolBinario<T> a){
		if (a==null && !cola.esVacia()) cola.encolar(null);
	}
	
	private void imprimirNivel(int nivel){
		System.out.println("");
		System.out.println("Elementos del nivel: " +nivel+ " -> ");
	}
	
	private void imprimirDato(T dato){
		System.out.print(dato + " | ");
	}
	
	private void swapValores(int n, int m){
		if (n>m) {
			int aux = n;
			n = m;
			m = aux;
		}
	}
		
	public void entreNiveles(int n, int m){
		if (!this.esVacio()){
			swapValores(n,m);
			int nivel = 0;
			ArbolBinario<T> a;
			inicializarCola();
			encolarRaiz();
			while(nivel<=m && !cola.esVacia()){
				a = cola.desencolar();
				if (nivel>=n && nivel<=m){
					imprimirNivel(nivel);
				}
				while(a!=null){
					if(nivel>=n && nivel<=m){
						imprimirDato(a.getDatoRaiz());
					}
					encolarHijos(a);
					a = cola.desencolar();
					marcaNivel(a);
				}
				nivel++;
			}
		}
	}

	public static void main(String args[]){
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
		
		//				30
		//			 /  	\
		//			15		44
		//         /  \	   /  \
		//		  7	  20  36  50
		//			    \     /
		//              25   47
		
		e.espejo();
		e.entreNiveles(2,5);
		e.recorridoPorNiveles();
		
	}
}