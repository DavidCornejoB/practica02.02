package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Curso;
import modelo.Materia;
import vista.VentanaCurso;

public class EventoVentanaCurso implements ActionListener {

    private VentanaCurso vC;

    public EventoVentanaCurso(VentanaCurso vC) {
        this.vC = vC;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vC.getbGuardar())) {
            String p = this.vC.getTxtList().get(0).getText();
            int n = Integer.parseInt(this.vC.getTxtList().get(1).getText());
            String m = this.vC.getComboBox().getSelectedItem().toString();

            Materia materia = this.vC.getGd().buscarMateria(m);
            this.vC.getGd().addCurso(new Curso(p, n, materia));

            this.vC.getModeloTabla().setDataVector(cargaCurso(this.vC.getGd().getMateriaList().size(), 3), this.vC.getEncabezado());

            this.vC.getTxtList().get(0).setText("");
            this.vC.getTxtList().get(0).setText("");

        }
    }

    public Object[][] cargaCurso(int f, int c) {
        Object[][] retorno = new Object[f][c];
        int i = 0;
        for (Curso cur : this.vC.getGd().getCursoList()) {
            retorno[i][0] = cur.getParalelo();
            retorno[i][1] = cur.getNumAlumnos();
            retorno[i][2] = cur.getMateria().getNombre();
            i++;
        }
        return retorno;
    }

}
