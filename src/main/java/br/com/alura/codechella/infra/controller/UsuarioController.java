package br.com.alura.codechella.infra.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.codechella.application.usecases.CadastrarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    private final CadastrarUsuario cadastrarUsuario;
    private final ListarUsuarios listarUsuarios;

    public UsuarioController(CadastrarUsuario cadastrarUsuario, ListarUsuarios listarUsuarios) {
        this.cadastrarUsuario = cadastrarUsuario;
        this.listarUsuarios = listarUsuarios;
    }

    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto){
        Usuario salvo = cadastrarUsuario.cadastrarUsuario(new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return new UsuarioDto(salvo.getCpf(), salvo.getNome(), salvo.getNascimento(), salvo.getEmail());
    }

    @GetMapping
    public List<UsuarioDto> listarUsuarios() {
        return listarUsuarios.obterUsuarios().stream().map(u -> new UsuarioDto(u.getCpf(), u.getNome(), u.getNascimento(), u.getEmail()))
        .collect(Collectors.toList());
    }
}
