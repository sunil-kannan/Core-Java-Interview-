package java8_features.stream;

import java.util.Comparator;
import java.util.Objects;

public class Movie implements Comparable<Movie>{
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year && Objects.equals(name, movie.name) && Objects.equals(actor, movie.actor) && Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, actor, director);
    }

    private int year;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", actor='" + actor + '\'' +
                ", director='" + director + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public Movie(String name, int year, String actor, String director) {
        this.name = name;
        this.year = year;
        this.actor = actor;
        this.director = director;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    private String actor;
    private String director;


    @Override
    public int compareTo(Movie o) {
        return this.getYear() - o.getYear();
    }

    public static Comparator<Movie> byYear = Comparator
            .comparing(Movie::getYear, Comparator.nullsFirst(Comparator.naturalOrder()));
}