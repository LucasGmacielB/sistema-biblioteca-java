package model;

public class Professor extends Usuario{

    public Professor(int codigo, String nome, String email) {
        super(codigo, nome, email);
    }

    @Override
    public int limiteEmprestimos() {
        return 5;
    }

    @Override
    public int prazoDevolucao() {
        return 14;
    }

    @Override
    public double valorMulta() {
        return 1;
    }

    @Override
    public String tipoUsuario() {
        return "Professor";
    }
}
