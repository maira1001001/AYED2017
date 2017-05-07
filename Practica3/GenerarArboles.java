package tp03.ejercicio4;

import tp03.ejercicio1.ArbolBinario;

public class GenerarArboles {
	
	public static ArbolBinario<Integer> completo(){
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
	
	public static ArbolBinario<Integer> lleno(){
		return null;
	}

}
