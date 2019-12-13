package br.edu.ifpb;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GrafoMap extends Grafo {
    private Map<Integer, Aresta> grafo;

    public GrafoMap() {
        super();
        grafo = new TreeMap<>();
    }
    public GrafoMap(String[] vertices) {
        super(vertices);
        grafo = new TreeMap<>();
    }
    public GrafoMap(String[] vertices, Map<Integer, Aresta> arestas) {
        super(vertices);
        grafo = new TreeMap<>(arestas);
    }

    public void adicionaAresta(Aresta a, int num) throws ArestaException {
        if (!vertices.contains(a.getVerticeA()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeA()));
        if (!vertices.contains(a.getVerticeB()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeB()));
        if (grafo.containsKey(num))
            throw new ArestaException(String.format("Aresta com número %d já existe!", num));
        grafo.put(num, a);
    }
    public void removerAresta(Aresta a) throws ArestaException {
        if (grafo.containsValue(a)) {
            for (Integer num : grafo.keySet()) {
                if (grafo.get(num).equals(a)) {
                    grafo.remove(num);
                    break;
                }
            }
        }
        else throw new ArestaException(String.format("Aresta %s não existe no grafo", a));
    }

    @Override
    public String toString() {
        String aux = vertices.stream().collect(Collectors.joining(", "));
        String aux1 = grafo.values().stream().map(Aresta::toString).collect(Collectors.joining(", "));
        return aux + "\n" + aux1;
    }
}
