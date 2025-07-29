package UI_Formularios;

import BD.UsuariosBD;
import LoginDatos.DatosDelUsuario;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {

    public VentanaLogin(){
        setTitle("Login");
        setSize(550, 650); //Tamanio de la ventana del Login
        setLocation(150,100); //Para la posicion inicial de la ventana a la hora de ejecutar
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        componentes();
    }

    public void componentes(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(33, 105, 99));
        panel.setBounds(100, 100, 300, 700);
        this.getContentPane().add(panel);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(109, 112, 112));
        panel2.setBounds((500 - 400)/2, (400 - 300)/2, 450, 500);
        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.add(panel2);

        JLabel labelUsuario = new JLabel("Usuario: ");
        labelUsuario.setBounds(60, 220, 100, 30);
        DesignLogin.DisenoLabel(labelUsuario);
        panel2.add(labelUsuario);

        JTextField txtUsuario = new JTextField(20);
        txtUsuario.setBounds(160, 220, 200, 30);
        DesignLogin.DisenoTxt(txtUsuario);
        panel2.add(txtUsuario);

        JLabel labelPassword = new JLabel("Contraseña: ", SwingConstants.CENTER);
        labelPassword.setBounds(50, 260, 100, 30);
        DesignLogin.DisenoLabel(labelPassword);
        panel2.add(labelPassword);

        JPasswordField txtpassword = new JPasswordField(20);
        txtpassword.setBounds(160, 260, 200, 30);
        DesignLogin.DisenoTxt(txtpassword);
        panel2.add(txtpassword);

        JButton btnLogin = new JButton("Iniciar Sesion");
        btnLogin.setBounds(150, 310, 120, 30);
        DesignLogin.DisenoBotones(btnLogin);
        panel2.add(btnLogin);

        JButton btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setBounds(310, 310, 120, 30);
        DesignLogin.DisenoBotones(btnRegistrarse);
        panel2.add(btnRegistrarse);

        btnRegistrarse.addActionListener(e ->{
            VentanaRegistroUsuario registro = new VentanaRegistroUsuario();
            registro.setVisible(true);
        });

        ImageIcon imagenLogin = new ImageIcon(getClass().getResource("/contenidoMultimedia/imagen.png"));
        JLabel imagen = DesignLogin.DisenoImagen(imagenLogin);
        imagen.setBounds((getWidth() - 200) / 2, 5, 150, 200);
        panel2.add(imagen);

        btnLogin.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String password = new String(txtpassword.getPassword());

            if(usuario.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe ingresar su usuario y contraseña, si no está registrado debe registrarse");
                return;
            }

            UsuariosBD usu = new UsuariosBD();
            DatosDelUsuario user = usu.validarLogin(usuario, password);

            if(user != null){
                VentanaClientesRegistrados ventanaClientes = new VentanaClientesRegistrados();
                ventanaClientes.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }
        });

    }

}
