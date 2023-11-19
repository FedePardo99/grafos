
public class Main {
	
	
	public static void main(String[] args) {
		
		Grafo grafo = new Grafo(6);
		
		grafo.agregarArista(0, 1);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(2, 3);
		grafo.agregarArista(3, 4);
		grafo.agregarArista(4, 5);
		grafo.agregarArista(5, 3);
		
		
		System.out.println(grafo.esUnArbol());
		
		
		
	}
}
