/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;
import vista.VentanaCrearDirectorio;

public class EventoVentanaCrearDirectorio implements ActionListener {

    VentanaCrearDirectorio ventana;

    public EventoVentanaCrearDirectorio(VentanaCrearDirectorio ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.ventana.getButtonList().get(0))) {
            String unidad = nombreUnidad();//Nombre de la unidad
            String nombreDir = this.ventana.getTxtList().get(0).getText();
            File directorio = new File(unidad + ":/" + nombreDir);
            if (!directorio.exists()) {
                directorio.mkdir();
                JOptionPane.showMessageDialog(this.ventana,"Directorio creado", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.ventana, "Ya existe este directorio", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource().equals(this.ventana.getButtonList().get(1))){
            this.ventana.cargaCombo();
        }
    }

    public String nombreUnidad() {
        String unidad = "";
        String combo = this.ventana.getComboBox().getSelectedItem().toString();
        for (int i = 0; i < combo.length(); i++) {
            if (combo.charAt(i) == '(') {
                unidad = String.valueOf(combo.charAt(i + 1));
            }
        }
        return unidad;
    }

}
