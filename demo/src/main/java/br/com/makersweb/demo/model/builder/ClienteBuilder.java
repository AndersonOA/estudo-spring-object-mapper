package br.com.makersweb.demo.model.builder;

import br.com.makersweb.demo.model.dto.ClienteDTO;
import br.com.makersweb.demo.model.dto.EnderecoDTO;

/**
 * @author aaristides
 */
public class ClienteBuilder {

    private ClienteDTO clienteDTO;

    public ClienteBuilder() {
        this.clienteDTO = new ClienteDTO();
    }

    public ClienteBuilder comCliente(String nome, String email, boolean ativo) {
        this.clienteDTO.setNome(nome);
        this.clienteDTO.setEmail(email);
        this.clienteDTO.setAtivo(ativo);

        return this;
    }

    public ClienteBuilder comEndereco(String logradouro, String bairro, String numero, String cidade, String estado, String cep) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setLogradouro(logradouro);
        enderecoDTO.setBairro(bairro);
        enderecoDTO.setNumero(numero);
        enderecoDTO.setCidade(cidade);
        enderecoDTO.setEstado(estado);
        enderecoDTO.setCep(cep);
        this.clienteDTO.setEndereco(enderecoDTO);

        return this;
    }

    public ClienteDTO build() {
        return this.clienteDTO;
    }
}
