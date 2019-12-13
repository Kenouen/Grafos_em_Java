package br.edu.ifpb;

import java.util.HashMap;
import java.util.Map;
import br.edu.ifpb.Aresta;
import br.edu.ifpb.ArestaException;

public class GrafoNaoDirecionadoMap extends Grafo {
    private Map<Aresta, Integer> mapArestas;

    public GrafoNaoDirecionadoMap() {
        super();
        mapArestas = new HashMap<>();
    }
    public GrafoNaoDirecionadoMap(String array[]) {
        super(array);
        mapArestas = new HashMap<>();
    }
}