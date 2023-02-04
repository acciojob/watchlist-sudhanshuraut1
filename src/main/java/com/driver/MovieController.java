package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("movies")

public class MovieController {
    @Autowired
    MovieService movieService;

 @PostMapping("/add_movie")
public ResponseEntity<String> addMovie(@RequestBody Movie movie){
    movieService.addMovie(movie);
    return new ResponseEntity<>("New Movie added Successfully", HttpStatus.CREATED);
}
@PostMapping("/add_director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
    movieService.addDirector(director);
   // ResponseEntity<String> ResponseEntity;
    return new ResponseEntity<>("new director added",HttpStatus.CREATED);
}

@PutMapping("/add_pair")
    public ResponseEntity<String> addPair(@RequestParam("movie") String movieName,@RequestParam("director")String directorName){
      movieService.addPair(movieName,directorName);
      String aws = "Pair added successfully";
    return new ResponseEntity<>(aws,HttpStatus.CREATED);
}
@GetMapping("/get_movie_byname/{name}")
    public ResponseEntity<Movie> getMovie(@PathVariable("name")String name){
   //movieService.getMovie(name);
   return new ResponseEntity<>(movieService.getMovie(name),HttpStatus.CREATED);
}
 @GetMapping("/get_director_byname/{director}")
    public ResponseEntity<Director> getDirector(@PathVariable("director") String dir){
      return new ResponseEntity<>(movieService.getDirector(dir),HttpStatus.CREATED);
 }
  @GetMapping("/get_list_movies/{direct}")
    public ResponseEntity<ArrayList<String>> getList(@PathVariable("direct") String dir){
    return new ResponseEntity<>(movieService.getList(dir),HttpStatus.CREATED);
 }
  @GetMapping("/get_all_movies")
    public ResponseEntity<ArrayList<String>> getallmovies(){
    return new ResponseEntity<>(movieService.getallmovies(),HttpStatus.CREATED);
  }
  @DeleteMapping("/delete_director_&_movies")
    public ResponseEntity<String> deleteDirectorMovies(@RequestParam("dir") String dirname){
      movieService.deleteDirectorMovies(dirname);
      return new ResponseEntity<>(dirname +"removed successfully",HttpStatus.CREATED);
  }
  @DeleteMapping("/delete_all_director_work")
    public ResponseEntity<String> deleteDirectorwork(){
      movieService.deleteDirectorwork();
      return new ResponseEntity<>("All directors deleted successfully",HttpStatus.CREATED);
  }
}
