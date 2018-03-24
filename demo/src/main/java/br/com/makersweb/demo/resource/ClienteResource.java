package br.com.makersweb.demo.resource;

import br.com.makersweb.demo.model.Cliente;
import br.com.makersweb.demo.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author aaristides
 */
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteResource {

    @Autowired
    private IClienteService clienteService;


    @GetMapping
    public Page<Cliente> pesquisar(Cliente cliente, Pageable pageable) {
        return clienteService.filtrar(cliente, pageable);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long codigo) {
        Cliente cliente = clienteService.buscar(codigo);

        return !ObjectUtils.isEmpty(cliente) ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{codigo}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
        clienteService.atualizaPropriedadeAtivo(codigo, ativo);
    }

}
