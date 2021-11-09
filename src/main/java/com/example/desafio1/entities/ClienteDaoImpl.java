/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.desafio1.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manuel
 */
@Repository
public class ClienteDaoImpl implements ClienteDaoI {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void insertar(Cliente cliente) {
        Session session = entityManager.unwrap(Session.class);

        session.save(cliente);

        session.close();
    }

    @Override
    public List<Cliente> consultarTodos() {
        Session session = entityManager.unwrap(Session.class);

        ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) session.createQuery("FROM Cliente").list();
        
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println("Nombre: " + listaClientes.get(i).getNombre() + " Apellidos: " + listaClientes.get(i).getPrimer_apellido() + " " + listaClientes.get(i).getSegundo_apellido());
        }

        session.close();

        return listaClientes;
    }

    @Override
    public Cliente consultarById(Long idCliente) {
        Session session = entityManager.unwrap(Session.class);

        Cliente cliente = (Cliente) session.createQuery("FROM Cliente WHERE id=" + idCliente).uniqueResult();

        System.out.println("Nombre: " + cliente.getNombre() + " Apellidos: " + cliente.getPrimer_apellido() + " " + cliente.getSegundo_apellido());
        
        session.close();

        return cliente;
    }

    @Override
    public void eliminar(Cliente cliente) {
        Session session = entityManager.unwrap(Session.class);

        entityManager.remove(entityManager.merge(cliente));

        session.close();
    }

    @Override
    public void actualizar(Cliente cliente) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(cliente);

        session.close();
    }

    @Override
    public List<Cliente> buscarPorNombre(Cliente cliente) {
        Session session = entityManager.unwrap(Session.class);

        ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) session.createQuery("FROM Cliente WHERE nombre='" + cliente.getNombre()+"' AND primer_apellido='" + cliente.getPrimer_apellido()+"' AND segundo_apellido='" + cliente.getSegundo_apellido()+"'").list();

        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println("Nombre: " + listaClientes.get(i).getNombre() + " Apellidos: " + listaClientes.get(i).getPrimer_apellido() + " " + listaClientes.get(i).getSegundo_apellido());
        }
        
        session.close();

        return listaClientes;
    }

}
