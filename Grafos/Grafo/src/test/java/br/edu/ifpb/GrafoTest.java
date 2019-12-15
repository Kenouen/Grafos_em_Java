package br.edu.ifpb;

import static org.junit.Assert.assertTrue;
import br.edu.ifpb.VerticeException;

import org.junit.Test;

public class GrafoTest {
    @Test
    public void testeGrafoMap() {
        try {
            GrafoMap gp = new GrafoMap(new String[]{"A", "B", "C", "D", "E"});
            gp.adicionaAresta(new Aresta("A", "B"), 1);
            gp.adicionaAresta(new Aresta("B", "B"), 2);
            gp.adicionaAresta(new Aresta("E", "B"), 3);
            gp.adicionaAresta(new Aresta("D", "J"), 4);
            System.out.println(gp);
        }
        catch (ArestaException e) {
            System.err.println(e.getMessage());
        }
    }
    @Test
    public void testeGrafoList() {
        try {
            GrafoList gl = new GrafoList(new String[]{"A", "B", "C", "D", "E"});
            gl.adicionarVertice("F");
            gl.adicionarVertice("G");
            System.out.println(gl);
        } catch (VerticeException e) {
            System.err.println(e.getMessage());
        }
    }
}
