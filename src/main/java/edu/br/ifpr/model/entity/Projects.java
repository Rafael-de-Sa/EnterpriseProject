/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.model.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rafael
 */
@Entity
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    @Basic
    private String name;

    @Column(name = "start_date", nullable = false)
    @Basic
    private LocalDate startDate;

    @Column(name = "end_date", nullable = true)
    @Basic
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", nullable = false)
    private Departments department;

    @ManyToMany(mappedBy = "projects")
    private List<Employees> employees;

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employees employee) {
        if (employees == null) {
            employees = new LinkedList<>();
        }
        employees.add(employee);

        if (employee.getProjects() == null) {
            employee.setProjects(new LinkedList<>());
        }
        if (!employee.getProjects().contains(this)) {
            employee.getProjects().add(this);
        }

    }

    public Projects() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

}
