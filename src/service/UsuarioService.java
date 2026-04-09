package service;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public Usuario buscarUsuario(int id) {
        for (Usuario u : usuarios) {
            if (u.getCodigo() == id) {
                return u;
            }
        }
        return  null;
    }

    public void listar() {
        for (Usuario u : usuarios) {
            System.out.println("---------------------");
            System.out.println(u.exibirResumo());
            System.out.println("---------------------");
        }
    }
}
