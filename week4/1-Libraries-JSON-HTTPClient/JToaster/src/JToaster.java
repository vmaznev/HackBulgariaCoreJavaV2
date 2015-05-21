import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.nitido.utils.toaster.Toaster;

public class JToaster {
    
    public static void eyeProtection() throws InterruptedException {
        Toaster toasterManager = new Toaster();
        
        // Thread.sleep(30000); // Toast will pop-up in 30 seconds...!
        
        toasterManager.setBorderColor(new Color(0, 255, 0));
        toasterManager.setToasterHeight(600);
        toasterManager.setToasterWidth(800);
        
        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("Doge.jpg"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        toasterManager.setMargin(300);
        toasterManager.setMessageColor(new Color(255, 0, 255));
        toasterManager.setToasterMessageFont(new Font(null, 0, 20));
        toasterManager.setBackgroundImage(myImage);
        toasterManager.showToaster("GO OUTSIDE...!");
    }
    
    public static void main(String[] args) throws InterruptedException {
        eyeProtection();
    }
}
