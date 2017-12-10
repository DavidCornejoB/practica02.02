/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.EventoVentanaPrincipal;
import controlador.GestionDato;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Administrador
 */
public class VentanaPrincipal extends JFrame{
    
    private JDesktopPane escritorio;
    private JMenuBar barraMenu;
    private List<JMenu> menuList;
    private List<JMenuItem> itemMenuList;
    private GestionDato gd;
    
    private VentanaCurso vCurso;
    private VentanaDocente vDocente;
    private VentanaMateria vMateria;
    
    public VentanaPrincipal(String title, GestionDato gd){
        super(title);
        this.setSize(820, 720);
        this.setDefaultCloseOperation(3);
        this.gd = gd;
        this.iniciaComponentes();
    }
    
    public void iniciaComponentes(){
        
        this.escritorio = new JDesktopPane();
        this.barraMenu = new JMenuBar();
        
        this.menuList = new ArrayList();
        this.menuList.add(new JMenu("Docente"));
        this.menuList.add(new JMenu("Materia"));
        this.menuList.add(new JMenu("Curso"));
        this.menuList.add(new JMenu("Archivo"));
        
        this.itemMenuList = new ArrayList();
        this.itemMenuList.add(new JMenuItem("Nuevo Docente"));
        this.itemMenuList.add(new JMenuItem("Nueva Materia"));
        this.itemMenuList.add(new JMenuItem("Nuevo Curso"));
        this.itemMenuList.add(new JMenuItem("Crear Carpeta"));
        this.itemMenuList.add(new JMenuItem("Crear Documento"));
 
        this.add(this.escritorio);
        this.setJMenuBar(this.barraMenu);
        
        this.barraMenu.add(this.menuList.get(0));
        this.barraMenu.add(this.menuList.get(1));
        this.barraMenu.add(this.menuList.get(2));
        this.barraMenu.add(this.menuList.get(3));
        
        this.menuList.get(0).add(this.itemMenuList.get(0));
        this.menuList.get(1).add(this.itemMenuList.get(1));
        this.menuList.get(2).add(this.itemMenuList.get(2));
        this.menuList.get(3).add(this.itemMenuList.get(3));
        this.menuList.get(3).add(this.itemMenuList.get(4));
        
        this.itemMenuList.get(0).addActionListener(new EventoVentanaPrincipal(this));
        this.itemMenuList.get(1).addActionListener(new EventoVentanaPrincipal(this));
        this.itemMenuList.get(2).addActionListener(new EventoVentanaPrincipal(this));
        
    }
    

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenuBar getBarraMenu() {
        return barraMenu;
    }

    public void setBarraMenu(JMenuBar barraMenu) {
        this.barraMenu = barraMenu;
    }

    public List<JMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<JMenu> menuList) {
        this.menuList = menuList;
    }

    public List<JMenuItem> getItemMenuList() {
        return itemMenuList;
    }

    public void setItemMenuList(List<JMenuItem> itemMenuList) {
        this.itemMenuList = itemMenuList;
    }

    public GestionDato getGd() {
        return gd;
    }

    public void setGd(GestionDato gd) {
        this.gd = gd;
    }

    public VentanaCurso getvCurso() {
        return vCurso;
    }

    public void setvCurso(VentanaCurso vCurso) {
        this.vCurso = vCurso;
    }

    public VentanaDocente getvDocente() {
        return vDocente;
    }

    public void setvDocente(VentanaDocente vDocente) {
        this.vDocente = vDocente;
    }

    public VentanaMateria getvMateria() {
        return vMateria;
    }

    public void setvMateria(VentanaMateria vMateria) {
        this.vMateria = vMateria;
    }

}
