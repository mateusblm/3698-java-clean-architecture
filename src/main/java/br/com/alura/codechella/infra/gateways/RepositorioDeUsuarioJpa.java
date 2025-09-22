package br.com.alura.codechella.infra.gateways;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario{
    
    private final UsuarioRepository usuarioRepository;

    private final UsuarioEntityMapper mapper;
    
    public RepositorioDeUsuarioJpa(UsuarioRepository usuarioRepository, UsuarioEntityMapper mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = mapper.toEntity(usuario);
        usuarioRepository.save(usuarioEntity);
        return mapper.fromEntity(usuarioEntity);
    }

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll().stream().map(mapper::fromEntity).collect(Collectors.toList());
    }
}
