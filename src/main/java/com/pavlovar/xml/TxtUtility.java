package com.pavlovar.xml;

import java.io.*;
import java.util.logging.Logger;

/**
 * Created by artempavlovskyi on 12/11/2016.
 */
public class TxtUtility implements FileUtility {

    private Logger log = Logger.getLogger("TxtUtility");
    private FileWriter writer;

    private InputStream inputStream;
    private OutputStream outputStream;

    public TxtUtility(String lineSeparator) {
        System.setProperty("lineSeparator", lineSeparator);
    }

    @Override
    public boolean create(String fileName) {
        if (!fileExists(fileName)) {
            try {
                writer = new FileWriter(fileName);
                writer.close();
            } catch (IOException e) {
                log.info("Cannot create file: " + fileName);
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean fileExists(String fileName) {
        try {
            inputStream = new FileInputStream(fileName);
            inputStream.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void read(String path) {
        try {
            // инициализируем поток на чтение
            inputStream = new FileInputStream(path);
            // читаем первый символ в байтах (ASCII)
            int data = inputStream.read();
            char content;
            // по байтово читаем весь файл
            while (data != -1) {
                // преобразуем полученный байт в символ
                content = (char) data;
                // выводим посимвольно
                System.out.print(content);
                data = inputStream.read();
            }
            // закрываем поток
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void write(TxtFile myFile, String string) {
        try {
            // инициализируем поток для вывода данных
            // что позволит нам записать новые данные в файл
            outputStream = new FileOutputStream(myFile.getName());
            // передаем полученную строку string и приводим её к byte массиву.
            outputStream.write(string.getBytes());
            // закрываем поток вывода
            // только после того как мы закроем поток данные попадут в файл.
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

