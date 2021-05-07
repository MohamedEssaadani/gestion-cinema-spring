package com.essaadani.cinema.web;

import com.essaadani.cinema.dao.FilmRepository;
import com.essaadani.cinema.entities.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class CinemaRestController {
    @Autowired
    private FilmRepository filmRepository;
    @GetMapping(path = "/imageFilm/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable (name="id") Long id) throws IOException {
        Film film = filmRepository.findById(id).get();
        String photoName = film.getPhoto();
        File file = new File(System.getProperty("user.home")+"/cinema/images/"+photoName);
        Path path = Paths.get(file.toURI());

        return Files.readAllBytes(path);
    }
}
