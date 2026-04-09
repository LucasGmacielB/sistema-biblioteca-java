package model;

public class Livro extends Material{
    private String autor;

    public Livro(int codigo, String titulo, int anoPublicacao, int quantidadeDisponivel) {
        super(codigo, titulo, anoPublicacao, quantidadeDisponivel);
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
