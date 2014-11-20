/**
 * Write a description of class ClockDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplay
{
    //Un objeto NumberDisplay que nos guarda la hora.
    private NumberDisplay horas;
    //Un objeto NumberDisplay que nos guarda los minutos.
    private NumberDisplay minutos;
    //Un string de 5 caracteres: la hora, dos puntos y los minutos.
    private String horaActual;
    
    /**
     * Constuctor for objects of class ClockDisplay 
     */
    public ClockDisplay()
    {
      horas = new NumberDisplay(24);
      minutos = new NumberDisplay(60);
      updateDisplay();
    }
    
     /**
      * Constructor que crea un reloj con las horas y minutos dados
      */
     public ClockDisplay(int nuevaHora, int nuevoMinuto)
    {
      horas = new NumberDisplay(24);
      minutos = new NumberDisplay(60);
      horas.setValue(nuevaHora);
      minutos.setValue(nuevoMinuto);
      updateDisplay();
    }
    
    /**
     *Fija una nueva hora a partir de las horas y minutos dados 
     */
    public void setTime (int setHoras, int setMinutos)
    {
     horas.setValue(setHoras);
     minutos.setValue(setMinutos);
     updateDisplay();
    }
    
    /**
     * metodo timeTick que hace avanzar un minuto la hora actual. 
     */
    public void timeTick()
    {
        minutos.increment();
        if(minutos.getValue() == 0) {  // it just rolled over!
            horas.increment();
        }
        updateDisplay();
    }
    public String get()
    {
    return horaActual;
    }
    
    private void updateDisplay()
    {
        horaActual = horas.getDisplayValue()+ ":" + minutos.getDisplayValue();
    }
}
