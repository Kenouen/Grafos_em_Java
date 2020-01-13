package br.edu.ifpb;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Arrays;

public class GrafoMapNDirTest {
    @Test
    public void test() {
        try {
            GrafoMapDir gf = new GrafoMapDir(new String[]{"A", "B", "C"});
            gf.adicionaAresta(new Aresta("A", "B"), 1);
            gf.adicionaAresta(new Aresta("B", "C"), 2);
            gf.adicionaAresta(new Aresta("C", "C"), 3);
            System.out.println(gf.verticesNaoAdj());
            System.out.println(gf.haCiclo());
            System.out.println(gf.haArestasParalelas());
            System.out.println(gf.verticesIncidentes("B"));
            System.out.println(gf.ehCompleto());
        } catch (ArestaException e) {
            System.err.println(e.getMessage());
        }
    }
}
