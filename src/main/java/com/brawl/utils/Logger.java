package com.brawl.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Custom logger for outputting message to a custom output
 */
public class Logger {
    private final String filePath;

    public Logger(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Logs a message to our output
     * The message is also printed in the standard output
     * @param message Message to be written
     */
    public void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath, true))) {
            // Writing message to our custom output
            out.println(message);
            // Also redirect log to stdout
            System.out.println(message);
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier de log");
        }
    }
}