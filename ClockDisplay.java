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
    //Un objeto NumberDisplay que nos guarda los dias.
    private NumberDisplay dia;
    //Un objeto NumberDisplay que nos guarda los mes.
    private NumberDisplay mes;
    //Un objeto NumberDisplay que nos guarda los año.
    private NumberDisplay año;
    //Un string de 5 caracteres: la hora, dos puntos y los minutos.
    private String horaActual;

    private String fechaActual;
    /**
     * Constuctor for objects of class ClockDisplay 
     */
    public ClockDisplay()
    {
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        dia = new NumberDisplay(31);
        mes  = new NumberDisplay(13);
        año = new NumberDisplay(100);
        
        dia.setValue(1);
        mes.setValue(1);
        año.setValue(0);
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
        dia = new NumberDisplay(31);
        mes  = new NumberDisplay(13);
        año = new NumberDisplay(100);
        dia.setValue(nuevoDia);
        mes.setValue(nuevoMes);
        año.setValue(nuevoAño);
        updateDisplay();
    }

    /**
     *Fija una nueva hora a partir de las horas y minutos dados 
     */
    public void setTime (int setHoras, int setMinutos, int setDia, int setMes, int setAño)
    {
        horas.setValue(setHoras);
        minutos.setValue(setMinutos);
        dia.setValue(setDia);
        mes.setValue(setMes);
        año.setValue(setAño);
        updateDisplay();
    }

    public String getTime()
    {
        return horaActual;
    }

    /**
     * metodo diaTick para avanzar un dia poniendo una hora en concreto. 
     */
    private void diaTick()
    {
        dia.increment();
        
        if (dia.getValue() == 0)
        {   
            dia.setValue(1);
            mes.increment();
            
            if (mes.getValue() == 0)
            {
                mes.setValue(1);
                año.increment();
            }
        }
    }

    /**
     * metodo timeTick que hace avanzar un minuto la hora actual. 
     */
    public void timeTick()
    {
        minutos.increment();
        if(minutos.getValue() == 0) {  // it just rolled over!
            horas.increment();
            if (horas.getValue() == 0)
            {
                diaTick();
            }
        }
        updateDisplay();
    }

    /**
     * 
     */
    private void updateDisplay()
    {
        fechaActual = " " + dia.getDisplayValue() + "/" + mes.getDisplayValue() +  "/" + año.getDisplayValue();
        String pm = "P.M";
        String am = "A.M";
        if(horas.getValue() < 12)
        {
            if (horas.getValue() == 0)
            {
                horaActual = "12"+ ":" + minutos.getDisplayValue() + am + fechaActual;
            }
            else
            {
                horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue() + am + fechaActual;
            }
        }
        else
        {
            if (horas.getValue() == 12)
            {
                horaActual = horas.getValue() + ":" + minutos.getDisplayValue() + pm + fechaActual;
            }
            else
            {
                if((horas.getValue()-12) <10 )
                {
                    horaActual = "0" + (horas.getValue()-12) + ":" + minutos.getDisplayValue() + pm + fechaActual;
                }
                else
                {
                    horaActual = (horas.getValue()-12) + ":"  + minutos.getDisplayValue() + pm + fechaActual;
                }
            }
        }
    }

}