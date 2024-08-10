package fr.ensim.dp.map.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void play() {
        // initial state is Stop
        Player player = new Player();
        player.play();
        // testing Play illegal transitions
        assertThrows(IllegalStateException.class, () -> {
            player.play();
        });
        // from Play to Forward transition test
        player.forward();
        player.stop();
        player.play();
        // from Play to Backward transition test
        player.backward();
        player.stop();
        player.play();
        // from Play to Pause transition test
        player.pause();


        // from Pause to Stop transition test
        player.stop();
        player.play();
        player.forward();

        // from Play to Stop transition test
        player.stop();
    }
    @Test
    void stop() {
        // initial state is Stop
        Player player = new Player();
        // testing Stop illegal transitions
        assertThrows(IllegalStateException.class, () -> {
            player.forward();
        });
        assertThrows(IllegalStateException.class, () -> {
            player.backward();
        });
        assertThrows(IllegalStateException.class, () -> {
            player.pause();
        });
        assertThrows(IllegalStateException.class, () -> {
            player.stop();
        });
        // from Stop to Play transition test
        player.play();
    }
    void forward() {
        // initial state is Stop
        Player player = new Player();
        player.play();
        player.forward();
        // testing Forward illegal transitions
        assertThrows(IllegalStateException.class, () -> {
            player.forward();
        });
        assertThrows(IllegalStateException.class, () -> {
            player.play();
        });
        assertThrows(IllegalStateException.class, () -> {
            player.pause();
        });
        // from Forward to Backward transition test
        player.backward();
        player.forward();
        // from Forward to Stop transition test
        player.stop();
    }
    void backward() {
        // initial state is Stop
        Player player = new Player();
        player.play();
        player.backward();
        // testing Backward illegal transitions
        assertThrows(IllegalStateException.class, () -> {
            player.backward();
        });
        assertThrows(IllegalStateException.class, () -> {
            player.play();
        });
        assertThrows(IllegalStateException.class, () -> {
            player.pause();
        });
        // from Backward to Stop transition test
        player.stop();
    }
    void pause() {
        // initial state is Stop
        Player player = new Player();
        player.play();
        player.pause();
        // testing Pause illegal transitions
        assertThrows(IllegalStateException.class, () -> {
            player.backward();
        });
        assertThrows(IllegalStateException.class, () -> {
            player.forward();
        });
        assertThrows(IllegalStateException.class, () -> {
            player.pause();
        });
        // from Pause to Play transition test
        player.play();
        player.pause();
    }



}