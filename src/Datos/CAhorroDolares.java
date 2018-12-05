
package Datos;

import static Datos.DCuentas.FechaActual;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
     
      // Registrar Cuentas.
       public void RegistrarCuentaDolares() throws IOException{
        RegistrarDatos Reg = new RegistrarDatos(getBase());
        String Cadena = "|" + getIdcuenta() +"|" + getIntCantAhorroDolares()+"|" + getFec_in() + "|";
        Reg.RegistrarFila(Cadena);
           System.out.println("Registro Guardado");
    }
     // Depositar
       public void DepositoDolares(String id, int cantIn){
           String oldContent ="";
        try{
          RegistrarDatos Reg = new RegistrarDatos(getBase());
          String registroLinea = Reg.EncontrarCadena(id);
          // llamando al archivo y una condicion si existe o no existe.  
          File infile = new File("/BaseDatos/" + getBase() + ".txt");   
          if (!infile.isFile())
          System.out.println("No existe el Archivo ");
          // Obtener la lectura en la base de datos. 
          BufferedReader br= new BufferedReader(new FileReader("/BaseDatos/" + getBase() + ".txt"));
           //Reading all the lines of input text file into oldContent
          //leyendo todas las lineas de archivo de texto de entraas dentro de oldContent   
            String line = br.readLine();
               while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = br.readLine();
            }
         
              String montOld = registroLinea.substring(3,7);
              int montoDeposi = cantIn + Integer.parseInt(montOld);
              String fechaAct = getFec_in();
             
              String newString = "|" + id +"|"+ montoDeposi+"|"+ fechaAct + "|";
                            
            // Remplazando el viejo String con el nuevo dentro del oldContent. 
            String newContent = oldContent.replace(registroLinea, newString);
            
            FileWriter writer = new FileWriter(infile);
            writer.write(newContent);
            
            br.close();
            writer.close();
        }catch (FileNotFoundException ex){
            System.out.println(ex);
        }  catch (IOException | NumberFormatException e) {
            System.out.println(e.toString());
        }
      }
       //RETIRO
       public void retiroDolares(String id, int cantIn) {
             String oldContent ="";
        try{
          RegistrarDatos Reg = new RegistrarDatos(getBase());
          String registroLinea = Reg.EncontrarCadena(id);
          // llamando al archivo y una condicion si existe o no existe.  
          File infile = new File("/BaseDatos/" + getBase() + ".txt");   
          if (!infile.isFile())
          System.out.println("No existe el Archivo ");
          // Obtener la lectura en la base de datos. 
          BufferedReader br= new BufferedReader(new FileReader("/BaseDatos/" + getBase() + ".txt"));
           //Reading all the lines of input text file into oldContent
          //leyendo todas las lineas de archivo de texto de entraas dentro de oldContent   
            String line = br.readLine();
               while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = br.readLine();
            }
         
              String montOld = registroLinea.substring(3,7);
              int montoDeposi = Integer.parseInt(montOld) - cantIn;
              String fechaAct = getFec_in();
             
              String newString = "|" + id +"|"+ montoDeposi+"|"+ fechaAct + "|";
                            
            // Remplazando el viejo String con el nuevo dentro del oldContent. 
            String newContent = oldContent.replace(registroLinea, newString);
            
            FileWriter writer = new FileWriter(infile);
            writer.write(newContent);
            
            br.close();
            writer.close();
        }catch (FileNotFoundException ex){
            System.out.println(ex);
        }  catch (IOException | NumberFormatException e) {
            System.out.println(e.toString());
        }
           
       }
     
}
