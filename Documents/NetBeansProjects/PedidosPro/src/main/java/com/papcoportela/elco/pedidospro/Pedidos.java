package com.papcoportela.elco.pedidospro;


/**
 *
 * @author Paco Portela Henche
 * @date 18 mar 2023
 * Esta clase representa la lista de pedidos que usaremos en la aplicacion.
 * Utilizamos las anotaciones de la API JABX para poder trabajar con datos
 * en formato XML de forma sencilla.
 */
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Pedidos")
public class Pedidos {
    private List<LineaPedido> listaPedidos;
    
    public List<LineaPedido> getPedidos(){
        return this.listaPedidos;
    }
    
    @XmlElement(name = "Linea")
    public void setPedidos(List<LineaPedido> lista){
        this.listaPedidos = lista;
    }
    
    public void add(LineaPedido linea){
        if(this.listaPedidos == null){
            this.listaPedidos = new ArrayList<>();
        }
        this.listaPedidos.add(linea);
    }
    
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        for( LineaPedido linea : this.listaPedidos )
        {
            str.append( linea.toString() );
        }
        return str.toString();
    }

}
