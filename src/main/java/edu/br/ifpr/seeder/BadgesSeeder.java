/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.seeder;

import edu.br.ifpr.model.entity.Badges;
import edu.br.ifpr.model.entity.Employees;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

/**
 *
 * @author rafael
 */
public class BadgesSeeder {

    public static void seed() {
        Employees employee1 = new Employees();
        employee1.setName("Rafael de Sá");
        employee1.setPosition("Analista de TI");
        employee1.setAdmissionDate(LocalDate.of(2022, 7, 17));

        Employees employee2 = new Employees();
        employee2.setName("Vanessa");
        employee2.setPosition("Analista de RH");
        employee2.setAdmissionDate(LocalDate.of(2023, 8, 12));

        Badges badge1 = new Badges();
        badge1.setCode("2023TI001");
        badge1.setIssueDate(LocalDate.of(2023, 4, 12));
        badge1.setEmployee(employee1);
        employee1.addBadge(badge1);

        Badges badge2 = new Badges();
        badge2.setCode("2024TI001");
        badge2.setIssueDate(LocalDate.of(2024, 7, 23));
        badge2.setEmployee(employee1);
        employee1.addBadge(badge2);

        Badges badge3 = new Badges();
        badge3.setCode("2023RH001");
        badge3.setIssueDate(LocalDate.of(2023, 9, 02));
        badge3.setEmployee(employee2);
        employee2.addBadge(badge3);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("enterprise_project_db");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(badge1);
        em.persist(badge2);
        em.persist(badge3);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
