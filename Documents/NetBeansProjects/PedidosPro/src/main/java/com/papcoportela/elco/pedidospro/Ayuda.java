
package com.papcoportela.elco.pedidospro;

import javax.swing.JOptionPane;

/**
 *
 * @author Paco Portela Henche
 * @date 21 mar 2023
 */
public class Ayuda {
    public Ayuda(){
        String textoAyuda = "<html><head></head><body>"
                + "<div align=center><h1><b><u>FUNCIONAMIENTO DEL PROGRAMA"
                + "</u></b></h1></div>"
                + "<div align=center>"
                + "<h2>Seleccion del tipo de pedido</h2></div>"
                + "<font size=4><ol><li>Seleccione el tipo de pedido que "
                + "quiere introducir (alimentacion o drogueria).</li>"
                + "<li>Introduzca el texto en el campo de texto.</li>"
                + "<li>Pulse <b>ENTER</b>"
                + "</li></ol></font>"
                + "<div align=center><h2>Visualizacion "
                + "de pedidos por tipo</h2></div>"
                + "<font size=4><ol><li>Seleccione el tipo en el comboBox</b>"
                + "</li></ol></font>"
                + "<div align=center><h2>Mecanica de trabajo</h2></div>"
                + "<font size=4>Cuando haya introducido las lineas de pedido "
                + "vera que cada tipo de pedido tiene un color predefinido; "
                + "<br><b>NARANJA</b> los de alimentacion y <b>VERDE</b>"
                + " los de drogueria.<br> Si pulsa en alguna de"
                + " las lineas el color"
                + " del pedido cambiara a <b>ROJO</b>,"
                + " lo que indica que ya ha "
                + "sido pedido.<br> Si volvemos a pulsar "
                + "otra vez el color pasara a"
                + " ser <b>GRIS</b> lo que significa que ya hemos recibido la "
                + "mercancia.<br> Cuando salgamos del "
                + "programa las lineas en color "
                + "<b>GRIS</b> no se grabaran.</font></body></html>";
        
        JOptionPane.showMessageDialog(null, textoAyuda, "AYUDA",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
