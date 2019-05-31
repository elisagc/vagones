public class Prueba {

	public static void main(String[] args) {


		Connection c = MisMetodosBD.accesoBD();
		while (true) {
			System.out.println("" + "1.Comprobar disponibilidad\n" + "2.Mostrar billetes disponibles\n" + "0.Salir\n");
			int option = InputData.readInt();
			switch (option) {
			case 1:
				MisMetodosBD.disponibilidad(c);
				break;
			case 2:
				MisMetodosBD.mostrarLineas(c);
				System.out.println("Introduce la línea: ");
				String linea = InputData.readString();
				MisMetodosBD.listarPorLinea(c, linea);
				break;
			default:
				System.exit(1);
			}
		}
	}
