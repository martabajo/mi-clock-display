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
    private NumberDisplay dia;
    private NumberDisplay mes;
    private NumberDisplay año;
    /**
     * Constuctor for objects of class ClockDisplay 
     */
    public ClockDisplay()
    {
      horas = new NumberDisplay(24);
      minutos = new NumberDisplay(60);
      dia = new NumberDisplay(30);
      mes  = new NumberDisplay(12);
      año = new NumberDisplay(2015);
      updateDisplay();
    }
    
     /**
      * Constructor que crea un reloj con las horas y minutos dados
      */
     public ClockDisplay(int nuevaHora, int nuevoMinuto, int nuevoDia, int nuevoMes, int nuevoAño)
    {
      horas = new NumberDisplay(24);
      minutos = new NumberDisplay(60);
      horas.setValue(nuevaHora);
      minutos.setValue(nuevoMinuto);
      dia = new NumberDisplay(30);
      mes  = new NumberDisplay(12);
      año = new NumberDisplay(2015);
      dia.setValue(nuevoDia);
      mes.setValue(nuevoMes);
      año.setValue(nuevoAño);
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
    
    public String getTime()
    {
    return horaActual;
    }
    
    private void updateDisplay()
    {
        if(horas.getValue() < 12)
        {
            if (horas.getValue() == 0)
            {
                horaActual = "12"+ ":" + minutos.getDisplayValue() + " am"+ " " + dia.getDisplayValue() + "/" + mes.getDisplayValue() +  "/" + año.getDisplayValue();
            }
            else
            {
                horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue() + " am" + " " + dia.getDisplayValue() + "/" + mes.getDisplayValue() +  "/" + año.getDisplayValue();
            }
        }
        else
        {
            if (horas.getValue() == 12)
            {
                horaActual = horas.getValue() + ":" + minutos.getDisplayValue() + " pm"+ " " + dia.getDisplayValue() + "/" + mes.getDisplayValue() +  "/" + año.getDisplayValue();
            }
            else
            { 
                if((horas.getValue()-12) <10 )
                {
                    horaActual = "0" + (horas.getValue()-12) + ":" + minutos.getDisplayValue() + " pm"+ " " + dia.getDisplayValue() + "/" + mes.getDisplayValue() +  "/" + año.getDisplayValue();
                }
                else
                {
                    horaActual = (horas.getValue()-12) + ":"  + minutos.getDisplayValue() + " pm"+ " " + dia.getDisplayValue() + "/" + mes.getDisplayValue() +  "/" + año.getDisplayValue();
                }
            }
        }
    }
    
}
