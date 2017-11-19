import java.rmi.*;
import java.io.*;
import java.awt.*;  
  
import javax.imageio.ImageIO;  
import javax.swing.ImageIcon;  
import javax.swing.JFrame;  
import javax.swing.JLabel;

public interface SortServerInf extends Remote {
   public byte[] sort( byte rawImage[] ) throws RemoteException;

   }