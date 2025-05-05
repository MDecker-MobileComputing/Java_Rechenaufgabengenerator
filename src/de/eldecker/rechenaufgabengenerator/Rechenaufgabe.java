package de.eldecker.rechenaufgabengenerator;

import java.util.Random;


/**
 * Ein Objekt dieser Klasse repräsentiert eine einzelne Rechenaufgabe,
 * z.B. "102 - 5".
 */
public class Rechenaufgabe {

    private static final Random ZUFALL = new Random();
    
    private int _zahl1;
    private int _zahl2;
    
    private boolean _istAddition;
    
    private int _ergebnis;
    
    
    /**
     * Konstruktor, der eine zufällige Rechenaufgabe erstellt.
     */
    public Rechenaufgabe() {
      
        _zahl1 = 100 + ZUFALL.nextInt( 900 );
        _zahl2 =  11 + ZUFALL.nextInt( 15  );
        
        _istAddition = ZUFALL.nextBoolean();
        
        
        if ( _istAddition ) {
            
            _ergebnis = _zahl1 + _zahl2;
            
        } else {
            
            _ergebnis = _zahl1 - _zahl2;
        }
    }
    
    
    /**
     * Operator der Rechenaufgabe (Plus oder Minus) als String.
     * 
     * @return "+" oder "-"
     */
    private char operatorAlsString() {
        
        return _istAddition ? '+' : '-';
    }
    
    
    /**
     * Gibt Aufgabe ohne Ergebnis zurück.
     * 
     * @return Beispiel: "102 - 5 = "
     */
    @Override
    public String toString() {
        
        return _zahl1 + " " + operatorAlsString() + " " + _zahl2 + " = ";
    }
    
    
    /**
     * Gibt Aufgabe mit Ergebnis zurück.
     * 
     * @return Beispiel: "102 - 5 = 97"
     */
    public String toStringMitErgebnis() {
        
        return _zahl1 + " " + operatorAlsString() + " " + _zahl2 + " = " + _ergebnis;
    }
    
}
