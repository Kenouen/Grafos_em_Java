package br.edu.ifpb.Grafos;

import java.util.Objects;

public class ArestaNDirecionada extends Aresta{

    public ArestaNDirecionada(String vertice1, String vertice2) {
        super(vertice1, vertice2);
    }

    public ArestaNDirecionada(String vertice1, String vertice2, int peso) {
        super(vertice1, vertice2, peso);
    }

    public String arestaIncide (String vertice){
        if (this.getVertice1().equals(vertice)){
            return String.format("%s-%s", vertice, getVertice2());
        }
        if(this.getVertice2().equals(vertice)){
            return String.format("%s-%s", getVertice2(), vertice);
        }
        return null;
    }
}
