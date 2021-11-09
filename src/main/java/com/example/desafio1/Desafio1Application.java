package com.example.desafio1;

import com.example.desafio1.entities.Cliente;
import com.example.desafio1.entities.ClienteDaoI;
import com.example.desafio1.entities.Contrato;
import com.example.desafio1.service.ClienteServiceI;
import com.example.desafio1.service.ContratoServiceI;
import com.example.desafio1.service.ContratoServiceImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {

    @Autowired
    private ClienteServiceI clienteService;
    
    @Autowired
    private ContratoServiceI contratoService;

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
        
        clienteService.eliminar(c2);
        
        Contrato contrato1 = new Contrato();
        contrato1.setPrecio(1000);
        
        contrato1.setFecha_caducidad(new Date(2020, 12, 31));
        contrato1.setFecha_vigencia(new Date(2019, 01, 01));
        contrato1.setCliente(c1);
        
        contratoService.insertar(contrato1);
        
        contrato1.setPrecio(2000);
        contratoService.actualizar(contrato1);
        
        contratoService.consultarTodos();
        contratoService.buscarPorCliente(c1.getId());
        
    }

}
