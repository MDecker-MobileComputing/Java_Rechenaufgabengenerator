package de.eldecker.rechenaufgabengenerator;

import static java.util.Locale.GERMAN;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Random;


/**
 * Ein Objekt dieser Klasse repräsentiert eine einzelne Rechenaufgabe,
 * z.B. "102 - 5".
 */
public class Rechenaufgabe {

    /** Array mit einigen zweistelligen Primzahlen. */
    private final static int[] PRIMZAHLEN = { 13, 17, 19, 23, 29, 31, 37, 41, 43 };

    /** Formatierer, der Tausendertrennpunkte einfügt. */
    private static DecimalFormat sZahlenFormatierer = erzeugeDecimalFormat();

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
      
        _zahl1 = getZufallszahlNotMod10( 11_000, 99_000 );
        _zahl2 = getZufallszahlNotMod10(  1_000,  2_000 );
        
        //_istAddition = ZUFALL.nextBoolean();
        //_istAddition = false;
        // IDEE: Abwechselnd Plus oder Minus
        
        _istAddition = getPlusMinusAbwechselnd();
        
        if ( _istAddition ) {
            
            _ergebnis = _zahl1 + _zahl2;
            
        } else {
            
            _ergebnis = _zahl1 - _zahl2;
        }
    }
    
    
    /**
     * Zahlenformatierer erzeugen.
     * 
     * @return Zahlenformatierer, der Tausendertrennpunkte einfügt.
     */
    private static DecimalFormat erzeugeDecimalFormat() {
        
        final DecimalFormatSymbols symbole = new DecimalFormatSymbols( GERMAN );
        symbole.setGroupingSeparator( '.' );
        
        return new DecimalFormat( "#,###", symbole );
    }
    
    
    /**
     * Klassenvariable für abwechseln Plus/Minus.
     */
    private static boolean sIstPlus = false;
    
    
    public static boolean getPlusMinusAbwechselnd() {
    	
    	sIstPlus = !sIstPlus;
    	
    	return sIstPlus;
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
    
    	final int delta = max - min;
    	
    	int zahl = min + ZUFALL.nextInt( delta );
    	
    	if ( zahl % 10 == 0 ) { zahl++; }
    	
    	return zahl;
    }
    
    
    /**
     * Generiert eine zufällige Zahl innerhalb eines bestimmten Bereichs, 
     * die durch einen gegebenen Teiler teilbar ist.
     *
     * @param min Der minimale Wert des Bereichs (inklusive).
     * 
     * @param max Der maximale Wert des Bereichs (inklusive).
     * 
     * @param teiler Der Teiler, durch den die zurückgegebene Zahl teilbar sein muss.
     * 
     * @return Eine zufällige Zahl im Bereich [min, max], die durch den angegebenen Teiler teilbar ist.
     */
    private static int getZufallszahl( int min, int max, int teiler ) {
    	    	
        final int start = (min % teiler == 0) ? min : (min + teiler - (min % teiler));
        final int end   = (max % teiler == 0) ? max : (max - (max % teiler));
        
        final int range = (end - start) / teiler + 1;
        final int randomIndex = ZUFALL.nextInt(range);
        
        return start + randomIndex * teiler;
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
    @SuppressWarnings("unused")
	private static int getUngeradeZufallsZahl( int min, int max ) {
    	
    	final int delta = max - min;
    	
    	int zahl = min + ZUFALL.nextInt( delta );
    	
    	if ( zahl % 2 == 0 ) { zahl++; }
    	
    	return zahl;
    }
    
    /**
     * Methode erzeugt ungerade Zufallszahlen in bestimmten Bereich,
     * die aber nicht ein Vielfaches von 10 ist.
     * 
     * @param min Untere Grenze
     * 
     * @param max Obere Grenze
     * 
     * @return Zufallszahl (evtl. {@code max+1}, damit nicht Vielfaches von 10)
     */
    private static int getZufallszahlNotMod10( int min, int max ) {
    	
    	final int delta = max - min;
    	
    	int zahl = min + ZUFALL.nextInt( delta );

    	if ( zahl % 10 == 0 ) { zahl++; }
    	
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
        
        final String zahl1str = sZahlenFormatierer.format( _zahl1 );
        final String zahl2str = sZahlenFormatierer.format( _zahl2 );
        
        return String.format( "%s %s %s = ", 
                              zahl1str, operatorAlsString(), zahl2str );
    }
    
    
    /**
     * Gibt Aufgabe mit Ergebnis für Musterlösung zurück.
     * 
     * @return Beispiel: "1.102 - 5 = 1.097"
     */
    public String toStringMitErgebnis() {
        
        final String zahl1str = sZahlenFormatierer.format( _zahl1    );
        final String zahl2str = sZahlenFormatierer.format( _zahl2    );
        final String ergebStr = sZahlenFormatierer.format( _ergebnis );        
        
        return String.format( "%s %s %s = %s", 
                              zahl1str, operatorAlsString(), zahl2str, ergebStr );        
    }
    
}
