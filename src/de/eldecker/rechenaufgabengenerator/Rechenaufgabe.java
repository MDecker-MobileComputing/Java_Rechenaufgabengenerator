package de.eldecker.rechenaufgabengenerator;

import java.util.Random;


/**
 * Ein Objekt dieser Klasse repräsentiert eine einzelne Rechenaufgabe,
 * z.B. "102 - 5".
 */
public class Rechenaufgabe {

    /** Array mit einigen zweistelligen Primzahlen. */
    private final static int[] PRIMZAHLEN = { 11, 13, 17, 19, 23, 29, 31, 37 };

    /** Zufallsgenerator. */
    private static final Random ZUFALL = new Random();
    
    /** Operand 1. */
    private int _zahl1;
    
    /** Operand 2.*/ 
    private int _zahl2;
    
    /** Wenn {@code true}, dann Addition, sonst Subtraktion. */
    private boolean _istAddition;
    
    /** Ergebnis der Addition/Subtraktion für Musterlösung. */
    private int _ergebnis;
    
    
    /**
     * Konstruktor, der eine zufällige Rechenaufgabe erstellt.
     */
    public Rechenaufgabe() {
      
        _zahl1 = getUngeradeZufallsZahl( 10_000, 98_000 );
        _zahl2 = getUngeradeZufallsZahl(     20,     50 );
        
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
    @SuppressWarnings("unused")
	private static int getZufallszahl( int min, int max ) {
    
    	int delta = max - min;
    	
    	int zahl = min + ZUFALL.nextInt( delta );
    	
    	if ( zahl % 10 == 0 ) { zahl++; }
    	
    	return zahl;
    }
    
            
    /** 
     * Methode gibt zufällig ausgewählte Primzahl aus einem Array zurück.
     * 
     * @return zweistellige Primzahl
     */
    @SuppressWarnings("unused")
	private static int getZufallsPrimzahl() {
    	
    	final int anzahl = PRIMZAHLEN.length;
    	
    	final int index = ZUFALL.nextInt( anzahl );
    	
    	return PRIMZAHLEN[ index ];
    }
    
    
    /**
     * Methode erzeugt ungerade Zufallszahlen in bestimmten Bereich.
     * 
     * @param min Untere Grenze
     * 
     * @param max Obere Grenze
     * 
     * @return Ungerade Zufallszahl (evtl. {@code max+1}, damit ungerade)
     */
    private static int getUngeradeZufallsZahl( int min, int max ) {
    	
    	final int delta = max - min;
    	
    	int zahl = min + ZUFALL.nextInt( delta );
    	
    	if ( zahl % 2 == 0 ) { zahl++; }
    	
    	return zahl;
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
     * Gibt Aufgabe mit Ergebnis für Musterlösung zurück.
     * 
     * @return Beispiel: "102 - 5 = 97"
     */
    public String toStringMitErgebnis() {
        
        return _zahl1 + " " + operatorAlsString() + " " + _zahl2 + " = " + _ergebnis;
    }
    
}
