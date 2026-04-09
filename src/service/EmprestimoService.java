package service;

import interfaces.CalculavelMulta;
import model.Emprestimo;
import model.Material;
import model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoService implements CalculavelMulta {
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private MaterialService materialService;
    private UsuarioService usuarioService;

    public EmprestimoService(UsuarioService usuarioService, MaterialService materialService) {
        this.usuarioService = usuarioService;
        this.materialService = materialService;
    }

    public void realizarEmprestimo(int id, Material m, Usuario u) {
        if (!materialService.verificarDisponibilidade(m)) {
            throw new RuntimeException("Material sem estoque.");
        }

        int ativos = contarEmprestimosAtivos(u);

        if (ativos >= u.limiteEmprestimos()) {
            throw new RuntimeException("Limite de empréstimos excedido!");
        }

        materialService.reduzirEmprestimo(m);
        LocalDate hoje = LocalDate.now();
        LocalDate dataPrevista = hoje.plusDays(u.prazoDevolucao());

        Emprestimo novoEmprestimo = new Emprestimo(id, u, m, hoje, dataPrevista);
        emprestimos.add(novoEmprestimo);
    }

    public int contarEmprestimosAtivos(Usuario u) {
        int count = 0;

        for (Emprestimo e : emprestimos) {
            if (e.getUsuario().equals(u) && e.getDataRealDevolucao() == null) {
                count++;
            }
        }

        return count;
    }

    public void devolver(Emprestimo emprestimo, LocalDate dataDevolucao) {

        if (emprestimo.getDataRealDevolucao() != null) {
            throw new RuntimeException("Empréstimo já foi devolvido!");
        }

        emprestimo.setDataRealDevolucao(dataDevolucao);

        materialService.aumentarDevolucao(emprestimo.getMaterial());
    }

    @Override
    public double calcularMulta(Emprestimo emprestimo) {

        if (emprestimo.getDataRealDevolucao() == null) {
            throw new RuntimeException("Empréstimo ainda não foi devolvido!");
        }

        long diasAtraso = Math.max(0,
                emprestimo.getDataRealDevolucao().toEpochDay()
                        - emprestimo.getDataDevolucao().toEpochDay());

        return diasAtraso * emprestimo.getUsuario().valorMulta();
    }

    public void listarEmAndamento() {
        for (Emprestimo e : emprestimos) {
            if (e.getDataRealDevolucao() == null) {
                System.out.println("Em aberto: " + e.getMaterial().getTitulo());
            }
        }
    }

    public void listarFinalizados() {
        for (Emprestimo e : emprestimos) {
            if (e.getDataRealDevolucao() != null) {
                System.out.println("Finalizado: " + e.getMaterial().getTitulo());
            }
        }
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}