package br.com.alura.codechella.domain.entities.usuario;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UsuarioTest {
    
    @Test
    void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, 
        () -> new Usuario("123456789-99", "Mateues", LocalDate.parse("2020-08-04"), "email@gmail.com"));
    }

    @Test
    void naoDeveCadastrarUsuarioComEmailNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Usuario("123.456.789-99", "Mateues", LocalDate.parse("2020-08-04"), "emailgmail.com"));
    }

    @Test
    void deveCriarUsuarioUsandoFabricaDeUsuario() {
        BuilderUsuario fabricaDeUsuario = new BuilderUsuario();
        Usuario usuario = (fabricaDeUsuario.comNomeCpfNascimentoEmail("Mateus", "185.736.827-44", LocalDate.parse("2005-08-04"), "mateusblm@outlook.com"));

        Assertions.assertEquals("Mateus", usuario.getNome());

        usuario = fabricaDeUsuario.incluiEndereco("231123", 40, "apto 201");
        Assertions.assertEquals("231123", usuario.getEndereco().getCep());
    }
}
