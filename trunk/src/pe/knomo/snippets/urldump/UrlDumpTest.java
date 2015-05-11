package pe.knomo.snippets.urldump;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

/**
 * Contains various unorganized static utility methods used across Cayenne.
 * 
 * @author Andrei Adamchik
 */
public class UrlDumpTest {

	public static void main(String[] args) throws MalformedURLException {
		File to = new File("file.png");
		String preffix = "https://s3.amazonaws.com/edx-textbooks/guttag_computation_v3/p";
		String suffix = ".png";
		URL from;
		DecimalFormat df = new DecimalFormat("000");
		for (int i = 0; i < 300; i++) {
			from = new URL(preffix+df.format(i)+suffix);
			to = new File(df.format(i)+suffix);
			System.out.println(from);
			copy(from, to);
		}
	}

	/**
	 * Copies file contents from source to destination. Makes up for the lack of
	 * file copying utilities in Java
	 */
	public static boolean copy(File source, File destination) {
		BufferedInputStream fin = null;
		BufferedOutputStream fout = null;
		try {
			int bufSize = 8 * 1024;
			fin = new BufferedInputStream(new FileInputStream(source), bufSize);
			fout = new BufferedOutputStream(new FileOutputStream(destination), bufSize);
			copyPipe(fin, fout, bufSize);
		} catch (IOException ioex) {
			return false;
		} catch (SecurityException sx) {
			return false;
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException cioex) {
				}
			}
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException cioex) {
				}
			}
		}
		return true;
	}

	/**
	 * Save URL contents to a file.
	 */
	public static boolean copy(URL from, File to) {
		BufferedInputStream urlin = null;
		BufferedOutputStream fout = null;
		try {
			int bufSize = 8 * 1024;
			urlin = new BufferedInputStream(from.openConnection().getInputStream(), bufSize);
			fout = new BufferedOutputStream(new FileOutputStream(to), bufSize);
			copyPipe(urlin, fout, bufSize);
		} catch (IOException ioex) {
			return false;
		} catch (SecurityException sx) {
			return false;
		} finally {
			if (urlin != null) {
				try {
					urlin.close();
				} catch (IOException cioex) {
				}
			}
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException cioex) {
				}
			}
		}
		return true;
	}

	/**
	 * Reads data from the input and writes it to the output, until the end of
	 * the input stream.
	 * 
	 * @param in
	 * @param out
	 * @param bufSizeHint
	 * @throws IOException
	 */
	public static void copyPipe(InputStream in, OutputStream out, int bufSizeHint) throws IOException {
		int read = -1;
		byte[] buf = new byte[bufSizeHint];
		while ((read = in.read(buf, 0, bufSizeHint)) >= 0) {
			out.write(buf, 0, read);
		}
		out.flush();
	}

}
