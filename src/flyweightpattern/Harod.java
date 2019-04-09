/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweightpattern;

import javafx.scene.image.Image;

/**
 *
 * @author bonde
 */
public class Harod
{
    private  Image img;
    private int size;

    public Harod(Image img, int size)
    {
        this.img = img;
        this.size = size;
    }

    
    
    public Image getImg()
    {
        return img;
    }

    public void setImg(Image img)
    {
        this.img = img;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }
    
    
}
