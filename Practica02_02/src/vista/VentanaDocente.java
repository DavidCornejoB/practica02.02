/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.GestionDato;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class VentanaDocente extends JInternalFrame{

    private JPanel panel;
    private List<JLabel> lblList;
    private List<JTextField> txtList;
    private JButton bGuardar;
    private DefaultTableModel modeloTable;
    private JScrollPane scroll;
    private JTable tablaCuidad;
    private Object[] encabezado;
    private Object[][] datos;
    private GestionDato gd;

    public VentanaDocente(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable, GestionDato gd) {
         super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(440, 0, 350, 300);
        this.gd = gd;
        this.setVisible(true);
        this.iniciaComponentes();
    }

    public void iniciaComponentes() {

    }
}
