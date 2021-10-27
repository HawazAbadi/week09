import static javax.sound.sampled.AudioSystem.getAudioInputStream;

import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/*
    To compile: javac SpotifyLikeApp.java
    To run: java SpotifyLikeApp
 */
// declares a class for the app
public class SpotifyLikeApp {
    // global variables for the app
    String status;
    Long position;
    static Clip audioClip;
    // "main" makes this class a java app that can be executed
    public static void main(final String[] args) {
        // create a scanner for user input
        Scanner input = new Scanner(System.in);
        String userInput = "";
        while (!userInput.equals("q")) {
            menu();
            // get input
            userInput = input.nextLine();
            // accept upper or lower case commands
            userInput.toLowerCase();
            // do something
            handleMenu(userInput);
        }
        // close the scanner
        input.close();
    }
    /*
     * displays the menu for the app
     */
    public static void menu() {
        System.out.println("---- SpotifyLikeApp ----");
        System.out.println("[H]ome");
        System.out.println("[S]earch by title");
        System.out.println("[L]ibrary");
        System.out.println("[P]lay");
        System.out.println("[Q]uit");
        System.out.println("");
        System.out.print("Enter q to Quit:");
    }
    /*
     * handles the user input for the app
     */
    public static void handleMenu(String userInput) {
        switch(userInput) {
            case "h":
                System.out.println("-->Home<--");
                break;
            case "s":
                System.out.println("-->Search by title<--");
                break;
            case "l":
                System.out.println("-->Library<--");
                break;
                
            case "p":
                System.out.println("-->Play<--");
                play();
                break;
            case "q":
                System.out.println("-->Quit<--");
                break;
            default:
                break;
        }
    }
    /*
     * plays an audio file
     */
    public static void play() {
        // open the audio file
        final File file = new File("Bisou_-_04_-_Journey_of_King.wav");
        try {
        
            // create clip 
            audioClip = AudioSystem.getClip();
            // get input stream
            final AudioInputStream in = getAudioInputStream(file);
            audioClip.open(in);
            audioClip.setMicrosecondPosition(0);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch(Exception e) {
            e.printStackTrace(); 
        }
    }
}