package UI_Formularios;

import BD.Tabla;
import BD.UsuariosBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaClientesRegistrados extends JFrame {

    private Tabla tablaPanel;

    public VentanaClientesRegistrados() {
        setTitle("Usuarios Registrados");
        setSize(1200, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        componentes();

    }

    public void componentes() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().add(panel);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(109, 112, 112));
        panel2.setBounds(100, 60, 800, 450);
        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.add(panel2);

        JLabel titulo = new JLabel("USUARIOS REGISTRADOS");
        titulo.setFont(new Font("Cambria", Font.BOLD, 22));
        titulo.setForeground(Color.black);
        titulo.setBounds((1000 - 300) / 2, 20, 300, 30);
        panel.add(titulo);

        JButton Nuevo = new JButton("Nuevo");
        Nuevo.setBounds(950, 80, 140, 35);
        DesignLogin.DisenoBotones(Nuevo);
        panel.add(Nuevo);

        JButton Actualizar = new JButton("Actualizar");
        Actualizar.setBounds(950, 150, 140, 35);
        DesignLogin.DisenoBotones(Actualizar);
        panel.add(Actualizar);

        JButton Eliminar = new JButton("Eliminar");
        Eliminar.setBounds(950, 220, 140, 35);
        DesignLogin.DisenoBotones(Eliminar);
        panel.add(Eliminar);

        JButton CerrarSesion = new JButton("Cerrar Sesion");
        CerrarSesion.setBounds(950, 290, 140, 35);
        DesignLogin.DisenoBotones(CerrarSesion);
        panel.add(CerrarSesion);

        //
        CerrarSesion.addActionListener(e -> {
            dispose();
            new VentanaLogin().setVisible(true);
        });

        //

        tablaPanel = new Tabla();
        tablaPanel.setBounds(10, 10, 780, 440);
        tablaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel2.add(tablaPanel);

        JTable tabla = tablaPanel.getTablaUsuarios();

        Eliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione el usuario que desea eliminar");
                return;
            }

            int idUser = (int) tabla.getValueAt(fila, 0);

            int confirmar = JOptionPane.showConfirmDialog(null,
                    "¿Está seguro que desea eliminar al usuario seleccionado?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirmar == JOptionPane.YES_OPTION) {
                UsuariosBD dao = new UsuariosBD();
                if (dao.eliminarUsuario(idUser)) {
                    JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
                    ((DefaultTableModel) tabla.getModel()).removeRow(fila);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar usuario.");
                }
            }

        });

        Nuevo.addActionListener(e -> {
            VentanaRegistroUsuario ventanaUsuarios = new VentanaRegistroUsuario();
            ventanaUsuarios.setVisible(true);

            ((JFrame) SwingUtilities.getWindowAncestor(Nuevo)).dispose();
        });

        Actualizar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Seleccione el usuario que desea actualizar");
                return;
            }

            int idUser = (int) tabla.getValueAt(fila, 0);
            String nombreUsuario = (String) tabla.getValueAt(fila, 1).toString();
            String nombre = (String) tabla.getValueAt(fila, 2).toString();
            String apellido = (String) tabla.getValueAt(fila, 3).toString();
            String telefono = (String) tabla.getValueAt(fila, 4).toString();
            String correo = (String) tabla.getValueAt(fila, 5).toString();


            UsuariosBD usu = new UsuariosBD();
            boolean actualizado = usu.actualizarUsuario(idUser, nombreUsuario, nombre, apellido, telefono, correo);

        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el usuario.");
        }


        });

    }
}
