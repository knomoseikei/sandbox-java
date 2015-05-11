package pe.knomo.snippets.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class Propiedades {

	public static String PROPIEDAD_PRUEBA;

	static {

		Properties propiedades = new Properties();

		try {

			propiedades.load(new FileInputStream("recursos.properties"));

			if (propiedades.isEmpty()) {
				System.out.println("No se pudo cargar el archivo .properties");
			} else {
				System.out.println("Archivo .properties cargó correctamente");
			}
			PROPIEDAD_PRUEBA = propiedades.getProperty("propiedad_prueba");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
