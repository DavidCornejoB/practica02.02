
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Docente;
import modelo.Materia;
import vista.VentanaMateria;

public class EventoVentanaMateria implements ActionListener {
    private VentanaMateria vMateria;

    public EventoVentanaMateria(VentanaMateria vMateria) {
        this.vMateria = vMateria;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(this.vMateria.getbGuardar())){
                
            String n = this.vMateria.getTxtList().get(0).getText();
            int c = this.vMateria.getComboBox().getSelectedIndex();
            
            this.vMateria.getGd().addMateria(new Materia(n,this.vMateria.getGd().getDocenteList().get(c)));
            this.vMateria.getModeloTabla().setDataVector(this.cargaMateria(this.vMateria.getGd().getMateriaList().size(), 3), this.vMateria.getEncabezado());

            this.vMateria.getTxtList().get(0).setText("");
            this.vMateria.getComboBox().setSelectedItem(-1);
            
        }
  
    }   

    private Object[][] cargaMateria(int f, int c) {
        
        Object [][]retorno= new Object[f][c];
        int i = 0;
        for(Materia m: this.vMateria.getGd().getMateriaList()){
            retorno[i][0]= i+1;
            retorno[i][1]= m.getNombre();
            retorno[i][2]= m.getDocente().getNombre() + " " + m.getDocente().getApellido();
            i++;
        }
        return retorno;
        
    }
}
