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
public class Curso {
     
    private String grupo;
    private int numAlumnos;
    private Materia materia;

    public Curso(String paralelo, int numAlumnos, Materia materia) {
        this.grupo = paralelo;
        this.numAlumnos = numAlumnos;
        this.materia = materia;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getParalelo() {
        return grupo;
    }

    public void setParalelo(String paralelo) {
        this.grupo = paralelo;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }

    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }

    @Override
    public String toString() {
        return "Curso{" + "paralelo=" + grupo + ", numAlumnos=" + numAlumnos + ", materia=" + materia + '}';
    }

    
    
    
}