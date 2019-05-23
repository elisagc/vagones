import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class MisMetodosBD {
	
	public static Connection accesoBD() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String sourceURL = "jdbc:mysql://localhost/vagones";
			String user="root";  
		    String password="";
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/vagones",user,password);	
			return con;
		}catch(ClassNotFoundException e){
			System.out.println(e);
		
			}catch(SQLException e){
			System.out.println(e);
			}
		return null;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void consulta() {
		
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String sourceURL = "jdbc:mysql://localhost/vagones";
		String user="root";  
	    String password="";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/vagones",user,password);	
		Statement stmt = con.createStatement();
		
		String consulta="";
		String res="";
	
		System.out.println("Introduce tu SELECT");
		consulta=InputData.readString();
		
		ResultSet s2=stmt.executeQuery(consulta);
		
		while (s2.next()) {
			System.out.println(s2.getObject(1));
			System.out.println(s2.getObject(2));
			System.out.println(s2.getObject(3));
		}
		
		
		}catch(ClassNotFoundException e){
		System.out.println(e);
	
		}catch(SQLException e){
		System.out.println(e);
		}
	}
	
	
	public static boolean insertarFila() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String sourceURL = "jdbc:mysql://localhost/vagones";
			String user="root";  
	       	String password="";
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/vagones",user,password);	
			Statement stmt = con.createStatement();
		
			System.out.println("Escribe tu sentencia INSERT, ejemplo:");
			System.out.println();
			System.out.println("INSERT INTO estaciones (idEstacion,Nombre) VALUES (00001,'Majadahonda');");
	
			String insertar=InputData.readString();
					
			stmt.executeUpdate(insertar);
			
			return true;
			
			}catch(ClassNotFoundException e){
			System.out.println(e);
		
			}catch(SQLException e){
			System.out.println(e);
			}
		
			return true;
	}
	
	public static void consultarDispo() {
		System.out.println("Dime la línea");
		String linea=InputData.readString();
		
		
		
	}
}
