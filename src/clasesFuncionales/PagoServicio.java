package clasesFuncionales;

/**
 * Pago de servicios
 * @author Raquel Torres
 */
public class PagoServicio extends Transaccion{
    
    /**
     * Id de transacción del pago
     */
    private Integer idPago;
    
    /**
     * Id de la entidad a la que se realiza el pago
     */
    private Integer idEntidad;
    
    /**
     * Razón del pago
     */
    private String razon;
    
    /**
     * Define la fecha de la transacción<br>
     * Por defecto, establece la {@link clasesFuncionales.Fecha fecha y hora} actuales, pero puede ser cambiado
     */
    public PagoServicio(){
        super();
    }
    
    /**
     * Define el id de pago
     * @param id Id del pago
     */
    @Override
    public void setId(Integer id){
        idPago = id;
    }
    
    /**
     * Obtiene el id de pago
     * @return Id del pago
     */
    @Override
    public Integer getId() {
        return idPago;
    }
    
    /**
     * Define el id de la entidad a pagar
     * @param id Id de la entidad
     */
    public void setIdEntidad(Integer id){
        idEntidad = id;
    }

    /**
     * Define la razón de pago
     * @param razon Razón
     */
    public void setRazon(String razon){
        this.razon = razon;
    }
    
    
    /**
     * Obtiene el id de la entidad a pagar
     * @return Id de la entidad a la que se realiza el pago
     */
    public Integer getIdEntidad(){
        return idEntidad;
    }
    
    /**
     * Obtiene la razón de pago
     * @return Razón de pago
     */
    public String getRazon(){
        return razon;
    }
    
    
}
