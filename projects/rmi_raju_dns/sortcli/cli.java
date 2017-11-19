import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.*;
import java.rmi.*;
import javax.imageio.ImageIO;
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
import javax.swing.*;

class SortThread extends Thread {
   byte unsorted[], sorted[];
   SortServerInf ss ;   //............interface define ;
   String name;
   boolean sorting;
   public SortThread(SortServerInf ss, byte unsorted[], String name) {
        this.unsorted = unsorted;
        this.ss = ss;
        this.name = name;
        sorting = true;
   }
   
   public byte[] getSorted() {
        return sorted;
   }
   
   public void run() {
        System.out.println("Started thread " + name);
        try { 
                sorted = ss.sort(unsorted);    // ....interface method call
        } catch(Exception e) {}
        System.out.println("Finished thread " + name);
        sorting = false;
   }
   
   public boolean sorting() {
        return sorting;
   }
}

public class cli {


	String host1,host2;
	String arg[];
 public cli(String arg[]) throws RemoteException {
   super(); 
   this.arg=arg;
    } 
  

 JFrame mf = new JFrame(" ");

Image img;
JTextField text=new JTextField(20);
JButton browse,save;
JPanel p=new JPanel(new GridLayout(1,2));
JLabel label=new JLabel();
File file = null;
String path="",path2="E:\\Document\\1.jpg";
     JPanel mainp,firstp,secondp,thirdp,namep,designationp;
    private  JPanel secondp2;
    private  JPanel secondp3;
    private  JPanel firstp1;
    private  JLabel l3,l2;  
    private JLabel l4;
    private JPanel secondp4;
    private JLabel l5;
    private JLabel l6;
    private JPanel secondp6;

public  void clim() {
    JPanel as = new JPanel();
        JLabel l = new JLabel();
        as.add(l);

        mainp = new JPanel();
        mainp.setLayout(new BoxLayout(mainp, BoxLayout.Y_AXIS));
        mainp.add(as);
        Container contentPane = mf.getContentPane();
        contentPane.add(BorderLayout.CENTER,mainp);
    
    mf.setSize(1920,1080);

        firstp = new JPanel();
        JLabel l1= new JLabel("");   
        firstp.add(l1);
        mainp.add(firstp);
        
              
browse = new JButton(" Upload ");
save = new JButton(" Send ");
text.setBounds(20,20,140,20);
browse.setBounds(160,20,100,20);
label.setBounds(20,40,260,20);
save.setBounds(250,20,100,20);
        
        firstp1 = new JPanel();      
        firstp1.add(text);
        firstp1.add(browse);
        firstp1.add(save);
        firstp1.add(label);
        mainp.add(firstp1);
        
        secondp = new JPanel();
        l2= new JLabel("... Image send to server...");   
        secondp.add(l2);
        mainp.add(secondp);
       
        ImageIcon icon1=new ImageIcon(path2);
   
        secondp2 = new JPanel();
         l3= new JLabel(icon1);   
        secondp2.add(l3);
        mainp.add(secondp2);
        
        secondp6 = new JPanel();
        l6= new JLabel("...Identified Image By Server  ...");   
        secondp6.add(l6);
        mainp.add(secondp6);
        
        secondp4 = new JPanel();
         l5= new JLabel(icon1);   
        secondp4.add(l5);
        mainp.add(secondp4);
        
        secondp3 = new JPanel();
         l4= new JLabel("... DNS lab...");   
        secondp3.add(l4);
        mainp.add(secondp3);
        
        
   // mf.repaint();
		
mf.setVisible(true);

browse.addActionListener(new ActionListener()
 {
public void actionPerformed(ActionEvent e) {
JFileChooser chooser = new JFileChooser();
chooser.addChoosableFileFilter(new ImageFileFilter());
int returnVal = chooser.showOpenDialog(null);

if(returnVal == JFileChooser.APPROVE_OPTION) {
file = chooser.getSelectedFile();
 path=file.getPath();

ImageIcon icon=new ImageIcon(path);
l3.setIcon(icon);
text.setText(path);
mf.repaint();}}
}
);
save.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent e){
  try{
  try {

  try {   
  
      // save path in txt......
	   Writer output = null;
  File file = new File("saved.txt");
  output = new BufferedWriter(new FileWriter(file));
  output.write(path);
  output.close();
  System.out.println("Your file has been written"); 
  ///................Send image to server 
  
           BufferedImage image;
           InputStream is = new BufferedInputStream(new FileInputStream(path));  
           image = ImageIO.read(is);  

	       ByteArrayOutputStream baos = new ByteArrayOutputStream();  
           ImageIO.write(image, "jpg", baos);  
  int a=arg.length;
  
	SortThread thread []=new SortThread[arg.length] ;
	//SortServerInf ss[]=null;
	SortServerInf [] ss =new SortServerInf[arg.length];
	
	SortThread thread1,thread2 ;
	SortServerInf ss1,ss2;
	
	System.out.println("Your "+arg.length); 
	
	  //lookup SortServerInf remote object in rmiregistry
	    for(int i=0;i<arg.length;i++){
		      System.out.println("Yjkdjcd  "+arg[i]); 
			  ss[i]= (SortServerInf) Naming.lookup( "//" + arg[i] + "/Sort"+(i+1));
			  
			  //thread[i] = new SortThread(ss[i], baos.toByteArray(), "Sort"+(i+1));
			 // thread[i].start();
		
		}
		for(int j=0;j<arg.length;j++){
		      System.out.println("2nd dkld  "+arg[j]); 
			  //ss[i]= (SortServerInf) Naming.lookup( "//" + arg[i]+ "/Sort"+(i+1));
			  thread[j] = new SortThread(ss[j], baos.toByteArray(), "Sort"+(j+1));
			  
			  thread[j].start();
		
		} 
       		
		
		// Wait while either thread is sorting
        while(true){   
		    int p=0;
            for(int j=0;j<arg.length;j++){
                if(thread[j].sorting()==true){
                    p=1; }
            }
			if(p==0){
                break;}
        //System.out.println("running .. ");
        }
		int max=0,c=0;
		byte raw1[]=null;
		    
			    raw1=thread[0].getSorted();
	            //l5.setIcon(new ImageIcon(raw1));
				BufferedImage image1 = javax.imageio.ImageIO.read(new 
                ByteArrayInputStream(raw1));  
// do whatever you wish with the image  

    File outputfile = new File("resend.jpg");
    boolean write = ImageIO.write(image1, "jpg", outputfile);
			
   
        } catch (IOException e2) { 
					System.out.println("err1 : "+e2.getMessage());
        }  

  } catch (Exception e1) {
  System.out.println("err2 : "+e1.getMessage());
  
     }
    //JOptionPane.showMessageDialog(null,"send successfully!");
    }
    catch(Exception ex){
        System.out.print(ex);   }
}
});
}

public static void main(String args[] ) throws Exception{

	String host1 = "localhost", host2 = "localhost";
        if (args.length == 2) { host1 = args[0]; host2 = args[1]; }

 cli c=new cli(args);
c.clim();
//c.fun(image6);
}}


class ImageFileFilter extends javax.swing.filechooser.FileFilter {
public boolean accept(File file) {
if (file.isDirectory()) return false;
String name = file.getName().toLowerCase();
return (name.endsWith(".jpg") || name.endsWith(".png")|| name.endsWith(".gif"));
}
public String getDescription() { return "Images (*.gif,*.bmp, *.jpg, *.png )"; }
}