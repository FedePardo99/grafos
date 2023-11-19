
import java.util.HashSet;
import java.util.Set;

public class Grafo{
	
	private boolean[][] matrizDeAdyacencia;
	
	public Grafo(int vertices){
		matrizDeAdyacencia = new boolean[vertices][vertices];
	}
	
	public boolean esUnArbol() { 
		if(!BFS.esConexo(this)) {
			return false;
		}
		if(contieneCiclo(0)) {
			return false;
		}
		return true;
	}
	
	public boolean contieneCiclo(int vertice) {
		if (vertice == this.tamano()) {
			return false;
		}
		if(esUnCiclo(vertice))
			return true;
		
		return contieneCiclo(++vertice);
	}
	
	public boolean esUnCiclo(int indice) {
		for (int i = indice; i < this.tamano(); i++) {
			if(vecinos(i).size() != 2)
				return false;			
		}
		
		return true;
	}
	
	public Set<Integer> vecinos(int i){
		verificarVertice(i);
				
		Set<Integer> vecinos = new HashSet<Integer>();
		for(int j = 0; j < this.tamano(); ++j) if( i != j ){
			if( this.existeArista(i,j) )
				vecinos.add(j);
		}
			return vecinos;		
	}
	
	public boolean existeArista(int i, int j){
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		
		return matrizDeAdyacencia[i][j];	
	}

	public boolean esPar() {
		for (int i = 0; i < this.tamano(); i++) {
			if(vecinos(i).size() % 2 != 0)
				return false;			
		}
		return true;
	}
	
	public void agregarArista(int i, int j){
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		matrizDeAdyacencia[i][j] = true;
		matrizDeAdyacencia[j][i] = true;
	}

	public void eliminarArista(int i, int j){
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		matrizDeAdyacencia[i][j] = false;
		matrizDeAdyacencia[j][i] = false;
	}

	public int tamano(){
		return matrizDeAdyacencia.length;
	}
	
	private void verificarVertice(int i){
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		
		if( i >= matrizDeAdyacencia.length )
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}

	private void verificarDistintos(int i, int j){
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}
}
