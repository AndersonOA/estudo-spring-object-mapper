package br.com.makersweb.demo.model;

import br.com.makersweb.demo.model.dto.ClienteDTO;
import br.com.makersweb.demo.model.dto.ClienteEditarDTO;
import br.com.makersweb.demo.model.dto.EnderecoDTO;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class ClienteUnitTest {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void verificaMapeamentoCliente() {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setLogradouro("Rua Eduardo Carlos Pereira");
        enderecoDTO.setBairro("Portão");
        enderecoDTO.setNumero("4125");
        enderecoDTO.setCep("81020235");
        enderecoDTO.setComplemento("Apto 22 BL 11A");
        enderecoDTO.setCidade("Curitiba");
        enderecoDTO.setEstado("PR");

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome("Anderson");
        clienteDTO.setEmail("anderson@makersweb.com.br");
        clienteDTO.setEndereco(enderecoDTO);

        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        assertEquals(clienteDTO.getNome(), cliente.getNome());
        assertEquals(clienteDTO.getEmail(), cliente.getEmail());
        assertEquals(clienteDTO.getCriado(), cliente.getCriado());
        assertEquals(clienteDTO.getEditado(), cliente.getEditado());
        assertEquals(clienteDTO.getEndereco().getLogradouro(), cliente.getEndereco().getLogradouro());

        ClienteEditarDTO clienteEditarDTO = new ClienteEditarDTO();
        clienteEditarDTO.setNome("João da Silva");
        clienteEditarDTO.setEmail("joao@teste.com");

        modelMapper.map(clienteEditarDTO, cliente);
        assertEquals(clienteEditarDTO.getNome(), cliente.getNome());
        assertEquals(clienteEditarDTO.getEmail(), cliente.getEmail());
        assertEquals(clienteDTO.getCriado(), cliente.getCriado());
        assertEquals(clienteEditarDTO.getEditado(), cliente.getEditado());
    }
}
