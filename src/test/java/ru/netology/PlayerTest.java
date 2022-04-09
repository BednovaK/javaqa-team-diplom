package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfOneGame2() {

        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Палки", "Аркада");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game2, 5);

        int expected = 15;
        int actual = player.sumGenre(game.getGenre());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldMostPlayerByGenreGamePlayed() {

        GameStore store = new GameStore();

        Game game1 = store.publishGame("Ёлки", "Аркада");
        Game game2 = store.publishGame("Палки", "Аркада");
        Game game3 = store.publishGame("Пышки", "Бродилка");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game1, 50);
        player.play(game2, 12);
        player.play(game3, 1);


        Game expected = game1;
        Game actual = player.mostPlayerByGenre("Аркада");

        assertEquals(expected, actual);
    }

}
