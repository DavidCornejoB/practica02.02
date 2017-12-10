/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.EventoVentanaCrearCarpeta;
import controlador.EventoVentanaCrearDirectorio;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

public class VentanaCrearCarpeta extends JInternalFrame {

    private List<JTextField> textList;
    private List<JButton> buttonList;
    private List<JLabel> labelList;
    private File[] units;
    private JComboBox comboBox;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private List<JCheckBox> checkList;
    private Object[] items;
    private EventoVentanaCrearDirectorio c;

    public VentanaCrearCarpeta(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setSize(800, 180);
        this.setLocation(20, 50);
        this.setVisible(true);
        this.initComponents();
    }

    public void initComponents() {
        this.textList = new ArrayList<JTextField>();
        this.labelList = new ArrayList<JLabel>();
        this.buttonList = new ArrayList<JButton>();
        this.comboBox = new JComboBox();
        this.comboBox1 = new JComboBox();
        this.comboBox2 = new JComboBox();
        this.checkList = new ArrayList<JCheckBox>();

        this.labelList.add(new JLabel("Unidad: "));
        this.labelList.add(new JLabel("Directorio: "));
        this.labelList.add(new JLabel("Carpeta: "));
        this.labelList.add(new JLabel("Nombre"));

        this.textList.add(new JTextField(10));

        this.checkList.add(new JCheckBox("Crear aqui"));
        
        this.buttonList.add(new JButton("Crear carpeta"));
        this.buttonList.add(new JButton("Crear archivo"));

        for (int i = 0; i < this.buttonList.size(); i++) {
            this.buttonList.get(i).addActionListener(new EventoVentanaCrearCarpeta(this));
        }

        this.comboBox.addActionListener(new EventoVentanaCrearCarpeta(this));
        this.comboBox1.addActionListener(new EventoVentanaCrearCarpeta(this));       
        
        this.checkList.get(0).addActionListener(new EventoVentanaCrearCarpeta(this));

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelNorte = new JPanel(new GridLayout(4, 3));
        JPanel panelSur = new JPanel(new FlowLayout());
        this.cargaCombo();

        panelNorte.add(this.labelList.get(0));
        panelNorte.add(this.comboBox);
        panelNorte.add(new JLabel());
        panelNorte.add(this.labelList.get(1));
        panelNorte.add(this.comboBox1);
        panelNorte.add(this.checkList.get(0));
        panelNorte.add(this.labelList.get(2));
        panelNorte.add(this.comboBox2);
        panelNorte.add(new JLabel());
        panelNorte.add(this.labelList.get(3));
        panelNorte.add(this.textList.get(0));
        panelSur.add(this.buttonList.get(0));
        panelSur.add(this.buttonList.get(1));

        panelPrincipal.add(panelNorte, BorderLayout.NORTH);
        panelPrincipal.add(panelSur, BorderLayout.SOUTH);

        this.add(panelPrincipal);
    }

    public void cargaCombo() {
        this.comboBox.removeAllItems();
        this.units = File.listRoots();
        for (File f : units) {
            String elemento = FileSystemView.getFileSystemView().getSystemDisplayName(f);//Obtiene el nombre de la unidad
            if (!elemento.isEmpty()) //No admite elementos vacios
            {
                this.comboBox.addItem(elemento);
            }
        }
    }

    public void cargaCombo1(String unidad) {
        this.comboBox1.removeAllItems();
        File direc = new File(unidad + ":/");
        File[] lista = direc.listFiles();
        for (File s : lista) {
            if (s.isDirectory()) {
                this.comboBox1.addItem(s.toString());
            }
        }
    }

    public void Mostrar(File a) {
        this.comboBox2.removeAllItems();
        if (a.isFile()) {
            //System.out.println(a.getPath());
        }

        if (a.isDirectory()) {
            File[] directorio = a.listFiles();
            Metodo2(directorio);
        }

    }

    public void Metodo2(File[] lista1) {

        for (File a : lista1) {
            if (a.isFile()) {
                //System.out.println(a.getPath());
            }

            if (a.isDirectory()) {
                //System.out.println(a.getPath());
                this.comboBox2.addItem(a.getPath());
                Metodo2(a.listFiles());
            }
        }

    }

    public void cargaCombo1() {
        this.comboBox1.removeAllItems();

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

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public void setComboBox1(JComboBox comboBox1) {
        this.comboBox1 = comboBox1;
    }

    public JComboBox getComboBox2() {
        return comboBox2;
    }

    public void setComboBox2(JComboBox comboBox2) {
        this.comboBox2 = comboBox2;
    }

    public List<JCheckBox> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<JCheckBox> checkList) {
        this.checkList = checkList;
    }

}
