/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplo1.sinrelaciones.unoauno;

import edu.co.sena.anotaciones.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 *
 * @author ColsutecR
 */
@Entity
@Table(name = "estudiante1", indexes = {
    @Index(name = "pruebaIndice", columnList = "NOMBREESTUDIANTE,IDESTUDIANTE")})

public class Estudiante1 implements Serializable {

    @Id
    @Column(name = "IDESTUDIANTE",length = 45,nullable = false)
    private String idEstudiante;

    @Column(name = "NOMBREESTUDIANTE",length = 200,nullable = false)
    private String nombre;

   
    @Column(name = "CORREO",length = 200,nullable = false)
    private String correo;
    
    @Column(name = "DIRECCION",length = 100,nullable = false)
    private String direccion;
    
    @Column(name = "TELEFONO",length = 45,nullable = false)
    private String telefono;
    @Column(name = "IDMATERIA",length = 45,nullable = false)
    private String idMateria;
    

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

}
