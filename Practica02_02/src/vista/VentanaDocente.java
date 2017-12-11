/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.EventoVentanaDocente;
import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Docente;

/**
 *
 * @author Administrador
 */
public class VentanaDocente extends JInternalFrame{

    private JPanel panel;
    private List<JLabel> lblList;
    private List<JTextField> txtList;
    private JButton bGuardar;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    private Object encabezado[];
    private Object datos[][];
    private GestionDato gd;

    public VentanaDocente(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable, GestionDato gd) {
         super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(440, 0, 350, 300);
        this.gd = gd;
        this.setVisible(true);
        this.iniciaComponentes();
    }

    public void iniciaComponentes() {
        
        this.panel = new JPanel(new BorderLayout(3,1));
        JPanel panelCampos = new JPanel(new GridLayout(5,2));
        
        this.lblList = new ArrayList();
        this.lblList.add(new JLabel("Nombre:"));
        this.lblList.add(new JLabel("Apellido:"));
        this.lblList.add(new JLabel("Cédula:"));
        this.lblList.add(new JLabel("Fecha Nacimiento:"));
        this.lblList.add(new JLabel("Titulo:"));
        
        this.txtList = new ArrayList();
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        
        this.bGuardar = new JButton("Guardar");
        this.bGuardar.addActionListener(new EventoVentanaDocente(this));
        this.encabezado = new Object[6];
        this.encabezado[0]="N°";
        this.encabezado[1]="Nombre";
        this.encabezado[2]="Apellido";
        this.encabezado[3]="Cedula";
        this.encabezado[4]="Fecha Nacimiento";
        this.encabezado[5]="Titulo";

        this.datos= this.cargaDocente(this.gd.getDocenteList().size(),6);

        this.modeloTabla = new DefaultTableModel(this.datos,this.encabezado);
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
        
        panelCampos.add(this.lblList.get(0));
        panelCampos.add(this.txtList.get(0));
        panelCampos.add(this.lblList.get(1));
        panelCampos.add(this.txtList.get(1));
        panelCampos.add(this.lblList.get(2));
        panelCampos.add(this.txtList.get(2));
        panelCampos.add(this.lblList.get(3));
        panelCampos.add(this.txtList.get(3));
        panelCampos.add(this.lblList.get(4));
        panelCampos.add(this.txtList.get(4));
        
        
        this.panel.add(panelCampos, BorderLayout.NORTH);
        this.panel.add(this.bGuardar, BorderLayout.SOUTH);
        this.panel.add(this.scroll);
        this.add(this.panel);

    }
    
    public Object[][] cargaDocente(int f, int c){
        Object [][]retorno= new Object[f][c];
        int i = 0;
        for(Docente d: this.gd.getDocenteList()){
            retorno[i][0]= i+1;
            retorno[i][1]= d.getNombre();
            retorno[i][2]= d.getApellido();
            retorno[i][3]= d.getCedula();
            retorno[i][4]= d.getFechaNac();
            retorno[i][5]= d.getTitulo();
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

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
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
