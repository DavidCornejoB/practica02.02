
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Docente;
import modelo.Materia;
import vista.VentanaMateria;

public class EventoVentanaMateria implements ActionListener {
    private VentanaMateria vM;

    public EventoVentanaMateria(VentanaMateria vM) {
        this.vM = vM;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vM.getbGuardar())) {
            String n = this.vM.getTxtList().get(0).getText();
            String d= this.vM.getComboBox().getSelectedItem().toString();
             
            Docente doc= this.vM.getGd().buscarDocente(d);
            this.vM.getGd().addMateria(new Materia(n,doc));
            
            this.vM.getModeloTabla().setDataVector(cargaMateria(this.vM.getGd().getMateriaList().size(),2), this.vM.getEncabezado());
            
             this.vM.getTxtList().get(0).setText("");
        }    
    }
    public Object[][] cargaMateria(int f, int c){
        Object [][] retorno = new Object [f][c];
        int i = 0;
        for(Materia ma: this.vM.getGd().getMateriaList()){
            retorno[i][0]= ma.getNombre();
            retorno[i][1]= ma.getDocente().getNombre();
            i++;
        }
        return retorno;
    }
    
    
}
