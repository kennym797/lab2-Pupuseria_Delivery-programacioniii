package vista;

import interfaces.Imprimible;
import modelo.Bebida;
import modelo.Pedido;
import modelo.Producto;
import modelo.Pupusa;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Ventana principal de la aplicación Pupusería Delivery (Interfaz gráfica Swing).
 * Se integra con las clases del paquete modelo (Pupusa, Bebida, Pedido) e interfaces (Imprimible).
 */
public class VentanaPupuseria extends JFrame {

    private Pedido pedidoActual;
    private int siguienteId = 1;

    // Campos de texto para Pupusa
    private JTextField txtRellenoPupusa;
    private JTextField txtMasaPupusa;
    private JTextField txtPrecioPupusa;
    private JTextField txtCantidadPupusa;
    private JButton btnAgregarPupusa;

    // Campos de texto y controles para Bebida
    private JTextField txtNombreBebida;
    private JTextField txtTamanoBebida;
    private JTextField txtPrecioBebida;
    private JTextField txtCantidadBebida;
    private JCheckBox chkEsFria;
    private JButton btnAgregarBebida;

    // Área de resumen del pedido y botones principales
    private JTextArea txtResumenPedido;
    private JLabel lblTotal;
    private JButton btnGenerarTicket;
    private JButton btnNuevoPedido;

