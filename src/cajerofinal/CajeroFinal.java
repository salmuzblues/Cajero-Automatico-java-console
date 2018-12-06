package cajerofinal;
import Datos.*;
import java.io.IOException;
import java.util.Scanner;
 
public class CajeroFinal {

 
    public static void main(String[] args) throws IOException {

   Scanner sc = new Scanner(System.in);
   int opc, opc2 =0, opc3 = 0, opc4 = 0, opc5 = 0,opc6;
   String U,P, rest = "";
   
   
  // menu Princial 
   do {
       opc2 = Menu1();
       switch(opc2)
       {
           case 1 : 
                  do {
        System.out.println("Ingrese su Usuario de ADMINISTRADOR: ");
        U=sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        P=sc.nextLine();
                    }while (!(U.equals("admin")&&P.equals("1234")));
                     // admin Menu 
        do
        {
            opc = Menu2();
            switch(opc)
            {
                case 1:
                    try{
                        DPersona Clie = new DPersona("Cliente");                        
                        System.out.println("**CLIENTE**");
                        System.out.println("Ingrese Nombre: "); Clie.setNombre(sc.nextLine());
                        System.out.println("Ingrese Apellido: "); Clie.setApellidos(sc.nextLine());
                        System.out.println("Ingrese DNI: "); Clie.setDNI(sc.nextLine());
                        System.out.println("Ingrese 4 numeros para su Contraseña: ");Clie.setContrasena(sc.nextLine());
                        Clie.FechaActual();
                        Clie.RegistrarPersona();
                        System.out.println("¡Registro Guardado!"); 
                    }
                    catch(IOException e){
                        System.out.println(e.toString());
                    } 
                    break;
                    case 2:
                    try{
                        System.out.println("**LISTAR CLIENTES**");
                        RegistrarDatos Reg = new RegistrarDatos("Persona");
                        Reg.ListarRegistros("|ID|NOMBRES|APELLIDOS|CONTRASEÑA|FECHA REGISTRO|FECHA CESE|", "*");
                    }
                    catch(IOException e){
                        System.out.println(e.toString());
                    } 
                    break;
                     case 3:
                    try{
                        System.out.println("**BUSCAR CLIENTES**");
                        String busca,encuentra;
                        RegistrarDatos Reg = new RegistrarDatos("Persona");
                        System.out.println("Ingrese el ID a buscar");
                        busca=sc.nextLine();
                        encuentra=Reg.EncontrarCadena(busca);
                        System.out.println("encontró: "+encuentra);
                    }
                    catch(IOException e){
                        System.out.println(e.toString());
                    } 
                    break;
                     case 4:
                       try{
                        System.out.println("**MODIFICAR CLIENTE**");
                        RegistrarDatos Reg = new RegistrarDatos("Persona");
                        Reg.ListarRegistros("|ID|NOMBRES|APELLIDOS|CONTRASEÑA|FECHA REGISTRO|FECHA CESE|", "*");
                        String id;
                        DPersona Per = new DPersona("Persona");
                        System.out.println("Ingrese el ID a modificar");
                        id=sc.nextLine();
                        Per.modificarRegistro(id);
                         }
                         catch(IOException e){
                             System.out.println(e.toString());
                         }
                      break;
                     case 5:
                         try{
                        System.out.println("**ELIMINAR CLIENTE**");
                        RegistrarDatos Reg = new RegistrarDatos("Persona");
                        Reg.ListarRegistros("|ID|NOMBRES|APELLIDOS|CONTRASEÑA|FECHA REGISTRO|FECHA CESE|", "*");
                        String id;
                        DPersona Per = new DPersona("Persona");
                        System.out.println("Ingrese el ID a eliminar");
                        id=sc.nextLine();
                        Per.eliminarRegistro(id);
                         }
                         catch(IOException e){
                             System.out.println(e.toString());
                         }
                      break;
                    
            }
        }while(opc!=7);
                    break;
           case 2 :  
              
            do{        
        System.out.println("Ingrese su Usuario: ");
        U=sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        P=sc.nextLine();
        DPersona p = new DPersona("Persona");
         rest = p.verfUsuario(U, P);
         }while (!(rest.equals("OK") ));
            
                         // clienteMenu 
       do {
            opc3 = Menu3();
            switch(opc3)
            {
            // CUENTAS A CREAR    
             case 1 : 
         do {        
             opc4 = Menu4(); 
             switch(opc4)
             {
                 case 1 : 
                     try {
                     System.out.println("***CUENTA AHORRO SOLES***"); 
                     CAhorroSoles CS = new CAhorroSoles("AhorroSoles");
                         System.out.println("Ingrese la Cantidad a Iniciar");
                         int cant  = sc.nextInt();
                        CS.setIntCantCAhorroSoles(cant);
                         CS.FechaActual();
                         CS.RegistrarCuentaSoles();
                     
                     }catch(IOException e){
                               System.out.println(e.toString());
                             }
                    break;
                 case 2 : 
                        try {
                     System.out.println("***CUENTA CORRIENTE SOLES***"); 
                     CCorrienteSoles CRS = new CCorrienteSoles("CorrienteSoles");
                         System.out.println("Ingrese la Cantidad a Iniciar");
                         int cant  = sc.nextInt();
                        CRS.setIntCantCorrienteSoles(cant);
                        CRS.FechaActual();
                        CRS.RegistrarCuentaCorrienteSoles();
                     
                     }catch(IOException e){
                               System.out.println(e.toString());
                             }
                    break;
                 case 3 :
                   try {
                     System.out.println("***CUENTA AHORRO DOLARES***"); 
                     CAhorroDolares CD = new CAhorroDolares("AhorroDolares");
                         System.out.println("Ingrese la Cantidad a Iniciar");
                         int cant  = sc.nextInt();
                        CD.setIntCantAhorroDolares(cant);
                         CD.FechaActual();
                         CD.RegistrarCuentaDolares();
                     
                     }catch(IOException e){
                               System.out.println(e.toString());
                             }
                     break;
             }// Finaliza el Switch de cuentas a crear.
         }while(opc4 != 5);
             break;
             // DEPOSITAR EN CUENTA 
                case 2 :
              do {
                  opc5 = Menu5(); //DEPOSITAR
                  switch(opc5)
                  {
                      case 1: 
                          try{
                     System.out.println("*** DEPOSITO//CUENTA AHORRO SOLES***"); 
                     RegistrarDatos Reg = new RegistrarDatos("AhorroSoles");
                     Reg.ListarRegistros("|ID|CANTIDAD SOLES|FECHA INGRESADA|", "*"); 
                     System.out.println("INGRESE SU ID CORRESPONDIENTE");
                     String id = sc.next();
                     System.out.println("INGRESE SU MONTO A DEPOSITAR");
                     int mont = sc.nextInt();
                     CAhorroSoles CS = new CAhorroSoles("AhorroSoles");
                     CS.ModificarDeposito(id, mont);
                     System.out.println("DEPOSITO REALIZADO CON EXITO!");
                          }catch(IOException e){
                              System.out.println(e.toString());}
                              break;
                      case 2:
                          break;
                      case 3:
                             try{
                     System.out.println("***DEPOSITO//CUENTA AHORRO DOLARES***"); 
                     RegistrarDatos Reg = new RegistrarDatos("AhorroDolares");
                     Reg.ListarRegistros("|ID|CANTIDAD SOLES|FECHA INGRESADA|", "*"); 
                     System.out.println("INGRESE SU ID CORRESPONDIENTE");
                     String id = sc.next();
                     System.out.println("INGRESE SU MONTO A DEPOSITAR");
                     int mont = sc.nextInt();
                     CAhorroDolares CD = new CAhorroDolares("AhorroDolares");
                     CD.DepositoDolares(id, mont);
                     System.out.println("DEPOSITO REALIZADO CON EXITO!");
                          }catch(IOException e){
                              System.out.println(e.toString());}
                          break;
                  }
              }while(opc5 != 5);
                    break; // case 2
                  //RETIRO   
                case 3 :    
                      do {
                  opc6 = Menu6();//RETIRO
                  switch(opc6)
                  {
                      case 1: 
                          try{
                     System.out.println("***RETIRO//CUENTA AHORRO SOLES***"); 
                     RegistrarDatos Reg = new RegistrarDatos("AhorroSoles");
                     Reg.ListarRegistros("|ID|CANTIDAD SOLES|FECHA INGRESADA|", "*"); 
                     System.out.println("INGRESE SU ID CORRESPONDIENTE");
                     String id = sc.next();
                     System.out.println("INGRESE SU MONTO A RETIRAR");
                     int mont = sc.nextInt();
                     CAhorroSoles CS = new CAhorroSoles("AhorroSoles");
                     CS.retiro(id, mont);
                     System.out.println("RETIRO REALIZADO CON EXITO!");
                          }catch(IOException e){
                              System.out.println(e.toString());}
                              break;
                      case 2:
                          break;
                      case 3:
                              try{
                     System.out.println("***RETIRO//CUENTA AHORRO DOLARES***"); 
                     RegistrarDatos Reg = new RegistrarDatos("AhorroDolares");
                     Reg.ListarRegistros("|ID|CANTIDAD SOLES|FECHA INGRESADA|", "*"); 
                     System.out.println("INGRESE SU ID CORRESPONDIENTE");
                     String id = sc.next();
                     System.out.println("INGRESE SU MONTO A RETIRAR");
                     int mont = sc.nextInt();
                     CAhorroDolares CD = new CAhorroDolares("AhorroDolares");
                     CD.retiroDolares(id, mont);
                     System.out.println("RETIRO REALIZADO CON EXITO!");
                          }catch(IOException e){
                              System.out.println(e.toString());}
                          break;
                  }
              }while(opc6 != 5);
                    break; // case 3 finall 
           
            } //Finaliza switch opc3
          }while(opc3!=5);
                    break;
       }
   }while(opc2!=3 );
   
    }
  
