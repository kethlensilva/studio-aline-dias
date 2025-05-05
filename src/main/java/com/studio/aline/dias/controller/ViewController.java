package com.studio.aline.dias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/login")
    public String exibirTelaLogin() {
        return "login"; // Isso renderiza login.html (sem o .html aqui)
    }

    @GetMapping("/cadastro")
    public String exibirTelaCadastro() {
        return "cadastro"; // Isso renderiza cadastro.html
    }
}
