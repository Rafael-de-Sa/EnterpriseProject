/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package edu.br.ifpr;

import edu.br.ifpr.model.entity.Departments;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;

/**
 *
 * @author rafael
 */
public class EnterpriseProject {

    public static void main(String[] args) {

        Departments departament = new Departments();
        departament.setName("TI");
        departament.setBudget(BigDecimal.valueOf(20552.70));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("enterprise_project_db");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(departament);
        em.getTransaction().commit();
        emf.close();

    }
}
