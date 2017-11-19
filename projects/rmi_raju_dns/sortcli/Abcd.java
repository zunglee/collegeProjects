
import java.io.*;  
   
/** Recognizes faces.
 *
 * @author reed
 */
 
public class Abcd {

    public static void main() {
		System.out.println("Class abcd ");
		
		String [] cmds = new String [1];
			cmds[0] = "C:\\Users\\Rajendra\\Documents\\Visual Studio 2010\\Projects\\abc\\abc\\bin\\Debug\\abc.exe";
		     //Process p = Runtime.getRuntime().exec(command);
		Process p = new ProcessBuilder(cmds[0]).start();
		InputStream is = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;

		//System.out.printf("Output of running %s is:", Arrays.toString(args));

		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	System.out.println("pass");
    p.destroy() ;
	}
	
}