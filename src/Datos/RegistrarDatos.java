package Datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.Stream;


public class RegistrarDatos {

    private String Datos[][];
    private String Base;
    private int Filas;
    private int Columnas;
    private static Scanner x;
    public RegistrarDatos(String Base) throws IOException {
        this.Base = Base;
        this.Filas = ContarRegistros();
        this.Columnas = ContarColumnas();
        this.Datos = new String[this.Filas][this.Columnas];
    }

     public String[][] getDatos() {
        ObtenerRegistrosTotal();
        return Datos;
    }

    public void setDatos(String[][] Datos) {
        this.Datos = Datos;
    }

    public void setBase(String Base) {
        this.Base = Base;
    }

    public int getFilas() {
        return Filas;
    }

    public void setFilas(int Filas) {
        this.Filas = Filas;
    }

    public int getColumnas() {
        return Columnas;
    }

    public void setColumnas(int Columnas) {
        this.Columnas = Columnas;
    }
    
    
    
     //REGISTRA LA CADENA CAMPOS EN LA RUTA ESPECIFICADA
    public void RegistrarFila(String Campos) throws IOException{
        
        BufferedWriter out = null;   
        try {   
            out = new BufferedWriter(new FileWriter("/BaseDatos/" + this.Base + ".txt", true));   
            out.write(Campos);   
            out.newLine();
        } catch (IOException e) {   
            System.out.println(e.toString());
        } finally {
            try {
                if (out != null)    
                   out.close();   
            } catch (IOException e2) {
                   System.out.println(e2.toString());
                }
        }                
    }      
    
    //CUENTA LOS REGISTROS
    public int ContarRegistros() throws FileNotFoundException, IOException{
        int lNumeroLineas = 0;
        try {
            BufferedReader br= new BufferedReader(new FileReader("/BaseDatos/" + this.Base + ".txt"));
            String texto;
            while(true) {
                    if ((texto=br.readLine())==null){
                        break;
                    }
                    lNumeroLineas += 1;
            }
            br.close(); 
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return lNumeroLineas;   
    }
    
    
    //CUENTA LOS CAMPOS SEPARADOS POR "| |"
    public int ContarColumnas() throws FileNotFoundException, IOException{
        int lNumeroCampos=0;
        try {
            BufferedReader br= new BufferedReader(new FileReader("/BaseDatos/" + this.Base + ".txt"));
            String texto;
            if ((texto=br.readLine())!=null){
                int ini=0, pos = 0;
                while(ini != -1 && ini < texto.length()-1)
                {
                    pos = ini + 1;
                    ini = texto.indexOf("|", ini + 1);
                    lNumeroCampos+=1;
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.toString());
        } 
        return lNumeroCampos;
    }
    

    //LISTA TODOS LOS REGISTROS DESDE UN FILE  
    public void ListarRegistros(String Encabezado, String Filtro){
        System.out.println(Encabezado);
        try {
            BufferedReader br= new BufferedReader(new FileReader("/BaseDatos/" + this.Base + ".txt"));
            String texto;
            while((texto=br.readLine())!=null) {
                
                if(!("*".equals(Filtro) || texto.contains(Filtro)))
                    continue;
                //if("*".equals(Filtro) || texto.contains(Filtro))
                    System.out.println(texto);
            }
            br.close(); 
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    //EVALUA SI YA EXISTE EL REGISTRO
    
    public boolean BuscarCadena(String dato){
        boolean encontrar = false;
        try {
            BufferedReader br= new BufferedReader(new FileReader("/BaseDatos/" + this.Base + ".txt"));
            String texto;
            while((texto=br.readLine())!=null){    
                if (texto.contains("|"+dato+"|") && dato.compareTo("")!=0) {
                    encontrar = true; 
                }    
            }  
            br.close(); 
        } 
        catch (IOException | NumberFormatException e) {
            System.out.println(e.toString());
        }
        return encontrar;
    }
    
    // Encontrar un registro del Fichero
        public String EncontrarCadena(String dato){
        boolean encontrar = false;
        String registro="";
        try {
            BufferedReader br= new BufferedReader(new FileReader("/BaseDatos/" + this.Base + ".txt"));
            String texto;
            while((texto=br.readLine())!=null){    
                if (texto.contains("|"+dato+"|") && dato.compareTo("")!=0) {
                    encontrar = true; 
                    registro=texto;
                    
                }    
            } 
            
            br.close(); 
        } 
        catch (IOException | NumberFormatException e) {
            System.out.println(e.toString());
        }
        return registro;
    }

   
    public void ObtenerRegistrosTotal(){
        try {
            BufferedReader br= new BufferedReader(new FileReader("/BaseDatos/" + this.Base + ".txt"));
            String texto;
            int i=0;
            while((texto=br.readLine())!=null){
                int ini = 0, j = 0;
                int pos;
                while(ini != -1 && ini < texto.length()-1)
                {
                    pos = ini + 1;
                    ini = texto.indexOf("|", ini + 1);
                    Datos[i][j]=texto.substring(pos, ini);
                    j+=1;
                }
                i+=1;
            }
        }
        catch (IOException e) {
            System.out.println(e.toString());
        } 
    }
    
    
    
    public int SumarDatosCampos(int ColBus, String DatBus, int ColSum)
    {
        int sum=0;
        for (int i=0; i<this.Filas; i++)
        {
            if (Datos[i][ColBus-1].compareTo(DatBus)==0)
            {
                sum += Integer.parseInt(Datos[i][ColSum-1])  ;
            }
        }
        return sum;
    }
}