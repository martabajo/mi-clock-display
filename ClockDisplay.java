/**
 * Write a description of class ClockDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplay
{
    private NumberDisplay horas;
    private NumberDisplay minutos;
    private String horaActual;
    
    public ClockDisplay()
    {
      horas = new NumberDisplay(24);
      minutos = new NumberDisplay(60);
      horaActual = horas.getDisplayValue()+ ":" + minutos.getDisplayValue();
    }
    
     public ClockDisplay(int nuevaHora, int nuevoMinuto)
    {
      horas = new NumberDisplay(24);
      minutos = new NumberDisplay(60);
      horas.setValue(nuevaHora);
      minutos.setValue(nuevoMinuto);
      horaActual = horas.getDisplayValue()+ ":" + minutos.getDisplayValue();
    }
    
    public void setTime (int setHoras, int setMinutos)
    {
     horas.setValue(setHoras);
     minutos.setValue(setMinutos);
    }
    
    public String get()
    {
    return horaActual;
    }
}
