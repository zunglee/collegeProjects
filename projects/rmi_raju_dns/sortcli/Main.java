import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main {

	public static void main( String[] args ) throws IOException, ClassNotFoundException {

		String filename = "D:\\DNS\\key\\sortcli\\saved123.txt";

		//string test
		Property<String> prop = new Property<>( "Encryption", "RSA" );

		ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream( filename ) );
		prop.write( out );
		out.close();

		ObjectInputStream in = new ObjectInputStream( new FileInputStream( filename ) );
		prop.read( in );
		in.close();

		String encryptVal = prop.getValue();
		System.out.println( encryptVal );

		//Object test
		PublicKey pubKey = new PublicKey( "0832ACDEF46B3F" );
		Property<PublicKey> prop2 = new Property<>( "PublicKey", pubKey );

		out = new ObjectOutputStream( new FileOutputStream( filename ) );
		prop2.write( out );
		out.close();

		in = new ObjectInputStream( new FileInputStream( filename ) );
		prop2.read( in );
		in.close();

		PublicKey keyVal = prop2.getValue();
		System.out.println( keyVal.getKey() );
	}

}

class Property<T> implements Serializable {

	private static final long	serialVersionUID	= 1L;
	private String				description;
	private T					value;

	public Property( String description, T value ) {
		this.description = description;
		this.value = value;
	}

	public void read( ObjectInputStream in ) throws IOException, ClassNotFoundException {
		value = null; //just to test
		Object obj;
		while ( ( obj = in.readObject() ) != null ) {
			Property prop = Property.class.cast( obj );
			if ( prop.description.equals( description ) ) {
				value = ( T ) prop.value;
				return;
			}
		}
	}

	public void write( ObjectOutputStream out ) throws IOException {
		out.writeObject( this );
	}

	public void setValue( T value ) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}

class PublicKey implements Serializable {

	private static final long	serialVersionUID	= 1L;
	private String				key;

	public PublicKey( String key ) {
		this.key = key;
	}

	public String getKey() {
		return this.key;
	}
}

