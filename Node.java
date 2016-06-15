package bsp;
//Essa classe eu criei apenas caso nao haja necessidade de criar uma arvore inteira para testar casos, cria-se uma instancia de Nodo
/**
 *
 * @author nautec
 */
public class Node {
    
    Poligono poligono;

    public Node() {
    }

    public Node(Poligono poligono) {
        this.poligono = poligono;
    }

    public Poligono getPoligono() {
        return poligono;
    }

    public void setPoligono(Poligono poligono) {
        this.poligono = poligono;
    }
    
    
    
}
