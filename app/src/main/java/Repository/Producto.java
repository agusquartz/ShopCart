/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.modelo;

/**
 *
 * @author Arnaldo
 */
public class Producto extends ModeloBase implements Comparable<Producto> {
    private static long GenIdProducto = 100;
    
    private int codigo = 0;
    private String descripcion = null;
    private double precio = 0.0;
    
    
    public Producto(int codigo, String desc, double precio) {
        super(GenIdProducto++);
        this.codigo = codigo;
        this.descripcion = desc;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString(){
       return this.getId() + " ["+ this.codigo + "] " + this.descripcion + " (" + this.precio + ")"; 
    }
    
    @Override
    public boolean equals(Object o){
        return this.getCodigo() == ((Producto)o).getCodigo();
    }

    @Override
    public int compareTo(Producto o) {
        //return this.descripcion.compareTo(o.getDescripcion());
        return (int)(o.precio - this.precio);
        
        /*if(this.precio < o.precio) {return -1;}
        else if(this.precio == o.precio) {return 0;}
        else { return 1;}*/
    }

    
}
