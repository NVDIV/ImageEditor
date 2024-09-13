package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageEditor {
    private BufferedImage image;

    public void importImage(String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exportImage(String outputPath) {
        try {
            ImageIO.write(image, "jpg", new File(outputPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int truncate(int value) {
        return Math.max(0, Math.min(255, value));
    }

    public void adjustBrightness(int brightnessValue) {
        if (image != null) {
            for (int i = 0; i < image.getWidth(); i++) {
                for (int j = 0; j < image.getHeight(); j++) {
                    int[] rgb = image.getRaster().getPixel(i, j, new int[3]);
                    int red = truncate(rgb[0] + brightnessValue);
                    int green = truncate(rgb[1] + brightnessValue);
                    int blue = truncate(rgb[2] + brightnessValue);
                    int[] arr = {red, green, blue};
                    image.getRaster().setPixel(i, j, arr);
                }
            }
        }
    }

    public void adjustBrightnessUsingThreads(int brightnessValue) {
        if (image == null) {
            return;
        }

        int cores = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[cores];
        int width = image.getWidth();
        int height = image.getHeight();
        int chunkHeight = height / cores;

        for (int t = 0; t < cores; t++) {
            final int threadIndex = t;
            threads[t] = new Thread(() -> {
                int startRow = threadIndex * chunkHeight;
                int endRow = (threadIndex == cores - 1) ? height : startRow + chunkHeight;

                for (int i = 0; i < width; i++) {
                    for (int j = startRow; j < endRow; j++) {
                        int[] rgb = image.getRaster().getPixel(i, j, new int[3]);
                        int red = truncate(rgb[0] + brightnessValue);
                        int green = truncate(rgb[1] + brightnessValue);
                        int blue = truncate(rgb[2] + brightnessValue);
                        int[] arr = {red, green, blue};
                        image.getRaster().setPixel(i, j, arr);
                    }
                }
            });
            threads[t].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}