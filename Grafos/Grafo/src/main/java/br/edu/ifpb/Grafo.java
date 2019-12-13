package br.edu.ifpb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import br.edu.ifpb.VerticeException;

public abstract class Grafo {
    private List<String> vertices;

    public Grafo() { vertices = new ArrayList<>(); }
    public Grafo(String array[]) { vertices = new ArrayList<>(Arrays.asList(array)); }

    public void adicionarVertice(String vertice) throws VerticeException {
        if (vertices.contains(vertice)) throw new VerticeException(String.format("Vértice %s é já existe!"));
        vertices.add(vertice);
    }
    public void removerVertice(String vertice) throws VerticeException {
        if (!vertices.contains(vertice)) throw new VerticeException(String.format("Vértice %s é não existe ou já foi retirado!"));
        vertices.remove(vertice);
    }
}
