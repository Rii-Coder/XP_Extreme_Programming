/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetoNegocio;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

        CSVReader reader = null;

        try {

            //parsing a CSV file into CSVReader class constructor  
            reader = new CSVReader(new FileReader(absolutePath));
            String[] nextLine;

            //reads one line at a time  
            while ((nextLine = reader.readNext()) != null) {
                for (String token : nextLine) {
                    System.out.print(token + " ");
                }
                System.out.println("|");
            }

        } catch (Exception e) {
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

        CSVReader reader = null;

        try {

            //parsing a CSV file into CSVReader class constructor  
            reader = new CSVReader(new FileReader(absolutePath));
            String[] nextLine;

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);

            int c = 0;

//            //reads one line at a time  
            while ((nextLine = reader.readNext()) != null) {
                int i = 0;
                if (c > 2) {
                    String[] array = new String[5];
                    for (String token : nextLine) {
                        array[i] = token;
                        i++;
                    }
                    modelo.addRow(array);
                }
                c++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
