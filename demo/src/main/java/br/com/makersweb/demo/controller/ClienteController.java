package br.com.makersweb.demo.controller;

import br.com.makersweb.demo.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author aaristides
 */
@Controller
@RequestMapping(value = { "/", "/clientes" })
public class ClienteController {

    private static final String GO_CLIENTE = "Cliente";
    private static final String GO_CLIENTE_NOVO = "cliente/NovoCliente";

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public ModelAndView cliente() {
        ModelAndView mav = new ModelAndView(GO_CLIENTE);
        mav.addObject("clientes", clienteService.listar());

        return mav;
    }

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mav = new ModelAndView(GO_CLIENTE_NOVO);

        return mav;
    }
}
