/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetoNegocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author R2
 */


public class CsvImport {

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

    public void CargarTabla(JTable tabla) throws IOException {
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

            String[] nextLine;

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);

            int c = 0;

            String str;
            while ((str = reader.readLine()) != null) {
                if (c > 2) {
                    String[] array = str.split(",");
                    String[] last = new String[2];
                    last[0] = array[0];
                    if (array.length > 1) {

                        if (array[1].equals("?") || array[1].equals("✔")) {

                            last[1] = array[1];

                        } else {
                            last[1] = " ";
                        }

                    } else {
                        last[1] = " ";
                    }
                    modelo.addRow(last);
                }
                c++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
