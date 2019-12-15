package br.edu.ifpb.Grafos;

import java.util.Objects;

public class Vertice implements Comparable<Vertice>{
    private String nome;
    private int Beta;
    private boolean fi;
    private String pi;


    public Vertice(String nome) {
        this.nome = nome;
        Beta = 0;
        this.fi = false;
        this.pi = "";
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBeta() {
        return Beta;
    }

    public void setBeta(int beta) {
        Beta = beta;
    }

    public boolean isFi() {
        return fi;
    }

    public void setFi(boolean fi) {
        this.fi = fi;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    @Override
    public String toString() {
        return "Vertice{" +
                "nome='" + nome + '\'' +
                ", Beta=" + Beta +
                ", fi=" + fi +
                ", pi='" + pi + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return nome.equals(vertice.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public int compareTo(Vertice o) {
        return this.getNome().compareTo(o.getNome());
    }
}
