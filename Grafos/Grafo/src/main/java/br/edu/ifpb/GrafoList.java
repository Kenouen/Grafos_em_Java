package br.edu.ifpb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import br.edu.ifpb.MatrizException;

public class GrafoList extends Grafo {
    private List<List<Integer>> grafo;

    public GrafoList(String[] vertices) {
        super(vertices);
        grafo = new ArrayList<>();
        for (int i = 0; i < vertices.length; i ++) {
            grafo.add(new ArrayList<>(Arrays.asList(new Integer[vertices.length])));
        }
    }
    public GrafoList(String[] vertices, List<List<Integer>> arestas) throws MatrizException {
        super(vertices);
        if (arestas.size() != vertices.length)
            throw new MatrizException(String.format("Matriz possui não tamanho possui o tamanho %d!", vertices.length));
        grafo = new ArrayList<>(arestas);
    }
    @Override
    public void adicionarVertice(String vertice) throws VerticeException {
        if (vertices.contains(vertice)) throw new VerticeException(String.format("Vértice %s já existe!", vertice));
        vertices.add(vertice);
        for (List i : grafo) i.add(vertice);
        grafo.add(Arrays.asList(new Integer[vertices.size()]));
    }
    public void adicionarAresta(Aresta a) throws ArestaException {
        if (!vertices.contains(a.getVerticeA()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeA()));
        if (!vertices.contains(a.getVerticeB()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeB()));
    }
}
