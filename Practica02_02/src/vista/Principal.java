/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
import modelo.Curso;
import modelo.Docente;
import modelo.Materia;

/**
 *
 * @author Administrador
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<Curso> cursoList = new ArrayList();
        List<Docente> docenteList = new ArrayList();
        List<Materia> materiaList = new ArrayList();
        
        //docenteList.add(new Docente("juan","hkljh","jjjj",01023934123,"mmmm"));
        GestionDato gd = new GestionDato(docenteList, materiaList, cursoList);
        List<Docente> hola = gd.getDocenteList();
        
        VentanaPrincipal v = new VentanaPrincipal("Menu Principal",gd);
        v.setVisible(true);
        
        
        
        
        
    }
    
}
