/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.anotaciones;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ColsutecR
 */
@Entity 
@Table(name = "materia")
public class Materia implements Serializable {
     @Id
    @Column(name = "IDMATERIA",length = 45,nullable = false)
    private String idMateria;
    
    
    @Column(name = "NOMBREMATERIA",length = 200,nullable = false)
    private String nombre;
    
    @Column (name = "DESCRIPCION",length = 200,nullable = false)
    private String descripcion;

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    
}
