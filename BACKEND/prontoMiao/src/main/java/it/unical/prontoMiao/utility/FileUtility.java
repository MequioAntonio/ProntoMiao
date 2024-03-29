package it.unical.prontoMiao.utility;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Component
public class FileUtility {

    @Value("${prontomiao.baseUrl}")
    private String baseurò;

    public void base64ToFile(String encodedFile, String folderName) throws IOException {
        String filename = getNomeFIle(encodedFile);
        String path = System.getProperty("user.dir") + "/" + folderName;
        //File folder = new File("/Users/saradramis/Desktop/prontomiao/"+folderName);
        Files.createDirectories(Paths.get(path));
        String splitted = encodedFile.split("base64,")[1];
        byte[] imageData = Base64.getDecoder().decode(splitted);
        OutputStream os = new FileOutputStream(path+"/"+filename);
        os.write(imageData);

    }

    public byte[] getImage(String nomeContesto, int idContesto, String nomeFile) throws IOException {
        File image = new File(System.getProperty("user.dir")  + "/" + nomeContesto + "/" + Integer.toString(idContesto) + "/" + nomeFile);
        InputStream is = new FileInputStream(image);
        return IOUtils.toByteArray(is);
    }

    public String getNomeFIle(String encodedFile){
        return encodedFile.split(";")[0];
    }

    public String generaUrlImmagine(String nomeContesto, int idContesto, String nomeFile) {
        return "http://localhost:8080/files/" + nomeContesto + "/" + Integer.toString(idContesto) + "?filename=" + nomeFile;
    }
}
