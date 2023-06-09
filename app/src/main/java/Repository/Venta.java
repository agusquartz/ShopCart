/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Arnaldo
 */
public class Venta {
    private List<ItemVenta> items = null;
    private Cliente cliente = null;
    private String fecha = null;
    private int monto = 0;
    
    public Venta(Cliente cliente, String fecha, int total){
        this.items = new ArrayList<>();
        this.cliente = cliente;
        this.fecha = fecha;
        this.monto = total;
        
        
    } 
    
    public void addItem(ItemVenta item){
        this.items.add(item);
    }
    
    
    
    public List<ItemVenta> getItems(){
        return this.items;
    }
    
    public void setItems(List<ItemVenta> nuevosItems){
        this.items = nuevosItems;
    }
    
    @Override
    public String toString(){
        return this.cliente + " Gs." + this.monto; 
    }
    
}