    /* **** CREACIÓN DE MENUS ***** */
    
 public static int Menu1()
    {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("\nSeleccione una opción\n"
            +"(1) ADMINISTRADOR \n"
            +"(2) USUARIO \n"
            +"(3) Salir\n");
            return Integer.parseInt(sc.next());
        }
        catch(Exception e){
            return 0;
        }   
    }
    
    public static int Menu2()
    {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("\nSeleccione una opción\n"
            +"(1) REGISTRAR USUARIO \n"
            +"(2) LISTAR USUARIO \n"
            +"(3) BUSCAR USUARIO\n"
            +"(4) MODIFICAR USUARIO\n"
            +"(5) ELIMINAR USUARIO\n"
            +"(6) (En construccion)..\n"
            +"(7) SALIR\n");
            return Integer.parseInt(sc.next());
        }
        catch(Exception e){
            return 0;
        }   
    }
    
      public static int Menu3()
    {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("\nSeleccione una opción\n"
            +"(1) CREAR CUENTAS \n"
            +"(2) DEPOSITO \n"
            +"(3) RETIRO\n"
            +"(4) MOVIMIENTO\n"
            +"(5) SALIR\n");
            return Integer.parseInt(sc.next());
        }
        catch(Exception e){
            return 0;
        }   
    }
      // MENU 4 CREAR CUENTAS 
          public static int Menu4()
    {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("\nSeleccione la cuenta a crear\n"
            +"(1) AHORRO SOLES \n"
            +"(2) CORRIENTES SOLES \n"
            +"(3) AHORRO DOLARES\n"
            +"(4) CORRIENTE DOLARES\n"
            +"(5) SALIR\n");
            return Integer.parseInt(sc.next());
        }
        catch(Exception e){
            return 0;
        }   
    }
    // MENU 5 DEPOSITO
          
         public static int Menu5()
    {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("\nSeleccione una cuenta a depositar\n"
            +"(1) AHORRO SOLES \n"
            +"(2) CORRIENTES SOLES \n"
            +"(3) AHORRO DOLARES\n"
            +"(4) CORRIENTE DOLARES\n"
            +"(5) SALIR\n");
            return Integer.parseInt(sc.next());
        }
        catch(Exception e){
            return 0;
        }   
    }
     // MENU 6 RETIRO 
        public static int Menu6()
    {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("\nSeleccione una cuenta para retirar\n"
            +"(1) AHORRO SOLES \n"
            +"(2) CORRIENTES SOLES \n"
            +"(3) AHORRO DOLARES\n"
            +"(4) CORRIENTE DOLARES\n"
            +"(5) SALIR\n");
            return Integer.parseInt(sc.next());
        }
        catch(Exception e){
            return 0;
        }   
    }
}
