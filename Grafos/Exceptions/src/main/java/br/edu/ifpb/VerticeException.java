package br.edu.ifpb;

public class VerticeException extends Exception {
    public VerticeException() { super("Vertice inválido!"); }
    public VerticeException(String message) { super(message); }
}
