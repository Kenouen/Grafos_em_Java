package br.edu.ifpb;

import java.util.Map;

public class GrafoMapNDir extends GrafoMap {
    public GrafoMapNDir(String[] vertices) { super(vertices); }
    public GrafoMapNDir(String[] vertices, Map<Integer, Aresta> arestas) { super(vertices, arestas); }
}
