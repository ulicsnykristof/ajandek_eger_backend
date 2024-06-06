package com.ajandekeger.raktar.termek;

import com.ajandekeger.raktar.image.Image;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TermekController {
    public static String UPLOAD_DIRECTORY = "src/main/resources/static/images";
    @Autowired
    public TermekRepository termekRepository;

    private List<Termek> termek_list;
    @CrossOrigin
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Termek> getAllTermek(){

        return termekRepository.findAll();
    }



    @CrossOrigin
    @GetMapping("/all/{id}")
    public List<Termek> show(@PathVariable String id){
        String termekId = id;
        termek_list =termekRepository.findAll();
        List<Termek> tl = new ArrayList<>();
        for (Termek var : termek_list)
        {
            if (termekId.equals(var.cikkszam)){
                tl.add(var);
            }
        }
        return tl;
    }

    @CrossOrigin
    @PostMapping("/addTermek")
    public Termek create(@RequestBody Map<String, String> body){
        String cikkszam =body.get("cikkszam");
        String vonalkod = body.get("vonalkod");
        String nev = body.get("nev");
        String img = body.get("img");
        Long eladarnetto = Long.parseLong(body.get("eladarnetto"));
        Long eladarbrutto = Long.parseLong(body.get("eladarbrutto"));
        int db = Integer.parseInt(body.get("db"));
        String tipus = body.get("tipus");
        String szin = body.get("szin");
        String meret = body.get("meret");
        String image = "blob";
        return termekRepository.save(new Termek(cikkszam, vonalkod, nev, img, eladarnetto, eladarbrutto, db, tipus, szin, meret, image));
    }

}
