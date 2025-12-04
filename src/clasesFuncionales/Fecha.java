package clasesFuncionales;

import java.util.Calendar;

/**
 * Clase de fecha que hace uso de la clase Calendar de java
 * @author lucas
 */
public class Fecha {
    private Integer year;
    
    /**
     * Mes de la fecha, en números<br>
     * Empieza en 1 para Enero
     */
    private Integer mes;
    
    /**
     * Mes de la fecha, en texto<br>
     * Se genera automáticamente cuando se genera o ajusta la fecha
     */
    private String mesStr;
    private Integer dia;
    private Integer hora;
    private Integer minuto;

    /**
     * Almacena fecha actual con o sin hora
     * @param conHora Indica si la fecha necesita tener hora o no
     */
    public Fecha(boolean conHora){
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        mes = c.get(Calendar.MONTH) + 1;
        mesStr = obtenerMesStr(mes);
        dia = c.get(Calendar.DATE);
        if (conHora){    
            hora = c.get(Calendar.HOUR_OF_DAY);
            minuto = c.get(Calendar.MINUTE);
        }
    }
    
    /**
     * Almacena una fecha especificada con a�o, mes y d�a
     * @param y A�o
     * @param m Mes
     * @param d D�a
     */
    public Fecha(Integer y, Integer m, Integer d){
        year = y;
        mes = m;
        mesStr = obtenerMesStr(m);
        dia = d;
    }
    
    /**
     * Almacena una fecha especificada con a�o, mes y d�a
     * @param y A�o
     * @param m Mes
     */
    public Fecha(Integer y, Integer m){
        year = y;
        mes = m;
        mesStr = obtenerMesStr(m);
    }
    
    /**
     * Almacena una fecha especificada con a�o, mes, d�a, hora y minuto
     * @param y A�o
     * @param m Mes
     * @param d D�a
     * @param h Hora
     * @param min Minuto
     */
    public Fecha(Integer y, Integer m, Integer d, Integer h, Integer min){
        year = y;
        mes = m;
        mesStr = obtenerMesStr(m);
        dia = d;
        hora = h;
        minuto = min;
    }

    /**
     * Define fecha como la fecha actual, con hora o sin hora
     * @param conHora Indica si la fecha necesita tener hora
     */
    public void setFecha(boolean conHora){
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        mes = c.get(Calendar.MONTH) + 1;
        mesStr = obtenerMesStr(mes);
        dia = c.get(Calendar.DATE);
        if (conHora){    
            hora = c.get(Calendar.HOUR_OF_DAY);
            minuto = c.get(Calendar.MINUTE);
            //segundo = c.get(Calendar.SECOND);
        }
    }
    
    /**
     * Aumenta el año en 5, utilizado para vencimiento de tarjetas de crédito
     */
    public void setFechaVenc(){
        year = year + 5;
    }
    
    /**
     * Define el año de la fecha
     * @param y Año
     */
    public void setYear(Integer y){
        year = y;
    }
    
    /**
     * Define el mes de la fecha
     * @param m Mes
     */
    public void setMes(Integer m){
        mes = m;
    }
    
    /**
     * Define el día de la fecha
     * @param d Día
     */
    public void setDia(Integer d){
        dia = d;
    }
    
    /**
     * Define la hora de la fecha
     * @param h Hora
     */
    public void setHora(Integer h){
        hora = h;
    }
    
    /**
     * Obtiene el minuto de la fecha
     * @param m Minuto
     */
    public void setMinuto(Integer m){
        minuto = m;
    }
    
    /**
     * Obtiene el año de la fecha
     * @return Año
     */
    public Integer getYear(){
        return year;
    }
    
    /**
     * Obtiene el mes de la fecha, en número
     * @return Mes
     */
    public Integer getMesInt(){
        return mes;
    }
    
    /**
     * Obtiene el mes de la fecha, en formato cadena
     * @return Mes
     */
    public String getMesStr(){
        return mesStr;
    }
    
    /**
     * Obtiene el día de la fecha
     * @return Día
     */
    public Integer getDia(){
        return dia;
    }

    /**
     * Retorna la fecha con formato cadena en estilo: "[día] de [mes] de [año], [hora]:[minuto] hs" 
     * @param conHora Determina si incluye la hora
     * @return Fecha en formato cadena
     */
    public String toStringLargo(boolean conHora){
        //anotacion: si se quiere usar dias de la semana despues, Calendar.DAY_OF_MONTH indexa empezando con domingo index 1 
        if (conHora){
            return dia.toString() + " de " + mesStr + " de " + year.toString() + ", " + hora + ":" + minuto + " hs";
        } else {
            return dia.toString() + " de " + mesStr + " de " + year.toString();
        }
    }
    
    /**
     * Retorna la fecha con formato cadena en estilo: "dd/mm/aaaa, hh:min"
     * @param conHora Determina si incluye la hora
     * @return Fecha en formato cadena
     */
    public String toStringCorto(boolean conHora){
        if (conHora){
            return dia.toString() + "/" + mes.toString() + "/" + year.toString() + ", " + hora.toString() + ":" + minuto.toString();
        } else {
            return dia.toString() + "/" + mes.toString() + "/" + year.toString();
        }
    }
    
    /**
     * Retorna la fecha con formato cadena en estilo: "mm/aaaa"
     * @return Fecha en formato cadena
     */
    public String toStringYearMes(){
        return mes.toString() + "/" + year.toString();
    }
   
    /**
     * Convierte el mes a cadena<br>
     * Empieza en 1 = Enero
     * @param m Mes
     * @return Mes en cadena
     */
    private String obtenerMesStr(Integer m){
        switch (m){
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Setiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "Error";
        }
    }
}
