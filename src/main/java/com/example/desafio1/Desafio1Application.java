package com.example.desafio1;

import com.example.desafio1.entities.Cliente;
import com.example.desafio1.entities.ClienteDaoI;
import com.example.desafio1.service.ClienteServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {

    @Autowired
    private ClienteServiceI clienteService;

    public static void main(String[] args) {
        SpringApplication.run(Desafio1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Cliente c1 = new Cliente();
        c1.setNombre("Manuel");
        c1.setPrimer_apellido("Cepero");
        c1.setSegundo_apellido("Sánchez");
        c1.setDni("11111111A");
        
        Cliente c2 = new Cliente();
        c2.setNombre("Paco");
        c2.setPrimer_apellido("Gómez");
        c2.setSegundo_apellido("López");
        c2.setDni("2222222B");
        
        clienteService.insertar(c1);
        clienteService.insertar(c2);
        
        c1.setDni("12345678C");
        clienteService.actualizar(c1);
        
        clienteService.consultarById(c2.getId());
        
        clienteService.consultarTodos();
        
        clienteService.buscarPorNombre(c1);
    }

}
