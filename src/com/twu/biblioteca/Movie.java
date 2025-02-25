package com.twu.biblioteca;

public class Movie {
    private String name;
    private Integer year;
    private String director;
    private Integer rating;
    private Boolean checkedout;

    public Movie(String name, Integer year, String director, Integer rating){
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checkedout = false;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getName() {
        return name;
    }

    public Boolean getCheckedout() {
        return checkedout;
    }

    public void setCheckedout(Boolean checkedout) {
        this.checkedout = checkedout;
    }

    public void checkOut() {
        if(!this.checkedout){
            System.out.println("Thank you! Enjoy the movie");
            this.checkedout = true;
        }
        else System.out.println("Sorry, that movie is not available");
    }
}
