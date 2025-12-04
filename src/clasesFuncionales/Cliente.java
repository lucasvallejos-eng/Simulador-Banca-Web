package clasesFuncionales;

import java.util.ArrayList;

/**
 * Clase abstracta de la que heredan los dos tipos de clientes
 * @author lucas
 */
public abstract class Cliente {
    
    /**
     * Id Interna del usuario
     */
    protected Integer idUsuario;
    
    /**
     * Número de cuenta del usuario 
     */
    protected Integer nroCuenta;
    
    /**
     * Dirección de domicilio o sucursal central del usuario
     */
    protected String direccion;
    
    /**
     * Pin de acceso a la cuenta
     */
    protected Integer pinCuenta;
    
    /**
     * Pin de confirmación de transferencias
     */
    protected Integer pinTransferencia;
    
    /**
     * Lista de tarjetas de crédito del cliente
     */
    protected ArrayList<TarjetaCredito> tarjetasCredito;
    
    /**
     * Nombre del cliente<br>
     * Nombre de persona en caso de ser un individuo<br>
     * Nombre de la empresa u organización en caso de ser una entidad<br>
     */
    protected String nombre;
    
    /**
     * Saldo en la cuenta del cliente
     */
    protected Long fondos;
    
    /**
     * Archivo que contiene la información del cliente
     */
    protected Integer archivo;
    
    /**
     * Define qué tipo de cliente es
     */
    protected Integer tipo; //1 = Persona ; 2 = Entidad
    
    /**
     * Inicializa la {@link clasesFuncionales.Cliente#tarjetasCredito lista de tarjetas de crédito}
     */
    public Cliente(){
        tarjetasCredito = new ArrayList();
    }
    
    /**
     * Define la id del usuario
     * @param id Nueva id
     */
    public void setId(Integer id){
        idUsuario = id;
    }
    
    /**
     * Define el número de cuenta del usuario
     * @param nro Nuevo numero de cuenta
     */
    public void setNroCuenta(Integer nro){
        nroCuenta = nro;
    }
    
    /**
     * Define dirección del cliente
     * @param dir Nueva dirección
     */
    public void setDireccion(String dir){
        direccion = dir;
    }
    
    /**
     * Define el pin de acceso de la cuenta
     * @param pin Nuevo pin de cuenta
     */
    public void setPin(Integer pin){
        pinCuenta = pin;
    }
    
    /**
     * Define el pin de transferencia de la cuenta
     * @param pin Pin de transferencia
     */
    public void setPinTransf(Integer pin){
        pinTransferencia = pin;
    }
    
    /**
     * Define el Nombre del titular de la cuenta
     * @param n Nombre
     */
    public void setNombre(String n){
        nombre = n;
    }
    
    
    /**
     * Define el saldo de la cuenta
     * @param fondos Nuevos fondos
     */
    public void setFondos(Long fondos){
        this.fondos = fondos;
    }
    
    /**
     * Añade al saldo de la cuenta la cantidad especificada
     * @param monto Monto añadido a la cuenta
     */
    public void addFondos(Long monto){
        fondos = fondos + monto;
    }
    
    /**
     * Define el archivo con los datos de la cuenta
     * @param archivo Archivo donde se encuentran los datos
     */
    public void setArchivo(Integer archivo){
        this.archivo = archivo;
    }
    
    /**
     * Guarda si el usuario es {@link clasesFuncionales.ClienteEntidad ClienteEntidad} o {@link clasesFuncionales.ClientePersona ClientePersona}
     * @param tipo Tipo de cuenta
     */
    public void setTipo(Integer tipo){
        this.tipo = tipo;
    }
    
    /**
     * Obtiene el id del usuario
     * @return Id del usuario
     */
    public Integer getId(){
        return idUsuario;
    }
    
    /**
     * Obtiene el número de la cuenta
     * @return Número de cuenta
     */
    public Integer getNroCuenta(){
        return nroCuenta;
    }
    
    /**
     * Obtiene la dirección del titular de la cuenta
     * @return Dirección
     */
    public String getDireccion(){
        return direccion;
    }
    
    /**
     * Obtiene el pin de acceso de la cuenta
     * @return Pin de acceso
     */
    public Integer getPin(){
        return pinCuenta;
    }
    
    /**
     * Obtiene el pin de transferencia de la cuenta
     * @return devuelve el pin de transferencia
     */
    public Integer getPinTransf(){
        return pinTransferencia;
    }
    
    /**
     * Obtiene el listado de las tarjetas de crédito que posee el cliente
     * @return Lista de tarjetas de crédito que tiene el usuario
     */
    public ArrayList<TarjetaCredito> getTarjetas(){
        return tarjetasCredito;
    }
    
    /**
     * Obtiene el nombre del cliente
     * @return Nombre del cliente
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Obtiene los fondos de la cuenta
     * @return Fondos del cliente
     */
    public Long getFondos(){
        return fondos;
    }
    
    /**
     * Obtiene el archivo de información del cliente
     * @return Archivo de información del cliente
     */
    public Integer getArchivo(){
        return archivo;
    }
    
    /**
     * Devuelve el tipo del cliente
     * @return Tipo de cliente
     */
    public Integer getTipo(){
        return tipo;
    }
    
    /**
     * {@link clasesFuncionales.Cliente#getTarjetas() tarjetasCredito}
     * @param tarjeta Nueva tarjeta a a�adir
     */
    public void addTarjeta(TarjetaCredito tarjeta){
        tarjetasCredito.add(tarjeta);
        /*TODO mas funcionalidades si es necesario*/
    }

}
