package br.edu.ifpb;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Arrays;

public class GrafoMapNDirTest {
    @Test
    public void test() {
        try {
            GrafoMapNDir gf = new GrafoMapNDir(new String[]{"A", "B", "C", "D", "E"});
            gf.adicionaAresta(new Aresta("A", "B"), 1);
            gf.adicionaAresta(new Aresta("A", "B"), 2);
            gf.adicionaAresta(new Aresta("B", "B"), 3);
            System.out.println(gf.verticesNaoAdj());
            System.out.println(gf.haCiclo());
            System.out.println(gf.haArestasParalelas());
        } catch (ArestaException e) {
            System.err.println(e.getMessage());
        }
    }
}
