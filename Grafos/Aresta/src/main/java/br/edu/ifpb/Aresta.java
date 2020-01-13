package br.edu.ifpb;

import java.util.Objects;

public class Aresta {
    private String verticeA;
    private String verticeB;

    public Aresta(String verticeA, String verticeB) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
    }

    public String getVerticeA() { return verticeA; }
    public String getVerticeB() { return verticeB; }

    @Override
    public String toString() {
        return String.format("%s-%s", verticeA, verticeB);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aresta aresta = (Aresta) o;
        return Objects.equals(verticeA, aresta.verticeA) &&
                Objects.equals(verticeB, aresta.verticeB);
    }
}