package com.ajandekeger.raktar.termek;

import com.ajandekeger.raktar.charts.TermekTipus;
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
import java.util.Optional;

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
    @GetMapping("/all/{cikkszam}")
    public List<Termek> show(@PathVariable String cikkszam){
        termek_list =termekRepository.findAll();
        List<Termek> tl = new ArrayList<>();
        for (Termek var : termek_list)
        {
            if (cikkszam.equals(var.cikkszam)){
                tl.add(var);
            }
        }
        return tl;
    }

    @CrossOrigin
    @GetMapping(path="/chartTermekTipus")
    public @ResponseBody Iterable<TermekTipus> getAllTermekTipus(){

        termek_list =termekRepository.findAll();
        List<TermekTipus> ttl = new ArrayList<>();
        boolean voltmar = false;

        for (Termek termek : termek_list)
        {   voltmar = false;
            for (TermekTipus termekTipus : ttl)
            {
                if (termekTipus.getId().equals(termek.getTipus()))
                {
                    termekTipus.setValue(termekTipus.getValue() + termek.getDb());
                    voltmar = true;
                }
            }
            if(!voltmar)
            {
                TermekTipus tt = new TermekTipus(termek.getTipus(), termek.getTipus(), termek.getDb());
                ttl.add(tt);

            }

        }
        return ttl;
    }

    @CrossOrigin
    @PostMapping("/addTermek")
    public Termek create(@RequestBody Map<String, String> body){
        String cikkszam =body.get("cikkszam");
        String vonalkod = body.get("vonalkod");
        String nev = body.get("nev");
        Long eladarnetto = Long.parseLong(body.get("eladarnetto"));
        Long eladarbrutto = Long.parseLong(body.get("eladarbrutto"));
        int db = Integer.parseInt(body.get("db"));
        int fogyas = Integer.parseInt(body.get("fogyas"));
        String tipus = body.get("tipus");
        String szin = body.get("szin");
        String meret = body.get("meret");
        return termekRepository.save(new Termek(cikkszam, vonalkod, nev, eladarnetto, eladarbrutto, db, fogyas, tipus, szin, meret));
    }

    @CrossOrigin
    @PostMapping("/updateTermek")
    public void updateItem(@RequestBody Map<String, String> body){
        Optional<Termek> temp = termekRepository.findById(Integer.parseInt(body.get("id")));
        temp.get().setCikkszam(body.get("cikkszam"));
        temp.get().setNev(body.get("nev"));
        temp.get().setVonalkod(body.get("vonalkod"));
        temp.get().setEladarnetto(Long.parseLong(body.get("eladarnetto")));
        temp.get().setEladarbrutto(Long.parseLong(body.get("eladarbrutto")));
        temp.get().setDb(Integer.parseInt(body.get("db")));
        temp.get().setFogyas(Integer.parseInt(body.get("fogyas")));
        temp.get().setTipus(body.get("tipus"));
        temp.get().setSzin(body.get("szin"));
        temp.get().setMeret(body.get("meret"));
        termekRepository.save(temp.get());
    }

    @CrossOrigin
    @DeleteMapping("/deleteTermek/{id}")
    public void deleteItem(@PathVariable String id){
        Termek del = null;
        for (Termek var : termekRepository.findAll())
        {
            if (id.equals(var.cikkszam)){
                del = var;
            }
        }
        termekRepository.delete(del);
    }


}
