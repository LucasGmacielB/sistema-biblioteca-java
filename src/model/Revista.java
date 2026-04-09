package model;

public class Revista extends Material{
    private int edicao;

    public Revista(int codigo, String titulo, int anoPublicacao, int quantidadeDisponivel) {
        super(codigo, titulo, anoPublicacao, quantidadeDisponivel);
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
}
