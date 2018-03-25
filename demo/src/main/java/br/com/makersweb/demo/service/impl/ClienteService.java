package br.com.makersweb.demo.service.impl;

import br.com.makersweb.demo.model.Cliente;
import br.com.makersweb.demo.repository.IClienteRepository;
import br.com.makersweb.demo.repository.specifications.ClienteSpecification;
import br.com.makersweb.demo.service.IClienteService;
import br.com.makersweb.demo.service.exception.ClienteInexistenteOuInativaException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

/**
 * @author aaristides
 */
@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscar(Long codigo) {
        return clienteRepository.getOne(codigo);
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente editar(Long codigo, Cliente cliente) {
        validaCliente(codigo);
        Cliente clienteSave = buscar(codigo);
        BeanUtils.copyProperties(cliente, clienteSave, "codigo");

        return clienteRepository.save(cliente);
    }

    @Override
    public Page<Cliente> filtrar(Cliente clienteFilter, Pageable pageable) {
        return clienteRepository.findAll(where(ClienteSpecification.filtroCliente(clienteFilter)), pageable);
    }

    @Override
    public void remover(Long codigo) {
        try {
            clienteRepository.deleteById(codigo);
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException(1);
        }
    }

    @Override
    public void atualizaPropriedadeAtivo(Long codigo, Boolean ativo) {
        Cliente cliente = buscar(codigo);
        cliente.setAtivo(ativo);
        clienteRepository.save(cliente);
    }

    private void validaCliente(Long codigo) {
        Cliente clienteSave = buscar(codigo);
        if (null == clienteSave || clienteSave.isInativo()) {
            throw new ClienteInexistenteOuInativaException();
        }
    }
}
