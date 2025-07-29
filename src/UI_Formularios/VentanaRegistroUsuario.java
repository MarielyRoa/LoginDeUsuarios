package UI_Formularios;

import BD.UsuariosBD;
import LoginDatos.DatosDelUsuario;
import javax.swing.*;
import java.awt.*;

public class VentanaRegistroUsuario extends JFrame {

    public VentanaRegistroUsuario(){
        setTitle("Registro de Usuario");
        setSize(1000, 650);
        setLocation(150,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        componentes();
    }

    public void componentes(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(100, 100, 300, 500);
        this.getContentPane().add(panel);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(109, 112, 112));
        panel2.setBounds((500 - 400)/2, (400 - 300)/2, 450, 500);
        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.add(panel2);

        JLabel tituloVentana = new JLabel("REGISTRO");
        tituloVentana.setFont(new Font("Cambria", Font.BOLD, 30));
        tituloVentana.setBounds(670, 20, 200, 30);
        panel.add(tituloVentana);

        JLabel labelUsuario = new JLabel("Nombre de Usuario: ");
        labelUsuario.setBounds(30, 80, 150, 30);
        DesignLogin.DisenoLabel(labelUsuario);
        panel2.add(labelUsuario);

        JLabel labelNombre = new JLabel("Nombre: ");
        labelNombre.setBounds(30, 120, 150, 30);
        DesignLogin.DisenoLabel(labelNombre);
        panel2.add(labelNombre);

        JLabel labelApellido = new JLabel("Apellido: ");
        labelApellido.setBounds(30, 160, 150, 30);
        DesignLogin.DisenoLabel(labelApellido);
        panel2.add(labelApellido);

        JLabel labelTelefono = new JLabel("Telefono: ");
        labelTelefono.setBounds(30, 200, 150, 30);
        DesignLogin.DisenoLabel(labelTelefono);
        panel2.add(labelTelefono);

        JLabel labelCorreo = new JLabel("Correo Electronico: ");
        labelCorreo.setBounds(30, 240, 150, 30);
        DesignLogin.DisenoLabel(labelCorreo);
        panel2.add(labelCorreo);

        JLabel labelContrase = new JLabel("Password: ");
        labelContrase.setBounds(30, 280, 150, 30);
        DesignLogin.DisenoLabel(labelContrase);
        panel2.add(labelContrase);

        JLabel labelConfirmarContra = new JLabel("Confirmar Password: ");
        labelConfirmarContra.setBounds(30, 320, 150, 30);
        DesignLogin.DisenoLabel(labelConfirmarContra    );
        panel2.add(labelConfirmarContra);

        JTextField txtNombreUsuario = new JTextField(20);
        txtNombreUsuario.setBounds(200, 80, 200, 25);
        DesignLogin.DisenoTxt(txtNombreUsuario);
        panel2.add(txtNombreUsuario);

        JTextField txtNombre = new JTextField(20);
        txtNombre.setBounds(200, 120, 200, 25);
        DesignLogin.DisenoTxt(txtNombre);
        panel2.add(txtNombre);

        JTextField txtApellido = new JTextField(20);
        txtApellido.setBounds(200, 160, 200, 25);
        DesignLogin.DisenoTxt(txtApellido);
        panel2.add(txtApellido);

        JTextField txtTelefono = new JTextField(20);
        txtTelefono.setBounds(200, 200, 200, 25);
        DesignLogin.DisenoTxt(txtTelefono);
        panel2.add(txtTelefono);

        JTextField txtCorreo = new JTextField(20);
        txtCorreo.setBounds(200, 240, 200, 25);
        DesignLogin.DisenoTxt(txtCorreo);
        panel2.add(txtCorreo);

        JPasswordField txtContra = new JPasswordField(20);
        txtContra.setBounds(200, 280, 200, 25);
        DesignLogin.DisenoTxt(txtContra);
        panel2.add(txtContra);

        JPasswordField txtConfirmarContra= new JPasswordField(20);
        txtConfirmarContra.setBounds(200, 320, 200, 25);
        DesignLogin.DisenoTxt(txtConfirmarContra);
        panel2.add(txtConfirmarContra);

        JButton btnRegistro = new JButton("Registrarse");
        btnRegistro.setBounds((500 - 200) / 2, 400, 150, 35);
        DesignLogin.DisenoBotones(btnRegistro);
        panel2.add(btnRegistro);

        btnRegistro.addActionListener(e -> {

            String usuario = txtNombreUsuario.getText().trim();
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            String telefono = txtTelefono.getText().trim();
            String correo = txtCorreo.getText().trim();
            String contrasena = new String(txtContra.getPassword()).trim();
            String confirmarContra = new String(txtConfirmarContra.getPassword()).trim();

        if(usuario.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar el nombre de usuario", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar el nombre", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(apellido.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar el apellido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(telefono.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar el teléfono", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(correo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar el correo electrónico", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar la contraseña", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(confirmarContra.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe confirmar la contraseña", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(!contrasena.equals(confirmarContra)) {
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DatosDelUsuario nuevoUsuario = new DatosDelUsuario(usuario, nombre, apellido, telefono, correo, contrasena);

            UsuariosBD usu = new UsuariosBD();

            if (usu.registroUsuario(nuevoUsuario)) {
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");

                VentanaClientesRegistrados ventanaUsuarios = new VentanaClientesRegistrados();
                ventanaUsuarios.setVisible(true);

                ((JFrame) SwingUtilities.getWindowAncestor(btnRegistro)).dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar usuario.");
            }

        });

        ImageIcon imagenLogin = new ImageIcon(getClass().getResource("/contenidoMultimedia/imagen.png"));
        Image imagenRedimen = imagenLogin.getImage().getScaledInstance(300, 280,Image.SCALE_SMOOTH);
        ImageIcon imagenRedimen2 = new ImageIcon(imagenRedimen);

        JLabel imagenRegistro = new JLabel(imagenRedimen2);
        imagenRegistro.setBounds((getWidth() - 100) / 2, 150, 600, 300);
        panel.add(imagenRegistro);
    }

}
