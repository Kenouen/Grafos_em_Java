package br.edu.ifpb;

public class MatrizException extends Exception {
    public MatrizException() { super("Matriz inválida!"); }
    public MatrizException(String message) { super(message); }
}
