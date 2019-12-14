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
        grafo = new ArrayList<>();
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

    public void removerAresta(Aresta a) throws ArestaException {
        if (!vertices.contains(a.getVerticeA()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeA()));
        if (!vertices.contains(a.getVerticeB()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeB()));
        if (!grafo.get(vertices.indexOf(a.getVerticeA())).get(vertices.indexOf(a.getVerticeB())).equals("-"))
            if (!grafo.get(vertices.indexOf(a.getVerticeA())).get(vertices.indexOf(a.getVerticeB())).equals("0"))
                grafo.get(vertices.indexOf(a.getVerticeA())).set(vertices.indexOf(a.getVerticeB())
                        , String.format("%d", Integer.parseInt(grafo.get(vertices.indexOf(a.getVerticeA())).get(vertices.indexOf(a.getVerticeB()))) - 1));
            else
                throw new ArestaException(String.format("Aresta %s inválida! não existe mais aresta com %s e %s", a, a.getVerticeA(), a.getVerticeB()));
        else
            if (!grafo.get(vertices.indexOf(a.getVerticeB())).get(vertices.indexOf(a.getVerticeA())).equals("0"))
                grafo.get(vertices.indexOf(a.getVerticeB())).set(vertices.indexOf(a.getVerticeA())
                        , String.format("%d", Integer.parseInt(grafo.get(vertices.indexOf(a.getVerticeB())).get(vertices.indexOf(a.getVerticeA()))) - 1));
            else
                throw new ArestaException(String.format("Aresta %s inválida! não existe mais aresta com %s e %s", a, a.getVerticeA(), a.getVerticeB()));
        boolean cond = false;
        for (Aresta a1 : arestas) {
            if (a1.getVerticeA().equals(a.getVerticeA()) && a1.getVerticeB().equals(a.getVerticeB())) {
                arestas.remove(a1);
                cond = true;
                break;
            }
        }
        if (!cond) throw new ArestaException(String.format("Aresta %s inválida! ela não existe nas lista de arestas!", a));
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
