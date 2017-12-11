/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Docente;
import vista.VentanaDocente;

/**
 *
 * @author Administrador
 */
public class EventoVentanaDocente implements ActionListener {

    private final VentanaDocente vDocente;

    public EventoVentanaDocente(VentanaDocente vDocente) {
        this.vDocente = vDocente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.vDocente.getbGuardar())) {

            try {
                String n = this.vDocente.getTxtList().get(0).getText();
                String a = this.vDocente.getTxtList().get(1).getText();
                String cedula = this.vDocente.getTxtList().get(2).getText();
                String fn = this.vDocente.getTxtList().get(3).getText();
                String titulo = this.vDocente.getTxtList().get(4).getText();

                if (n.isEmpty() && a.isEmpty() && cedula.isEmpty() && fn.isEmpty() && titulo.isEmpty()) {
                    JOptionPane.showInternalMessageDialog(vDocente, "Todos los parámetros están vacíos", "EmptyParameter", JOptionPane.NO_OPTION);
                } else if (n.isEmpty()) {
                    JOptionPane.showInternalMessageDialog(vDocente, "El parámetro Nombre está vacío", "EmptyParameter", JOptionPane.NO_OPTION);
                } else if (a.isEmpty()) {
                    JOptionPane.showInternalMessageDialog(vDocente, "El parámetro Apellido está vacío", "EmptyParameter", JOptionPane.NO_OPTION);
                } else if (cedula.isEmpty()) {
                    JOptionPane.showInternalMessageDialog(vDocente, "El parámetro Cedula está vacío", "EmptyParameter", JOptionPane.NO_OPTION);
                } else if (fn.isEmpty()) {
                    JOptionPane.showInternalMessageDialog(vDocente, "El parámetro Fecha Nacimiento está vacío", "EmptyParameter", JOptionPane.NO_OPTION);
                } else if (titulo.isEmpty()) {
                    JOptionPane.showInternalMessageDialog(vDocente, "El parámetro Titulo está vacío", "EmptyParameter", JOptionPane.NO_OPTION);
                } else {

                    if (cedula.length() != 10) {
                        JOptionPane.showInternalMessageDialog(vDocente, "La cedula debe tener 10 dígitos", "Error Cédula", JOptionPane.ERROR_MESSAGE);
                    } else {

                        int nCedula = Integer.parseInt(cedula);

                        int cont = 0;
                        boolean cent = true;
                        for (Docente d : this.vDocente.getGd().getDocenteList()) {
                            //DOS PERSONAS NO PUEDEN TENER LA MISMA CEDULA
                            if (cedula.equalsIgnoreCase(Integer.toString(this.vDocente.getGd().getDocenteList().get(cont).getCedula()))) {
                                JOptionPane.showInternalMessageDialog(vDocente, "Ya se encuentra esta persona(cedula: " + cedula + ") en nuestra base de datos", "Parámetro Repetido", JOptionPane.ERROR_MESSAGE);
                                cent = false;
                                break;
                            } else {
                                cent = true;
                           }
                            cont++;
                        }

                        if (cent == true) {

                            this.vDocente.getGd().addDocente(new Docente(titulo, n, a, nCedula, fn));
                            this.vDocente.getModeloTabla().setDataVector(cargaDocente(this.vDocente.getGd().getDocenteList().size(), 6), this.vDocente.getEncabezado());
                            
                        }
                    }
                }

            } catch (NumberFormatException error) {
                JOptionPane.showInternalMessageDialog(vDocente, "Ingresar sólo numeros en el parámetro Cédula", "NumberFormatException", JOptionPane.ERROR_MESSAGE);
            }
            this.vDocente.getTxtList().get(0).setText("");
            this.vDocente.getTxtList().get(1).setText("");
            this.vDocente.getTxtList().get(2).setText("");
            this.vDocente.getTxtList().get(3).setText("");
            this.vDocente.getTxtList().get(4).setText("");

        }
        
        if(e.getSource().equals(this.vDocente.getbGenerar())){
            JOptionPane.showMessageDialog(null, "Se debe escribir con la direccion del disco ejemplo: c:/Usuario");
            this.vDocente.getGd().persistirArchivoDocente(this.vDocente.getGd().getDocenteList());
            
        }
    }

    public Object[][] cargaDocente(int f, int c) {
        Object[][] retorno = new Object[f][c];
        int i = 0;
        for (Docente d : this.vDocente.getGd().getDocenteList()) {
            retorno[i][0] = i + 1;
            retorno[i][1] = d.getNombre();
            retorno[i][2] = d.getApellido();
            retorno[i][3] = d.getCedula();
            retorno[i][4] = d.getFechaNac();
            retorno[i][5] = d.getTitulo();
            i++;
        }
        return retorno;
    }

}
