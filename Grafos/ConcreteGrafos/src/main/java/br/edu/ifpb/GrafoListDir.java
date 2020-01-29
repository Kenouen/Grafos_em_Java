package br.edu.ifpb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrafoListDir extends GrafoList {
    public GrafoListDir(String[] vertice) throws MatrizException {
        super(vertice);
        for (int i = 0; i < vertice.length; i ++) {
            String[] AUX = new String[vertice.length];
            Arrays.fill(AUX, "0");
            arestas.add(Arrays.asList(AUX));
        }
    }

    @Override
    public void adicionarVertice(String vertice) throws VerticeException {
        if (vertices.contains(vertice)) throw new VerticeException(String.format("Vértice %s é já existe!", vertice));
        vertices.add(vertice);
        for (List<String> l : arestas) l.add("0");
        String[] AUX = new String[vertices.size()];
        Arrays.fill(AUX, "0");
        arestas.add(Arrays.asList(AUX));
    }
    @Override
    public void removerVertice(String vertice) throws VerticeException {
        int AUX = vertices.indexOf(vertice);
        if (!vertices.contains(vertice)) throw new VerticeException(String.format("Vértice %s é não existe ou já foi retirado!", vertice));
        vertices.remove(vertice);
        arestas.remove(AUX);
        for (List<String> l : arestas) l.remove(AUX);
    }
    @Override
    public void adicionarAresta(Aresta a) throws ArestaException {
        if (!vertices.contains(a.getVerticeA()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeA()));
        if (!vertices.contains(a.getVerticeB()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeB()));
        arestas1.add(a);
        if (!arestas.get(vertices.indexOf(a.getVerticeA())).get(vertices.indexOf(a.getVerticeB())).equals("-"))
            arestas.get(vertices.indexOf(a.getVerticeA())).set(vertices.indexOf(a.getVerticeB())
                    , String.format("%d", 1 + Integer.parseInt(arestas.get(vertices.indexOf(a.getVerticeA())).get(vertices.indexOf(a.getVerticeB())))));
    }
    @Override
    public void removerAresta(Aresta a) throws ArestaException {
        if (!vertices.contains(a.getVerticeA()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeA()));
        if (!vertices.contains(a.getVerticeB()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeB()));
        if (!arestas.get(vertices.indexOf(a.getVerticeA())).get(vertices.indexOf(a.getVerticeB())).equals("0"))
            arestas.get(vertices.indexOf(a.getVerticeA())).set(vertices.indexOf(a.getVerticeB())
                    , String.format("%d", Integer.parseInt(arestas.get(vertices.indexOf(a.getVerticeA())).get(vertices.indexOf(a.getVerticeB()))) - 1));
        else
            throw new ArestaException(String.format("Aresta %s inválida! não existe mais aresta com %s e %s", a, a.getVerticeA(), a.getVerticeB()));
        boolean cond = false;
        for (Aresta a1 : arestas1) {
            if (a1.getVerticeA().equals(a.getVerticeA()) && a1.getVerticeB().equals(a.getVerticeB())) {
                arestas1.remove(a1);
                cond = true;
                break;
            }
        }
        if (!cond) throw new ArestaException(String.format("Aresta %s inválida! ela não existe nas lista de arestas!", a));
    }
    public String verticesIncidentes(String vertice) {
        StringBuilder AUX = new StringBuilder();
        for (int i = 0; i < vertices.size(); i ++) {
            for (int j = 0; j < vertices.size(); j ++) {
                int AUX1 = Integer.parseInt(arestas.get(i).get(j));
                if (vertices.get(j).equals(vertice)) {
                    for (int k = 0; k < AUX1; k ++) {
                        if (i != AUX1 - 1) AUX.append(vertices.get(i) + " ,");
                        else AUX.append(vertices.get(i));
                    }
                }
            }
        }
        return AUX.toString();
    }
    public String verticesAdjacentes(String vertice) {
        StringBuilder AUX = new StringBuilder();
        for (int i = 0; i < vertices.size(); i ++) {
            for (int j = 0; j < vertices.size(); j ++) {
                int AUX1 = Integer.parseInt(arestas.get(i).get(j));
                if (vertices.get(i).equals(vertice)) {
                    for (int k = 0; k < AUX1; k ++) {
                        if (i != AUX1 - 1) AUX.append(vertices.get(j) + " ,");
                        else AUX.append(vertices.get(j));
                    }
                }
            }
        }
        return AUX.toString();
    }
    @Override
    public boolean ehCompleto() {
        boolean cond = true;
        int i = 0;
        while (cond) {
            if (vertices.size() - 1 == i) break;
            String vertice = vertices.get(i);
            List<String> AUX = Arrays.asList(verticesIncidentes(vertice).split(" ,"));
            List<String> AUX1 = new ArrayList<>(vertices);
            AUX1.remove(vertice);
            if (!AUX.containsAll(AUX1)) {
                cond = false;
                break;
            }
            AUX = Arrays.asList(verticesAdjacentes(vertice).split(" ,"));
            if (!AUX.containsAll(AUX1)) {
                cond = false;
                break;
            }
            i ++;
        }
        return cond;
    }
}
