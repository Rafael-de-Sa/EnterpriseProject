/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.seeder;

import edu.br.ifpr.model.entity.Badges;
import edu.br.ifpr.model.entity.Departments;
import edu.br.ifpr.model.entity.Employees;
import edu.br.ifpr.model.entity.Projects;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author rafael
 */
public class FullDatabaseSeeder {

    public static void seed() {
        Departments department1 = new Departments();
        department1.setName("Tecnologia da Informação e Comunicação");
        department1.setBudget(BigDecimal.valueOf(20552.70));

        Departments department2 = new Departments();
        department2.setName("Recursos Humanos");
        department2.setBudget(BigDecimal.valueOf(14228.43));

        Projects project1 = new Projects();
        project1.setName("Implantação Telemetria");
        project1.setStartDate(LocalDate.of(2025, 06, 10));
        project1.setDepartment(department1);
        department1.addProject(project1);

        Projects project2 = new Projects();
        project2.setName("Força tarefa para contratação de novos colaboradores");
        project2.setStartDate(LocalDate.of(2025, 05, 25));
        project2.setEndDate(LocalDate.of(2025, 06, 03));
        project2.setDepartment(department2);
        department2.addProject(project2);

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

        project1.addEmployee(employee1);
        project2.addEmployee(employee2);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("enterprise_project_db");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(employee1);
        em.persist(employee2);
        em.persist(project1);
        em.persist(project2);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
