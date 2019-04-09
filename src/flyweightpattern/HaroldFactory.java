/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweightpattern;

import java.util.HashMap;
import javafx.scene.image.Image;

/**
 *
 * @author bonde
 */
public class HaroldFactory
{
    private HashMap<Integer, Harod> lbcache = new HashMap();
    private  String imageURL;

    public HaroldFactory(String imageURL)
    {
        this.imageURL = imageURL;
    }
    
    
    
    public Harod create(int size){
        Harod lb = lbcache.get(size);
        
        if(lb == null)
        {
            Image img= new Image(imageURL, size, size, true, true);
            lb = new Harod(img, size);
            lbcache.put(size, lb);
        }
        return lb;
    }
}
