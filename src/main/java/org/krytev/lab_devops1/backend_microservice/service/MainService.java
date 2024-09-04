package org.krytev.lab_devops1.backend_microservice.service;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class MainService {

    public void writeString(String string) throws IOException {
        FileWriter fw = new FileWriter("data.txt");
        fw.write(string);
        fw.close();
        System.out.println(string);
    }

}
