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
public class ModeloBase {
    private long id = 0;
    
    public ModeloBase(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
