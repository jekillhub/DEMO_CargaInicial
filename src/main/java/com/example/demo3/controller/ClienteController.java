package com.example.demo3.controller;

import com.example.demo3.model.data.ClienteDAO;
import com.example.demo3.model.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired
    private ClienteDAO clienteDAO;

    @GetMapping(value = "/listar")
    public String listar(Model model){
        String titulo = "Listado de Clientes";
        model.addAttribute("titulo",titulo);
        model.addAttribute("clientes",clienteDAO.findAll());
        return "listar";
    }

    @GetMapping(value = "/formulario")
    public String mostrarFormulario(Model model){
        Cliente cliente = new Cliente();
        String titulo = "Formulario";
        model.addAttribute("titulo",titulo);
        model.addAttribute("cliente",cliente);
        return "formulario";
    }

    @PostMapping(value = "/formulario")
    public String guardarFormulario(Cliente cliente){
        clienteDAO.save(cliente);
        return "redirect:listar";
    }


}
