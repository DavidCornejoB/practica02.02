/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Docente;
import vista.VentanaDocente;

/**
 *
 * @author Administrador
 */
public class EventoVentanaDocente implements ActionListener {

    private VentanaDocente vDocente;

    public EventoVentanaDocente(VentanaDocente vDocente) {
        this.vDocente = vDocente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.vDocente.getbGuardar())) {
            String n = this.vDocente.getTxtList().get(0).getText();
            String a = this.vDocente.getTxtList().get(1).getText();
            String c = this.vDocente.getTxtList().get(2).getText();
            String fn = this.vDocente.getTxtList().get(3).getText();
            String titulo = this.vDocente.getTxtList().get(4).getText();

            this.vDocente.getGd().addDocente(new Docente(n, a, c, fn, titulo));
            this.vDocente.getModeloTabla().setDataVector(cargaDocente(this.vDocente.getGd().getDocenteList().size(), 6), this.vDocente.getEncabezado());

            this.vDocente.getTxtList().get(0).setText("");
            this.vDocente.getTxtList().get(1).setText("");
            this.vDocente.getTxtList().get(2).setText("");
            this.vDocente.getTxtList().get(3).setText("");
            this.vDocente.getTxtList().get(4).setText("");

        }
    }
    
        public Object[][] cargaDocente(int f, int c){
        Object [][] retorno = new Object [f][c];
        int i = 0;
        for(Docente d: this.vDocente.getGd().getDocenteList()){
            retorno[i][0]= i+1;
            retorno[i][1]= d.getNombre();
            retorno[i][2]= d.getApellido();
            retorno[i][3]= d.getCedula();
            retorno[i][4]= d.getFechaNac();
            retorno[i][4]= d.getTitulo();
            i++;
        }
        return retorno;
    }

}
