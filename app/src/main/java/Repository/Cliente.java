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
public class Cliente extends ModeloBase {
    
    private static long GenIdCliente = 1000;
    
    private String ci = "";
    private String nombre = "";
    private int edad = 0;
    private String correo = "";
    
    public Cliente(String ci, String nombre, int edad, String email){
        super(GenIdCliente++);
        this.ci = ci;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = email;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    @Override
    public String toString(){
       return this.getId() + " ["+ this.ci + "] " + this.nombre + " (" + this.correo + ")"; 
    }
}
