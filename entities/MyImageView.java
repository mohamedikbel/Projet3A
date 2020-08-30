/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
//import java.awt.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author 
 */
public class MyImageView extends ImageView{
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public MyImageView(Image image ){
        setImage(image);
    
};
    
}
