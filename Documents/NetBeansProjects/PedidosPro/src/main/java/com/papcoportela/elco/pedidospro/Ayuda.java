
package com.papcoportela.elco.pedidospro;

import javax.swing.JOptionPane;

/**
 *
 * @author Paco Portela Henche
 * @date 21 mar 2023
 * Esta clase presenta una ayuda de como utilizar la aplicacion al usuario.
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
                + "<li>Pulse <b>ENTER.</b>"
                + "</li></ol></font>"
                + "<div align=center><h2>Visualizacion "
                + "de pedidos por tipo</h2></div>"
                + "<font size=4><ol><li>Seleccione el tipo en el comboBox.</b>"
                + "</li></ol></font>"
                + "<div align=center><h2>Mecanica de trabajo</h2></div>"
                + "<font size=4>Para utilizar correctamente la funcionalidad "
                + "del envio del pedido por correo electronico la forma de "
                + "escribir el pedido es importante.<br> Primero tecleamos la "
                + "cantidad de cajas que queremos del producto,<br> luego "
                + "tecleamos un guion - y a continuacion el producto a pedir. "
                + "Cuando enviemos el pedido por correo el programa separa "
                + "<br>por el guion la cantidad y el nombre del producto y lo "
                + "envia en una tabla al proveedor."
                + "<br> Si no introducimos ninguna "
                + "cantidad el programa incluye 1 caja por defecto."
                + "<br>Cuando haya introducido las lineas de pedido "
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
                + "<b>GRIS</b> no se grabaran.</font>"
                + "<div align=center><h2>Envio por correo electronico</h2></div>"
                + "<font size=4>Seleccione los articulos que quiera enviar por"
                + " correo electronico pinchando primero con el boton<br>"
                + "izquierdo del raton y luego con el derecho. El articulo"
                + " cambiara su color a azul claro.<br> Una vez que haya "
                + "seleccionado todos los articulos, pulse en el menu "
                + "<b>Utilidades</b> y luego en <b>Correo</b>.<br> Escriba la "
                + "direccion a quien lo quiere enviar y pulse <b>Aceptar.</b>"
                + "</body></html>";
        
        JOptionPane.showMessageDialog(null, textoAyuda, "AYUDA",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
