package com.papcoportela.elco.pedidospro;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Paco Portela Henche
 * @date 18 mar 2023
 * Esta clase crea la interfaz que va a utilizar el usuario.
 */
public class Interfaz extends javax.swing.JFrame {
    private  Pedidos pedidos;

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        initOtros();
        situarVentana();
        ponerIcono();
        this.pedidos = new Pedidos();
        this.comprobarArchivoDatos();
        this.cargarDatos();
    }
    
    private void initOtros(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent ev) {
                textIntroducirPedido.requestFocusInWindow();
            }

            @Override
            public void windowClosing(WindowEvent ev) {
                salir();
            }
        });

        this.listadoPedidos.setCellRenderer(new MiListRenderer());
    }
    
    private void situarVentana(){
        // coloco la ventana en la parte inferior derecha de la pantalla.
        int altoPantalla = 
                java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        int anchoPantalla = 
                java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        Dimension d = this.getPreferredSize();
        int altoPedido = d.height;
        int anchoPedido = d.width;
        this.setLocation(anchoPantalla-anchoPedido, altoPantalla-altoPedido);

    }
    
    private void ponerIcono(){
        URL url = this.getClass().getResource("/recursos/elco.png");
        if(url != null){
            ImageIcon imagen = new ImageIcon(url);
            this.setIconImage(imagen.getImage());
        }
    }
    
    public int salir(){
        this.guardarDatos();
        System.exit(0);
        return 0;
    }
    
    private void comprobarArchivoDatos(){
        File fichero = new File("datos/pedidos.xml");
        if (!fichero.exists()) {
            try {
                File f = new File("datos");
                f.mkdirs();
                fichero.createNewFile();
            } catch (java.io.IOException ex) {
                JOptionPane.
                        showMessageDialog(this, ex.toString());
            }
        }
    }
    
    private void cargarDatos(){
        try
        {
            File ficheroDatos = new File("datos/pedidos.xml");
            if(ficheroDatos.length() == 0) return;
            JAXBContext jaxbContext = JAXBContext.newInstance(Pedidos.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            pedidos = (Pedidos)jaxbUnmarshaller.unmarshal(ficheroDatos);
            if(this.pedidos.getPedidos() != null){
                this.listadoPedidos.
                    setListData(this.pedidos.getPedidos()
                    .toArray(new LineaPedido[0]));
            }
        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }
    }
    
    private void guardarDatos(){
        if(this.pedidos.getPedidos() == null) return;
        try
        {
            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance(Pedidos.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
            this.eliminarPedidosRecibidos();
            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal(pedidos, new File("datos/pedidos.xml"));
            //jaxbMarshaller.marshal(pedidos, System.out);

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }
    
    private void eliminarPedidosRecibidos(){
        for(int i = 0; i < this.pedidos.getPedidos().size(); i++){
            LineaPedido linea = this.pedidos.getPedidos().get(i);
            if(linea.getEstadoPedido() == LineaPedido.ESTADO_RECIBIDO){
                this.pedidos.getPedidos().remove(i);
                i--;
            }
        }
    }
    
    private void verPedidosDeTipo(int tipo) {
        LineaPedido linea;
        //si queremos ver todos los pedidos pasamos un argumento -1.
        if (tipo == -1) {
            for (int i = 0; i < this.pedidos.getPedidos().size(); i++) {
                linea = this.pedidos.getPedidos().get(i);
                linea.setVisible(true);
            }

        } else {
            /* hacemos visibles las lineas de pedido que corresponden con el
            tipo que hemos seleccionado (alimentacion o drogueri­a) y el 
            resto de las lineas invisibles. Esto influira en la forma en la
            que las lineas de pedido se visualizaran en la lista de pedidos.
            Ver el metodo 'toString()' de la clase 'LineaPedido'*/
            for (int i = 0; i < this.pedidos.getPedidos().size(); i++) {
                linea = this.pedidos.getPedidos().get(i);
                if (linea.getTipoPedido() == tipo) {
                    linea.setVisible(true);
                } else {
                    linea.setVisible(false);
                }
            }
        }
        this.actualizarDatos();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listadoPedidos = new javax.swing.JList<>();
        comboTipoPedido = new javax.swing.JComboBox<>();
        textIntroducirPedido = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFichero = new javax.swing.JMenu();
        menuItemSalir = new javax.swing.JMenuItem();
        menuUtilidades = new javax.swing.JMenu();
        menuItemCorreo = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        menuItemAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PEDIDOS");
        setAlwaysOnTop(true);

        listadoPedidos.setBackground(new java.awt.Color(0, 0, 0));
        listadoPedidos.setForeground(new java.awt.Color(0, 0, 0));
        listadoPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listadoPedidosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(listadoPedidos);

        comboTipoPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alimentación", "Droguería", "Todos" }));
        comboTipoPedido.setToolTipText("Tipo de pedido");
        comboTipoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoPedidoActionPerformed(evt);
            }
        });

        textIntroducirPedido.setText("Escribir aquí el artículo a pedir");
        textIntroducirPedido.setToolTipText("");
        textIntroducirPedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textIntroducirPedidoFocusGained(evt);
            }
        });
        textIntroducirPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textIntroducirPedidoKeyPressed(evt);
            }
        });

        menuFichero.setText("Fichero");

        menuItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        menuFichero.add(menuItemSalir);

        jMenuBar1.add(menuFichero);

        menuUtilidades.setText("Utilidades");

        menuItemCorreo.setText("Correo");
        menuItemCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCorreoActionPerformed(evt);
            }
        });
        menuUtilidades.add(menuItemCorreo);

        jMenuBar1.add(menuUtilidades);

        menuAyuda.setText("Ayuda");

        menuItemAyuda.setText("Ayuda");
        menuItemAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAyudaActionPerformed(evt);
            }
        });
        menuAyuda.add(menuItemAyuda);

        jMenuBar1.add(menuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboTipoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textIntroducirPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textIntroducirPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        this.salir();
    }//GEN-LAST:event_menuItemSalirActionPerformed

    private void comboTipoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoPedidoActionPerformed
        int indice = this.comboTipoPedido.getSelectedIndex();
        switch (indice) {
            case 0 -> this.verPedidosDeTipo(LineaPedido.TIPO_ALIMENTACION);
            case 1 -> this.verPedidosDeTipo(LineaPedido.TIPO_DROGUERIA);
            default -> this.verPedidosDeTipo(-1);
        }
    }//GEN-LAST:event_comboTipoPedidoActionPerformed

    private void textIntroducirPedidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textIntroducirPedidoFocusGained
        this.textIntroducirPedido.selectAll();
    }//GEN-LAST:event_textIntroducirPedidoFocusGained

    private void textIntroducirPedidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textIntroducirPedidoKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            this.addArticulo();
        }
    }//GEN-LAST:event_textIntroducirPedidoKeyPressed

    private void listadoPedidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listadoPedidosMousePressed
        int ind = this.listadoPedidos.getSelectedIndex();
        if (ind != -1) {
            LineaPedido lineaSeleccionada = this.listadoPedidos.getSelectedValue();
            int botonPulsado = evt.getButton();
            if(botonPulsado == MouseEvent.BUTTON1){
                lineaSeleccionada.cambiarEstadoPedido();
            }
            else if(botonPulsado == MouseEvent.BUTTON3){
                lineaSeleccionada.setEstadoPedido(LineaPedido.ESTADO_SELECCIONADO);
            }
            this.listadoPedidos.repaint();
            this.textIntroducirPedido.requestFocusInWindow();
        }
    }//GEN-LAST:event_listadoPedidosMousePressed

    private void menuItemAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAyudaActionPerformed
        new Ayuda();
    }//GEN-LAST:event_menuItemAyudaActionPerformed

    private void menuItemCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCorreoActionPerformed
        if(this.pedidos.getPedidos() == null){
            JOptionPane.showMessageDialog(this, "No hay articulos para pedir",
                    "Sin pedidos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        enviarCorreo();
    }//GEN-LAST:event_menuItemCorreoActionPerformed

    private void enviarCorreo(){
        new EnviarEmail(this.pedidos.getPedidos()).setVisible(true);
    }
    
    private void addArticulo() {
        String texto = this.textIntroducirPedido.getText();
        LineaPedido nuevaLinea = new LineaPedido();
        if(texto.length() > 0){
            texto = comprobarCantidad(texto);
            nuevaLinea.setTextoPedido(texto.toUpperCase());
            int indiceCombo = this.comboTipoPedido.getSelectedIndex();
            switch (indiceCombo) {
                case 0 -> {
                    nuevaLinea.setTipoPedido(LineaPedido.TIPO_ALIMENTACION);
                    this.pedidos.add(nuevaLinea);
                }
                case 1 -> {
                    nuevaLinea.setTipoPedido(LineaPedido.TIPO_DROGUERIA);
                    this.pedidos.add(nuevaLinea);
                }
                default -> JOptionPane.showMessageDialog
                            (this,
                             "Seleccione el tipo de pedido en el combo box",
                             "AVISO", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        actualizarDatos();
    }
    
    private void actualizarDatos(){
        Collections.sort(this.pedidos.getPedidos());
        this.listadoPedidos.
                    setListData(this.pedidos.getPedidos()
                    .toArray(new LineaPedido[0]));
        this.listadoPedidos.repaint();
        this.textIntroducirPedido.selectAll();
    }
    
    private String comprobarCantidad(String texto){
        if(texto.charAt(0) < '1' || texto.charAt(0) > '9'){
            texto = "1-" + texto;
        }
        return texto;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboTipoPedido;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<LineaPedido> listadoPedidos;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuFichero;
    private javax.swing.JMenuItem menuItemAyuda;
    private javax.swing.JMenuItem menuItemCorreo;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenu menuUtilidades;
    private javax.swing.JTextField textIntroducirPedido;
    // End of variables declaration//GEN-END:variables

    
}
