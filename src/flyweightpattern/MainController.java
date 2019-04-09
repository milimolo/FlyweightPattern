/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweightpattern;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author bonde
 */
public class MainController implements Initializable
{
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private AnchorPane mainPane;
    
    Canvas canvas;
    GraphicsContext gc;
    @FXML
    private Button button1;
    
    private void handleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me!");
        
    }
    
    private int getRandomSize(Random rand){
        return (rand.nextInt(2)+1)*25; //15 30 45;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        canvas = new Canvas(800, 560);
        mainPane.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
    }    

    @FXML
    private void withFlyClick(ActionEvent event)
    {
        Random rand = new Random();
        long start = System.nanoTime();
        HaroldFactory fact = new HaroldFactory("hidethepainharold.jpg");
        for (int i = 0; i < 1000; i++)
        {
            int size = getRandomSize(rand);
            Harod h = fact.create(size);
            gc.drawImage(h.getImg(), rand.nextInt((int) canvas.getWidth()), rand.nextInt((int) canvas.getHeight()));
            
        }
        long end = System.nanoTime();
        System.out.println("time: " + (end-start)/1_000_000 + "ms");
    }

    @FXML
    private void noFlyClick(ActionEvent event)
    {
        Random rand = new Random();
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++)
        {
            int size = getRandomSize(rand);
            Image image = new Image("hidethepainharold.jpg", size, size, true, true); // slow
            gc.drawImage(image, rand.nextInt((int) canvas.getWidth()), rand.nextInt((int) canvas.getHeight()));
            
        }
        long end = System.nanoTime();
        System.out.println("time: " + (end-start)/1_000_000 + "ms");
    }
    
}
