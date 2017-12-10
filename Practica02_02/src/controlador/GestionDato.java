/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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

/**
 *
 * @author Administrador
 */
public class GestionDato {

    private List<Docente> docenteList;
    private List<Materia> materiaList;
    private List<Curso> cursoList;
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
        
        try {

            FileWriter aE = new FileWriter("C:/raiz/archivo.txt", true);
            BufferedWriter escritura = new BufferedWriter(aE);
            for (Docente d : this.docenteList) { 
                escritura.append(d.getNombre()+" | "+ d.getApellido()+" | "+d.getCedula()+" | "+d.getFechaNac()+" | "+d.getTitulo());
                escritura.newLine();
                
            }
            
            escritura.close();
            return true;
        } catch (IOException e1) {
            System.out.println("El Archivo NO Existe");
            return false;
        }
    }

    public List<Docente> leerDocente() {
        try {
            FileReader fr = new FileReader("C:/raiz/archivo.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();

            while (linea != null) {
                partes = linea.split(" | ");
                String parte1 = partes[0];
                String parte3 = partes[2];
                String parte4 = partes[3];
                String parte6 = partes[5];

                System.out.println(parte1);

            }
            br.close();

        } catch (IOException ae) {
        }
        return this.docenteList;
    }

}
