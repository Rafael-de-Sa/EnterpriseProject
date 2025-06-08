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
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rafael
 */
@Entity
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    @Basic
    private String name;

    @Column(length = 50, nullable = false)
    @Basic
    private String position;

    @Column(nullable = false, name = "admission_date")
    @Basic
    private LocalDate admissionDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Badges> badges;

    public void addBadge(Badges badge) {
        if (badges == null) {
            badges = new LinkedList<>();
        }
        badges.add(badge);
    }

    public List<Badges> getBadges() {
        return badges;
    }

    public void setBadges(List<Badges> badges) {
        this.badges = badges;
    }

    public Employees() {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

}
