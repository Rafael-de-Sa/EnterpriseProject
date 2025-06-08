/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.seeder;

import edu.br.ifpr.model.entity.Departments;
import edu.br.ifpr.model.entity.Projects;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author rafael
 */
public class ProjectsSeeder {
    
    public static void seed() {
        Departments department1 = new Departments();
        department1.setName("Tecnologia da Informação e Comunicação");
        department1.setBudget(BigDecimal.valueOf(20552.70));
        
        Departments department2 = new Departments();
        department2.setName("Departamento Pessoal");
        department2.setBudget(BigDecimal.valueOf(142328.43));
        
        Projects project1 = new Projects();
        project1.setName("Implantação Telemetria");
        project1.setStartDate(LocalDate.of(2025, 06, 10));
        project1.setDepartment(department1);
        department1.addProject(project1);
        
        Projects project2 = new Projects();
        project2.setName("Cálculo Folha de Pagamento 06/2025");
        project2.setStartDate(LocalDate.of(2025, 05, 25));
        project2.setEndDate(LocalDate.of(2025, 06, 03));
        project2.setDepartment(department2);
        department2.addProject(project2);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("enterprise_project_db");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(project1);
        em.persist(project2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
