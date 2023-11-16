import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlotaVehiculosGUI extends JFrame {
    private List<Vehiculo> flota;
    private JTextArea informacionVehiculos;
    private JTextField placaField;
    private JTextField modeloField;
    private JTextField tipoVehiculoField;
    private JComboBox<String> vehiculosComboBox;

    public FlotaVehiculosGUI() {
        flota = new ArrayList<>();
        informacionVehiculos = new JTextArea(10, 40);
        informacionVehiculos.setEditable(false);

        JButton agregarVehiculoButton = new JButton("Agregar Vehículo");
        JButton verVehiculosButton = new JButton("Ver Vehículos");
        JButton limpiarButton = new JButton("Limpiar");
        JButton verUbicacionButton = new JButton("Ver Ubicación");
        JButton asignarConductorButton = new JButton("Asignar Conductor");

        placaField = new JTextField(10);
        modeloField = new JTextField(10);
        tipoVehiculoField = new JTextField(10);

        vehiculosComboBox = new JComboBox<>();
        vehiculosComboBox.setPreferredSize(new Dimension(150, 25));

        agregarVehiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = placaField.getText();
                String modelo = modeloField.getText();
                String tipoVehiculo = tipoVehiculoField.getText();

                if (!placa.isEmpty() && !modelo.isEmpty() && !tipoVehiculo.isEmpty()) {
                    Vehiculo nuevoVehiculo = new Vehiculo(placa);
                    nuevoVehiculo.setModelo(modelo);
                    nuevoVehiculo.setTipoVehiculo(tipoVehiculo);
                    flota.add(nuevoVehiculo);
                    informacionVehiculos.append("Vehículo agregado: Placa " + nuevoVehiculo.getPlaca() + ", Modelo: " + nuevoVehiculo.getModelo() + ", Tipo: " + nuevoVehiculo.getTipoVehiculo() + "\n");
                    vehiculosComboBox.addItem(nuevoVehiculo.getPlaca()); // Agregar la placa al ComboBox
                    placaField.setText("");
                    modeloField.setText("");
                    tipoVehiculoField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, complete los campos de Placa, Modelo y Tipo de Vehículo.");
                }
            }
        });

        verVehiculosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                informacionVehiculos.append("Vehículos en la flota:\n");
                for (Vehiculo vehiculo : flota) {
                    informacionVehiculos.append("Placa: " + vehiculo.getPlaca() + ", Modelo: " + vehiculo.getModelo() + ", Tipo: " + vehiculo.getTipoVehiculo() + "\n");
                }
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                informacionVehiculos.setText(""); // Limpiar el área de texto
            }
        });

        verUbicacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flota.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay vehículos en la flota.");
                } else {
                    int selectedIndex = vehiculosComboBox.getSelectedIndex();
                    if (selectedIndex >= 0) {
                        Vehiculo vehiculoSeleccionado = flota.get(selectedIndex);

                        Random random = new Random();
                        double latitud = -90 + (90 - (-90)) * random.nextDouble();
                        double longitud = -180 + (180 - (-180)) * random.nextDouble();
                        String ubicacionAleatoria = "Latitud: " + latitud + ", Longitud: " + longitud;

                        vehiculoSeleccionado.cambiarEstado(vehiculoSeleccionado.getEstado(), ubicacionAleatoria);

                        informacionVehiculos.append("Ubicación actual de " + vehiculoSeleccionado.getPlaca() + ": " + ubicacionAleatoria + "\n");
                    } else {
                        JOptionPane.showMessageDialog(null, "Seleccione un vehículo.");
                    }
                }
            }
        });
        asignarConductorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = vehiculosComboBox.getSelectedIndex();

                if (selectedIndex >= 0) {
                    Vehiculo vehiculoSeleccionado = flota.get(selectedIndex);

                    if (vehiculoSeleccionado.obtenerConductor() != null) {
                        JOptionPane.showMessageDialog(null, "El vehículo ya tiene un conductor asignado.");
                    } else {
                        Conductor.asignarConductorAVehiculo(flota);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un vehículo.");
                }
            }
        });


        setLayout(new FlowLayout());
        add(new JLabel("Placa del nuevo vehículo:"));
        add(placaField);
        add(new JLabel("Modelo del nuevo vehículo:"));
        add(modeloField);
        add(new JLabel("Tipo de vehículo:"));
        add(tipoVehiculoField);
        add(agregarVehiculoButton);
        add(verVehiculosButton);
        add(limpiarButton);
        add(new JLabel("Seleccionar vehículo:"));
        add(vehiculosComboBox);
        add(verUbicacionButton);
        add(asignarConductorButton);
        add(new JScrollPane(informacionVehiculos));

        setTitle("Flota de Vehículos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FlotaVehiculosGUI gui = new FlotaVehiculosGUI();
                gui.setVisible(true);
            }
        });
    }
}
