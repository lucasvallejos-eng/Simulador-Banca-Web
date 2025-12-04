package clasesFuncionales;

/**
 * Clase abstracta de la cual heredan los tipos de transacci�n
 * @author Raquel Torres
 */
public abstract class Transaccion {

    /**
     * Atributo entero en donde se almacena el id del usuario
     */
    protected Integer idUsuario;

    /**
     * Atriburo en donde se almacena la fecha del usuario
     */
    protected Fecha fecha;
    /**
     * Atributo en donde se almacena el monto de la transaccion
     */
    protected Long monto;
    
    /**
     * Define la {@link clasesFuncionales.Fecha fecha} de la transacción<br>
     * Por defecto, establece la fecha y hora actuales, pero puede ser cambiado
     * {@link clasesFuncionales.Fecha Fecha}
     */
    public Transaccion(){
        //Fecha por defecto: fecha y hora actual
        fecha = new Fecha(true);
    }
    
    /**
     * Define id interno de la transacción<br>
     * Cada clase de transacción tiene ids internos separados
     * @param id Id de la transacción
     */
    public abstract void setId(Integer id);
    
    /**
     * Obtiene id interno de la transacción
     * @return Id de la transacción
     */
    public abstract Integer getId();
    
    /**
     * Define id del usuario que realiza la transacción
     * @param id Id del usuario
     */
    public void setIdUsuario(Integer id){
        idUsuario = id;
    }
    
    /**
     * Define fecha y hora en la que se realiza la transacción ingresando los datos como números
     * @param a Año
     * @param m Mes
     * @param d Día
     * @param h Hora
     * @param min Minuto
     */
    public void setFecha(Integer a, Integer m, Integer d, Integer h, Integer min){
        fecha = new Fecha(a, m, d, h, min);
    }
    
    /**
     * Define fecha y hora en la que se realiza la transacción ingresando los datos como una variable fecha
     * @param fecha Nueva fecha (con hora)
     */
    public void setFecha(Fecha fecha){
        this.fecha = fecha;
    }
    
    /**
     * Define fecha y hora en la que se realiza la transacción como la fecha y hora actual
     */
    public void setFecha(){
        //Fecha y hora actual
        fecha = new Fecha(true);
    }
    
    /**
     * Define monto de dinero de la transacción
     * @param monto Monto de dinero
     */
    public void setMonto(Long monto){
        this.monto = monto;
    }
    
    /**
     * Obtiene el id del usuario que realiza la transacción
     * @return id del usuario
     */
    public Integer getIdUsuario(){
        return idUsuario;
    }
    
    /**
     * Obtiene la fecha de transacción
     * @return Fecha de transacción
     */
    public Fecha getFecha(){
        return fecha;
    }
    
    /**
     * Obtiene el monto de la transacción
     * @return Monto de la transacción
     */
    public Long getMonto(){
        return monto;
    }
}
