/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesFuncionales;


/**
 * Tarjeta de crédito
 * @author Raquel Torres
 */
public class TarjetaCredito {
    
    /**
     * Id del usuario dueño de la tarjeta
     */
    private Integer idUsuario;
    
    /**
     * Número de la tarjeta
     */
    private Integer nroTarjeta;
    
    /**
     * Fecha de vigencia de la tarjeta de crédito
     */
    private Fecha fechaVigencia;
    
    /**
     * Contraseña de la tarjeta de crédito
     */
    private Integer codigoSeguridad;
    
    /**
     * Deuda actual de la tarjeta, no debe superar el límiteDeuda
     */
    private Integer deuda;
    
    /**
     * Establece la máxima deuda que puede tener la tarjeta
     */
    private Integer limiteDeuda;
    
    /**
     * Inicializa la fecha de vencimiento de la tarjeta<br>
     * Si no se establece una fecha de vencimiento, por defecto, se establece el vencimiento como el mismo mes, con 5 años.
     */
    public TarjetaCredito(){
        //Si no se establece una fecha de vencimiento, por defecto se dice que la 
        //fecha es en el mismo mes, en 5 a�os
        fechaVigencia = new Fecha(false);
        fechaVigencia.setFechaVenc();
    }
    
    /**
     * Inicializa la fecha de vencimiento de la tarjeta y su id<br>
     * Si no se establece una fecha de vencimiento, por defecto, se establece el vencimiento como el mismo mes, con 5 años.
     * @param id Id de la tarjeta
     */
    public TarjetaCredito(Integer id){
        //Si no se establece una fecha de vencimiento, por defecto se dice que la 
        //fecha es en el mismo mes, en 5 a�os
        fechaVigencia = new Fecha(false);
        fechaVigencia.setFechaVenc();
        idUsuario = id;
    }
    
    /**
     * Inicializa la fecha de vencimiento de la tarjeta y su id
     * @param id Id de la tarjeta
     * @param fecha Fecha de vencimiento de la tarjeta
     */
    public TarjetaCredito(Integer id, Fecha fecha){
        idUsuario = id;
        fechaVigencia = fecha;
    }
    
    /**
     * Inicializa la fecha de vencimiento de la tarjeta
     * @param fecha Fecha de vencimiento de la tarjeta
     */
    public TarjetaCredito(Fecha fecha){
        fechaVigencia = fecha;
    }
    
    /**
     * Inicializa la fecha de vencimiento de la tarjeta y su id
     * @param id Id de la tarjeta
     * @param y Año de vencimiento
     * @param m Mes de vencimiento
     */
    public TarjetaCredito(Integer id, Integer y, Integer m){
        idUsuario = id;
        fechaVigencia = new Fecha(y, m);
    }
    
    /**
     * Inicializa la fecha de vencimiento de la tarjeta
     * @param y Año de vencimiento
     * @param m Mes de vencimiento
     */
    public TarjetaCredito(Integer y, Integer m){
        fechaVigencia = new Fecha(y, m);
    }
    
    /**
     * Define el id del usuario dueño de la tarjeta de crédito
     * @param id Id del usuario
     */
    public void setIdUsuario(Integer id){
        idUsuario = id;
    }
    
    /**
     * Define el número de la tarjeta de crédito
     * @param nro Número
     */
    public void setNro(Integer nro){
        nroTarjeta = nro;
    }
    
    /**
     * Define fecha de vencimiento de la tarjeta con números
     * @param a Año de vencimiento
     * @param m Mes de vencimiento
     */
    public void setFecha(Integer a, Integer m){
        fechaVigencia = new Fecha(a, m);
    }
    
    /**
     * Define fecha de vencimiento de la tarjeta con una variable fecha
     * @param fecha Fecha de vencimiento
     */
    public void setFecha(Fecha fecha){
        fechaVigencia = fecha;
    }

    /**
     * Define el código de seguridad (contraseña) de la tarjeta
     * @param cod Código de seguridad
     */
    public void setCodigo(Integer cod){
        codigoSeguridad = cod;
    }
    
    /**
     * Define la deuda a pagar de la tarjeta
     * @param deuda Deuda
     */
    public void setDeuda(Integer deuda){
        this.deuda = deuda;
    }
    
    /**
     * Define el límite de deuda de la tarjeta, la deuda no puede sobrepasar este límite
     * @param limite Límite de deuda
     */
    public void setLimiteDeuda(Integer limite){
        limiteDeuda = limite;
    }
    
    /**
     * Obtiene el id del usuario dueño de la tarjeta de crédito
     * @return IdUsuario
     */
    public Integer getIdUsuario(){
        return idUsuario;
    }
    
    /**
     * Obtiene el número de la tarjeta de crédito
     * @return Numero de tarjeta
     */
    public Integer getNro(){
        return nroTarjeta;
    }
    
    /**
     * Obtiene la fecha de vencimiento de la tarjeta
     * @return Fecha de vencimiento
     */
    public Fecha getFecha(){
        return fechaVigencia;
    }
    
    /**
     * Obtiene el código de seguridad de la tarjeta
     * @return Código de seguridad
     */
    public Integer getCodigo(){
        return codigoSeguridad;
    }
    
    /**
     * Obtiene la deuda de la tarjeta
     * @return Deuda
     */
    public Integer getDeuda(){
        return deuda;
    }
    
    /**
     * Obtiene el límite de deuda de la tarjeta
     * @return Límite de deuda
     */
    public Integer getLimiteDeuda(){
        return limiteDeuda;
    }
    
    //pagar y aumentar retornan el nuevo total de la deuda
    /**
     * Pagar deuda de la tarjeta
     * @param pago Pago que se va a realizar
     * @return La cantidad restante de la deuda
     */
    public Integer pagarDeuda(Integer pago){
        //el sistema se debe encargar de no ir a los numeros negativos antes de realizar el pago
        deuda = deuda - pago;
        return deuda;
    }
    
    /**
     * Aumentar el monto de la deuda
     * @param deuda Monto a aumentar
     * @return El total de la deuda después de añadir
     */
    public Integer aumentarDeuda(Integer deuda){
        //el sistema se debe encargar de revisar que no supere la deuda máxima antes de aumentar
        this.deuda = this.deuda + deuda;
        return this.deuda;
    }
}
