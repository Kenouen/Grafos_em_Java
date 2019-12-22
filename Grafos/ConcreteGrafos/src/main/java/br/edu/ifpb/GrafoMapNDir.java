package br.edu.ifpb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GrafoMapNDir extends GrafoMap {
    public GrafoMapNDir(String[] vertices) { super(vertices); }
    public GrafoMapNDir(String[] vertices, Map<Integer, Aresta> arestas) { super(vertices, arestas); }

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
}
