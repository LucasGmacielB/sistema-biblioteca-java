package model;

public class Ebook extends Material{
    private String formato;
    private String arquivo;

    public Ebook(int codigo, String titulo, int anoPublicacao, int quantidadeDisponivel) {
        super(codigo, titulo, anoPublicacao, quantidadeDisponivel);
    }


    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
