/**
 * Write a description of class NumberDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumberDisplay
{
    public int limite;
    public int value;
//new commit
    /**
     * Un constructor que recibe por parámetro el límite del display y que fija el valor actual del display a 0.
     */
    public NumberDisplay(int nuevoLimite)
    {
        // initialise instance variables
        value = 0;
        limite = nuevoLimite;
    }

    /**
     * Un método setter que fija el valor actual del display al valor pasado como parámetro(nombre del método: setValue)
     */
    public void setValue(int currentValue)
    {
        value = currentValue;
    }
    
    /**
     * New commit
     * Un método que devuelve el valor actual del display en forma de cadena de 2 caracteres (nombre del método: getDisplayValue).
     */
 
    public String getDisplayValue()
    {
        if(value < 10) {
            return "0" + value;
        }
        else {
            return "" + value;
        }
    }
    
    /**
     * Un método que devuelve el valor actual del display como entero (nombre del método: getValue)
     */
    public int getValue()
    {
       return value;
    }
    
    /**
     * Un método que incrementa en 1 al display y lo hace volver al principio si alcanza el límite (nombre del método: increment)
     */
    public void increment()
    {
        value = value + 1;
        if (value == limite)
        {
            value = 0;
        }
    }
}



