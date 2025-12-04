package clasesFuncionales;

/**
 * Depósito de saldo en una cuenta
 * @author Raquel Torres
 */
public class Deposito extends Transaccion{
    
    /**
     * Id interna del depósito
     */
    private Integer idDeposito;
    
    /**
     * Método de pago del depósito
     */
    private String metodoPago;
            
    /**
     * Define la {@link clasesFuncionales.Fecha fecha} de la transacción<br>
     * Por defecto, establece la fecha y hora actuales, pero puede ser cambiado<br>
     */
    public Deposito(){
        super();
        
    }
    
    /**
     * Define la {@link clasesFuncionales.Fecha fecha} de la transacción y el monto a depositar<br>
     * Por defecto, establece la fecha y hora actuales, pero puede ser cambiado<br>
     * @param monto Monto a depositar
     */
    public Deposito(Long monto){
        //por defecto, se instancia la fecha y hora actual
        super();
        this.monto = monto;
    }
    
    /**
     * Define la id del depósito
     * @param id Id del depósito
     */
    @Override
    public void setId(Integer id){
        idDeposito = id;
    }
    
    /**
     * Obtiene la id del depósito
     * @return Id del depósito
     */
    @Override
    public Integer getId(){
        return idDeposito;
    }
    
    /**
     * Define el método de pago del depósito
     * @param metodo Método de pago
     */
    public void setMetodo(String metodo){
        metodoPago = metodo;
    }
    
    /**
     * Obtiene el método de pago del depósito
     * @return Metodo de pago
     */
    public String getMetodo(){
        return metodoPago;
    }
}
