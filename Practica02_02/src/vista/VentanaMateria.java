/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaMateria;
import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Docente;
import modelo.Materia;

/**
 *
 * @author Administrador
 */
public class VentanaMateria extends JInternalFrame {

    private JPanel panel;
    private List<JLabel> lblList;
    private List<JTextField> txtList;
    private JButton bGuardar, bGenerar;
    private DefaultTableModel modeloTabla;
    private JScrollPane scroll;
    private JTable tabla;
    private Object[] encabezado;
    private Object[][] datos;
    private GestionDato gd;
    private JComboBox comboBox;

    public VentanaMateria(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable, GestionDato gd) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(440, 0, 350, 300);
        this.gd = gd;
        this.setVisible(true);
        this.iniciaComponentes();
    }

    public void iniciaComponentes() {
        this.panel = new JPanel(new BorderLayout(3, 2));
        JPanel pBotones = new JPanel(new BorderLayout());
        JPanel panelCampos = new JPanel(new GridLayout(2, 2));

        this.lblList = new ArrayList();
        this.lblList.add(new JLabel("Nombre:"));
        this.lblList.add(new JLabel("Docente:"));

        this.txtList = new ArrayList();
        this.txtList.add(new JTextField(15));

        this.bGuardar = new JButton("Guardar");
        this.bGenerar = new JButton("Generar Archivo");
        this.bGenerar.setBackground(Color.cyan);
        
        this.comboBox = new JComboBox(this.CargaCombo());

        this.bGuardar.addActionListener(new EventoVentanaMateria(this));
        this.bGenerar.addActionListener(new EventoVentanaMateria(this));
        this.encabezado = new Object[3];
        this.encabezado[0] = "N°";
        this.encabezado[1] = "Materia";
        this.encabezado[2] = "Docente";

        this.datos = this.cargaMateria(this.gd.getMateriaList().size(),3);

        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);

        panelCampos.add(this.lblList.get(0));
        panelCampos.add(this.txtList.get(0));
        panelCampos.add(this.lblList.get(1));
        panelCampos.add(this.comboBox);
        
        this.panel.add(panelCampos, BorderLayout.NORTH);
        this.panel.add(pBotones, BorderLayout.SOUTH);
        pBotones.add(this.bGuardar, BorderLayout.WEST);
        pBotones.add(this.bGenerar, BorderLayout.EAST);
        this.panel.add(this.scroll);
        this.add(this.panel);
    }   

    public Object[][] cargaMateria(int f, int c) {
        Object[][] retorno = new Object[f][c];
        int i = 0;
        for (Materia m : this.gd.getMateriaList()) {
            
            retorno[i][0] = i+1;
            retorno[i][1] = m.getNombre();
            retorno[i][2] = m.getDocente().getNombre()+" "+m.getDocente().getApellido();
            
            i++;
        }
        return retorno;
    }

    private Object[] CargaCombo() {
        String[] retorno = new String[this.gd.getDocenteList().size()];
        int i = 0;
        for (Docente d : this.gd.getDocenteList()) {
            retorno[i] = d.getNombre()+" "+d.getApellido();
            
            i++;
        }
        return retorno;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public List<JLabel> getLblList() {
        return lblList;
    }

    public void setLblList(List<JLabel> lblList) {
        this.lblList = lblList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public JButton getbGuardar() {
        return bGuardar;
    }

    public void setbGuardar(JButton bGuardar) {
        this.bGuardar = bGuardar;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public GestionDato getGd() {
        return gd;
    }

    public void setGd(GestionDato gd) {
        this.gd = gd;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public JButton getbGenerar() {
        return bGenerar;
    }

    public void setbGenerar(JButton bGenerar) {
        this.bGenerar = bGenerar;
    }
}
