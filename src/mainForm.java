import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class mainForm extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JTextField textID;
    private JTextField textNombre;
    private JTextField textEdad;
    private JTextField textPrioridad;
    private JTextField textAmigos;
    private JButton btnAgregar;
    private JTextArea textArea1;
    private JButton btnDatosQuemados;
    private JTextArea textADatosQuemados;
    private JButton btnBuscarID;
    private JTextField textBuscaId;
    private JCheckBox chBoxColaActiva;
    private JButton buscarConPrioridadMayoresButton;
    private JTextArea textABuscar;
    private JScrollPane textScrollDatosQuemados;
    private JTabbedPane tabbedPane2;
    private JButton btnActivarUsuario;
    private JButton btnActivarUsuarios;
    private JTextArea textAActivarUsuario;
    private JButton btnEliminarUsuario;
    private JButton btnEliminarUsuarios;
    private JTextArea textAEliminar;
    private JButton btnRestablecerUsuario;
    private JButton btnRestablecerUsuarios;
    private JTextArea textARestablecer;
    private JButton btnMostrarActivos;
    private JTextArea textAMostrar;

    RedSocial redSocial = new RedSocial();

    public mainForm() {
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarPersona();
            }
        });
        btnDatosQuemados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textADatosQuemados.setText("Los datos quemados son: " + redSocial.QuemarDatos());
            }
        });
        btnBuscarID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscaPorId(Integer.parseInt(textBuscaId.getText()), chBoxColaActiva.isSelected());
            }
        });
        buscarConPrioridadMayoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarMayores50(chBoxColaActiva.isSelected());
            }
        });
        btnActivarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActivarUsuario();
            }
        });
        btnActivarUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActivarUsuarios();
            }
        });
        btnEliminarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarUsuario();
            }
        });
        btnEliminarUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarUsuarios();
            }
        });
        btnRestablecerUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RestablecerUsuario();
            }
        });
        btnRestablecerUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RestablecerUsuarios();
            }
        });
        btnMostrarActivos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarActivos();
            }
        });
    }

    private void MostrarActivos() {
        textAMostrar.setText(redSocial.getPersonasActivas().toString());
    }

    private void RestablecerUsuarios() {
        List<Persona> personaRestablecidas = redSocial.RestablecerPersonas();
        if(personaRestablecidas != null){
            textARestablecer.setText("Personas Restablecidas: "+ personaRestablecidas);
        }
        else{
            textARestablecer.setText("No hay personas eliminadas");
        }
    }

    private void RestablecerUsuario() {
        Persona personaRestablecida = redSocial.RestablecerPersona();
        if(personaRestablecida != null){
            textARestablecer.setText("Persona restablecida: " + personaRestablecida);
        }
        else{
            textARestablecer.setText("No hay personas eliminadas");
        }
    }

    private void EliminarUsuarios() {
        List<Persona> usuariosEliminados = redSocial.EliminarUsuarios();
        if(usuariosEliminados != null){
            textAEliminar.setText("Personas Eliminadas: " + usuariosEliminados);
        }
        else{
            textAEliminar.setText("No hay personas activas para eliminar.");
        }
    }

    private void EliminarUsuario() {
        Persona usuarioEliminado = redSocial.EliminarUsuario();
        if(usuarioEliminado != null){
            textAEliminar.setText("Persona Eliminada: " + usuarioEliminado);
        }
        else{
            textAEliminar.setText("No hay personas activas para eliminar.");
        }
    }

    private void ActivarUsuarios() {
        List<Persona> personasActivas = redSocial.ActivarUsuarios();
        if(personasActivas != null){
            textAActivarUsuario.setText("Personas Activadas: " + personasActivas);
        }
        else{
            textAActivarUsuario.setText("No hay personas para activar.");
        }
    }

    private void ActivarUsuario() {
        Persona personaActiva = redSocial.ActivarUsuario();
        if(personaActiva != null){
            textAActivarUsuario.setText("Persona Activada: " + personaActiva.toString());
        }
        else{
            textAActivarUsuario.setText("No hay personas para activar.");
        }
    }

    private void BuscarMayores50(boolean buscarColaActiva) {
        List<Persona> personasEncontrada = redSocial.BuscarPorPrioridad(buscarColaActiva);
        if(!personasEncontrada.isEmpty()){
            textABuscar.setText(personasEncontrada.toString());
        }
        else{
            textABuscar.setText("Persona no encontrada");
        }
    }

    private void BuscaPorId(int id, boolean buscarColaActiva) {
        Persona personaEncontrada = redSocial.BuscarPorId(id, buscarColaActiva);
        if(personaEncontrada != null){
            textABuscar.setText(personaEncontrada.toString());
        }
        else{
            textABuscar.setText("Persona no encontrada");
        }
    }

    private void AgregarPersona() {
        Persona personaAgregar = new Persona(Integer.parseInt(textID.getText()),
                Integer.parseInt(textEdad.getText()),
                Integer.parseInt(textPrioridad.getText()),
                Integer.parseInt(textAmigos.getText()),
                textNombre.getText());
        redSocial.AgregarPersonaColaEspera(personaAgregar);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
