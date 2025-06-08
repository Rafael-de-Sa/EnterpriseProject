/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.seeder;

import edu.br.ifpr.model.entity.Employees;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

/**
 *
 * @author rafael
 */
public class EmployeesSeeder {

    public static void seed() {
        Employees employee1 = new Employees();
        employee1.setName("Rafael de Sá");
        employee1.setPosition("Analista de TI");
        employee1.setAdmissionDate(LocalDate.of(2022, 7, 17));

        Employees employee2 = new Employees();
        employee2.setName("Vanessa");
        employee2.setPosition("Analista de RH");
        employee2.setAdmissionDate(LocalDate.of(2023, 8, 12));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("enterprise_project_db");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(employee1);
        em.persist(employee2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
