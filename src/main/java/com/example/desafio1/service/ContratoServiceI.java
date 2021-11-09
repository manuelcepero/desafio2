/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.desafio1.service;

import com.example.desafio1.entities.Contrato;
import java.util.List;

/**
 *
 * @author Manuel
 */
public interface ContratoServiceI {
    public void insertar(Contrato contrato);
    
    public List<Contrato> consultarTodos();
    
    public Contrato consultarById(Long idContrato);
    
    public void eliminar(Contrato contrato);
    
    public void actualizar(Contrato contrato);
    
    public List<Contrato> buscarPorCliente(Long idCliente);
}