    public VentanaPupuseria() {
        this.pedidoActual = new Pedido();
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Pupusería Delivery - Registro de Pedidos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 520);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Encabezado
        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelTitulo.setBorder(new EmptyBorder(10, 10, 0, 10));
        JLabel lblTitulo = new JLabel("SISTEMA DE GESTIÓN DE PEDIDOS - PUPUSERÍA");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);

        // Panel central dividido en Formularios (izquierda) y Resumen (derecha)
        JPanel panelCentral = new JPanel(new GridLayout(1, 2, 12, 10));
        panelCentral.setBorder(new EmptyBorder(5, 12, 5, 12));

        // Pestañas para los formularios de Pupusa y Bebida
        JTabbedPane pestanasFormulario = new JTabbedPane();
        pestanasFormulario.addTab("Registrar Pupusa", crearPanelFormularioPupusa());
        pestanasFormulario.addTab("Registrar Bebida", crearPanelFormularioBebida());
        panelCentral.add(pestanasFormulario);

        // Panel derecho: Resumen del pedido actual
        panelCentral.add(crearPanelResumen());
        add(panelCentral, BorderLayout.CENTER);

        // Panel inferior: Botones de acción del pedido
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 10));
        btnNuevoPedido = new JButton("Nuevo Pedido");
        btnGenerarTicket = new JButton("Generar Ticket");

        btnNuevoPedido.addActionListener(e -> limpiarPedido());
        btnGenerarTicket.addActionListener(e -> mostrarTicket());

        panelInferior.add(btnNuevoPedido);
        panelInferior.add(btnGenerarTicket);
        add(panelInferior, BorderLayout.SOUTH);
    }

    private JPanel crearPanelFormularioPupusa() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(12, 12, 12, 12));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtRellenoPupusa = new JTextField(15);
        txtMasaPupusa = new JTextField(15);
        txtPrecioPupusa = new JTextField(15);
        txtCantidadPupusa = new JTextField("1", 15);
        btnAgregarPupusa = new JButton("Agregar Pupusa");

        agregarFilaFormulario(panel, gbc, 0, "Relleno (ej. Revuelta, Loroco):", txtRellenoPupusa);
        agregarFilaFormulario(panel, gbc, 1, "Tipo de Masa (Maíz / Arroz):", txtMasaPupusa);
        agregarFilaFormulario(panel, gbc, 2, "Precio Unitario ($):", txtPrecioPupusa);
        agregarFilaFormulario(panel, gbc, 3, "Cantidad:", txtCantidadPupusa);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(14, 6, 6, 6);
        btnAgregarPupusa.addActionListener(e -> registrarPupusa());
        panel.add(btnAgregarPupusa, gbc);

        return panel;
    }

    private JPanel crearPanelFormularioBebida() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(12, 12, 12, 12));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtNombreBebida = new JTextField(15);
        txtTamanoBebida = new JTextField(15);
        txtPrecioBebida = new JTextField(15);
        txtCantidadBebida = new JTextField("1", 15);
        chkEsFria = new JCheckBox("Bebida Helada / Fría", true);
        btnAgregarBebida = new JButton("Agregar Bebida");

        agregarFilaFormulario(panel, gbc, 0, "Nombre (ej. Horchata, Café):", txtNombreBebida);
        agregarFilaFormulario(panel, gbc, 1, "Tamaño (Mediano / Grande):", txtTamanoBebida);
        agregarFilaFormulario(panel, gbc, 2, "Precio Unitario ($):", txtPrecioBebida);
        agregarFilaFormulario(panel, gbc, 3, "Cantidad:", txtCantidadBebida);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(chkEsFria, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(14, 6, 6, 6);
        btnAgregarBebida.addActionListener(e -> registrarBebida());
        panel.add(btnAgregarBebida, gbc);

        return panel;
    }

    private JPanel crearPanelResumen() {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(new TitledBorder("Detalle del Pedido Actual"));

        txtResumenPedido = new JTextArea();
        txtResumenPedido.setEditable(false);
        txtResumenPedido.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtResumenPedido.setText("No hay productos agregados aún.\n");

        JScrollPane scroll = new JScrollPane(txtResumenPedido);
        panel.add(scroll, BorderLayout.CENTER);

        lblTotal = new JLabel("Total a pagar: $0.00", SwingConstants.RIGHT);
        lblTotal.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblTotal.setBorder(new EmptyBorder(4, 6, 4, 6));
        panel.add(lblTotal, BorderLayout.SOUTH);

        return panel;
    }

    private void agregarFilaFormulario(JPanel panel, GridBagConstraints gbc, int fila, String etiqueta, JTextField campo) {
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.gridwidth = 1;
        gbc.weightx = 0.4;
        panel.add(new JLabel(etiqueta), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.6;
        panel.add(campo, gbc);
    }

    private void registrarPupusa() {
        String relleno = txtRellenoPupusa.getText().trim();
        String masa = txtMasaPupusa.getText().trim();
        String precioStr = txtPrecioPupusa.getText().trim();
        String cantidadStr = txtCantidadPupusa.getText().trim();

        if (relleno.isEmpty() || masa.isEmpty() || precioStr.isEmpty() || cantidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, completa todos los campos de la pupusa.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        try {
            double precio = Double.parseDouble(precioStr);
            int cantidad = Integer.parseInt(cantidadStr);

            if (precio <= 0 || cantidad <= 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "El precio y la cantidad deben ser mayores que cero.",
                        "Valores inválidos",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            Producto pupusa = new Pupusa(siguienteId++, relleno, masa, precio);
            if (cantidad == 1) {
                pedidoActual.agregarProducto(pupusa);
            } else {
                pedidoActual.agregarProducto(pupusa, cantidad);
            }

            actualizarResumen();
            limpiarCamposPupusa();

            JOptionPane.showMessageDialog(
                    this,
                    "Se agregó al pedido: " + cantidad + "x " + pupusa.getNombre(),
                    "Producto registrado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingresa valores numéricos válidos para el precio y la cantidad.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void registrarBebida() {
        String nombre = txtNombreBebida.getText().trim();
        String tamano = txtTamanoBebida.getText().trim();
        String precioStr = txtPrecioBebida.getText().trim();
        String cantidadStr = txtCantidadBebida.getText().trim();
        boolean esFria = chkEsFria.isSelected();

        if (nombre.isEmpty() || tamano.isEmpty() || precioStr.isEmpty() || cantidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, completa todos los campos de la bebida.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        try {
            double precio = Double.parseDouble(precioStr);
            int cantidad = Integer.parseInt(cantidadStr);

            if (precio <= 0 || cantidad <= 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "El precio y la cantidad deben ser mayores que cero.",
                        "Valores inválidos",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            Producto bebida = new Bebida(siguienteId++, nombre, precio, tamano, esFria);
            if (cantidad == 1) {
                pedidoActual.agregarProducto(bebida);
            } else {
                pedidoActual.agregarProducto(bebida, cantidad);
            }

            actualizarResumen();
            limpiarCamposBebida();

            JOptionPane.showMessageDialog(
                    this,
                    "Se agregó al pedido: " + cantidad + "x " + bebida.getNombre(),
                    "Producto registrado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingresa valores numéricos válidos para el precio y la cantidad.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void actualizarResumen() {
        if (pedidoActual.getListaProductos().isEmpty()) {
            txtResumenPedido.setText("No hay productos agregados aún.\n");
            lblTotal.setText("Total a pagar: $0.00");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Producto p : pedidoActual.getListaProductos()) {
            sb.append("• ").append(p.toString()).append("\n");
        }
        txtResumenPedido.setText(sb.toString());
        lblTotal.setText(String.format("Total a pagar: $%.2f", pedidoActual.calcularTotalPedido()));
    }

    private void mostrarTicket() {
        if (pedidoActual.getListaProductos().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "El pedido está vacío. Agrega al menos un producto para generar el ticket.",
                    "Pedido vacío",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (pedidoActual instanceof Imprimible) {
            String ticket = pedidoActual.generarTicket();
            JTextArea areaTicket = new JTextArea(ticket);
            areaTicket.setEditable(false);
            areaTicket.setFont(new Font("Monospaced", Font.PLAIN, 12));
            JOptionPane.showMessageDialog(
                    this,
                    new JScrollPane(areaTicket),
                    "Ticket de Compra",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void limpiarPedido() {
        if (pedidoActual.getListaProductos().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "El pedido ya se encuentra vacío.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Deseas reiniciar el pedido actual y borrar los productos agregados?",
                "Confirmar nuevo pedido",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            pedidoActual = new Pedido();
            siguienteId = 1;
            actualizarResumen();
            JOptionPane.showMessageDialog(
                    this,
                    "Se ha iniciado un nuevo pedido.",
                    "Pedido reiniciado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void limpiarCamposPupusa() {
        txtRellenoPupusa.setText("");
        txtMasaPupusa.setText("");
        txtPrecioPupusa.setText("");
        txtCantidadPupusa.setText("1");
        txtRellenoPupusa.requestFocus();
    }

    private void limpiarCamposBebida() {
        txtNombreBebida.setText("");
        txtTamanoBebida.setText("");
        txtPrecioBebida.setText("");
        txtCantidadBebida.setText("1");
        chkEsFria.setSelected(true);
        txtNombreBebida.requestFocus();
    }
}
