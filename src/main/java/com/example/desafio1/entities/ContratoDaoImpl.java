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
public class ContratoDaoImpl implements ContratoDaoI {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void insertar(Contrato contrato) {
        Session session = entityManager.unwrap(Session.class);

        session.save(contrato);

        session.close();
    }

    @Override
    public List<Contrato> consultarTodos() {
        Session session = entityManager.unwrap(Session.class);

        ArrayList<Contrato> listaContratos = (ArrayList<Contrato>) session.createQuery("FROM Contrato").list();

        for (int i = 0; i < listaContratos.size(); i++) {
            System.out.println("ID: " + listaContratos.get(i).getId() + " Fecha vigencia: " + listaContratos.get(i).getFecha_vigencia() + " Fecha caducidad: " + listaContratos.get(i).getFecha_vigencia() + " Precio: " + listaContratos.get(i).getPrecio());
        }

        session.close();

        return listaContratos;
    }

    @Override
    public Contrato consultarById(Long idContrato) {
        Session session = entityManager.unwrap(Session.class);

        Contrato contrato = (Contrato) session.createQuery("FROM Contrato WHERE id=" + idContrato).uniqueResult();

        System.out.println("ID: " + contrato.getId() + " Fecha vigencia: " + contrato.getFecha_vigencia() + " Fecha caducidad: " + contrato.getFecha_vigencia() + " Precio: " + contrato.getPrecio());

        session.close();

        return contrato;
    }

    @Override
    public void eliminar(Contrato contrato) {
        Session session = entityManager.unwrap(Session.class);

        entityManager.remove(entityManager.merge(contrato));

        session.close();
    }

    @Override
    public void actualizar(Contrato contrato) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(contrato);

        session.close();
    }

    @Override
    public List<Contrato> buscarPorCliente(Long idCliente) {
        Session session = entityManager.unwrap(Session.class);

        ArrayList<Contrato> listaContratos = (ArrayList<Contrato>) session.createQuery("FROM Contrato WHERE id_cliente="+idCliente).list();

        for (int i = 0; i < listaContratos.size(); i++) {
            System.out.println("ID: " + listaContratos.get(i).getId() + " Fecha vigencia: " + listaContratos.get(i).getFecha_vigencia() + " Fecha caducidad: " + listaContratos.get(i).getFecha_vigencia() + " Precio: " + listaContratos.get(i).getPrecio());
        }

        session.close();

        return listaContratos;
    }

}
