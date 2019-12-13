package br.edu.ifpb;

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
}