/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.desafio1.service;

import com.example.desafio1.entities.Cliente;
import com.example.desafio1.entities.ClienteDaoI;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manuel
 */
@Service
public class ClienteServiceImpl implements ClienteServiceI{
    
    @Autowired
    private ClienteDaoI clienteDao;

    @Override
    @Transactional
    public void insertar(Cliente cliente) {
        clienteDao.insertar(cliente);
    }

    @Override
    @Transactional
    public List<Cliente> consultarTodos() {
        return clienteDao.consultarTodos();
    }

    @Override
    @Transactional
    public Cliente consultarById(Long idCliente) {
        return clienteDao.consultarById(idCliente);
    }

    @Override
    @Transactional
    public void eliminar(Cliente cliente) {
        clienteDao.eliminar(cliente);
    }

    @Override
    @Transactional
    public void actualizar(Cliente cliente) {
        clienteDao.actualizar(cliente);
    }

    @Override
    @Transactional
    public List<Cliente> buscarPorNombre(Cliente cliente) {
        return clienteDao.buscarPorNombre(cliente);
    }
    
}
