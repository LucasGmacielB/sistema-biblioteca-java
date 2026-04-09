package model;

import interfaces.CalculavelMulta;
import interfaces.Exibivel;

import java.time.LocalDate;

public class Emprestimo implements Exibivel{
    private int idEmprestimo;
    private Usuario usuario;
    private Material material;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate dataRealDevolucao;

    public Emprestimo(int idEmprestimo, Usuario usuario, Material material, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.idEmprestimo = idEmprestimo;
        this.usuario = usuario;
        this.material = material;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String exibirResumo() {
        return "id: " + idEmprestimo +
                "Data do Emprestimo: " + dataEmprestimo +
                "Data de devolução: " + dataDevolucao +
                "Data que foi devolvido: " + dataRealDevolucao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataRealDevolucao() {
        return dataRealDevolucao;
    }

    public void setDataRealDevolucao(LocalDate dataRealDevolucao) {
        this.dataRealDevolucao = dataRealDevolucao;
    }
}
