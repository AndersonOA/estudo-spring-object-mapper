package br.com.makersweb.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author aaristides
 */
public class ClienteDTO {

    @NotNull
    private String nome;

    @NotNull
    @Email
    private String email;

    private EnderecoDTO endereco;

    @JsonIgnore
    private final LocalDateTime criado = LocalDateTime.now();

    @JsonIgnore
    private final LocalDateTime editado = LocalDateTime.now();

    @NotNull
    private Boolean ativo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getCriado() {
        return criado;
    }

    public LocalDateTime getEditado() {
        return editado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
