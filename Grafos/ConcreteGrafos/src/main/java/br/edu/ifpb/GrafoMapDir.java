package br.edu.ifpb;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Comparator;

public class GrafoMapDir extends GrafoMap {
    public GrafoMapDir(String[] vertices) { super(vertices); }

    @Override
    public String verticesNaoAdj() {
        List<String> verticesList = new ArrayList<>();
        for (String i : vertices) {
            for (String j : vertices) {
                Aresta a = new Aresta(i, j);
                if (!temAresta(a)) verticesList.add(a.toString());
            }
        }
        return String.join(", ", verticesList);
    }
    @Override
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
    @Override
    public int grau(String vertice) {
        String[] AUX = verticesIncidentes(vertice).split(", ");
        return AUX.length;
    }
    @Override
    public String verticesIncidentes(String vertice) {
        List<String> vertices = new ArrayList<>();
        for (int i : arestas.keySet()) {
            if (arestas.get(i).getVerticeB().equals(vertice)) vertices.add(arestas.get(i).getVerticeA().toString());
        }
        return String.join(", ", vertices);
    }
    public String verticesIncidentes1(String vertice) {
        List<String> vertices = new ArrayList<>();
        for (int i : arestas.keySet()) {
            if (arestas.get(i).getVerticeA().equals(vertice)) vertices.add(arestas.get(i).getVerticeB().toString());
        }
        return String.join(", ", vertices);
    }
    @Override
    public boolean ehCompleto() {
        Map<String, List<String>> AUXS = new HashMap();
        for (String v : vertices) {
            List<String> AUX = new ArrayList<>(Arrays.asList(verticesIncidentes(v).split(", ")));
            AUX.addAll(Arrays.asList(verticesIncidentes1(v).split(", ")));
            AUXS.put(v, AUX);
        }
        for (String a : AUXS.keySet()) {
            List<String> AUX = new ArrayList<>(vertices);
            AUX.remove(a);
            if (!compare(AUXS.get(a), AUX)) return false;
        }
        return true;
    }
    public boolean compare(List<String> list, List<String> list1) {
        list.sort(Comparator.naturalOrder());
        list1.sort(Comparator.naturalOrder());
        if (list.size() != list1.size()) return false;
        for (int i = 0; i < list.size(); i ++) {
            if (list.get(i) != list1.get(i)) return false;
        }
        return true;
    }
}
