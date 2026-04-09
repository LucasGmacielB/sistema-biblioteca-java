package service;

import model.Material;

import java.util.ArrayList;
import java.util.List;

public class MaterialService {
    private List<Material> materiais = new ArrayList<>();

    public void cadastrarMaterial(Material m) {
        materiais.add(m);
    }

    public Material buscarMaterial(int id) {
        for (Material m : materiais) {
            if (m.getCodigo() == id) {
                return m;
            }
        }
        return null;
    }

    public void listar() {
        for (Material m : materiais) {
            System.out.println("---------------------");
            System.out.println(m.exibirResumo());
            System.out.println("---------------------");
        }
    }

    public boolean verificarDisponibilidade(Material material) {
        return material.getQuantidadeDisponivel() > 0;
    }

    public void reduzirEmprestimo(Material material) {
        if (verificarDisponibilidade(material)) {
            material.setQuantidadeDisponivel(material.getQuantidadeDisponivel() - 1);
        } else {
            throw new RuntimeException("Material indisponível");
        }
    }

    public void aumentarDevolucao(Material material) {
        material.setQuantidadeDisponivel(material.getQuantidadeDisponivel() + 1);
    }
}
