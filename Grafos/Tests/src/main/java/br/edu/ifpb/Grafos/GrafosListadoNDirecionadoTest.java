package br.edu.ifpb.Grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrafosListadoNDirecionadoTest {

    public static void main(String[] args) {
        List<String> vertices = Arrays.asList("J", "C", "E", "P", "T", "M", "Z");
        List<String> arestas = Arrays.asList("J-C", "C-E","C-E", "C-P", "C-M", "C-T", "M-T", "T-Z");
        GrafosListadoNDirecinado grafo = new GrafosListadoNDirecinado(vertices, arestas);

        System.out.println(grafo.toString());
    }
}
