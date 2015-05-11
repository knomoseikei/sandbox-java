package pe.knomo.snippets.file;

import java.io.File;

public class MkDirMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File carpetaComprobanteRecibidos = new File("COMPROBANTES_RECIBIDOS_");
		System.out.println("Creo carpeta? : "+carpetaComprobanteRecibidos.mkdirs());
	}

}
