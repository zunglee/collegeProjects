/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package client;

/**
 *
 * @author rajendra
 */

import java.rmi.*;
import java.rmi.server.*;
import java.awt.*;  
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.Desktop;     
import javax.imageio.ImageIO;  
import javax.swing.ImageIcon;  
import javax.swing.JFrame;  
import javax.swing.JLabel;

public class SortServerImpl extends UnicastRemoteObject implements SortServerInf {

    public SortServerImpl() throws RemoteException { super();  }

   // implementation for SortServerInf interface method
    public byte[] sort( byte raw[] ) {
	
		byte raw1[]=null;
		byte val[]=null;
        
			try {
          
            
				BufferedImage image = javax.imageio.ImageIO.read(new 
                ByteArrayInputStream(raw));  
// do whatever you wish with the image  

    File outputfile = new File("saved.jpg");
    boolean write = ImageIO.write(image, "jpg", outputfile);

    JFrame frame = new JFrame();  
    JLabel label = new JLabel(new ImageIcon(image));  
    frame.getContentPane().add(label, BorderLayout.CENTER);  
    frame.pack();  
    frame.setVisible(true);
                                                            
                                                            
            
        } catch (IOException ex) {
           
        }
		// Desktop.getDesktop().open(new File("FaceRecognition.jar")); 
	
	 // Abcd ab=new Abcd();
	   //     ab.main1();
	try {   
		System.out.println("begin : fatch resend.jpg");
           BufferedImage image2;
			InputStream is2 = new BufferedInputStream(new FileInputStream("resend.jpg"));  
            image2 = ImageIO.read(is2);
		    ByteArrayOutputStream baos2 = new ByteArrayOutputStream();  
             ImageIO.write(image2, "jpg", baos2);
        System.out.println("fatch resend.jpg");  

//.................resend image

         raw1 = baos2.toByteArray(); 
        System.out.println("resend.jpg is resend"); 
    } catch (IOException e2) {  
                         System.out.println("Error1"+e2.getMessage());
    } 

	
return raw1;
 }

   public static void main( String args[] ) throws Exception {     
      System.err.println( "Initializing server: please wait." );

      String number = "";
      if (args.length > 0) number = args[0];

      // create server object and bind SortServerImpl object to the rmiregistry
      Naming.rebind( "//localhost/Sort" + number, new SortServerImpl() );

      System.err.println("The Sort Server " + number + " is up and running." );
	  
	  
	  
	  
   }
}
