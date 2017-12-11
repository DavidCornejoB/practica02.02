/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.VentanaCrearDirectorio;
import vista.VentanaCurso;
import vista.VentanaDocente;
import vista.VentanaMateria;
import vista.VentanaPrincipal;

/**
 *
 * @author Administrador
 */
public class EventoVentanaPrincipal implements ActionListener {

    private VentanaPrincipal vPrincipal;

    public EventoVentanaPrincipal(VentanaPrincipal vPrincipal) {
        this.vPrincipal = vPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(2))) {
            this.vPrincipal.setvCurso(new VentanaCurso("Nuevo Curso", true, true, true, true, this.vPrincipal.getGd()));
            this.vPrincipal.getEscritorio().add(this.vPrincipal.getvCurso());
        }
        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(0))) {
            this.vPrincipal.setvDocente(new VentanaDocente("Nuevo Docente", true, true, true, true, this.vPrincipal.getGd()));
            this.vPrincipal.getEscritorio().add(this.vPrincipal.getvDocente());
        }
        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(1))) {
            this.vPrincipal.setvMateria(new VentanaMateria("Nueva Materia", true, true, true, true, this.vPrincipal.getGd()));
            this.vPrincipal.getEscritorio().add(this.vPrincipal.getvMateria());
        }
        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(3))) {
            JOptionPane.showMessageDialog(vPrincipal, "Espacio para crear el directorio en donde se creará el archivo", "Info", JOptionPane.INFORMATION_MESSAGE);
            this.vPrincipal.setvCrearDirectorio(new VentanaCrearDirectorio("CrearDirectorio", true, true, true, true));
            this.vPrincipal.getEscritorio().add(this.vPrincipal.getvCrearDirectorio());
        }


    }

}
