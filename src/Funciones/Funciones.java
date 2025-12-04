/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.Desktop;
import java.net.URI;

import java.util.ArrayList;
import javax.swing.JFrame;
//paquetes
import clasesFuncionales.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import pkgfinal.*;



/**
 * Clase en donde se almacenan las funciones generales del programa
 * @author lucas
 */
public class Funciones {
    
    public Funciones(){
        
    }
    
    //Funcion que verifica el inicio de sesion de un usuario
    //Recibe la ubicacion y nombre del archivo a ser analizado pero sin la terminacion, para poder asi ver todos los usuarios que hay
    /**
     * Metodo que valida los datos de inicio de sesion de un usuario
     * @param cliente Cliente parcial con datos de Cuenta y contrasenha
     * @param ubicacion_Archivos Ubicacion del archivo para buscarlo
     * @return Terminacion del archivo en donde se encuentra
     */
    public static int verificarAcceso(Cliente cliente,String ubicacion_Archivos){
        int iteracion=0;
        try{
            
            while (true){
                
                iteracion++;
                String Terminacion = iteracion+".txt";
               
                BufferedReader br=new BufferedReader(new FileReader(ubicacion_Archivos+Terminacion));
                String linea;
                String usuario=null;
                String pin =null;

                Integer nroCuentaIngresado=cliente.getNroCuenta();
                Integer pinIngresado=cliente.getPin();

                while ((linea=br.readLine())!=null){
                    if (linea.startsWith("Nro de Cuenta: ")){
                        usuario=linea.substring("Nro de Cuenta: ".length()).trim();
                    }else if (linea.startsWith("Pin de acceso: ")){
                        pin=linea.substring("Pin de acceso: ".length()).trim();
                    }

                    if (usuario!=null && pin!=null){
                        if (nroCuentaIngresado.equals(Integer.parseInt(usuario)) && pinIngresado.equals(Integer.parseInt(pin))){
                            br.close();
                            return iteracion;
                        }
                        usuario=null;
                        pin=null;
                    }
                }
                br.close();
                
            }
            
        } catch(Exception e){
            return 0;
        }
        
    }
    
    /**
     * Metodo que valida la existencia de una cuenta dada
     * @param NroCuenta Cuenta a buscar la existencia
     * @return Valor booleano de existencia de cuenta
     */
    public static boolean ExistenciaCuenta(String NroCuenta){
        
        int iteracion=0;
        
        try{
            String ubicacion_Archivos = "src\\Documentos\\Usuarios\\Usuario";
            while (true){
                
                iteracion++;
                String Terminacion = iteracion+".txt";
               
                BufferedReader br=new BufferedReader(new FileReader(ubicacion_Archivos+Terminacion));
                String linea;
                String usuario=null;

                while ((linea=br.readLine())!=null){
                    if (linea.startsWith("Nro de Cuenta: ")){
                        usuario=linea.substring("Nro de Cuenta: ".length()).trim();
                        if ( usuario.equals(NroCuenta) ){
                            return true;
                        } else {
                            break;
                        }
                    }
                }
                br.close();
                
            }
            
        } catch(Exception e){
            return false;
        }
        
    }
    
