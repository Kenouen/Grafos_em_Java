package br.edu.ifpb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GrafoMapNDir extends GrafoMap {
    public GrafoMapNDir(String[] vertices) { super(vertices); }
    public GrafoMapNDir(String[] vertices, Map<Integer, Aresta> arestas) { super(vertices, arestas); }
}
