package insightfulu.imagespackage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * SingleImage class represents a single image. This class contains the 
 * information necessary to display a single image and manipulate it
 */
public class SingleImage extends ImageView {
    // Constants related to the image, these can be manipulated
    private double imageWidth;
    private double imageHeight;
    private double xPosition;
    private double yPosition;
    private double scale; // Scale can go above 1.0 to enlarge images
    private double angle;

    private Image image;

    /*
     * Constructor requires just the image source. The size will be 
     * the original dimensions of the image and will be displayed at 
     * 0,0
     */
    public SingleImage(String source) throws FileNotFoundException {
        // Loading image file
        File imageFile = new File(source);
        image = new Image(new FileInputStream(imageFile));
        setImage(image);

        // Image position is based on top left corner of image
        imageWidth = image.getWidth();
        imageHeight = image.getHeight();
        
        // Default behaviour is to preserve aspect ratio
        setPreserveRatio(true);
    }

    /*
     * Constructor requires the image source and x/y coordinates.
     * The size will be the original dimensions of the image and will
     * be displayed at x,y
     */
    public SingleImage(String source, double xPos, double yPos) throws FileNotFoundException {
        // Loading image file
        File imageFile = new File(source);
        image = new Image(new FileInputStream(imageFile));
        setImage(image);

        // Dimensions are based on original image size
        imageWidth = image.getWidth();
        imageHeight = image.getHeight();

        // Image position is based on top left corner of image
        xPosition = xPos;
        yPosition = yPos;
        setX(xPos);
        setY(yPos);

        // Default behaviour is to preserve aspect ratio
        setPreserveRatio(true);
    }

    /*
     * Constructor requires the image source, x/y coordinates and
     * scale. The size will be the original dimensions multiplied by 
     * the scale, and will be displayed at x,y
     */
    public SingleImage(String source, double xPos, double yPos, double scale) throws FileNotFoundException {
        // Loading image file
        File imageFile = new File(source);
        image = new Image(new FileInputStream(imageFile));
        setImage(image);

        // Dimensions are based on original image size
        imageWidth = image.getWidth();
        imageHeight = image.getHeight();
        
        // Image position is based on top left corner of image
        xPosition = xPos;
        yPosition = yPos;
        setX(xPos);
        setY(yPos);

        // Setting image size according to scale
        setFitWidth(imageWidth * scale);
        setFitHeight(imageHeight * scale);

        // Default behaviour is to preserve aspect ratio
        setPreserveRatio(true);
    }

    /*
     * Constructor requires the image source, x/y coordinates, scale
     * and angle. The size will be the original dimensions multiplied 
     * by the scale, and will be displayed at x,y. The image will be 
     * rotated at a specified number of degrees rotated clockwise 
     * about the center of the image
     */
    public SingleImage(String source, double xPos, double yPos, double scale, double angle) throws FileNotFoundException {
        // Loading image file
        File imageFile = new File(source);
        image = new Image(new FileInputStream(imageFile));
        setImage(image);

        // Dimensions are based on original image size
        imageWidth = image.getWidth();
        imageHeight = image.getHeight();

        // Image position is based on top left corner of image
        xPosition = xPos;
        yPosition = yPos;
        setX(xPos);
        setY(yPos);

        // Setting image size according to scale
        setFitWidth(imageWidth * scale);
        setFitHeight(imageHeight * scale);

        // Setting angle of rotation
        setRotate(angle);

        // Default behaviour is to preserve aspect ratio
        setPreserveRatio(true);
    }

    /*
     * Constructor requires the image source, x/y coordinates, scale, angle
     * and a delay until showing. The size will be the original dimensions 
     * multiplied by the scale, and will be displayed at x,y. The image 
     * will be rotated at a specified number of degrees rotated clockwise 
     * about the center of the image. The image will be shown after the delay
     * in seconds, with millisecond resolution
     */
    public SingleImage(String source, double xPos, double yPos, double scale, double angle, double delay) throws FileNotFoundException {
        // Loading image file
        File imageFile = new File(source);
        image = new Image(new FileInputStream(imageFile));
        setImage(image);

        // Dimensions are based on original image size
        imageWidth = image.getWidth();
        imageHeight = image.getHeight();

        // Image position is based on top left corner of image
        xPosition = xPos;
        yPosition = yPos;
        setX(xPos);
        setY(yPos);

        // Setting image size according to scale
        setFitWidth(imageWidth * scale);
        setFitHeight(imageHeight * scale);

        // Setting angle of rotation
        setRotate(angle);

        // Default behaviour is to preserve aspect ratio
        setPreserveRatio(true);

        setVisible(false);
        new Thread ( new Runnable() {
            public void run() {
                try {
                    Thread.sleep((int) (delay * 1000));
                } catch (InterruptedException ie) {}
                setVisible(true);
            }
        }).start();
    }

    /*
     * Constructor requires the full set of parameters for the image. The size
     * will be the original dimensions multiplied by the scale, and will be 
     * displayed at x,y. The image will be rotated at a specified number of 
     * degrees rotated clockwise about the center of the image. The image will
     * be shown after the delay, and will be hidden after the duration, both
     * with millisecond resolution.
     */
    public SingleImage(String source, double xPos, double yPos, double scale, double angle, double delay, double duration) throws FileNotFoundException {
        // Loading image file
        File imageFile = new File(source);
        image = new Image(new FileInputStream(imageFile));
        setImage(image);

        // Dimensions are based on original image size
        imageWidth = image.getWidth();
        imageHeight = image.getHeight();

        // Image position is based on top left corner of image
        xPosition = xPos;
        yPosition = yPos;
        setX(xPos);
        setY(yPos);

        // Setting image size according to scale
        setFitWidth(imageWidth * scale);
        setFitHeight(imageHeight * scale);

        // Setting angle of rotation
        setRotate(angle);

        // Default behaviour is to preserve aspect ratio
        setPreserveRatio(true);

        setVisible(false);
        new Thread ( new Runnable() {
            public void run() {
                try {
                    Thread.sleep((int) (delay * 1000));
                } catch (InterruptedException ie) {}
                setVisible(true);
                try {
                    Thread.sleep((int) (duration * 1000));
                } catch (InterruptedException ie) {}
                setVisible(false);
            }
        }).start();
    }

    public double getImageWidth() {
        return imageWidth;
    }

    public double getImageHeight() {
        return imageHeight;
    }

    public double getImageX() {
        return xPosition;
    }

    public double getImageY() {
        return yPosition;
    }

    public double getImageScale() {
        return scale;
    }

    public double getImageAngle() {
        return angle;
    }
}