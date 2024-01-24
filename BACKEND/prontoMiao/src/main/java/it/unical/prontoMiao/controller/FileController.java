package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.utility.FileUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/files")
public class FileController {

    @Autowired
    FileUtility fileUtility;

    @RequestMapping(value = "/{nomeContesto}/{idContesto}",method = RequestMethod.GET, produces = "image/*")
    public @ResponseBody byte[] getImage(@PathVariable(value = "nomeContesto") String nomeContesto, @PathVariable(value = "idContesto") int idContesto, @Param(value = "filename") String filename) {
        try {
            return fileUtility.getImage(nomeContesto,idContesto,filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
