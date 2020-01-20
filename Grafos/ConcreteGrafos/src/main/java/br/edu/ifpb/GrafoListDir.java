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

    public String verticeNaoAdj() {
        List<String> AUX = new ArrayList<>();
        for (int i = 0; i < vertices.size(); i ++) {
            for (int j = 0; j < vertices.size(); j ++) {
                if (arestas.get(i).get(j).equals("0")) AUX.add(vertices.get(i) + "-" + vertices.get(j));
            }
        }
        return String.join(" ,", AUX);
    }
    @Override
    public boolean haArestasParalelas() {
        for (int i = 0; i < vertices.size(); i ++) {
            for (int j = 0; j < vertices.size(); j ++) {
                int AUX = Integer.parseInt(arestas.get(i).get(j));
                if (AUX >= 2) return true;
            }
        }
        return false;
    }
    @Override
    public String verticesIncidentes(String vertice) {
        List<String> AUX = new ArrayList();
        for (int i = 0; i < vertices.size(); i ++) {
            for (int j = 0; j < vertices.size(); j ++) {
                if (vertices.get(j).equals(vertice)) {
                    for (int k = 0; k < Integer.parseInt(arestas.get(i).get(j)); k ++)
                        AUX.add(vertices.get(i));
                }
            }
        }
        return String.join(" ,", AUX);
    }
    public String verticesIncidentesReverso(String vertice) {
        List<String> AUX = new ArrayList();
        for (int i = 0; i < vertices.size(); i ++) {
            for (int j = 0; j < vertices.size(); j ++) {
                if (vertices.get(i).equals(vertice)) {
                    for (int k = 0; k < Integer.parseInt(arestas.get(i).get(j)); k ++)
                        AUX.add(vertices.get(j));
                }
            }
        }
        return String.join(" ,", AUX);
    }
    @Override
    public int grau(String vertice) {
        String[] AUX = verticesIncidentes(vertice).split(" ,");
        String[] AUX1 = verticesIncidentesReverso(vertice).split(" ,");
        return AUX.length + AUX1.length;
    }
}
