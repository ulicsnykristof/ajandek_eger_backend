package com.ajandekeger.raktar.image;

import com.ajandekeger.raktar.termek.Termek;
import org.apache.catalina.filters.RemoteIpFilter;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@RestController
public class ImageController {
    public static String UPLOAD_DIRECTORY = "src/main/resources/static/images";
    @Autowired
    public ImageRepository imageRepository;

    private List<Image> image_list;
    @CrossOrigin
    @PostMapping("public/uploadImage") public String uploadImage( @RequestParam("file") MultipartFile file,@RequestParam("cikkszam") String cikkszam) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        imageRepository.save(new Image(fileNames.toString(), cikkszam));
        return "imageupload/index";
    }

    @CrossOrigin
    @PostMapping("public/changeImage") public String changeImage( @RequestParam("file") MultipartFile file,@RequestParam("cikkszam") String cikkszam) throws IOException {
        Image del = null;
        for (Image var : imageRepository.findAll())
        {
            if (cikkszam.equals(var.cikkszam)){
                del = var;
            }
        }
        if(del != null){
            Path fileToDeletePath = Paths.get("src/main/resources/static/images/"+del.img);
            Files.delete(fileToDeletePath);
            imageRepository.delete(del);

        }

        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        imageRepository.save(new Image(fileNames.toString(), cikkszam));
        return "imageupload/index";
    }

    @CrossOrigin
    @GetMapping(path="public/images/all")
    public @ResponseBody Iterable<Image> getAllImage(){

        return imageRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("public/images/{cikkszam}")
    public ResponseEntity<Resource> getImage(@PathVariable String cikkszam) throws Exception {
        String kep = "";
        image_list = imageRepository.findAll();
        for (Image var : image_list)
        {
            if (cikkszam.equals(var.cikkszam)){
                kep = var.img;
            }
        }
        Path path = Paths.get("src/main/resources/static/images/"+kep);

        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }




    @CrossOrigin
    @DeleteMapping("public/deleteImage/{cikkszam}")
    public void deleteImage(@PathVariable String cikkszam) throws IOException {
        Image del = null;
        for (Image var : imageRepository.findAll())
        {
            if (cikkszam.equals(var.cikkszam)){
                del = var;
            }
        }
        if(del == null){
            return;
        }
        Path fileToDeletePath = Paths.get("src/main/resources/static/images/"+del.img);
        Files.delete(fileToDeletePath);
        imageRepository.delete(del);
        System.out.println("deleted successfully");
    }
}
