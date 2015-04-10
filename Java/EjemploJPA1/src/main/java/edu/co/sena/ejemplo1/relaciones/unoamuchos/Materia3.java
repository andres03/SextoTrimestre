/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplo1.relaciones.unoamuchos;

import edu.co.sena.ejemplo1.relaciones.unoauno.*;
import edu.co.sena.anotaciones.*;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ColsutecR
 */
@Entity
@Table(name = "MATERIA3")
public class Materia3 implements Serializable {

    @Id
    @Column(name = "IDMATERIA", length = 45, nullable = false)
    private String idMateria;

    @Column(name = "NOMBREMATERIA", length = 200, nullable = false)
    private String nombre;

    @Column(name = "DESCRIPCION", length = 200, nullable = false)
    private String descripcion;  
    
  
    @OneToMany(mappedBy = "materia")
    private Collection<Estudiante3> listaEstudiantes;
    
  

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

    public Collection<Estudiante3> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(Collection<Estudiante3> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public String toString() {
        return "Materia3{" + "idMateria=" + idMateria + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }

    
    

   

    

   
    

}
