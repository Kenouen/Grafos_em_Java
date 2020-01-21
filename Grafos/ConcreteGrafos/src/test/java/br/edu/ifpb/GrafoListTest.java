package br.edu.ifpb;

import org.junit.Test;

public class GrafoListTest {
    @Test
    public void Test() throws MatrizException, ArestaException {
        GrafoListDir gl = new GrafoListDir(new String[]{"A", "B", "C", "D"});
        System.out.println(gl);
        System.out.println(gl);
        gl.adicionarAresta(new Aresta("C", "C"));
        gl.adicionarAresta(new Aresta("D", "C"));
        gl.adicionarAresta(new Aresta("C", "A"));
        gl.adicionarAresta(new Aresta("B", "A"));
//        gl.adicionarAresta(new Aresta("C", "A"));
//        gl.adicionarAresta(new Aresta("C", "B"));
        System.out.println(gl.verticeNaoAdj());
        System.out.println(gl.haCiclo());
        System.out.println(gl.haArestasParalelas());
        System.out.println(gl.grau("C"));
        System.out.println(gl.verticesIncidentes("C"));
        System.out.println(gl.ehCompleto());
    }
}
