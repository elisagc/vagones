import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class prueba {

	public static void main(String[] args) {
		
	
		
		/*System.out.println("�QU� QUIERES HACER EN LA TABLA VAGONES?");
		System.out.println("SELECT ---> Pulsa 1");
		System.out.println("INSERT ---> Pulsa 2");
		System.out.println("DELETE ---> Pulsa 3");
		System.out.println("CONSULTAR DISPONIBILIDAD DE PLAZAS ---> Pulsa 4");
		System.out.println("NADA ---> Pulsa 99");
		
		int numero=InputData.readInt();*/
		
	/*	if (numero==1) {
			 MisMetodosBD.consulta(); 
		}else {
			if(numero==2) {
				MisMetodosBD.insertarFila();
			}else {
				if (numero==3){
					System.out.println("borrar");
				}else {
					if(numero==4) {
						MisMetodosBD.consultarDispo();
					}
				}
			}
		}*/
	
	       /*stmt.executeUpdate("INSERT INTO vagones VALUES (20,'Preferente',1);");
		    stmt.executeUpdate("INSERT INTO estaciones (idEstacion,Nombre) VALUES (00002,'Las Rozas');");
		    stmt.executeUpdate("INSERT INTO estaciones (idEstacion,Nombre) VALUES (00003,'Villalba');");
		    stmt.executeUpdate("INSERT INTO estaciones (idEstacion,Nombre) VALUES (00004,'Atocha');");
		    stmt.executeUpdate("INSERT INTO estaciones (idEstacion,Nombre) VALUES (00005,'Aravaca');");
		    stmt.executeUpdate("INSERT INTO estaciones (idEstacion,Nombre) VALUES (00006,'Torrelodones');");*/
		
		
		// MEN� PABLO EL MAND�N
		
		Connection c=MisMetodosBD.accesoBD();
		
		try {
			Statement stmt=c.createStatement();
			String sql="select IdLinea,NumeroVagon,PlazasLibres from vagonesenlinea";
			ResultSet res=stmt.executeQuery(sql);
			
			/*1. Consulta de disponibilidad / expedici�n de billetes: la
			aplicaci�n debe mostrar informaci�n acerca de la disponibilidad
			de plazas en cada l�nea, vag�n por vag�n. En aquellos vagones
			en que haya plazas libres, debe dar la oportunidad de expedir
			un billete. */
			
			while(res.next()) {
				
				// Comprobamos las plazas libres
				// Guardamos IdLinea e IdVagon porque si quiere hacer la reserva se necesitan insertar en la tabla billetes
				
				int plazasLibres=(int)res.getObject("PlazasLibres");
				int IdLinea=(int)res.getObject("IdLinea");
				int IdVagon=(int)res.getObject("IdVagon");
				
				// Si hay plazas libres se muestra la informaci�n
		
				if (plazasLibres>0) {
					System.out.print("L�nea " + res.getObject("IdLinea") + " ");
					System.out.print("N�mero de vag�n " + res.getObject("NumeroVagon") + " ");
					System.out.print("Plazas libres " +res.getObject("PlazasLibres"));
					System.out.println();
					
					System.out.println("�Desea hacer una reserva? S / N");
					String reserva=InputData.readString();
				
					// PREGUNTAR SI DESEA REALIZAR UNA RESERVA EN ESA L�NEA 
					// SI ES S� SE PIDEN LOS DATOS PARA HACER LA RESERVA, SI NO, SE SIGUEN MOSTRANDO L�NEA Y VAG�N
					
					/*La interfaz gr�fica ofrecer� distintos componentes gr�ficos para
					obtener los datos de estaci�n origen, estaci�n destino, fecha,
					preferente o segunda, etc. Obtendr� la informaci�n
					correspondiente de la base de datos y se la presentar� al
					usuario para que �ste pueda escoger entre las opciones de
					acuerdo con su criterio de b�squeda. En caso de que el usuario
					quiera expedir billetes en una l�nea/vag�n concretos, la
					aplicaci�n debe recoger la informaci�n adicional necesaria para
					el billete (nombre del viajero y modo de pago) y realizar la
					reserva. */
					
					if (reserva.equals("s") || reserva.equals("S")) {
						
						
					}
				}	
			}
						
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		// FIN MOSTRAR VAGONES Y PLAZAS DE CADA L�NEA
		    	
		
	
	
	
	}	
}
