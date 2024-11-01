# Image Editor

## Description
This is a simple image editor implemented in Java. The application provides functionality to import images, adjust their brightness, and export the modified images. The brightness adjustment can be performed in both single-threaded and multi-threaded modes, showcasing performance improvements with multi-threading.

### Features
- Import images in JPEG format.
- Adjust brightness of images.
- Export modified images in JPEG format.
- Single-threaded and multi-threaded brightness adjustment.

### Technologies Used
- Java AWT and Swing for image manipulation.
- Java Concurrency for multi-threading.

### How to Run
1. Ensure you have Java Development Kit (JDK) installed.
2. Clone this repository to your local machine.
3. Update the file paths in the `Main` class to point to your input and output image locations.
4. Compile the Java files and run the `Main` class to start the application.


### Example Usage
1. The program imports an image from the specified path.
2. It adjusts the brightness by a specified value.
3. The output image is saved to a specified location.

### Performance
- The single-threaded approach processes the image in a single pass.
- The multi-threaded approach splits the image processing task among available CPU cores for improved performance.

## Contact
If you’d like to reach out, feel free to connect with me:
- [LinkedIn](https://www.linkedin.com/in/nadiia-rybak-5092b8336)
- [Email](mailto:nvdiv5@gmail.com)

Thanks for visiting!
