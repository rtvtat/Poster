package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PosterManagerTest {
    PosterManager manager1;
    PosterManager manager2;
    PosterManager manager3;

    @BeforeEach
    public void setUp() {
        manager1 = new PosterManager();
        manager1.AddFilm(new FilmInfo("фильм1", "боевик"));
        manager1.AddFilm(new FilmInfo("фильм2", "комедия"));
        manager1.AddFilm(new FilmInfo("фильм3", "драма"));
        manager1.AddFilm(new FilmInfo("фильм4", "драма"));
        manager1.AddFilm(new FilmInfo("фильм5", "драма"));
        manager1.AddFilm(new FilmInfo("фильм6", "драма"));
        manager1.AddFilm(new FilmInfo("фильм7", "драма"));
        manager1.AddFilm(new FilmInfo("фильм8", "драма"));
        manager1.AddFilm(new FilmInfo("фильм9", "драма"));
        manager1.AddFilm(new FilmInfo("фильм10", "драма"));
        manager1.AddFilm(new FilmInfo("фильм11", "драма"));

        manager2 = new PosterManager(3);
        manager2.AddFilm(new FilmInfo("фильм1", "боевик"));
        manager2.AddFilm(new FilmInfo("фильм2", "комедия"));
        manager2.AddFilm(new FilmInfo("фильм3", "драма"));
        manager2.AddFilm(new FilmInfo("фильм4", "драма"));
        manager2.AddFilm(new FilmInfo("фильм5", "драма"));

        manager3 = new PosterManager();
        manager3.AddFilm(new FilmInfo("фильм1", "боевик"));

    }

    @Test
    void testAddFilm() {
        FilmInfo newFilm = new FilmInfo("фильмN", "комедия");
        manager1.AddFilm(newFilm);
        FilmInfo[] all = manager1.findAll();
        assertEquals(12, all.length);
        assertEquals(newFilm, all[all.length - 1]);
    }

    @Test
    void testFindAll() {
        FilmInfo[] all = manager1.findAll();
        assertEquals(11, all.length);
    }

    @Test
    void findLast() {
        FilmInfo[] lastFilms = manager1.findLast();
        assertEquals(10, lastFilms.length);
        FilmInfo[] excepted = {
                new FilmInfo("фильм11", "драма"),
                new FilmInfo("фильм10", "драма"),
                new FilmInfo("фильм9", "драма"),
                new FilmInfo("фильм8", "драма"),
                new FilmInfo("фильм7", "драма"),
                new FilmInfo("фильм6", "драма"),
                new FilmInfo("фильм5", "драма"),
                new FilmInfo("фильм4", "драма"),
                new FilmInfo("фильм3", "драма"),
                new FilmInfo("фильм2", "комедия"),
        };

        assertArrayEquals(excepted, lastFilms);
    }

    @Test
    void testAddFilmManager2() {
        FilmInfo newFilm = new FilmInfo("фильмN", "комедия");
        manager2.AddFilm(newFilm);
        FilmInfo[] all = manager2.findAll();
        assertEquals(6, all.length);
        assertEquals(newFilm, all[all.length - 1]);
    }

    @Test
    void testFindAllManager2() {
        FilmInfo[] all = manager2.findAll();
        assertEquals(5, all.length);
    }

    @Test
    void findLastManager2() {
        FilmInfo[] lastFilms = manager2.findLast();
        assertEquals(3, lastFilms.length);
        FilmInfo[] excepted = {
                new FilmInfo("фильм5", "драма"),
                new FilmInfo("фильм4", "драма"),
                new FilmInfo("фильм3", "драма")
        };

        assertArrayEquals(excepted, lastFilms);
    }

    @Test
    void findLastManager3() {
        FilmInfo[] lastFilms = manager3.findLast();
        assertEquals(1, lastFilms.length);
        FilmInfo[] excepted = {
                new FilmInfo("фильм1", "боевик")
        };

        assertArrayEquals(excepted, lastFilms);
    }


}