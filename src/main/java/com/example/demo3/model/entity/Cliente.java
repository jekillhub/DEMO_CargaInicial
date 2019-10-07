package com.example.demo3.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long id;

    @Column(name = "cliente_nombre")
    private String nombre;

    @Column(name = "cliente_apellido")
    private String apellido;

    @Column(name = "cliente_email")
    private String email;

    @Column(name = "cliente_creacion")
    private Date creadoEn;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String email, Date creadoEn) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.creadoEn = creadoEn;
    }

    public void conversionStringDate(String fechaTexto){
        SimpleDateFormat formato=new SimpleDateFormat("dd-MMM-yyyy");
        try {
            this.creadoEn = formato.parse(fechaTexto);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DateTimeFormat(pattern="dd-MMM-YYYY")
    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }
}
