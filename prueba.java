import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class prueba {

	public static void main(String[] args) {
		
	
		
		/*System.out.println("¿QUÉ QUIERES HACER EN LA TABLA VAGONES?");
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
		
		
		// MENÚ PABLO EL MANDÓN
		
		Connection c=MisMetodosBD.accesoBD();
		
		try {
			Statement stmt=c.createStatement();
			String sql="select IdLinea,NumeroVagon,PlazasLibres from vagonesenlinea";
			ResultSet res=stmt.executeQuery(sql);
			
			/*1. Consulta de disponibilidad / expedición de billetes: la
			aplicación debe mostrar información acerca de la disponibilidad
			de plazas en cada línea, vagón por vagón. En aquellos vagones
			en que haya plazas libres, debe dar la oportunidad de expedir
			un billete. */
			
			while(res.next()) {
				
				// Comprobamos las plazas libres
				// Guardamos IdLinea e IdVagon porque si quiere hacer la reserva se necesitan insertar en la tabla billetes
				
				int plazasLibres=(int)res.getObject("PlazasLibres");
				int IdLinea=(int)res.getObject("IdLinea");
				int IdVagon=(int)res.getObject("IdVagon");
				
				// Si hay plazas libres se muestra la información
		
				if (plazasLibres>0) {
					System.out.print("Línea " + res.getObject("IdLinea") + " ");
					System.out.print("Número de vagón " + res.getObject("NumeroVagon") + " ");
					System.out.print("Plazas libres " +res.getObject("PlazasLibres"));
					System.out.println();
					
					System.out.println("¿Desea hacer una reserva? S / N");
					String reserva=InputData.readString();
				
					// PREGUNTAR SI DESEA REALIZAR UNA RESERVA EN ESA LÍNEA 
					// SI ES SÍ SE PIDEN LOS DATOS PARA HACER LA RESERVA, SI NO, SE SIGUEN MOSTRANDO LÍNEA Y VAGÓN
					
					/*La interfaz gráfica ofrecerá distintos componentes gráficos para
					obtener los datos de estación origen, estación destino, fecha,
					preferente o segunda, etc. Obtendrá la información
					correspondiente de la base de datos y se la presentará al
					usuario para que éste pueda escoger entre las opciones de
					acuerdo con su criterio de búsqueda. En caso de que el usuario
					quiera expedir billetes en una línea/vagón concretos, la
					aplicación debe recoger la información adicional necesaria para
					el billete (nombre del viajero y modo de pago) y realizar la
					reserva. */
					
					if (reserva.equals("s") || reserva.equals("S")) {
						
						
					}
				}	
			}
						
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		// FIN MOSTRAR VAGONES Y PLAZAS DE CADA LÍNEA
		    	
		
	
	
	
	}	
}
