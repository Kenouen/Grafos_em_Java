package br.edu.ifpb.Grafos;
import java.util.*;

public abstract class Grafo
{
    public List<Vertice> Vertices;
    public List<Aresta> Arestas;


    public Grafo() {
        Vertices = new ArrayList<>();
        Arestas = new ArrayList<>();
    }

    public boolean verticeValido(Vertice vertice){
        return !vertice.getNome().equals("") && !vertice.getNome().equals(" ") && vertice.getNome().length() == 1;
    }

    public boolean arestaValido(String aresta){
        String novo1 = String.format("%c", aresta.charAt(0));
        String novo2 = String.format("%c", aresta.charAt(aresta.length()-1));

        return !verticeValido(new Vertice(novo1)) &&
                !verticeValido (new Vertice(novo2));
    }

    @Override
    public String toString() {

        System.out.println(Vertices.toString());
        System.out.println(Arestas.toString());

        return null;
    }
}
