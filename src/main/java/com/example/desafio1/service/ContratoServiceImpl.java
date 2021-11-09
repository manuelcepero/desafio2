/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.desafio1.service;

import com.example.desafio1.entities.Cliente;
import com.example.desafio1.entities.Contrato;
import com.example.desafio1.entities.ContratoDaoI;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manuel
 */
@Service
public class ContratoServiceImpl implements ContratoServiceI{
    
    @Autowired
    private ContratoDaoI contratoDao;

    @Override
    @Transactional
    public void insertar(Contrato contrato) {
        contratoDao.insertar(contrato);
    }

    @Override
    @Transactional
    public List<Contrato> consultarTodos() {
        return contratoDao.consultarTodos();
    }

    @Override
    @Transactional
    public Contrato consultarById(Long idContrato) {
        return contratoDao.consultarById(idContrato);
    }

    @Override
    @Transactional
    public void eliminar(Contrato contrato) {
        contratoDao.eliminar(contrato);
    }

    @Override
    @Transactional
    public void actualizar(Contrato contrato) {
        contratoDao.actualizar(contrato);
    }

    @Override
    @Transactional
    public List<Contrato> buscarPorCliente(Long idCliente) {
        return contratoDao.buscarPorCliente(idCliente);
    }

    
}
