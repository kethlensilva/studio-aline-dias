package com.studio.aline.dias.service;

import com.studio.aline.dias.model.Usuario;
import com.studio.aline.dias.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para cadastrar usuário
    public String cadastrarUsuario(String nome, String email, String senha) {
        if (usuarioRepository.findByEmail(email).isPresent()) {
            return "Usuário já cadastrado";
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuarioRepository.save(usuario); // Salva no banco

        return "Usuário cadastrado com sucesso";
    }
}
