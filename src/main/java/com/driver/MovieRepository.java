package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class MovieRepository {
    HashMap<String,Movie> M = new HashMap<>();
    HashMap<String,Director> D = new HashMap<>();
    HashMap<String, ArrayList<String>> DM = new HashMap<>();
    public MovieRepository(){
        this.M = new HashMap<String, Movie>();
        this.D = new HashMap<String, Director>();
        this.DM = new HashMap<String, ArrayList<String>>();
    }
    public void addMovie(Movie movie){
        String movieName = movie.getName();
        M.put(movieName,movie);
    }
    public void addDirector( Director director){
        String directorName = director.getName();
        D.put(directorName,director);

    }
    public void addPair(String movieName, String directorName){
        if(!M.containsKey(movieName) || !D.containsKey(directorName)){
           return;
        }
        if(DM.containsKey(directorName)){
            DM.get(directorName).add(movieName);
        }
        else{
            ArrayList <String> ans = new ArrayList<>();
            ans.add(movieName);
            DM.put(directorName,ans);
        }

    }
    public Movie getMovie(String name){
        if(!M.containsKey(name)) return null;
        return M.get(name);
    }
    public Director getDirector( String dir){
        if(!D.containsKey(dir)) return null;
        return D.get(dir);
    }
    public ArrayList<String> getList(String dir){
        if(!DM.containsKey(dir)) return null;
        return  DM.get(dir);
    }
    public ArrayList<String> getallmovies(){
        ArrayList<String> ans = new ArrayList<>();
        for(String s : M.keySet()){
            ans.add(s);
        }
        return ans;
    }
    public void deleteDirectorMovies(String dirname){
        ArrayList<String> movies = DM.get(dirname);
        for (int i = 0; i < movies.size(); i++) {
            if(M.containsKey(movies.get(i))){
                M.remove(movies.get(i));
            }
        }
        DM.remove(dirname);
        if(D.containsKey(dirname)){
            D.remove(dirname);
        }

    }
    public void deleteDirectorwork(){
        for (String dir: DM.keySet()) {
            ArrayList<String> lis = DM.get(dir);
            for (String name: lis) {
                if(M.containsKey(name)){
                    M.remove(name);
                }
            }
            D.remove(dir);
        }
        for (String d: D.keySet()) {
            D.remove(d);
        }
    }

}
