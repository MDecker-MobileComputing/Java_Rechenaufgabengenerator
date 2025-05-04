package de.eldecker.rechenaufgabengenerator;

public class Main {

    public static void main(String[] args) {
        
        Rechenaufgabe[] aufgabenArray = new Rechenaufgabe[20];
        
        for (int i = 0; i < aufgabenArray.length; i++) {
            
            aufgabenArray[i] = new Rechenaufgabe();
        }
        
        
        System.out.println("Aufgaben:\n");
        for (Rechenaufgabe aufgabe : aufgabenArray) {

            System.out.println( aufgabe + "\n" );
        }
        
        System.out.println("\n\nLösungen:\n");

        for (Rechenaufgabe aufgabe : aufgabenArray) {

            System.out.println( aufgabe.toStringMitErgebnis() + "\n" );
        }
    }
    
}
