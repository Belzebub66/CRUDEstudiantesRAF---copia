package controlador;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ArchivoOrgnDir;
import vista.VistaCRUDEstudiantes;

public class ControladorCRUDEstudiantes {

    public VistaCRUDEstudiantes objVistaCRUDEst;
    ArchivoOrgnDir objArchivo;
    DefaultTableModel modelo;

    public ControladorCRUDEstudiantes(VistaCRUDEstudiantes aThis, ArchivoOrgnDir objArchivo) {
        this.objVistaCRUDEst = aThis;
        this.objArchivo = objArchivo;
        this.modelo = null;
    }
    /*
     * public void llenarTabla(){
     * String [] columnas = {"Num.Control", "Nombre", "Apellidos","Semestre",
     * "Grupo", "Carrera"};
     * ArchivoOrgnDir objArchivo = new ArchivoOrgnDir();
     * //Abrir Archivo
     * objArchivo.abrirArchivoTexto('r', "estudiantes.txt");
     * //Lectura de datos desde el archivo (extraer los registros)
     * String [][] filas = objArchivo.obtenerMatrizRegistros(6);
     * //Cerrar el archivo
     * objArchivo.cerrarArchivo('r');
     * modelo= new DefaultTableModel(filas,columnas);
     * this.objVistaCRUDEst.jtblEstudiantes.setModel(modelo);
     * }
     */

    public void guardarRegistro(String nc, String nom, String ape, int sem, char gpo, String carrera) {
        // String linea= nc + "," + nom + ","+ ape + ","+ sem + ","+ gpo + ","+ carrera;
        this.objArchivo = new ArchivoOrgnDir();
        this.objArchivo.abrirArchivoRAF("estudiantes.dat");
        // this.objArchivo.crearLinea(linea);
        this.objArchivo.escribirRegistro(nc, nom, ape, sem, gpo, carrera);
        this.objArchivo.cerrarArchivo();
        // this.llenarTabla();
    }

    public String[] buscarRegistro(String nc) {
        String[] datos = null;
        this.objArchivo = new ArchivoOrgnDir();
        this.objArchivo.abrirArchivoRAF("estudiantes.dat");
        datos = this.objArchivo.buscarRegistro(nc);
        this.objArchivo.cerrarArchivo();
        return datos;
    }
    /*
     * public void buscarSeleccionarRegistro(String nc){
     * boolean encontrado=false;
     * for(int i=0; i<this.modelo.getRowCount(); i++ ){
     * String nControl = this.modelo.getValueAt(i, 0).toString();
     * if(nControl.equals(nc)){
     * this.objVistaCRUDEst.jtblEstudiantes.setRowSelectionInterval(i, i);
     * this.objVistaCRUDEst.jtblEstudiantes.setSelectionBackground(Color.BLUE);
     * encontrado=true;
     * break;
     * }
     * }
     * if (encontrado==false)
     * JOptionPane.showMessageDialog(objVistaCRUDEst,"No se encontro el registro");
     * }
     * 
     * 
     * public void eliminarRegistro(String numControl) {
     * this.objArchivo = new ArchivoOrgnDir();
     * this.objArchivo.abrirArchivoTexto('r', "estudiantes.txt");
     * this.objArchivo.eliminarLinea(numControl);
     * this.objArchivo.cerrarArchivo('r');
     * 
     * this.objArchivo.eliminarArchivo("estudiantes.txt");
     * this.objArchivo.renombrarArchivo("temporal.txt", "estudiantes.txt");
     * 
     * this.llenarTabla();
     * }
     */

    public boolean eliminarRegistro(String numControl) {
        this.objArchivo = new ArchivoOrgnDir();
        this.objArchivo.abrirArchivoRAF("estudiantes.dat");
        boolean resultado = this.objArchivo.eliminarRegistroRAF(numControl);
        this.objArchivo.cerrarArchivo();
        return resultado;
    }

    public boolean validaNumControl(String numControl) {
        this.objArchivo = new ArchivoOrgnDir();
        return this.objArchivo.validaControl(numControl);
    }
}