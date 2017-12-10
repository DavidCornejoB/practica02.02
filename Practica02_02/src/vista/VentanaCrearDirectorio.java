/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.EventoVentanaCrearDirectorio;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class VentanaCrearDirectorio extends JInternalFrame {

    private List<JTextField> textList;
    private List<JButton> buttonList;
    private List<JLabel> labelList;
    private File[] units;
    private JComboBox comboBox;
    private Object[] items;
    private EventoVentanaCrearDirectorio c;

    public VentanaCrearDirectorio(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setSize(380, 120);
        this.setLocation(100, 50);
        this.setVisible(true);
        this.initComponents();
    }

    public void initComponents() {
        this.textList = new ArrayList<JTextField>();
        this.labelList = new ArrayList<JLabel>();
        this.buttonList = new ArrayList<JButton>();
        this.comboBox = new JComboBox();

        this.labelList.add(new JLabel("Unidad: "));
        this.labelList.add(new JLabel("Nombre del directorio: "));

        this.textList.add(new JTextField(15));

        this.buttonList.add(new JButton("Crear"));
        this.buttonList.add(new JButton("Actualizar"));
        
        for(int i=0;i<this.buttonList.size();i++){
            this.buttonList.get(i).addActionListener(new EventoVentanaCrearDirectorio(this));
        }

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelNorte = new JPanel(new GridLayout(2, 2));
        JPanel panelSur=new JPanel(new FlowLayout());
        this.cargaCombo();
        
        panelNorte.add(this.labelList.get(0));
        panelNorte.add(this.comboBox);
        panelNorte.add(this.labelList.get(1));
        panelNorte.add(this.textList.get(0));
        panelSur.add(this.buttonList.get(0));
        panelSur.add(this.buttonList.get(1));

        panelPrincipal.add(panelNorte, BorderLayout.NORTH);
        panelPrincipal.add(panelSur,BorderLayout.SOUTH);
        
        this.add(panelPrincipal);
    }

    public void cargaCombo() {
        this.comboBox.removeAllItems();
        this.units = File.listRoots();
        for (File f : units) {
            String elemento = FileSystemView.getFileSystemView().getSystemDisplayName(f);
            if (!elemento.isEmpty())
            {
                this.comboBox.addItem(elemento);
            }
        }  
    }

    public List<JTextField> getTextList() {
        return textList;
    }

    public void setTextList(List<JTextField> textList) {
        this.textList = textList;
    }

    public List<JButton> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<JButton> buttonList) {
        this.buttonList = buttonList;
    }

    public List<JLabel> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<JLabel> labelList) {
        this.labelList = labelList;
    }

    public File[] getUnits() {
        return units;
    }

    public void setUnits(File[] units) {
        this.units = units;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public Object[] getItems() {
        return items;
    }

    public void setItems(Object[] items) {
        this.items = items;
    }

    public EventoVentanaCrearDirectorio getC() {
        return c;
    }

    public void setC(EventoVentanaCrearDirectorio c) {
        this.c = c;
    }
    
}
