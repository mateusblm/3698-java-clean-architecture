package br.com.alura.codechella.domain.entities.usuario;

import java.time.LocalDate;

import br.com.alura.codechella.domain.Endereco;

public class BuilderUsuario {

    private Usuario usuario;

    public Usuario comNomeCpfNascimentoEmail(String nome, String cpf, LocalDate nascimento, String email) {
        this.usuario = new Usuario(cpf,nome,nascimento, email);
        return this.usuario;
    }
    
    public Usuario incluiEndereco(String cep, Integer numero, String complemento) {
        this.usuario.setEndereco(new Endereco(cep, complemento, numero));
        return this.usuario;
    }
}
