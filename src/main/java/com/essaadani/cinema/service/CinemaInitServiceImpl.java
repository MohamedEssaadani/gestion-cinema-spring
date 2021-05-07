package com.essaadani.cinema.service;

import com.essaadani.cinema.dao.*;
import com.essaadani.cinema.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService {
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ProjectionRepository projectionRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void initVilles() {
        Stream.of("Casablanca", "Safi", "Rabat", "Marrakech", "El Jadida")
                .forEach(villeName->{
                    Ville ville = new Ville();
                    ville.setNom(villeName);
                    villeRepository.save(ville);
                });
    }

    @Override
    public void initCinemas() {
        villeRepository.findAll()
                .forEach(ville -> {
                    Stream.of("MegaRama", "IMAX", "Chahrazad", "Daouliz", "Founoun")
                            .forEach(cinemaName->{
                                Cinema cinema = new Cinema();
                                cinema.setNom(cinemaName);
                                cinema.setVille(ville);
                                cinema.setNombreSalles(3+(int)(Math.random()*7));

                                cinemaRepository.save(cinema);
                            });
                });
    }

    @Override
    public void initSalles() {
        cinemaRepository.findAll()
                .forEach(cinema -> {
                    for(int i=0; i<cinema.getNombreSalles(); i++){
                        Salle salle = new Salle();
                        salle.setNom("Salle"+(i+1));
                        salle.setCinema(cinema);
                        salle.setNombrePlaces(15+(int) (Math.random()*10));
                        salleRepository.save(salle);
                    }
                });
    }

    @Override
    public void initPlaces() {
        salleRepository.findAll()
                .forEach(salle -> {
                    for (int i=0; i<salle.getNombrePlaces(); i++){
                        Place place = new Place();
                        place.setNumero(i+1);
                        place.setSalle(salle);
                        placeRepository.save(place);
                    }
                });
    }

    @Override
    public void initSeances() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Stream.of("12:00", "15:00", "17:00", "19:00", "21:00")
                .forEach(s->{
                    Seance seance = new Seance();
                    try {
                        seance.setHeureDebut(dateFormat.parse(s));
                        seanceRepository.save(seance);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                });
    }

    @Override
    public void initCategories() {
        Stream.of("Histoire", "Actions", "Fiction", "Drama")
                .forEach(categorieName->{
                    Categorie categorie = new Categorie();
                    categorie.setNom(categorieName);
                    categorieRepository.save(categorie);
                });
    }

    @Override
    public void initFilms() {
        double [] durees = {2.3, 3, 3.33, 2.43};
        List<Categorie> categories = categorieRepository.findAll();

        Stream.of("Game Of Thrones", "Seigneur des Anneaux", "Spider Man", "Iron Man", "Arrow", "Cat Woman")
                .forEach(titreFilm->{
                    Film film = new Film();
                    film.setTitre(titreFilm);
                    film.setDuree(durees[new Random().nextInt(durees.length)]);
                    film.setPhoto(titreFilm+".jpg");
                    film.setCategorie(categories.get(new Random().nextInt(categories.size())));
                    film.setDescription("description");
                    film.setRealisateur("Es-saadani Mohamed");
                    filmRepository.save(film);
                });
    }

    @Override
    public void initProjections() {
        double [] prices = {33, 44, 50, 88, 99, 21};

        villeRepository.findAll()
                .forEach(ville -> {
                    ville.getCinemas().forEach(cinema -> {
                        cinema.getSalles().forEach(salle -> {
                            filmRepository.findAll()
                                    .forEach(film -> {
                                        seanceRepository.findAll()
                                                .forEach(seance -> {
                                                    Projection projection = new Projection();
                                                    projection.setDateProjection(new Date());
                                                    projection.setFilm(film);
                                                    projection.setPrix(prices[new Random().nextInt(prices.length)]);
                                                    projection.setSalle(salle);
                                                    projection.setSeance(seance);
                                                    projectionRepository.save(projection);
                                                });
                                    });

                        });
                    });
                });

    }

    @Override
    public void initTickets() {
        projectionRepository.findAll()
                .forEach(projection -> {
                        projection.getSalle().getPlaces().forEach(place -> {
                            Ticket ticket = new Ticket();
                            ticket.setPlace(place);
                            ticket.setPrix(projection.getPrix());
                            ticket.setReservee(false);
                            ticket.setProjection(projection);
                            ticketRepository.save(ticket);
                        });
                });
    }
}
