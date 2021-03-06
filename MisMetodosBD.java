import java.sql.*;
import java.util.*;

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
	
	public static void mostrarLineas(Connection c) {
		
		Statement stmt;
		try {
			stmt = c.createStatement();
			String sql = "select Nombre from lineas";
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				System.out.println("Línea " + res.getObject("Nombre") + " ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("************");

	}

	public static void listarPorLinea(Connection c, String linea) {

		try {

			Statement stmt = c.createStatement();
			String sql = "select * from billetes,lineas where Nombre='" + linea
					+ "' and billetes.IdLinea=lineas.IdLinea";
			ResultSet res = stmt.executeQuery(sql);

			while (res.next()) {

				int idBillete = (int) res.getObject("IdBillete");
				int idVagon = (int) res.getObject("IdVagon");
				String nombre = (String) res.getObject("NombreViajero");
				String pago = (String) res.getObject("Pago");
				String estado = (String) res.getObject("Estado");

				System.out.println("IdBillete: " + idBillete + "/ IdVagon: " + idVagon + "/ Nombre: " + nombre
						+ "/ Pago: " + pago + "/ Estado: " + estado);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void disponibilidad(Connection c) {
		
		try {
			Statement stmt = c.createStatement();
			String sql = "select IdLinea,NumeroVagon,PlazasLibres,IdVagon from vagonesenlinea";
			ResultSet res = stmt.executeQuery(sql);

			while (res.next()) {

				int plazasLibres = (int) res.getObject("PlazasLibres");
				int IdLinea = (int) res.getObject("IdLinea");
				int IdVagon = (int) res.getObject("IdVagon");

				if (plazasLibres > 0) {
					System.out.print("Lï¿½nea " + res.getObject("IdLinea") + " ");
					System.out.print("Nï¿½mero de vagï¿½n " + res.getObject("NumeroVagon") + " ");
					System.out.print("Plazas libres " + res.getObject("PlazasLibres"));
					System.out.println();

					System.out.println("ï¿½Desea hacer una reserva? S / N");
					String reserva = InputData.readString();
					reserva = reserva.toUpperCase();

					if (reserva.equals("S")) {

						String IdBillete = UUID.randomUUID().toString().replaceAll("[^0-9]", "").substring(0, 7);

						Date dt = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String FechaExpedicion = sdf.format(dt);
						String FechaExpedicion2 = "'" + FechaExpedicion + "'";

						System.out.println(FechaExpedicion);

						System.out.println("Nombre y Apellidos");
						String NombreViajero = InputData.readString();
						NombreViajero = "'" + NombreViajero + "'";

						System.out.println("Pago en efectivo: Pulse 1");
						System.out.println("Pago con tarjeta: Pulse 2");
						int pago = InputData.readInt();

						System.out.println("Cargando su reserva...");

						stmt.executeUpdate(
								"INSERT INTO billetes (IdBillete,IdLinea,IdVagon,NombreViajero,Pago,Estado,FechaExpedicion)"
										+ "VALUES" + "(" + IdBillete + "," + IdLinea + "," + IdVagon + ","
										+ NombreViajero + "," + pago + "," + "1" + "," + FechaExpedicion2 + ")");

						plazasLibres--;
						stmt.executeUpdate(
								"UPDATE vagonesenlinea set PlazasLibres=" + plazasLibres + " where IdVagon=" + IdVagon);

						System.out.println("Reserva realizada con ï¿½xito");
						break;
					}
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}	
}
