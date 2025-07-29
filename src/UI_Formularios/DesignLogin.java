package UI_Formularios;

import javax.swing.*;
import java.awt.*;

public class DesignLogin {

    public static void DisenoBotones(JButton boton){
        boton.setForeground(Color.cyan);
        boton.setBackground(Color.black);
        boton.setFont(new Font("Cambria", Font.PLAIN, 16));
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

    }
    public static void DisenoLabel(JLabel label){
        label.setForeground(Color.black);
        label.setFont(new Font("Cambria", Font.PLAIN, 16 ));
    }

    public static void DisenoTxt(JTextField txt){
        txt.setFont(new Font("Cambria", Font.PLAIN, 14));
        txt.setBorder(BorderFactory.createLineBorder(Color.darkGray));
    }

    public static JLabel DisenoImagen(ImageIcon imagen){
        Image imagenRedimen = imagen.getImage().getScaledInstance(180, 180,Image.SCALE_SMOOTH);
        ImageIcon imagenRedimen2 = new ImageIcon(imagenRedimen);
        return new JLabel(imagenRedimen2);

    }
}
