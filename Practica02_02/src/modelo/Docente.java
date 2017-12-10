/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Administrador
 */
public class Docente extends Persona {
    
     private String titulo;

    public Docente(String titulo, String nombre, String apellido, int cedula, String fechaNac) {
        super(nombre, apellido, cedula, fechaNac);
        this.titulo = titulo;
    }

    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Docente{" + "titulo = " + titulo + '}';
    }
     
     
}