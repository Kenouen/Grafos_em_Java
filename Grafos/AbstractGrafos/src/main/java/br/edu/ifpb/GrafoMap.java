package br.edu.ifpb;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import br.edu.ifpb.Aresta;

public abstract class GrafoMap extends Grafo {
    private Map<Integer, Aresta> arestas;

    public GrafoMap(String[] vertices) {
        super(vertices);
        arestas = new TreeMap<>();
    }
    public GrafoMap(String[] vertices, Map<Integer, Aresta> arestas) {
        super(vertices);
        this.arestas = new TreeMap<>(arestas);
    }

    public void adicionaAresta(Aresta a, int num) throws ArestaException {
        if (!vertices.contains(a.getVerticeA()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeA()));
        if (!vertices.contains(a.getVerticeB()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeB()));
        if (arestas.containsKey(num))
            throw new ArestaException(String.format("Aresta com número %d já existe!", num));
        arestas.put(num, a);
    }
    public void removerAresta(Aresta a) throws ArestaException {
        if (arestas.containsValue(a)) {
            for (Integer num : arestas.keySet()) {
                if (arestas.get(num).equals(a)) {
                    arestas.remove(num);
                    break;
                }
            }
        }
        else throw new ArestaException(String.format("Aresta %s não existe no grafo", a));
    }

    @Override
    public String toString() {
        String aux = String.join(", ", vertices);
        String aux1 = arestas.values().stream().map(Aresta::toString).collect(Collectors.joining(", "));
        return aux + "\n" + aux1;
    }
}
