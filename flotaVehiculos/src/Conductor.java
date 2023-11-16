import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class Conductor {
    private String nombre;
    private String id;
    private String telefono;

    public Conductor(String nombre, String id, String telefono) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getTelefono() {
        return telefono;
    }

    public static void asignarConductorAVehiculo(List<Vehiculo> vehiculosSinConductor) {
        JFrame frame = new JFrame();
        JDialog asignarConductorDialog = new JDialog(frame, "Asignar Conductor", true);
        asignarConductorDialog.setLayout(new FlowLayout());

        JComboBox<String> vehiculosSinConductorCombo = new JComboBox<>();
        for (Vehiculo vehiculo : vehiculosSinConductor) {
            vehiculosSinConductorCombo.addItem(vehiculo.getPlaca());
        }

        JTextField nombreConductorField = new JTextField(10);
        JTextField idConductorField = new JTextField(10);
        JTextField telefonoConductorField = new JTextField(10);

        JButton asignarConductorButton = new JButton("Asignar Conductor");
        asignarConductorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreConductorField.getText();
                String id = idConductorField.getText();
                String telefono = telefonoConductorField.getText();

                int selectedIndex = vehiculosSinConductorCombo.getSelectedIndex();
                if (selectedIndex >= 0 && !nombre.isEmpty() && !id.isEmpty() && !telefono.isEmpty()) {
                    Vehiculo vehiculoSeleccionado = vehiculosSinConductor.get(selectedIndex);

                    // Verificar si el vehículo ya tiene un conductor asignado
                    if (vehiculoSeleccionado.obtenerConductor() != null) {
                        JOptionPane.showMessageDialog(null, "El vehículo ya tiene un conductor asignado.");
                    } else {
                        Conductor conductor = new Conductor(nombre, id, telefono);
                        vehiculoSeleccionado.asignarConductor(conductor);
                        asignarConductorDialog.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos y seleccione un vehículo.");
                }
            }
        });

        asignarConductorDialog.add(new JLabel("Seleccione un vehículo:"));
        asignarConductorDialog.add(vehiculosSinConductorCombo);
        asignarConductorDialog.add(new JLabel("Nombre del Conductor:"));
        asignarConductorDialog.add(nombreConductorField);
        asignarConductorDialog.add(new JLabel("ID del Conductor:"));
        asignarConductorDialog.add(idConductorField);
        asignarConductorDialog.add(new JLabel("Teléfono del Conductor:"));
        asignarConductorDialog.add(telefonoConductorField);
        asignarConductorDialog.add(asignarConductorButton);

        asignarConductorDialog.setSize(300, 250);
        asignarConductorDialog.setLocationRelativeTo(frame);
        asignarConductorDialog.setVisible(true);
    }
}

