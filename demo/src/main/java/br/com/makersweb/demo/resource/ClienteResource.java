package br.com.makersweb.demo.resource;

import br.com.makersweb.demo.model.Cliente;
import br.com.makersweb.demo.model.dto.ClienteDTO;
import br.com.makersweb.demo.model.dto.ClienteEditarDTO;
import br.com.makersweb.demo.service.IClienteService;
import br.com.makersweb.demo.util.DTO;
import br.com.makersweb.demo.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author aaristides
 */
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteResource {

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public Page<Cliente> pesquisar(@DTO(ClienteDTO.class) Cliente cliente, Pageable pageable) {
        return clienteService.filtrar(cliente, pageable);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long codigo) {
        Cliente cliente = clienteService.buscar(codigo);

        return !ObjectUtils.isEmpty(cliente) ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> salvar(@DTO(ClienteDTO.class) @Valid Cliente cliente) {
        Cliente clienteSave = clienteService.salvar(cliente);
        ClienteEditarDTO clienteDTO = ObjectMapperUtils.map(clienteSave, ClienteEditarDTO.class);

        return ResponseEntity.ok(clienteDTO);
    }

    @PatchMapping("/{codigo}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
        clienteService.atualizaPropriedadeAtivo(codigo, ativo);
    }

}
