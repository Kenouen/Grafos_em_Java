package br.edu.ifpb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GrafoList extends Grafo {
    protected List<List<String>> grafo;
    protected List<Aresta> arestas;

    public GrafoList(String[] vertice) {
        super(vertice);
        grafo = new ArrayList<>();
        arestas = new ArrayList<>();
        for (int i = 0; i < vertice.length; i ++) {
            String[] array = new String[vertice.length];
            Arrays.fill(array, "-");
            for (int j = i; j < vertice.length; j ++) {
                array[j] = "0";
            }
            grafo.add(new ArrayList<>(Arrays.asList(array)));
        }
    }
    public GrafoList(String[] vertice, String[][] array) {
        super(vertice);
        arestas = new ArrayList<>();
        for (String[] i : array) {
            grafo.add(Arrays.asList(i));
        }
        for (int i = 0; i < grafo.size(); i ++) {
            for (int j = i; j < grafo.size(); j ++) {
                if (!grafo.get(i).get(j).equals("0"))
                    arestas.add(new Aresta(vertices.get(i), vertices.get(j)));
            }
        }
    }

    public void adicionarAresta(Aresta a) throws ArestaException {
        if (!vertices.contains(a.getVerticeA()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeA()));
        if (!vertices.contains(a.getVerticeB()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeB()));
        arestas.add(a);
        if (!grafo.get(vertices.indexOf(a.getVerticeA())).get(vertices.indexOf(a.getVerticeB())).equals("-"))
            grafo.get(vertices.indexOf(a.getVerticeA())).set(vertices.indexOf(a.getVerticeB())
                    , String.format("%d", 1 + Integer.parseInt(grafo.get(vertices.indexOf(a.getVerticeA())).get(vertices.indexOf(a.getVerticeB())))));
        else
            grafo.get(vertices.indexOf(a.getVerticeB())).set(vertices.indexOf(a.getVerticeA())
                    , String.format("%d", 1 + Integer.parseInt(grafo.get(vertices.indexOf(a.getVerticeB())).get(vertices.indexOf(a.getVerticeA())))));
    }

    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder("  " + vertices.stream().collect(Collectors.joining(" ")) + "\n");
        for (int i = 0; i < grafo.size(); i ++) {
            aux.append(vertices.get(i)).append(" ");
            aux.append(grafo.get(i).stream().collect(Collectors.joining(" "))).append("\n");
        }
        return aux.toString();
    }
}
