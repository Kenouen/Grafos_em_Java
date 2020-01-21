package br.edu.ifpb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrafoList extends Grafo {
    protected List<List<String>> arestas;
    protected List<Aresta> arestas1;

    public GrafoList(String[] vertice) throws MatrizException {
        super(vertice);
        this.arestas = new ArrayList<>();
        arestas1 = new ArrayList<>();
    }

    @Override
    public void adicionarVertice(String vertice) throws VerticeException {
        super.adicionarVertice(vertice);
        for (List<String> i : arestas) i.add("0");
        String[] AUX = new String[vertices.size()];
        Arrays.fill(AUX, "-");
        AUX[vertices.size() - 1] = "0";
        arestas.add(new ArrayList<>(Arrays.asList(AUX)));
    }
    @Override
    public void removerVertice(String vertice) throws VerticeException {
        List<String> AUX = new ArrayList<>();
        AUX.addAll(vertices);
        super.removerVertice(vertice);
        int AUX1 = AUX.indexOf(vertice);
        for (List<String> i : arestas) i.remove(AUX1);
        arestas.remove(AUX1);
    }
    public void adicionarAresta(Aresta a) throws ArestaException {
        if (!vertices.contains(a.getVerticeA()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeA()));
        if (!vertices.contains(a.getVerticeB()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeB()));
        arestas1.add(a);
        if (!arestas.get(vertices.indexOf(a.getVerticeA())).get(vertices.indexOf(a.getVerticeB())).equals("-"))
            arestas.get(vertices.indexOf(a.getVerticeA())).set(vertices.indexOf(a.getVerticeB())
                    , String.format("%d", 1 + Integer.parseInt(arestas.get(vertices.indexOf(a.getVerticeA())).get(vertices.indexOf(a.getVerticeB())))));
        else
            arestas.get(vertices.indexOf(a.getVerticeB())).set(vertices.indexOf(a.getVerticeA())
                    , String.format("%d", 1 + Integer.parseInt(arestas.get(vertices.indexOf(a.getVerticeB())).get(vertices.indexOf(a.getVerticeA())))));
    }
    public void removerAresta(Aresta a) throws ArestaException {
        if (!vertices.contains(a.getVerticeA()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeA()));
        if (!vertices.contains(a.getVerticeB()))
            throw new ArestaException(String.format("Aresta %s inválida! Falta %s na lista de vértices!", a, a.getVerticeB()));
        if (!arestas.get(vertices.indexOf(a.getVerticeA())).get(vertices.indexOf(a.getVerticeB())).equals("-"))
            if (!arestas.get(vertices.indexOf(a.getVerticeA())).get(vertices.indexOf(a.getVerticeB())).equals("0"))
                arestas.get(vertices.indexOf(a.getVerticeA())).set(vertices.indexOf(a.getVerticeB())
                        , String.format("%d", Integer.parseInt(arestas.get(vertices.indexOf(a.getVerticeA())).get(vertices.indexOf(a.getVerticeB()))) - 1));
            else
                throw new ArestaException(String.format("Aresta %s inválida! não existe mais aresta com %s e %s", a, a.getVerticeA(), a.getVerticeB()));
        else
            if (!arestas.get(vertices.indexOf(a.getVerticeB())).get(vertices.indexOf(a.getVerticeA())).equals("0"))
                arestas.get(vertices.indexOf(a.getVerticeB())).set(vertices.indexOf(a.getVerticeA())
                        , String.format("%d", Integer.parseInt(arestas.get(vertices.indexOf(a.getVerticeB())).get(vertices.indexOf(a.getVerticeA()))) - 1));
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
    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder("  " + String.join(" ", vertices) + "\n");
        for (int i = 0; i < arestas.size(); i ++) {
            aux.append(vertices.get(i)).append(" ");
            aux.append(String.join(" ", arestas.get(i))).append("\n");
        }
        return aux.toString();
    }
    public String verticeNaoAdj() {
        StringBuilder AUX = new StringBuilder();
        for (int i = 0; i < vertices.size(); i ++) {
            for (int j = i; j < vertices.size(); j ++) {
                if (arestas.get(i).get(j).equals("0")) {
                    if (j != vertices.size() - 1) AUX.append(vertices.get(i) + "-" + vertices.get(j) + " ,");
                    else AUX.append(vertices.get(i) + "-" + vertices.get(j));
                }
            }
        }
        return AUX.toString();
    }
    public boolean haCiclo() {
        for (int i = 0; i < vertices.size(); i ++) {
            if (!arestas.get(i).get(i).equals("0")) return true;
        }
        return false;
    }
    public boolean haArestasParalelas() {
        for (int i = 0; i < vertices.size(); i ++) {
            for (int j = i; j < vertices.size(); j ++) {
                int AUX = Integer.parseInt(arestas.get(i).get(j));
                if (AUX >= 2) return true;
            }
        }
        return false;
    }
    public int grau(String vertice) {
        String[] AUX = verticesIncidentes(vertice).split(", ");
        return AUX.length;
    }
    public String verticesIncidentes(String vertice) {
        StringBuilder AUX = new StringBuilder();
        for (int i = 0; i < vertices.size(); i ++) {
            for (int j = i; j < vertices.size(); j ++) {
                int AUX1 = Integer.parseInt(arestas.get(i).get(j));
                if (i == vertices.indexOf(vertice)) {
                    if (AUX1 >= 1) {
                        for (int k = 0; k < AUX1; k ++) {
                            if (k != AUX1 - 1) AUX.append(vertices.get(j) + " ,");
                            else AUX.append(vertices.get(j) + " ,");
                        }
                    }
                }
                else if (j == vertices.indexOf(vertice)) {
                    if (AUX1 >= 1) {
                        for (int k = 0; k < AUX1; k ++) {
                            if (k != AUX1 - 1) AUX.append(vertices.get(i) + " ,");
                            else AUX.append(vertices.get(i) + " ,");
                        }
                    }
                }
            }
        }
        return AUX.toString();
    }
    public boolean ehCompleto() {
        for (String v : vertices) {
            List<String> verticesV = Arrays.asList(verticesIncidentes(v).split(", "));
            if (!(verticesV.size() >= vertices.size() - 1)) return false;
        }
        return true;
    }
}