    /**
     * Metodo que Busca el archivo que posea la entidad y el servicio dado, y devuelve un valor numerico con la terminacion del archivo en donde se encuentra
     * @param EntidadBusc Nombre de la entidad en donde se desea buscar el servicio
     * @param ServicioBusc El servicio a ser buscado
     * @return devuelve la terminacion del archivo
     */
    public static int VerificarArchivoServicio(String EntidadBusc,String ServicioBusc){
        int iteracion=0;
        String ubicacion_Archivos="src\\Documentos\\ServiciosRegistrados\\Servicio";
        
        try{
            
            while (true){
                
                iteracion++;
                String Terminacion = iteracion+".txt";
               
                BufferedReader br=new BufferedReader(new FileReader(ubicacion_Archivos+Terminacion));
                String linea;
                String Entidad=null;
                String Servicio=null;

                while ((linea=br.readLine())!=null){
                    if (linea.startsWith("Nombre: ")){
                        Entidad=linea.substring("Nombre: ".length()).trim();
                    }else if (linea.startsWith("Servicio: ")){
                        Servicio=linea.substring("Servicio: ".length()).trim();
                    }

                    if (Entidad!=null && Servicio!=null){
                        if (EntidadBusc.equals(Entidad) && Servicio.equals(ServicioBusc)){
                            br.close();
                            return iteracion;
                        }
                        Entidad=null;
                        Servicio=null;
                    }
                }
                br.close();
                
            }
            
            
        } catch(Exception e){
            return 0;
        }
        
    }
    
    
    /**
     * El metodo Busca en los archivos de servicio todas las empresas que poseen algun tipo de deuda y las devuelve
     * @return  ArrayList de todas las empresas
     */
    public static ArrayList<String> EmpresasServicio() {
        ArrayList<String> Empresas = new ArrayList<>();
        Empresas.add("Ninguno");
        int iteracion = 0;

        String ubicacion_Archivos = "src\\Documentos\\ServiciosRegistrados\\Servicio";
        boolean archivoEncontrado = true;

        while (archivoEncontrado) {
            iteracion++;
            String Terminacion = iteracion + ".txt";
            String rutaArchivo = ubicacion_Archivos + Terminacion;

            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                
                String linea;
                String empresa = null;

                while ((linea = br.readLine()) != null) {
                    if (linea.startsWith("Nombre: ")) {
                        
                        empresa = linea.substring("Nombre: ".length()).trim();
                        
                        if (!Empresas.contains(empresa)) {
                            Empresas.add(empresa);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                archivoEncontrado = false; // Salir del bucle si el archivo no se encuentra
            } catch (IOException e) {
                System.out.println("Error vario");
            }
        }
        
        return Empresas;
    }   
    /**
     * Metodo que devuelve en un ArrayList todos los servicios que posee una empresa dada
     * @param EmpresaBusc Nombre de la empresa buscada
     * @return Devuelve con array todos los valores de las deudas
     */
    public static ArrayList<String> EmpresasServicioDeuda(String EmpresaBusc) {
        ArrayList<String> Servicios = new ArrayList<>();
        
        int iteracion = 0;

        String ubicacion_Archivos = "src\\Documentos\\ServiciosRegistrados\\Servicio";
        boolean archivoEncontrado = true;

        while (archivoEncontrado) {
            iteracion++;
            String Terminacion = iteracion + ".txt";
            String rutaArchivo = ubicacion_Archivos + Terminacion;

            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                
                String linea;
                String empresa = null;
                String Servicio = null;
                while ((linea = br.readLine()) != null) {
                    if (linea.startsWith("Nombre: ")) {
                        
                        empresa = linea.substring("Nombre: ".length()).trim();
                        break;
                        
                    }
                }
                
                if (empresa.equals(EmpresaBusc)){
                    while ((linea = br.readLine()) != null) {
                        if (linea.startsWith("Servicio: ")) {

                            Servicio = linea.substring("Servicio: ".length()).trim();
                            if (!Servicios.contains(Servicio)) {
                                Servicios.add(Servicio);
                            }

                        }
                    }
                }
            } catch (FileNotFoundException e) {
                archivoEncontrado = false; // Salir del bucle si el archivo no se encuentra
            } catch (IOException e) {
                System.out.println("Error vario");
            }
        }
        
        return Servicios;
    }
    
    /**
     * Metodo que devuelve todas las cuentas que poseen X tipo de deuda
     * @param ServicioBusc Parametro del servicio buscado
     * @return Devuelve un array list con las cuentas con deudas
     */
    public static ArrayList<Integer> EmpresasServicioDeudaCuenta(String ServicioBusc) {
        ArrayList<Integer> ServiciosCuenta = new ArrayList<>();
        
        int iteracion = 0;

        String ubicacion_Archivos = "src\\Documentos\\ServiciosRegistrados\\Servicio";
        boolean archivoEncontrado = true;

        while (archivoEncontrado) {
            iteracion++;
            String Terminacion = iteracion + ".txt";
            String rutaArchivo = ubicacion_Archivos + Terminacion;

            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                
                String linea;
                String empresa = null;
                String Servicio = null;
                
                while ((linea = br.readLine()) != null) {
                    if (linea.startsWith("Servicio: ")){
                        Servicio = linea.substring("Servicio: ".length()).trim();
                        if (ServicioBusc.equals(Servicio)) {
                            while ((linea = br.readLine()) != null) {
                    
                                if (linea.startsWith("Cuentas:")) {
                                    while (!(linea = br.readLine()).contains("-")){
                                        
                                        ServiciosCuenta.add(Integer.parseInt(linea));
                                    }
                                }
                                
                            }
                        }
                    }
                }
                
                
                
            } catch (FileNotFoundException e) {
                archivoEncontrado = false; // Salir del bucle si el archivo no se encuentra
            } catch (IOException e) {
                System.out.println("Error vario");
            }
        }
        
        return ServiciosCuenta;
    }
    
