package br.edu.ifpb.Grafos;

import java.util.Objects;

public abstract class Aresta {
    private String vertice1;
    private String vertice2;
    private int peso;

    public Aresta(String vertice1, String vertice2) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.peso = 1;
    }

    public Aresta(String vertice1, String vertice2, int peso) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.peso = peso;
    }

    public String getVertice1() {
        return vertice1;
    }

    public void setVertice1(String vertice1) {
        this.vertice1 = vertice1;
    }

    public String getVertice2() {
        return vertice2;
    }

    public void setVertice2(String vertice2) {
        this.vertice2 = vertice2;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aresta aresta = (Aresta) o;
        return vertice1.equals(aresta.vertice1) &&
                vertice2.equals(aresta.vertice2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertice1, vertice2);
    }
}
