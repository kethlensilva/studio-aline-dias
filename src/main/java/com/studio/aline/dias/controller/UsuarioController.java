package com.studio.aline.dias.controller;

import com.studio.aline.dias.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.studio.aline.dias.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Cadastro de Usuário - Recebendo os parâmetros diretamente
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarUsuario(@RequestParam String nome, 
                                                   @RequestParam String email, 
                                                   @RequestParam String senha) {
        // Verifica se o usuário já existe
        if (usuarioRepository.findByEmail(email).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já cadastrado");
        }

        // Cria um novo usuário e salva no banco
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuarioRepository.save(usuario); // Salva no banco

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso");
    }
}