    /**
     * Metodo que devuelve todos los valores de las deudas que poseen la gente que poseen X tipo de deuda
     * @param ServicioBusc Servicio buscado
     * @return Devuelve los valores de la deuda en un array
     */
    public static ArrayList<Long> EmpresasServicioDeudaValor(String ServicioBusc) {
        ArrayList<Long> ServiciosValor = new ArrayList<>();
        
        int iteracion = 0;

        String ubicacion_Archivos = "src\\Documentos\\ServiciosRegistrados\\Servicio";
        boolean archivoEncontrado = true;

        while (archivoEncontrado) {
            iteracion++;
            String Terminacion = iteracion + ".txt";
            String rutaArchivo = ubicacion_Archivos + Terminacion;

            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                
                String linea;
                String empresa = null;
                String Servicio = null;
                while ((linea = br.readLine()) != null) {
                    if (linea.startsWith("Servicio: ")){
                        Servicio = linea.substring("Servicio: ".length()).trim();
                        if (ServicioBusc.equals(Servicio)) {
                            while ((linea = br.readLine()) != null) {
                    
                                if (linea.startsWith("CantidadDeuda:")) {
                                    while (!(linea = br.readLine()).contains("-")){
                                        ServiciosValor.add(Long.parseLong(linea.replace(" ", "")));
                                    }
                                }
                                
                            }
                        }
                    }
                }
                
            } catch (FileNotFoundException e) {
                archivoEncontrado = false; // Salir del bucle si el archivo no se encuentra
            } catch (IOException e) {
                System.out.println("Error vario");
            }
        }
        
