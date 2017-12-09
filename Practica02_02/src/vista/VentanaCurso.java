/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.EventoVentanaCurso;
import controlador.EventoVentanaMateria;
import controlador.GestionDato;
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
import modelo.Curso;
import modelo.Materia;

/**
 *
 * @author Administrador
 */
public class VentanaCurso extends JInternalFrame {

    private JPanel panel;
    private List<JLabel> lblList;
    private List<JTextField> txtList;
    private JButton bGuardar;
    private DefaultTableModel modeloTabla;
    private JScrollPane scroll;
    private JTable tabla;
    private JComboBox comboBox;
    private Object[] encabezado;
    private Object[][] datos;
    private GestionDato gd;

    public VentanaCurso(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable, GestionDato gd) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(440, 0, 350, 300);
        this.gd = gd;
        this.setVisible(true);
        this.iniciaComponentes();
    }

    public void iniciaComponentes() {
         this.panel = new JPanel(new GridLayout(3,2 ));
        JPanel panelCampos = new JPanel(new GridLayout(4, 2));

        this.lblList = new ArrayList();
        this.lblList.add(new JLabel("Paralelo :"));
        this.lblList.add(new JLabel("Numero Alumnos:"));
        this.lblList.add(new JLabel("Materia:"));

        this.txtList = new ArrayList();
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));

        this.bGuardar = new JButton("Guardar");
        
        this.comboBox = new JComboBox(this.CargaCombo());

        this.bGuardar.addActionListener(new EventoVentanaCurso(this));
        this.encabezado = new Object[3];
        this.encabezado[0] = "Paralelo";
        this.encabezado[1] = "Numero Alumnos";
        this.encabezado[1] = "Materia";

        this.datos = this.cargaCurso(this.gd.getCursoList().size(),3);

        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);

        panelCampos.add(this.lblList.get(0));
        panelCampos.add(this.txtList.get(0));
        panelCampos.add(this.lblList.get(1));
        panelCampos.add(this.txtList.get(1));
        panelCampos.add(this.lblList.get(2));
        panelCampos.add(this.comboBox);
        
        this.panel.add(panelCampos);
        this.panel.add(this.bGuardar);
        this.panel.add(this.scroll);
        this.add(this.panel);

    }
    
    public Object[][] cargaCurso(int f, int c) {
        Object[][] retorno = new Object[f][c];
        int i = 0;
        for (Curso cu : this.gd.getCursoList()) {
            
            retorno[i][0] = cu.getParalelo();
            retorno[i][1] = cu.getNumAlumnos();
            retorno[i][1]=  cu.getMateria().getNombre();
            i++;
        }
        return retorno;
    }

    private Object[] CargaCombo() {
        String[] retorno = new String[this.gd.getMateriaList().size()];
        int i = 0;
        for (Materia  mat : this.gd.getMateriaList()) {
            retorno[i] = mat.getNombre();
            
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

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
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

    
    
}
