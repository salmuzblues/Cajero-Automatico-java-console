
package Datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;


public class DPersona {
    private int id;
    private String Contrasena;
    private String Nombre;
    private String Apellidos;
    private String DNI;
    private String fec_in;
    private String fec_out;
    private String Base;
    
    //
        public DPersona(String Tipo) throws IOException {
        this.Base = "Persona";
        RegistrarDatos Reg = new RegistrarDatos(this.Base);
        this.id = Reg.ContarRegistros() + 1;
        this.fec_in=FechaActual();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) throws IOException {
               Scanner sc = new Scanner(System.in);
        RegistrarDatos Reg = new RegistrarDatos(this.Base);
            while(Reg.BuscarCadena(Contrasena) || ((Contrasena.length()!=4 || esNumero(Contrasena)==false) && Contrasena.length()!=0) ){
                if (Reg.BuscarCadena(Contrasena))
                    System.out.println("---Ya existe\nIngrese otra CONTRASEÑA: ");
                else if((Contrasena.length()!=4 || esNumero(Contrasena)==false) && Contrasena.length()!=0)
                    System.out.println("---Dato incorrecto\nIngrese 4 numeros para su CONTRASEÑA: ");
                this.Contrasena = sc.next();
            }
    
        this.Contrasena = Contrasena;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        Scanner sc = new Scanner(System.in);
        while(Nombre.compareTo("")==0)
        {
            System.out.println("---Nombre vacío\nIngrese Nombre: ");
            Nombre = sc.next();
        }
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
                Scanner sc = new Scanner(System.in);
        while(Apellidos.compareTo("")==0)
        {
            System.out.println("---Apellidos vacío\nIngrese Apellido: ");
            Apellidos = sc.next();
        }
        this.Apellidos = Apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) throws IOException {
                Scanner sc = new Scanner(System.in);
        RegistrarDatos Reg = new RegistrarDatos(this.Base);
            while(Reg.BuscarCadena(DNI) || ((DNI.length()!=8 || esNumero(DNI)==false) && DNI.length()!=0) ){
                if (Reg.BuscarCadena(DNI))
                    System.out.println("---Ya existe\nIngrese DNI: ");
                else if((DNI.length()!=8 || esNumero(DNI)==false) && DNI.length()!=0)
                    System.out.println("---Dato incorrecto\nIngrese DNI: ");
                DNI = sc.next();
            }
        this.DNI = DNI;
    }

    public String getFec_in() {
        return fec_in;
    }

    public void setFec_in(String fec_in) {
        this.fec_in = fec_in;
    }

    public String getFec_out() {
        return fec_out;
    }

    public void setFec_out(String fec_out) {
        this.fec_out = fec_out;
    }
    
    
        public void RegistrarPersona() throws IOException{
        RegistrarDatos Reg = new RegistrarDatos(this.Base);
        String Cadena = "|" + this.id +"|" + this.Nombre +"|" + this.Apellidos + "|" + this.DNI + 
                "|"  + this.Contrasena + "|" + this.fec_in + "|" + this.fec_out+ "|";
        Reg.RegistrarFila(Cadena);
    }
    
        
        
    public void eliminarRegistro (String id ) throws IOException{
        
        try{
          RegistrarDatos Reg = new RegistrarDatos(this.Base);
          String registroLinea = Reg.EncontrarCadena(id);
          
         // llamando al archivo y una condicion si existe o no existe.  
         File infile = new File("/BaseDatos/" + this.Base + ".txt");   
         if (!infile.isFile())
            System.out.println("No existe el Archivo ");
         
        // Obtener la lectura en la base de datos. 
        BufferedReader br= new BufferedReader(new FileReader("/BaseDatos/" + this.Base + ".txt"));
        //Construye el nuevo archivo que luego sera renombrado por el original archivo. 
        File tempFile = new File(infile.getAbsolutePath() + ".tmp");
        // PrintWriter = Imprime representaciones formateadas de objetos en un flujo de salida de texto.
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));        
        String line;
        //lee desde el archivo original y escribe lo al nuevo 
        // al menos que contenga una realación con la data para poder ser removida  
        while ((line = br.readLine()) != null) {
          if (!line.trim().equals(registroLinea)) {
 
                pw.println(line);
                pw.flush();
            }
        }
      
        pw.close();
        br.close();
        // Elimina el Archivo original.   
        if (infile.delete()) {
            System.out.println("Se elimino con exito");
        }else {
            System.out.println("No se puede elimar el archivo");     
        }
        // Renombra el nuevo archivo desde el el nombre del archivo origianl que se tuvo.
        if (!tempFile.renameTo(infile)){
            System.out.println("No se puede renombra el archivo");
         }
     
        } 
        catch(FileNotFoundException ex) {
            System.out.println(ex);
        }
        catch (IOException | NumberFormatException e) {
            System.out.println(e.toString());
        }
        }
    //Modificar 
    public void modificarRegistro (String id) throws IOException {
        
        String oldContent ="";
        try{
          RegistrarDatos Reg = new RegistrarDatos(this.Base);
          String registroLinea = Reg.EncontrarCadena(id);
          // llamando al archivo y una condicion si existe o no existe.  
          File infile = new File("/BaseDatos/" + this.Base + ".txt");   
          if (!infile.isFile())
          System.out.println("No existe el Archivo ");
          // Obtener la lectura en la base de datos. 
          BufferedReader br= new BufferedReader(new FileReader("/BaseDatos/" + this.Base + ".txt"));
           //Reading all the lines of input text file into oldContent
          //leyendo todas las lineas de archivo de texto de entraas dentro de oldContent   
            String line = br.readLine();
               while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = br.readLine();
            }
            // ingresando los nuevos parametros para la actualización.  
              Scanner sc = new Scanner(System.in);
              System.out.println("Ingrese su nuevo Nombre:");
              this.setNombre(sc.next());
              System.out.println("Ingrese su nuevo Apellido");
              this.setApellidos(sc.next());
              System.out.println("Ingrese su nuevo Dni");
              this.setDNI(sc.next());
              System.out.println("Ingrese su nueva Contraseña");
              this.setContrasena(sc.next());
              DPersona p = new DPersona("Cliente");
              String fechaAct = p.fec_in;
              String fechaOut = p.getFec_out();
              String newString = "|" + id +"|"+ this.getNombre()+ "|" + this.getApellidos() + "|" + this.getDNI() + "|" 
                     + this.getContrasena() + "|"+ fechaAct + "|" + fechaOut + "|";
                            
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
    // verificacion de Usuario  y Password
    public String verfUsuario (String user, String password) throws IOException{
        
        RegistrarDatos Reg = new RegistrarDatos(this.Base); 
          String registroLinea = Reg.EncontrarCadena(user);
           boolean resultado1 = registroLinea.contains(user);
           boolean resultado2 = registroLinea.contains(password);
           if (resultado1 && resultado2)
               return "OK";
           else 
               return "NO"; 
    }
    
    // FECHA ACTUAL AUTOMATICA     
    public static String FechaActual()
    {
        Date fecha = new Date();
        return fecha.getDate() + "/" + (fecha.getMonth()+1) + "/" + (fecha.getYear()+1900);
    }
    
    
    
    private static boolean esNumero(String cadena){
	try {
		Long.parseLong(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
}
