package br.edu.ifpb;

import java.util.*;
import java.util.stream.Collectors;
import br.edu.ifpb.Aresta;

public abstract class GrafoMap extends Grafo {
    protected Map<Integer, Aresta> arestas;

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

    public boolean temAresta(Aresta a) {
        for (Aresta i : arestas.values()) {
            if (i.equals(a)) return true;
        }
        return false;
    }
    public String verticesNaoAdj() {
        List<String> verticesList = new ArrayList<>();
        for (String i : vertices) {
            for (String j : vertices) {
                Aresta a = new Aresta(i, j);
                if (!temAresta(a) && !temAresta(new Aresta(a.getVerticeB(), a.getVerticeA())))
                    verticesList.add(a.toString());
            }
        }
        return String.join(", ", verticesList);
    }
    public boolean haCiclo() {
        for (Aresta a : arestas.values()) {
            if (a.getVerticeB().equals(a.getVerticeA())) return true;
        }
        return false;
    }
    public boolean haArestasParalelas() {
        for (int i : arestas.keySet()) {
            for (int j : arestas.keySet()) {
                if (i != j) {
                    if (arestas.get(i).equals(arestas.get(j))) return true;
                    else {
                        if (arestas.get(i).getVerticeA().equals(arestas.get(j).getVerticeB()) &&
                            arestas.get(j).getVerticeA().equals(arestas.get(i).getVerticeB()))
                                return true;
                    }
                }
            }
        }
        return false;
    }
    public String verticesIncidentes(String vertice) {
        List<String> vertices = new ArrayList<>();
        for (Aresta a : arestas.values()) {
            if (a.getVerticeA().equals(vertice)) vertices.add(a.getVerticeB());
            else if (a.getVerticeB().equals(vertice)) vertices.add(a.getVerticeA());
        }
        return String.join(", ", vertices);
    }
    public boolean ehCompleto() {
        for (String v : vertices) {
            List<String> verticesV = Arrays.asList(verticesIncidentes(v).split(", "));
            if (!(verticesV.size() >= vertices.size() - 1)) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String aux = String.join(", ", vertices);
        String aux1 = arestas.values().stream().map(Aresta::toString).collect(Collectors.joining(", "));
        return aux + "\n" + aux1;
    }
}
