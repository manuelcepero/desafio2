/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.desafio1.service;

import com.example.desafio1.entities.Cliente;
import java.util.List;

/**
 *
 * @author Manuel
 */
public interface ClienteServiceI {
    public void insertar(Cliente cliente);
    
    public List<Cliente> consultarTodos();
    
    public Cliente consultarById(Long idCliente);
    
    public void eliminar(Cliente cliente);
    
    public void actualizar(Cliente cliente);
    
    public List<Cliente> buscarPorNombre(Cliente cliente);
}
