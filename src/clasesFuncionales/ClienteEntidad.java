package clasesFuncionales;

/**
 * Cliente de tipo entidad (Empresas, Organizaciones, etc)
 * @author lucas
 */
public class ClienteEntidad extends Cliente{
    
    /**
     * Id interna de la entidad
     */
    private Integer idEntidad;
    
    /**
     * Atributo en donde se almacena el valor de ClienteEntidad para evitar duplicaciones
     */
    public static ClienteEntidad instance;
    
    /**
     * Metodo de instancia que te devuelve el cliente para evitar duplicados
     * @return Una instacia creada de Cliente
     */
    public static ClienteEntidad getInstance(){
        if (instance==null){
            return null;
        }
        return instance;
    }
    
    /**
     * Inicializa la lista de tarjetas de crédito
     */
    public ClienteEntidad(){
        super();
        instance=this;
    }
    
    /**
     * Define el id de la entidad
     * @param id Nuevo id
     */
    public void setIdEnt(Integer id){
        idEntidad = id;
    }
    
    /**
     * Obtiene el id de la entidad
     * @return Id interna de la entidad
     */
    public Integer getIdEnt(){
        return idEntidad;
    }
}
