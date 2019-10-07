package com.example.demo3.controller;

import com.example.demo3.model.data.ClienteDAO;
import com.example.demo3.model.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Optional;

@Controller
@SessionAttributes(value = "cliente")
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

    @GetMapping(value = "/formulario/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Optional<Cliente> cliente = null;
        if(id>0){
            cliente = clienteDAO.findById(id);
        }
        else {
            return "redirect:/listar";
        }
        String titulo = "Editar Cliente";
        model.addAttribute("titulo",titulo);
        model.addAttribute("cliente",cliente);
        return "formulario";
    }

    @PostMapping(value = "/formulario")
    public String guardarFormulario(Cliente cliente, SessionStatus sessionStatus){
        clienteDAO.save(cliente);
        sessionStatus.setComplete();
        return "redirect:listar";
    }

    @GetMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        if(id>0){
            clienteDAO.deleteById(id);
        }
        return "redirect:/listar";
    }


}
