package model;

import interfaces.Exibivel;

public abstract class Material implements Exibivel {
    private int codigo;
    private String titulo;
    private int anoPublicacao;
    private int quantidadeDisponivel;

    public Material(int codigo, String titulo, int anoPublicacao, int quantidadeDisponivel) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public String exibirResumo() {
        return "Código: " + codigo +
                "\nTítulo: " + titulo +
                "\nAno de Publicação" + anoPublicacao +
                "\nQuantidade diponível: " + quantidadeDisponivel;
    }
}
