package BD;

import LoginDatos.DatosDelUsuario;

import java.sql.*;

public class UsuariosBD {

    public boolean registroUsuario(DatosDelUsuario usuario){
        String mysql = "INSERT INTO usuarios (UserName, Nombre, Apellido, Telefono, Email, Password) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(mysql)) {

            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getCorreo());
            ps.setString(6, usuario.getPassword());

            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public DatosDelUsuario validarLogin(String username, String password){
        String mysql = "SELECT * FROM usuarios WHERE UserName = ? AND Password = ?";

        try(Connection conexion = ConexionBD.obtenerConexion();
        PreparedStatement ps = conexion.prepareStatement(mysql)){

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new DatosDelUsuario(
                        rs.getString("UserName"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Telefono"),
                        rs.getString("Email"),
                        rs.getString("Password")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        }

    public boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE idUser = ?";

        ConexionBD conexionBD = new ConexionBD();

        try (Connection conexion = DriverManager.getConnection(conexionBD.getURL(), conexionBD.getUSER(), conexionBD.getPASSWORD());
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarUsuario(int id, String usuario, String nombre, String apellido, String telefono, String correo){
        String sql = "UPDATE usuarios SET UserName = ?, Nombre = ?, Apellido = ?, Telefono = ?, Email = ? WHERE idUser = ?";
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido);
            stmt.setString(4, telefono);
            stmt.setString(5, correo);
            stmt.setInt(6, id);

            return stmt.executeUpdate() > 0;

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

