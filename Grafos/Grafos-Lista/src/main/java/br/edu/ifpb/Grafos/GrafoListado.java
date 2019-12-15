package br.edu.ifpb.Grafos;

import java.util.List;

public class GrafoListado extends Grafo {

    public GrafoListado(List<String> vertices) {
        super();
        for (String vertex : vertices) {
            if(verticeValido(new Vertice(vertex))) adicionarVertice(vertex);
        }
    }

    public GrafoListado(List<String> vertices, List<String> arestas) {
        for (String vertex : vertices) {
            if(verticeValido(new Vertice(vertex))) adicionarVertice(vertex);
        }
        for (String aresta : arestas) {
            if(arestaValido(aresta)) adicionarAresta(aresta);
        }
    }

    public boolean adicionarVertice(String vertice){
        Vertice aux = new Vertice(vertice);
        if (verticeValido(aux)){
            this.Vertices.add(aux);
            return true;
        }
        return false;

    }

    public boolean adicionarAresta(String aresta){

        String novo1 = String.format("%c", aresta.charAt(0));
        String novo2 = String.format("%c", aresta.charAt(aresta.length()-1));

        if(!verticeValido(new Vertice(novo1)) || !verticeValido(new Vertice(novo2))) return false;

        this.Arestas.add(new ArestaNDirecionada(novo1, novo2));
        return true;
    }
}
