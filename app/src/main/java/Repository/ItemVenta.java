/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.modelo;

import carrito.modelo.Producto;

/**
 *
 * @author Arnaldo
 */
class ItemVenta {
    private Producto producto = null;
    private int cantidad = 0;
    private double precioVenta = 0;
    private double parcial = 0;
    
    public ItemVenta(Producto p, int cant, double precio, double parcial){
        this.producto = p;
        this.cantidad = cant;
        this.precioVenta = precio;
        this.parcial = parcial;
    }
    
}
