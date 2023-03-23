package com.papcoportela.elco.pedidospro;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Paco Portela Henche
 * @date 21 mar 2023
 */
/**
     * Esta clase nos permite manejar a nuestro antojo la forma en como se
     * visualizan los datos en la JList 'jlListaPedidos'. Una instancia de esta
     * clase le serÃ¡ pasada a la JList a travÃ©s del mÃ©todo 'setCellRenderer(new
     * miListRenderer())'. Lo que hacemos es reescribir el mÃ©todo
     * 'getListCellRendererComponent' para adaptarlo a nuestras necesidades.
     */
    class MiListRenderer extends JLabel implements ListCellRenderer {

        /**
         * Constructor de la clase.
         */
        public MiListRenderer() {
            setOpaque(true);
            setHorizontalAlignment(LEFT);
            setVerticalAlignment(CENTER);
            setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 0));
        }

        @Override
        public Component getListCellRendererComponent(
                JList lista,
                Object valor,
                int indice,
                boolean estaSeleccionado,
                boolean celdaTieneFoco) {

            if (estaSeleccionado) {
                setBackground(Color.BLACK);
                setForeground(lista.getSelectionForeground());
            } else {
                setBackground(Color.BLACK);
                setForeground(lista.getForeground());
            }
            LineaPedido obj = (LineaPedido) valor;

            switch (obj.getEstadoPedido()) {
                case LineaPedido.ESTADO_PENDIENTE:
                    if (obj.getTipoPedido() == LineaPedido.TIPO_ALIMENTACION) {
                        setForeground(Color.ORANGE);
                        setText(obj.toString());
                    } else if (obj.getTipoPedido() == LineaPedido.TIPO_DROGUERIA) {
                        setForeground(Color.GREEN);
                        setText(obj.toString());
                    }
                    break;
                case LineaPedido.ESTADO_PEDIDO:
                    setForeground(Color.RED);
                    setText(obj.toString());
                    break;
                case LineaPedido.ESTADO_SELECCIONADO:
                    setForeground(Color.CYAN);
                    setText(obj.toString());
                    break;
                default:
                    setForeground(Color.LIGHT_GRAY);
                    setText(obj.toString());
                    break;
            }
            return this;
        }
    }

