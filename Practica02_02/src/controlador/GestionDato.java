/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.Docente;
import modelo.Materia;
import vista.VentanaPrincipal;

/**
 *
 * @author Administrador
 */
public class GestionDato {

    private List<Docente> docenteList;
    private List<Materia> materiaList;
    private List<Curso> cursoList;
    private VentanaPrincipal vPrincipal;
    private String[] partes;
    private String directorio;

    public GestionDato(List<Docente> docenteList, List<Materia> materiaList, List<Curso> cursoList) {
        this.docenteList = docenteList;
        this.materiaList = materiaList;
        this.cursoList = cursoList;
    }

    public boolean addDocente(Docente d) {
        return this.docenteList.add(d);
    }

    public boolean addMateria(Materia m) {
        return this.materiaList.add(m);
    }

    public boolean addCurso(Curso c) {
        return this.cursoList.add(c);
    }

    public List<Docente> getDocenteList() {
        return docenteList;
    }

    public void setDocenteList(List<Docente> docenteList) {
        this.docenteList = docenteList;
    }

    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
    }

    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    public Docente buscarDocente(String txt) {
        Docente retorno = null;
        int i = 0;
        for (Docente d : this.docenteList) {
            if (d.getNombre().equals(txt)) {
                i++;
                return d;
            }
        }
        return retorno;
    }

    public Materia buscarMateria(String txt) {
        Materia retorno = null;
        int i = 0;
        for (Materia m : this.materiaList) {
            if (m.getNombre().equals(txt)) {
                i++;
                return m;
            }
        }
        return retorno;
    }

    public boolean persistirArchivoDocente(List<Docente> lista) {

        String directorio = JOptionPane.showInputDialog(vPrincipal, "Ingresar el directorio donde se guardará el archivo DatosDocente");
        this.directorio = directorio;

        try {
            JOptionPane.showMessageDialog(this.vPrincipal, "Se ha generado un archivo DatosDocente en: " + directorio, "Directorio", JOptionPane.PLAIN_MESSAGE);
            FileWriter aE = new FileWriter(this.directorio + "/DatosDocente.txt", true);
            BufferedWriter escritura = new BufferedWriter(aE);
            for (Docente d : this.docenteList) {
                escritura.append(d.getNombre() + " | " + d.getApellido() + " | " + d.getCedula() + " | " + d.getFechaNac() + " | " + d.getTitulo());
                escritura.newLine();

            }

            escritura.close();
            return true;
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(this.vPrincipal, "El Directorio especificado NO Existe", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
