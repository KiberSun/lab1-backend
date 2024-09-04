package org.krytev.lab_devops1.backend_microservice.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Service
public class MainService {

    public void writeString(String string) throws IOException {
        FileWriter fw = new FileWriter("data.txt");
        fw.write(string);
        fw.close();
        System.out.println(string);
    }

    public String getString() {
        try {
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(new File("data.txt"));
            if (scanner.hasNextLine()) sb.append(scanner.nextLine());
            for (; scanner.hasNextLine(); sb.append('\n').append(scanner.nextLine()));
            return sb.toString();
        } catch (FileNotFoundException e) {
            return "";
        }
    }
}
