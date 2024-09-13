package org.example;

public class Main {
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();
        editor.importImage("d:\\Java\\ImageEditor\\input.jpg");

        // Single-threaded adjustment
        long startTime = System.currentTimeMillis();
        editor.adjustBrightness(50);
        long endTime = System.currentTimeMillis();
        System.out.println("Single-threaded execution time: " + (endTime - startTime) + " ms");
        editor.exportImage("d:\\Java\\ImageEditor\\output.jpg");

        // Multi-threaded adjustment
        editor.importImage("d:\\Java\\ImageEditor\\input.jpg"); // Reload the original image
        startTime = System.currentTimeMillis();
        editor.adjustBrightnessUsingThreads(50);
        endTime = System.currentTimeMillis();
        System.out.println("Multi-threaded execution time: " + (endTime - startTime) + " ms");
        editor.exportImage("d:\\Java\\ImageEditor\\output1.jpg");
    }
}