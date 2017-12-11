package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.Materia;
import vista.VentanaCurso;

public class EventoVentanaCurso implements ActionListener {

    private VentanaCurso vCurso;

    public EventoVentanaCurso(VentanaCurso vCurso) {
        this.vCurso = vCurso;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.vCurso.getbGuardar())) {
try{
            try {
                String grupo = this.vCurso.getTxtList().get(0).getText();
                String varAlumnos = this.vCurso.getTxtList().get(1).getText();
                int comboMateria = this.vCurso.getComboBox().getSelectedIndex();
                Object combo = this.vCurso.getComboBox().getSelectedItem();

                if (grupo.isEmpty() && varAlumnos.isEmpty()) {
                    JOptionPane.showInternalMessageDialog(vCurso, "Todos los parámetros está vacíos", "Empty Parameter", JOptionPane.NO_OPTION);
                } else if (grupo.isEmpty()) {
                    JOptionPane.showInternalMessageDialog(vCurso, "El parámetro Grupo esrá vacío", "Empty Parameter", JOptionPane.NO_OPTION);
                } else if (varAlumnos.isEmpty()) {
                    JOptionPane.showInternalMessageDialog(vCurso, "El parámetro Numero Alumnos está vacío", "Empty Parameter", JOptionPane.NO_OPTION);
                } else {//INICIO ELSE

                    int numAlumnos = Integer.parseInt(varAlumnos);

                    int a = 0;
                    boolean cent = true;
                    for (Curso c : this.vCurso.getGd().getCursoList()) {
                        if (combo.equals(this.vCurso.getGd().getMateriaList().get(a).getNombre())) {
                            JOptionPane.showInternalMessageDialog(vCurso, "Ya se encuentra este dato en nuestra base de datos", "Parámetro Repetido", JOptionPane.ERROR_MESSAGE);
                            cent = false;
                            break;
                        } else {
                            cent = true;
                        }
                        a++;
                    }

                    if (cent == true) {//INICIO IF
                        this.vCurso.getGd().addCurso(new Curso(grupo, numAlumnos, this.vCurso.getGd().getMateriaList().get(comboMateria)));
                        this.vCurso.getModeloTabla().setDataVector(this.cargaCurso(this.vCurso.getGd().getCursoList().size(), 4), this.vCurso.getEncabezado());
                    }//FIN IF
                }//FIN ELSE

            } catch (NumberFormatException error) {

                JOptionPane.showInternalMessageDialog(vCurso, "Ingresar solo números en el parámetro Numero Alumnos", "NumberFormatException", JOptionPane.ERROR_MESSAGE);

            }
} catch(ArrayIndexOutOfBoundsException error){
    
                    JOptionPane.showInternalMessageDialog(vCurso, "El parámetro Materia está vacío. Ingrese una materia desde la ventana Nueva Materia", "ArrayIndexOutOfBoundsException", JOptionPane.ERROR_MESSAGE);

}

            this.vCurso.getTxtList().get(0).setText("");
            this.vCurso.getTxtList().get(1).setText("");
            this.vCurso.getComboBox().setSelectedIndex(-1);

        }

    }

    public Object[][] cargaCurso(int f, int c) {
        Object[][] retorno = new Object[f][c];
        int i = 0;
        for (Curso cur : this.vCurso.getGd().getCursoList()) {
            retorno[i][0] = i + 1;
            retorno[i][1] = cur.getParalelo();
            retorno[i][2] = cur.getNumAlumnos();
            retorno[i][3] = cur.getMateria().getNombre();
            i++;
        }
        return retorno;
    }

}
