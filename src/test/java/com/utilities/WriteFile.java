package com.utilities;

import java.io.*;

/**
 * This util class helps writing the data inside .txt file
 */
public class WriteFile {

     File file = new File(ConfigurationReader.getProperty("txtPath"));
     FileWriter fWriter;
     BufferedWriter bWriter;

    /**
     * If 2 different data's want to be written separately line, this method should use for this action
     * @param data1
     * @param data2
     */
    public void writeUsingBufferedWriter(String data1,String data2) {
        try {
            fWriter = new FileWriter(file);
            bWriter = new BufferedWriter(fWriter);
            bWriter.write(data1);
            bWriter.newLine();
            bWriter.write(data2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * After writing data inside .txt file, writeFile class should be closed with this method
     */
    public void closeWriteFile(){
        try {
            bWriter.close();
            fWriter.close();
        } catch (IOException e) {
            System.out.println("FileWriter could not closed successfully!");
            e.printStackTrace();
        }
    }

}
