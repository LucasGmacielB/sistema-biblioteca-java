import model.*;
import service.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        UsuarioService usuarioService = new UsuarioService();
        MaterialService materialService = new MaterialService();
        EmprestimoService emprestimoService = new EmprestimoService(usuarioService, materialService);

        Usuario aluno = new Aluno(1, "Ana", "ana@email");
        Usuario professor = new Professor(2, "Carlos", "carlos@email");

        usuarioService.cadastrarUsuario(aluno);
        usuarioService.cadastrarUsuario(professor);


        Material livro1 = new Livro(1, "Java Básico", 2, 10);
        Material livro2 = new Livro(2, "Estruturas de Dados", 1, 8);
        Material revista = new Revista(3, "Revista Tech", 1, 1);
        Material ebook = new Ebook(4, "POO em Java", 1, 200);

        materialService.cadastrarMaterial(livro1);
        materialService.cadastrarMaterial(livro2);
        materialService.cadastrarMaterial(revista);
        materialService.cadastrarMaterial(ebook);

        System.out.println("\n=== USUÁRIOS ===");
        usuarioService.listar();

        System.out.println("\n=== MATERIAIS ===");
        materialService.listar();

        emprestimoService.realizarEmprestimo(1, livro1, aluno);
        emprestimoService.realizarEmprestimo(2,  livro2, aluno);
        emprestimoService.realizarEmprestimo(3, revista, aluno);
        emprestimoService.realizarEmprestimo(4, ebook, professor);


        System.out.println("\n=== EMPRÉSTIMOS EM ANDAMENTO ===");
        emprestimoService.listarEmAndamento();


        Emprestimo emp1 = emprestimoService.getEmprestimos().get(0);
        Emprestimo emp2 = emprestimoService.getEmprestimos().get(1);

        emprestimoService.devolver(
                emp1,
                emp1.getDataDevolucao().plusDays(3)
        );

        emprestimoService.devolver(
                emp2,
                emp2.getDataDevolucao()
        );

        System.out.println("\n=== MULTAS ===");

        double multa1 = emprestimoService.calcularMulta(emp1);
        double multa2 = emprestimoService.calcularMulta(emp2);

        System.out.println("Multa (com atraso): R$ " + multa1);
        System.out.println("Multa (sem atraso): R$ " + multa2);

        System.out.println("\n=== ESTADO FINAL ===");

        System.out.println("\nMateriais atualizados:");
        materialService.listar();

        System.out.println("\nEmpréstimos finalizados:");
        emprestimoService.listarFinalizados();

        System.out.println("\nEmpréstimos em andamento:");
        emprestimoService.listarEmAndamento();
    }
}