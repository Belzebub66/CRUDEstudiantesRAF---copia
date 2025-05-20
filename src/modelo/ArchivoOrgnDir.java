//Representa al CRUD de un archivo de texto
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ArchivoOrgnDir {
    File fichero;
    RandomAccessFile raf;

    final int NUMCONTROL_LEN = 8;
    final int NOMBRE_LEN = 20;
    final int APELLIDOS_LEN = 20;
    final int SEMESTRE_LEN = 2;
    final int GRUPO_LEN = 1;
    final int CARRERA_LEN = 30;
    final int TAMREG = NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN +
            SEMESTRE_LEN + GRUPO_LEN + CARRERA_LEN;

    FileWriter writer;
    PrintWriter pw;
    FileReader reader;
    BufferedReader buffer;
    int totReg;

    public ArchivoOrgnDir() {
        this.fichero = null;
        this.raf = null;

        this.writer = null;
        this.pw = null;
        this.reader = null;
        this.buffer = null;
        this.totReg = 0;
    }

    private boolean establecerFlujo(String nombreArchivo) {
        fichero = new File(nombreArchivo);
        return fichero.exists();
    }

    public boolean abrirArchivoRAF(String nombreArchivo) {
        boolean existe = this.establecerFlujo(nombreArchivo);
        try {
            this.raf = new RandomAccessFile(nombreArchivo, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private static String ajustar(String s, int longitud) {
        if (s.length() > longitud) {
            return s.substring(0, longitud);
        } else {
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() < longitud) {
                sb.append(' ');
            }
            return sb.toString();
        }
    }

    public void escribirRegistro(String numControl, String nombre,
            String apellidos, int semestre,
            char grupo, String carrera) {

        String formato = "00";
        // long pos = (long)(numRegistro - 1) * REGISTRO_BYTES;
        long pos = establecerPosicionByte(numControl);
        try {
            raf.seek(pos);
            raf.write(numControl.getBytes(("ISO-8859-1")));
            raf.write(ajustar(nombre, NOMBRE_LEN).getBytes("ISO-8859-1"));
            raf.write(ajustar(apellidos, APELLIDOS_LEN).getBytes("ISO-8859-1"));
            DecimalFormat df = new DecimalFormat(formato);
            String sem = df.format(semestre);
            // String sem = String.format("%d2", semestre);
            raf.write(sem.getBytes("ISO-8859-1"));
            String gpo = String.valueOf(grupo);
            raf.write(gpo.getBytes("ISO-8859-1"));
            raf.write(ajustar(carrera, CARRERA_LEN).getBytes("ISO-8859-1"));
        } catch (IOException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private long establecerPosicionByte(String numeroControl) {
        return ((Long.parseLong(numeroControl.substring(5))) - 1) * TAMREG;
    }

    public void crearLinea(String linea) {
        this.pw.println(linea);
    }

    public void cerrarArchivo() {
        try {
            this.raf.close();
        } catch (IOException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    String obtenerLineas() {
        String lineas = "";
        try {
            String linea = null;
            linea = buffer.readLine();
            while (linea != null) {
                this.totReg++;
                lineas += linea + "\n";
                linea = buffer.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineas;
    }

    public String[][] obtenerMatrizRegistros(int numCol) {

        String lineas = this.obtenerLineas();
        String lista[] = lineas.split("\n");
        String registros[][] = new String[this.totReg][numCol];

        for (int f = 0; f < this.totReg; f++) {
            String datos[] = lista[f].split(",");
            for (int c = 0; c < numCol; c++) {
                registros[f][c] = datos[c];
            }
        }
        // System.out.println("Lineas:"+ lineas);
        return registros;
    }

    public String[] buscarRegistro(String nc) {
        try {
            // establecer psicion con los 3 ultimos digitos
            long pos = establecerPosicionByte(nc);
            this.raf.seek(pos);
            byte[] buf = new byte[TAMREG];
            raf.readFully(buf);

            String nControl = new String(buf, 0, NUMCONTROL_LEN, "ISO-8859-1").trim();

            // Verificar si el registro existe (si el número de control no está vacío)
            if (!nControl.isEmpty() && nControl.equals(nc)) {
                String nombre = new String(buf, NUMCONTROL_LEN, NOMBRE_LEN, "ISO-8859-1").trim();
                String apellidos = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN, APELLIDOS_LEN, "ISO-8859-1").trim();
                String semestre = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN, SEMESTRE_LEN,
                        "ISO-8859-1").trim();
                String grupo = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN, GRUPO_LEN,
                        "ISO-8859-1").trim();
                String carrera = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN + GRUPO_LEN,
                        CARRERA_LEN, "ISO-8859-1").trim();

                // Crear y devolver el array con los datos del registro
                String[] registro = { nControl, nombre, apellidos, semestre, grupo, carrera };
                return registro;
            }
            /*
             * String nControl = new String(buf, 0, NUMCONTROL_LEN, "ISO-8859-1").trim();
             * String nombre = new String(buf, NUMCONTROL_LEN, NOMBRE_LEN,
             * "ISO-8859-1").trim();
             * JOptionPane.showMessageDialog(null, nControl + " " + nombre);
             * 
             * String linea=null;
             * linea = buffer.readLine();
             * while(linea!=null){
             * String datos[] = linea.split(",");
             * if (datos[0].equals(nc)) return datos;
             * linea = buffer.readLine();
             * }
             */
        } catch (IOException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void eliminarLinea(String numControl) {
        File ficheroTemporal = new File("temporal.txt");
        // Abrir el archivo que se va a utilizar como temporal, se abre para escritura
        try {
            this.writer = new FileWriter(ficheroTemporal);
            this.pw = new PrintWriter(this.writer);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            String linea = null;
            linea = buffer.readLine();
            while (linea != null) {
                String datos[] = linea.split(",");
                // Paso a temporal todas las lineas distintas
                if (!(datos[0].equals(numControl)))
                    this.crearLinea(linea);
                linea = buffer.readLine();
            }
            // Cierro el archivo temporal.txt
            this.pw.close();
            this.writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarArchivo(String archivoEliminar) {
        if (this.establecerFlujo(archivoEliminar)) {
            this.fichero.delete();
        }
    }

    public void renombrarArchivo(String archivoRenombrar, String nuevoNombre) {
        if (this.establecerFlujo(archivoRenombrar)) {
            File fichero2 = new File(nuevoNombre);
            this.fichero.renameTo(fichero2);
        }
    }

    public boolean validaControl(String numControl) {
        return numControl.matches("^[0-9]{8}$");
    }

    // codigo para leer todos los registros
    public Object[][] leerTodosLosRegistros() {
        try {
            // Determinar cuántos registros hay en el archivo
            long longArchivo = raf.length();
            int numRegistros = (int) (longArchivo / TAMREG);

            // Crear una lista para almacenar solo los registros válidos
            List<Object[]> registrosValidos = new ArrayList<>();

            // Leer cada registro
            for (int i = 0; i < numRegistros; i++) {
                raf.seek(i * TAMREG);
                byte[] buf = new byte[TAMREG];
                raf.readFully(buf);

                // Extraer los campos del registro
                String numControl = new String(buf, 0, NUMCONTROL_LEN, "ISO-8859-1").trim();

                // Solo procesar registros que tengan un número de control válido
                if (!numControl.isEmpty()) {
                    String nombre = new String(buf, NUMCONTROL_LEN, NOMBRE_LEN, "ISO-8859-1").trim();
                    String apellidos = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN, APELLIDOS_LEN, "ISO-8859-1").trim();
                    String semestre = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN, SEMESTRE_LEN,
                            "ISO-8859-1").trim();
                    String grupo = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN,
                            GRUPO_LEN, "ISO-8859-1").trim();
                    String carrera = new String(buf,
                            NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN + GRUPO_LEN, CARRERA_LEN,
                            "ISO-8859-1").trim();

                    // Añadir a la lista de registros válidos
                    Object[] registro = { numControl, nombre, apellidos, semestre, grupo, carrera };
                    registrosValidos.add(registro);
                }
            }

            // Convertir la lista a una matriz
            Object[][] resultado = new Object[registrosValidos.size()][6];
            for (int i = 0; i < registrosValidos.size(); i++) {
                resultado[i] = registrosValidos.get(i);
            }

            return resultado;
        } catch (IOException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
            return new Object[0][0]; // Devolver matriz vacía en caso de error
        }
    }

    public boolean eliminarRegistroRAF(String numControl) {
        try {
            // Establecer posición con los 3 últimos dígitos
            long pos = establecerPosicionByte(numControl);
            this.raf.seek(pos);

            // Crear un registro vacío para sobrescribir el existente
            byte[] registroVacio = new byte[TAMREG];
            for (int i = 0; i < TAMREG; i++) {
                registroVacio[i] = ' ';
            }

            // Escribir el registro vacío en la posición del registro a eliminar
            raf.write(registroVacio);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}