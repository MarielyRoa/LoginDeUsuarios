package BD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Tabla extends JPanel {

    private JTable tablaUsuarios;
    private DefaultTableModel modelo;

    public JTable getTablaUsuarios() {
        return tablaUsuarios;
    }

    public Tabla(){
        setLayout(null);

        String[] columnas = {"ID", "Usuario", "Nombre", "Apellido", "Teléfono", "Correo"};
        modelo = new DefaultTableModel(null, columnas);
        tablaUsuarios = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tablaUsuarios);
        scroll.setBounds(20, 20, 750, 400);
        add(scroll);

        CargarUsuarios();
    }

    private void CargarUsuarios(){
        String url = "jdbc:mysql://almacenitla-db-itla-3837.e.aivencloud.com:25037/almacenitlafinal";
        String user = "avnadmin";
        String password = "Aqui va la contrasena";

        try {
            Connection conexion = DriverManager.getConnection(url, user, password);
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idUser, UserName, Nombre, Apellido, Telefono, Email, Password FROM usuarios");

            while (rs.next()) {
                Object[] fila = {
                        rs.getInt("idUser"),
                        rs.getString("UserName"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Telefono"),
                        rs.getString("Email"),
                        rs.getString("Password"),
                };
                modelo.addRow(fila);
            }

            rs.close();
            stmt.close();
            conexion.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar usuarios: " + e.getMessage());
        }
    }

    public void recargarUsuarios() {
        modelo.setRowCount(0); // Limpia la tabla
        CargarUsuarios();
    }

}
