package com.brawl.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private String filePath;

    public Logger(String filePath) {
        this.filePath = filePath;
    }

    public void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath, true))) {
            out.println(message);
            // Also redirect log to stdout
            System.out.println(message);
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier de log");
        }
    }
}