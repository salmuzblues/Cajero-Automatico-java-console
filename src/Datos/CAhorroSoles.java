
package Datos;

import java.io.IOException;

public class CAhorroSoles extends DCuentas{
     private double doubCantCAhorroSoles;
   

    public CAhorroSoles(String Tipo) throws IOException {
        setBase("AhorroSoles");
        RegistrarDatos Reg = new RegistrarDatos(getBase());
        setIdcuenta(Reg.ContarRegistros() + 1); 
        setFec_in(FechaActual());
    }
    
      public double getDoubCantCAhorroSoles() {
        return doubCantCAhorroSoles;
    }

    public void setDoubCantCAhorroSoles(double doubCantCAhorroSoles) {
        this.doubCantCAhorroSoles = doubCantCAhorroSoles;
    }
    
      // Registrar Cuentas.
       public void RegistrarCuentaSoles() throws IOException{
        RegistrarDatos Reg = new RegistrarDatos(getBase());
        String Cadena = "|" + getIdcuenta() +"|" + String.valueOf(getDoubCantCAhorroSoles()) +"|" + getFec_in() + "|";
        Reg.RegistrarFila(Cadena);
    }
       
    
}