        return ServiciosValor;
    }
    
    /**
     * Metodo que recibe un numero de tarjeta de credito que desea pagar y valida que el numero de tarjeta de credito exista
     * @param TarjetaBusc Numero de tarjeta de credito a buscar
     * @return devuelve el archivo en donde se encuentra la tarjeta
     */
    public static Integer TarjetaAPagar(String TarjetaBusc) {
        
        int iteracion = 0;

        String ubicacion_Archivos = "src\\Documentos\\TarjetasRegistradas\\Tarjetas";
        boolean archivoEncontrado = true;

        while (archivoEncontrado) {
            iteracion++;
            String Terminacion = iteracion + ".txt";
            String rutaArchivo = ubicacion_Archivos + Terminacion;

            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                ArrayList<String> TarjetasEnc = new ArrayList<>();
                String linea;
                String Tarjeta = null;
                while ((linea = br.readLine()) != null) {
                    if (linea.startsWith("Tarjetas:")) {
                        
                        while (!(linea = br.readLine()).contains("_")){
                            TarjetasEnc.add(linea.replace("-",""));
                        }
                        if (TarjetasEnc.contains(TarjetaBusc)){
                            
                            return iteracion;
                        }
                        break;
                        
                    }
                }
            } catch (FileNotFoundException e) {
                archivoEncontrado = false; // Salir del bucle si el archivo no se encuentra
            } catch (IOException e) {
                System.out.println("Error vario");
            }
        }
        
        return -1;
    }
    
    /**
     * Metodo que recibe el archivo donde se encuentra la tarjeta y devuelve la posicion donde se encuentra
     * @param TarjetaBusc Numero de la tarjeta de credito a buscar
     * @param posicion Posicion del archivo para buscar
     * @return devuelve el archivo en donde se encuentra la tarjeta
     */
    public static Integer TarjetaAPagarPos(String TarjetaBusc, int posicion) {
        
        int iteracion = posicion;

        String ubicacion_Archivos = "src\\Documentos\\TarjetasRegistradas\\Tarjetas";
        boolean archivoEncontrado = true;

        while (archivoEncontrado) {
            
            String Terminacion = iteracion + ".txt";
            String rutaArchivo = ubicacion_Archivos + Terminacion;

            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                ArrayList<String> TarjetasEnc = new ArrayList<>();
                String linea;
                String Tarjeta = null;
                while ((linea = br.readLine()) != null) {
                    if (linea.startsWith("Tarjetas:")) {
                        
                        while (!(linea = br.readLine()).contains("_")){
                            TarjetasEnc.add(linea.replace("-",""));
                        }
                        
                        if (TarjetasEnc.contains(TarjetaBusc)){
                            
                            return TarjetasEnc.indexOf(TarjetaBusc) ;
                        }
                        break;
                        
                    }
                }
            } catch (FileNotFoundException e) {
                archivoEncontrado = false; // Salir del bucle si el archivo no se encuentra
            } catch (IOException e) {
                System.out.println("Error vario");
            }
        }
        
        return -1;
    }
    /**
     * Valor que devuelve el valor minimo de una tarjeta en una posicion dada de un archivo
     * @param archivo Terminacion del archivo
     * @param posicion Posicion en la que se encuentra
     * @return Valor del minimo de la tarjeta
     */
    public static String ValorMinimoTarjeta(int archivo, int posicion){
        
        int iteracion = archivo;

        String ubicacion_Archivos = "src\\Documentos\\TarjetasRegistradas\\Tarjetas";
        boolean archivoEncontrado = true;

        while (archivoEncontrado) {
            
            String Terminacion = iteracion + ".txt";
            String rutaArchivo = ubicacion_Archivos + Terminacion;

            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                
                long posicionFila=0;
                int aux=1,lineaSob=14+posicion;        //En los archivos txt en la linea 13 esta el dato a sobreescribir
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (aux==lineaSob) {
                        break;
                    }
                    aux++;
                }
                
                return linea;
            } catch (FileNotFoundException e) {
                archivoEncontrado = false; // Salir del bucle si el archivo no se encuentra
            } catch (IOException e) {
                System.out.println("Error vario");
            }
        }
        
        return "Nulo";
    }
    /**
     * Metodo que devuelve el valor maximo de una tarjeta segun su posicion y archivo en el que se encuentre
     * @param archivo Terminacion del archivo
     * @param posicion Posicion dentro del archivo
     * @return Valor del Maximo de la tarjeta
     */
    public static String ValormMaximoTarjeta(int archivo, int posicion){
        
        int iteracion = archivo;

        String ubicacion_Archivos = "src\\Documentos\\TarjetasRegistradas\\Tarjetas";
        boolean archivoEncontrado = true;

        while (archivoEncontrado) {
            
            String Terminacion = iteracion + ".txt";
            String rutaArchivo = ubicacion_Archivos + Terminacion;

            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                
                long posicionFila=0;
                int aux=1,lineaSob=9+posicion;        //En los archivos txt en la linea 13 esta el dato a sobreescribir
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (aux==lineaSob) {
                        break;
                    }
                    aux++;
                }
                
                return linea;
            } catch (FileNotFoundException e) {
                archivoEncontrado = false; // Salir del bucle si el archivo no se encuentra
            } catch (IOException e) {
                System.out.println("Error vario");
            }
        }
        
        return "Nulo";
    }
    
    
    /**
     * Metodo que te devuelve que tipo de cliente es el que esta utilizando el programa
     * Ya sea Entidad o Persona
     * @param ubicacion_Archivos Ubicacion del archivo a leer para validar
     * @return Tipo de cliente entidad/persona
     */
    public static Integer verificarTipoCliente(String ubicacion_Archivos){
        
        try{
            
            while (true){
                
                BufferedReader br=new BufferedReader(new FileReader(ubicacion_Archivos));
                String linea;
                String Tipo;
                while ((linea=br.readLine())!=null){
                    if (linea.startsWith("Tipo: ")){
                        Tipo=linea.substring("Tipo: ".length()).trim();
                        br.close();
                        return Integer.parseInt(Tipo);
                    }
                }
            }
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    // Para traer los datos del txt 
    /**
     * Metodo que lee un ClientePersona desde un archivo
     * @param ubicacionArchivo Direccion del archivo a ser leido
     * @param archivo Entero de la terminacion del archivo
     * @return Cliente con todos los datos
     */
    public static ClientePersona leerClientePDesdeArchivo(String ubicacionArchivo, Integer archivo) {
        ClientePersona cliente = new ClientePersona();

        try {
            BufferedReader br = new BufferedReader(new FileReader(ubicacionArchivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Nombre: ")) {
                    String nombre = linea.substring("Nombre: ".length());
                    cliente.setNombre(nombre, null); // Configura el nombre del cliente
                } else if (linea.startsWith("Apellido: ")) {
                    String apellido = linea.substring("Apellido: ".length());
                    cliente.setNombre(cliente.getNombre(), apellido); // Agrega el apellido al nombre
                } else if (linea.startsWith("CI: ")) {
                    Integer ci = Integer.parseInt(linea.substring("CI: ".length()));
                    cliente.setDocumento(ci);
                } else if (linea.startsWith("Fecha de Nacimiento: ")) {
                    // Aquí debes manejar la fecha y configurarla en el cliente
                } else if (linea.startsWith("Sexo: ")) {
                    String sexo = linea.substring("Sexo: ".length());
                    cliente.setSexo(sexo);
                } else if (linea.startsWith("Direccion: ")) {
                    String direccion = linea.substring("Direccion: ".length());
                    cliente.setDireccion(direccion);
                } else if (linea.startsWith("Nro de Cuenta: ")) {
                    Integer nroCuenta = Integer.parseInt(linea.substring("Nro de Cuenta: ".length()));
                    cliente.setNroCuenta(nroCuenta);
                } else if (linea.startsWith("Pin de acceso: ")) {
                    Integer pinAcceso = Integer.parseInt(linea.substring("Pin de acceso: ".length()).replace(" ", ""));
                    cliente.setPin(pinAcceso);
                } else if (linea.startsWith("Pin Transaccion: ")){
                    Integer pinTransf = Integer.parseInt(linea.substring("Pin Transaccion: ".length()).replace(" ", ""));
                    cliente.setPinTransf(pinTransf);
                } else if (linea.startsWith("Tipo: ")){
                    Integer Tipo = Integer.parseInt(linea.substring("Tipo: ".length()));
                    cliente.setTipo(Tipo);
                }else if (linea.startsWith("Fondos: ")) {
                    Long fondos = Long.parseLong(linea.substring("Fondos: ".length()).replace(".", "").replace(",", ".").replace(" ", ""));
                    cliente.setFondos(fondos);
                
                } else if (linea.startsWith("Tarjetas: ")) {
                    /*// Manejar las tarjetas
                    linea = br.readLine(); // Leer la primera tarjeta
                        while (linea != null && !linea.trim().isEmpty()) {
                            Tarjetas tarjeta = new Tarjetas(linea);
                            cliente.addTarjeta(tarjeta); // Añadir tarjeta al cliente
                            linea = br.readLine(); // Leer la siguiente línea
                       }*/
                   } else if (linea.startsWith("Fondos Tarjetas: ")) {
                      /*  // Manejar los fondos de las tarjetas
                        linea = br.readLine(); // Leer el primer fondo de tarjeta
                            while (linea != null && !linea.trim().isEmpty()) {
                                Double fondoTarjeta = Double.parseDouble(linea);
                                cliente.addFondoTarjeta(fondoTarjeta); // Añadir fondo de tarjeta al cliente
                                linea = br.readLine(); // Leer el siguiente fondo de tarjeta
                        }*/
                    }
            }
            

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cliente.setArchivo(archivo);
        return cliente;
    }
    
    /**
     * Metodo que lee los datos del cliente desde un archivo dado
     * @param ubicacionArchivo Direccion del archivo
     * @param archivo 
     * @return 
     */
    public static ClienteEntidad leerClienteEDesdeArchivo(String ubicacionArchivo, Integer archivo) {
        
        return new ClienteEntidad();
    }
    
    
    /**
     * Metodo que verifica la existencia de la cuenta dada
     * @param NroCuenta Nro de la cuenta buscada
     * @param ubicacion_Archivos Direccion donde esta la ubicacion del archivo
     * @return Posicion en donde se encuentra
     */
    public static int verificarExistenciaCuenta(int NroCuenta,String ubicacion_Archivos){
        int iteracion=0;
        try{
            
            while (true){
                
                iteracion++;
                String Terminacion = iteracion+".txt";
                
                BufferedReader br=new BufferedReader(new FileReader(ubicacion_Archivos+Terminacion));
                String linea;
                String usuario=null;
                String pin =null;

                Integer nroCuentaIngresado=NroCuenta;
                
                while ((linea=br.readLine())!=null){
                    if (linea.startsWith("Nro de Cuenta: ")){
                        usuario=linea.substring("Nro de Cuenta: ".length()).trim();
                    }else if (linea.startsWith("Pin de acceso: ")){
                        pin=linea.substring("Pin de acceso: ".length()).trim();
                    }

                    if (usuario!=null && pin!=null){
                        if (nroCuentaIngresado.equals(Integer.parseInt(usuario))){
                            br.close();
                            return iteracion;
                        }
                        usuario=null;
                        pin=null;
                    }
                }
                br.close();
                
            }
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
