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
      
        _zahl1 = getZufallszahl( 1000, 9000 );
        _zahl2 = getZufallsPrimzahl();
        
        _istAddition = ZUFALL.nextBoolean();
        
        
        if ( _istAddition ) {
            
            _ergebnis = _zahl1 + _zahl2;
            
        } else {
            
            _ergebnis = _zahl1 - _zahl2;
        }
    }
    
    
    /**
     * Erzeugt Zufallszahl, ohne Vielfache von 10 (10er-Vermeidung).
     * 
     * @param min Kleinste Zahl vor 10er-Vermeidung
     * 
     * @param max Obere Schranke vor 10er-Vermeidung
     * 
     * @return Zufallszahl
     */
    private static int getZufallszahl( int min, int max ) {
    
    	int delta = max - min;
    	
    	int zahl = min + ZUFALL.nextInt( delta );
    	
    	if ( zahl % 10 == 0 ) { zahl++; }
    	
    	return zahl;
    }
    
    
    private final static int[] PRIMZAHLEN = { 11, 13, 17, 19, 23, 29, 31 };
    
    
    private static int getZufallsPrimzahl() {
    	
    	final int anzahl = PRIMZAHLEN.length;
    	
    	final int index = ZUFALL.nextInt( anzahl );
    	
    	return PRIMZAHLEN[ index ];
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
