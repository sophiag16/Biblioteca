//has information about movie and displays it
package com.tw.biblioteca;

public class Movie {
    private String name;
    private String director;
    private String year;
    private String rating;
    private Display display;

    public Movie(String name, String director, String year, String rating, Display display) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.display = display;
    }

    public void printInfo() {
        display.printString(String.format("%-34s %-34s %-34s %-34s\n", name, director, year, rating));
    }

    @Override
    public boolean equals(Object that) {
        if (!(that instanceof Movie)) {
            return false;
        }
        if(this == that) {
            return true;
        }
        Movie thatMovie = (Movie) that;
        if(this.name.equals(thatMovie.name)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
