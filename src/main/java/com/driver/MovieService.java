package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
       movieRepository.addMovie(movie);
    }
    public void addDirector( Director director){
      movieRepository.addDirector(director);
    }
    public void addPair(String movieName, String directorName){
        movieRepository.addPair(movieName,directorName);
    }
    public Movie getMovie(String name){
        return movieRepository.getMovie(name);
    }
    public Director getDirector( String dir){
       return movieRepository.getDirector(dir);
    }
    public ArrayList<String> getList(String dir){
        return movieRepository.getList(dir);
    }
    public ArrayList<String> getallmovies(){
        return movieRepository.getallmovies();
    }
    public void deleteDirectorMovies(String dirname){
        movieRepository.deleteDirectorMovies(dirname);
    }
    public void deleteDirectorwork(){
        movieRepository.deleteDirectorwork();
    }
}
