package model;

public class Aluno extends Usuario{

    public Aluno(int codigo, String nome, String email) {
        super(codigo, nome, email);
    }

    @Override
    public int limiteEmprestimos() {
        return 3;
    }

    @Override
    public int prazoDevolucao() {
        return 7;
    }

    @Override
    public double valorMulta() {
        return 2.5;
    }

    @Override
    public String tipoUsuario() {
        return "Aluno";
    }
}
