package br.edu.ifpb.Grafos;

import java.util.List;

public class GrafosListadoNDirecinado extends GrafoListado {

    public GrafosListadoNDirecinado() {
    }

    public GrafosListadoNDirecinado(List<String> vertices) {
        super(vertices);
    }

    public GrafosListadoNDirecinado(List<String> vertices, List<String> arestas) {
        super(vertices, arestas);
    }


}
