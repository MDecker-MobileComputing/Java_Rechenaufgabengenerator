package de.eldecker.rechenaufgabengenerator;


/**
 * Klasse mit Einstiegspunkt.
 */
public class Main {

    private static final int ANZAHL_AUFGABEN = 40;
    
    /** Wird zu Beginn von Aufgabe {@link #schreibeAufgabenTrenner()} erhöht. */
    private static int ZEILEN_ZAEHLER = 0;
    
    
    /**
     * Einstiegspunkt.
     * 
     * @param args Wird nicht ausgewertet
     */
    public static void main( String[] args ) {
        
        final Rechenaufgabe[] aufgabenArray = new Rechenaufgabe[ ANZAHL_AUFGABEN ];
        
        for ( int i = 0; i < aufgabenArray.length; i++ ) {
            
            aufgabenArray[i] = new Rechenaufgabe();
        }
        
        
        System.out.println( "Aufgaben:\n" );
        for ( Rechenaufgabe aufgabe : aufgabenArray ) {

            System.out.print( aufgabe );
         
            schreibeAufgabenTrenner();
        }
        
        ZEILEN_ZAEHLER = 0;
        
        System.out.println( "\n\nLösungen:\n" );

        for ( Rechenaufgabe aufgabe : aufgabenArray ) {

            System.out.print( aufgabe.toStringMitErgebnis() );
            
            schreibeAufgabenTrenner();
        }
    }
    
    
    /**
     * Schreibt Leerzeilen und Tabs zwischen zwei Aufgaben
     * (ersteres für ungerade Zeilennummern, letzteres für gerade).
     * In der Methode wird zuerst der Zeilen-Zähler erhöht.
     */
    private static void schreibeAufgabenTrenner() {
        
        ZEILEN_ZAEHLER++;
        
        if ( ZEILEN_ZAEHLER % 2 == 1 ) {
            
            System.out.print( "\t\t\t\t" );
            
        } else {
         
            System.out.print( "\n\n" );
        }
    }
    
}
