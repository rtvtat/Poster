package ru.netology;

public class PosterManager {

    private FilmInfo[] films = new FilmInfo[0];
    int lastCount;

    public PosterManager() {
        lastCount = 10;
    }

    public PosterManager(int lastCount) {
        this.lastCount = lastCount;
    }

    public void AddFilm(FilmInfo film) {
        int newLength = films.length + 1;
        FilmInfo[] copy = new FilmInfo[newLength];
        System.arraycopy(films, 0, copy, 0, films.length);
        copy[copy.length - 1] = film;
        films = copy;
    }

    public FilmInfo[] findAll() {
        return films;
    }

    public FilmInfo[] findLast() {
        int resultLength;
        if (lastCount < films.length) {
            resultLength = lastCount;
        } else {
            resultLength = films.length;
        }
        FilmInfo[] result = new FilmInfo[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = films[films.length - i - 1];
        }
        return result;
    }
}
