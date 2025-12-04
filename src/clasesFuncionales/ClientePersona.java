package clasesFuncionales;

/**
 * Cliente individuo
 * @author lucas
 */
public class ClientePersona extends Cliente{
    
    /**
     * Número de CI de la persona
     */
    private Integer nroDocumento;
    
    /**
     * Apellido(s) de la persona<br>
     * Los clientes individuales tienen apellido además de nombre
     */
    private String apellido;
    
    /**
     * Fecha de nacimiento de la persona
     */
    private Fecha fechaNacimiento;
    
    /**
     * Sexo de la persona
     */
    private String sexo;
    /**
     * Atributo de instancia en donde se almacena el ClientePersona para evitar duplicados
     */
    public static ClientePersona instance;
    
    /**
     * Metodo que te devuelve la instancia creada para evitar duplicas
     * @return instancia de persona
     */
    public static ClientePersona getInstance(){
        if (instance==null){
            return null;
        }
        return instance;
    }
    
    /**
     * Inicializa la lista de tarjetas de crédito
     */
    public ClientePersona(){
        super(); //Para inicializar el ArrayList de tajetas de cr�dito
        instance=this;
    }
    
    /**
     * Define el número de cédula del cliente
     * @param nro Nuevo número de cédula
     */
    public void setDocumento(Integer nro){
        nroDocumento = nro;
    }
    
    /**
     * Define el nombre y apellido del cliente
     * @param nom Nuevos nombres
     * @param ap Nuevos apellidos
     */
    public void setNombre(String nom, String ap){
        nombre = nom;
        apellido = ap;
    }
    
    /**
     * Define la fecha de nacimiento de la persona
     * @param a Año de nacimiento
     * @param m Mes de nacimiento
     * @param d Día de nacimiento
     */
    public void setFechaNacimiento(Integer a, Integer m, Integer d){
        fechaNacimiento = new Fecha(a, m, d);
    }
    
    /**
     * Define sexo del cliente
     * @param s Sexo del cliente
     */
    public void setSexo(String s){
        sexo = s;
    }
    
    /**
     * Obtiene número de documento (CI) del cliente
     * @return CI del cliente
     */
    public Integer getDocumento(){
        return nroDocumento;
    }
    
    /**
     * Obtiene apellido del cliente
     * @return Apellido del cliente
     */
    public String getApellido(){
        return apellido;
    }
    
    /**
     * Obtiene la fecha de nacimiento del cliente
     * @return Fecha de nacimiento del cliente
     */
    public Fecha getFechaNacimiento(){
        return fechaNacimiento;
    }
    
    /**
     * Obtiene sexo del cliente
     * @return Sexo del cliente
     */
    public String getSexo(){
        return sexo;
    }

}
