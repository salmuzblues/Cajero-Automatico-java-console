
package Datos;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class DCuentas {
    
    private int idcuenta;
    private double doubCantAhorroSoles;
    private double doubCantCorrienteSoles;
    private double doubCantAhorroDolares;
    private double doubCantCorrienteDolares;
    private String Nombre;
    private String Descripcion;
    private String moneda;
    private String Base;

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        Scanner sc = new Scanner(System.in);
        while(Nombre.compareTo("")==0)
        {
            System.out.println("---Nombre vacío\nIngrese Nombre de cuenta: ");
            Nombre = sc.next();
        }
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        Scanner sc = new Scanner(System.in);
        while(Descripcion.compareTo("")==0)
        {
            System.out.println("---Descripción vacía\nIngrese descripcion de cuenta: ");
            Descripcion = sc.next();
        }
        this.Descripcion = Descripcion;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getBase() {
        return Base;
    }

    public void setBase(String Base) {
        this.Base = Base;
    }

    public double getDoubCantAhorroSoles() {
        return doubCantAhorroSoles;
    }

    public void setDoubCantAhorroSoles(double doubCantAhorroSoles) {
        this.doubCantAhorroSoles = doubCantAhorroSoles;
    }

    public double getDoubCantCorrienteSoles() {
        return doubCantCorrienteSoles;
    }

    public void setDoubCantCorrienteSoles(double doubCantCorrienteSoles) {
        this.doubCantCorrienteSoles = doubCantCorrienteSoles;
    }

    public double getDoubCantAhorroDolares() {
        return doubCantAhorroDolares;
    }

    public void setDoubCantAhorroDolares(double doubCantAhorroDolares) {
        this.doubCantAhorroDolares = doubCantAhorroDolares;
    }

    public double getDoubCantCorrienteDolares() {
        return doubCantCorrienteDolares;
    }

    public void setDoubCantCorrienteDolares(double doubCantCorrienteDolares) {
        this.doubCantCorrienteDolares = doubCantCorrienteDolares;
    }
    
    
    
      
    
}