package br.edu.ifpb;

import java.util.ArrayList;
import java.util.Arrays;

public class GrafoListNDir extends GrafoList {
    public GrafoListNDir(String[] vertice) throws MatrizException {
        super(vertice);
        for (int i = 0; i < vertice.length; i ++) {
            String[] array = new String[vertice.length];
            Arrays.fill(array, "-");
            for (int j = i; j < vertice.length; j++) array[j] = "0";
            arestas.add(new ArrayList<>(Arrays.asList(array)));
        }
    }
}
