package com.example.demo3;

import com.example.demo3.model.data.ClienteDAO;
import com.example.demo3.model.entity.Cliente;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Date;


@Configuration
public class CargaInicial {

    @Bean
    public CommandLineRunner cliente(ClienteDAO clienteDAO) {

        return (args -> {
            clienteDAO.save(new Cliente("Alex","Cuevas","alex.cuevas@mail.com",new Date()));
            clienteDAO.save(new Cliente("Carlos","Gutierrez","carlos.gutierrez@mail.com",new Date()));
            clienteDAO.save(new Cliente("Felipe","Perez","felipe.perez@mail.com",new Date()));
        });

    }
}
