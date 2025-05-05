package de.eldecker.rechenaufgabengenerator;


/**
 * Klasse mit Einstiegspunkt.
 */
public class Main {

    private static final int ANZAHL_AUFGABEN = 20;
    
    
    /**
     * Einstiegspunkt
     * 
     * @param args Wird nicht ausgewertet
     */
    public static void main(String[] args) {
        
        final Rechenaufgabe[] aufgabenArray = new Rechenaufgabe[ ANZAHL_AUFGABEN ];
        
        for ( int i = 0; i < aufgabenArray.length; i++ ) {
            
            aufgabenArray[i] = new Rechenaufgabe();
        }
        
        
        System.out.println( "Aufgaben:\n" );
        for ( Rechenaufgabe aufgabe : aufgabenArray ) {

            System.out.println( aufgabe + "\n" );
        }
        
        System.out.println( "\n\nLösungen:\n" );

        for ( Rechenaufgabe aufgabe : aufgabenArray ) {

            System.out.println( aufgabe.toStringMitErgebnis() + "\n" );
        }
    }
    
}
