package tp02.ejercicio1;

public class TestListaDeEnterosConArreglos {

	public static void main(Integer args[]) {
		ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();
		for (int i = 0; i < args.length; i++) {
			lista.agregarEn(args[i], i);
		}

		ListaDeEnterosConArreglos lista2 = new ListaDeEnterosConArreglos();
		for (int i = 0; i < args.length; i++) {
			lista2.agregarInicio(args[i]);
		}

		ListaDeEnterosConArreglos lista3 = new ListaDeEnterosConArreglos();
		for (int i = 0; i < args.length; i++) {
			lista3.agregarFinal(args[i]);
		}

		for (int i = 0; i < args.length; i++) {
			System.out.println(lista.elemento(i));
			System.out.println(lista2.elemento(i));
			System.out.println(lista3.elemento(i));
		}

	}

}
