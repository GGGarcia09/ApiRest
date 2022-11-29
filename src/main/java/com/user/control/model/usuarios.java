package com.user.control.model;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "foto", length = 35, nullable = false)
    private String foto;

    @Column(name = "nombre", length = 35, nullable = false)
    private String nombre;

    @Column(name = "email", length = 35, nullable = false, unique = true)
    private String email;

    @Column(name = "gender", length = 35, nullable = false)
    private String gender;

    @Column(name = "estatus", length = 35, nullable = false)
    private String estatus;

    public usuarios(){

    }

    public usuarios(Long id, String foto,  String nombre, String email, String gender, String estatus) {
        this.id = id;
        this.foto = foto;
        this.nombre = nombre;
        this.email = email;
        this.gender = gender;
        this.estatus = estatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}

