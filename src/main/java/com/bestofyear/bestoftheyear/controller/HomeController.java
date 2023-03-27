package com.bestofyear.bestoftheyear.controller;

import com.bestofyear.bestoftheyear.model.Movie;
import com.bestofyear.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home(Model model) {
        model.addAttribute("myname", "Giovanni");
        return "home";
    }

    @GetMapping("/movies")
    public String movie(Model model) {
        List<Movie> moviesList = getBestMovies();
        String moviesString = "";
        for (Movie m : moviesList) {
            moviesString += m.getTitle() + ", ";
        }
        moviesString = moviesString.substring(0, moviesString.length() - 2) + ".";
        model.addAttribute("movies", moviesString);
        return "movies";
    }

    @GetMapping("/songs")
    public String song(Model model) {
        List<Song> songsList = getBestSongs();
        String songsString = "";
        for (Song s : songsList) {
            songsString += s.getTitle() + " by " + s.getAuthor() + ", ";
        }
        songsString = songsString.substring(0, songsString.length() - 2) + ".";
        model.addAttribute("songs", songsString);
        return "songs";
    }


    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Amelie"));
        movies.add(new Movie(2, "Blade Runner"));
        movies.add(new Movie(3, "Her"));
        return movies;
    }

    private List<Song> getBestSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Darkness", "Peter Gabriel"));
        songs.add(new Song(2, "San Jacinto", "Peter Gabriel"));
        return songs;
    }
}
