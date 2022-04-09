package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddGameNotFound() {

        GameStore store = new GameStore();
        Game game = null;

        assertFalse(store.containsGame(game));
    }

    @Test
    public void ShouldGetMostPlayer() {

        GameStore store = new GameStore();
        store.addPlayTime("Petya", 5);
        store.addPlayTime("Petya", 30);
        store.addPlayTime("Anna", 30);

        String expected = "Petya";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);

    }
}