/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.seeder;

import edu.br.ifpr.model.entity.Departments;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;

/**
 *
 * @author rafael
 */
public class DepartmentsSeeder {

    public static void seed() {
        Departments department1 = new Departments();
        department1.setName("Tecnologia da Informação e Comunicação");
        department1.setBudget(BigDecimal.valueOf(20552.70));

        Departments department2 = new Departments();
        department2.setName("Departamento Pessoal");
        department2.setBudget(BigDecimal.valueOf(142328.43));

        Departments department3 = new Departments();
        department3.setName("Financeiro");
        department3.setBudget(BigDecimal.valueOf(127854.70));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("enterprise_project_db");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(department1);
        em.persist(department2);
        em.persist(department3);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
