
package Datos;

import static Datos.DCuentas.FechaActual;
import java.io.IOException;

public class CAhorroDolares extends DCuentas{
     private int intCantAhorroDolares;
    
     
      public CAhorroDolares(String Tipo) throws IOException {
        setBase("AhorroDolares");
        RegistrarDatos Reg = new RegistrarDatos(getBase());
        setIdcuenta(Reg.ContarRegistros()); 
        setFec_in(FechaActual());
    }
    public int getIntCantAhorroDolares() {
        return intCantAhorroDolares;
    }

    public void setIntCantAhorroDolares(int intCantAhorroDolares) {
        this.intCantAhorroDolares = intCantAhorroDolares;
    }
     
     
}
