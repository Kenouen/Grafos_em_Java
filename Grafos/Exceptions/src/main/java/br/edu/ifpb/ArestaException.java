package br.edu.ifpb;

public class ArestaException extends Exception {
    public ArestaException() { super("Aresta inváida!"); }
    public ArestaException(String message) { super(message); }
}
