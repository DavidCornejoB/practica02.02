package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Materia;
import vista.VentanaMateria;

public class EventoVentanaMateria implements ActionListener {

    private final VentanaMateria vMateria;

    public EventoVentanaMateria(VentanaMateria vMateria) {
        this.vMateria = vMateria;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vMateria.getbGuardar())) {

            try {

                String n = this.vMateria.getTxtList().get(0).getText();
                int c = this.vMateria.getComboBox().getSelectedIndex();

                if (n.isEmpty()) {
                    JOptionPane.showInternalMessageDialog(vMateria, "El parámetro Nombre se encuentra vacío", "EmptyParameter", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    int cont = 0;
                    boolean cent = true;
                    for (Materia m : this.vMateria.getGd().getMateriaList()) {
                        if (n.equalsIgnoreCase(this.vMateria.getGd().getMateriaList().get(cont).getNombre())) {
                            JOptionPane.showInternalMessageDialog(vMateria, "Ya se encuentra esta materia en nuestra base de datos", "Parámetro Repetido", JOptionPane.ERROR_MESSAGE);
                            cent = false;
                            break;
                        } else {
                            cent = true;
                        }
                        cont++;
                    }

                    if (cent == true) {
                        this.vMateria.getGd().addMateria(new Materia(n, this.vMateria.getGd().getDocenteList().get(c)));
                        this.vMateria.getModeloTabla().setDataVector(this.cargaMateria(this.vMateria.getGd().getMateriaList().size(), 3), this.vMateria.getEncabezado());
                    }
                }
            } catch (ArrayIndexOutOfBoundsException err) {
                JOptionPane.showInternalMessageDialog(vMateria, "El parámetro docente está vacío. Ingrese un docente desde la ventana Nuevo Docente", "EmptyParameter", JOptionPane.ERROR_MESSAGE);
            }
            this.vMateria.getTxtList().get(0).setText("");
            this.vMateria.getComboBox().setSelectedItem(-1);

        }

        if (e.getSource().equals(this.vMateria.getbGenerar())) {
            JOptionPane.showMessageDialog(null, "Se debe escribir con la direccion del disco ejemplo: c:/Usuario");
            this.vMateria.getGd().persistirArchivoMateria(this.vMateria.getGd().getMateriaList());

        }
    }

    private Object[][] cargaMateria(int f, int c) {

        Object[][] retorno = new Object[f][c];
        int i = 0;
        for (Materia m : this.vMateria.getGd().getMateriaList()) {
            retorno[i][0] = i + 1;
            retorno[i][1] = m.getNombre();
            retorno[i][2] = m.getDocente().getNombre() + " " + m.getDocente().getApellido();
            i++;
        }
        return retorno;

    }
}
