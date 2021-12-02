/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetoNegocio;

import DAO.AlumnoDAO;
import DAO.AlumnoHasGrupoDAO;
import Entities.Alumno;
import Entities.Alumno_has_grupo;
import Entities.Grupo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author R2
 */
public class CsvImport {

    private String ruta = "";
    private String fecha = "";
    private ArrayList<Alumno> alumnos;
    private ArrayList<Boolean> asistencias;

    public void leer() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        String absolutePath = "";

        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("CSV Files", "csv");
        fileChooser.setFileFilter(imgFilter);

        int result = fileChooser.showOpenDialog(null);

        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = fileChooser.getSelectedFile();

            if ((fileName == null) || (fileName.getName().equals(""))) {
                throw new IOException("File null or empty");
            } else {
                absolutePath = fileName.getAbsolutePath();
            }
        }

        if (absolutePath.equals("")) {
            return;
        }

        try (FileInputStream fis = new FileInputStream(absolutePath);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr)) {

            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String obtenerRuta() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        String absolutePath = "";

        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("CSV Files", "csv");
        fileChooser.setFileFilter(imgFilter);

        int result = fileChooser.showOpenDialog(null);

        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = fileChooser.getSelectedFile();

            if ((fileName == null) || (fileName.getName().equals(""))) {
                throw new IOException("File null or empty");
            } else {
                absolutePath = fileName.getAbsolutePath();
            }
        }

        this.ruta = absolutePath;

        return absolutePath;
    }

    public boolean verificarAlumnosCsv(long idGrupo) {
        ArrayList<String> alumnos = ObtenerAlumnos();
        AlumnoDAO alumnoDao = new AlumnoDAO();
        this.alumnos = new ArrayList<>();
        int contador = 0;

        if (!alumnos.isEmpty()) {

            for (String alumno : alumnos) {

                try {
                    Alumno alumnoBD = alumnoDao.consultarAlumnosNombre(alumno, idGrupo);

                    if (alumnoBD == null) {

                        String txt = "Un alumno del csv no se encuentra en el grupo. El alumno: " + alumno;
                        JOptionPane.showMessageDialog(null, txt);
                        break;

                    }
                    this.alumnos.add(alumnoBD);
                    contador++;

                    if (contador == alumnos.size()) {
                        System.out.println("Verificado correcto");
                        return true;

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "CSV vacio");
        }
        System.out.println("Verificado con fallas");
        System.out.println("size: " + alumnos.size());
        System.out.println("Contador: " + contador);
        return false;
    }

    public ArrayList<String> ObtenerAlumnos() {
        String ruta = this.ruta;
        ArrayList<String> alumnos = new ArrayList<String>();

        if (ruta.equals("")) {
            return alumnos;
        }

        try (FileInputStream fis = new FileInputStream(ruta);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr)) {

            String[] nextLine;
            int c = 0;

            String str;
            while ((str = reader.readLine()) != null) {
                if (c > 2) {
                    String[] array = str.split(",");
                    String[] last = new String[2];
                    last[0] = array[0];
                    alumnos.add(last[0]);
                }
                c++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return alumnos;
    }

    public void CargarTabla(JTable tabla) throws IOException {
        this.asistencias = new ArrayList<>();

        try {
            String absolutePath = obtenerRuta();

            if (absolutePath.equals("")) {
                return;
            }

            try (FileInputStream fis = new FileInputStream(absolutePath);
                    InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                    BufferedReader reader = new BufferedReader(isr)) {

                String[] nextLine;

                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                modelo.setRowCount(0);

                int c = 0;

                String str;
                while ((str = reader.readLine()) != null) {

                    if (c == 2) {
                        String[] array = str.split(",");
                        String fecha = "";
                        for (int i = 0; i < 10; i++) {
                            fecha += array[1].charAt(i);
                        }
                        this.fecha = fecha;
                    }

                    if (c > 2) {
                        String[] array = str.split(",");
                        String[] last = new String[2];
                        last[0] = array[0];
                        if (array.length > 1) {

                            if (array[1].equals("?") || array[1].equals("✔")) {

                                last[1] = array[1];
                                asistencias.add(true);

                            } else {

                                asistencias.add(false);
                                last[1] = " ";
                            }

                        } else {
                            asistencias.add(false);
                            last[1] = " ";
                        }
                        modelo.addRow(last);
                    }
                    c++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
        }

    }

    public void agregarAlumnosCsv(Grupo grupo) {
        AlumnoHasGrupoDAO asistencias = new AlumnoHasGrupoDAO();

        String[] array = this.fecha.split("-");
        int[] fechas = new int[3];
        fechas[0] = Integer.parseInt(array[0]);
        fechas[1] = Integer.parseInt(array[1]);
        fechas[2] = Integer.parseInt(array[2]);
        Date date = new Date(fechas[2], fechas[1], fechas[0]);
        System.out.println(date.toString());
        System.out.println(grupo.toString());

        int i = 0;

        for (Alumno alumno : this.alumnos) {
            asistencias.agregar(new Alumno_has_grupo(date, this.asistencias.get(i), alumno, grupo));
            System.out.println(this.asistencias.get(i));
            System.out.println(alumno);
            i++;
        }

    }

}
