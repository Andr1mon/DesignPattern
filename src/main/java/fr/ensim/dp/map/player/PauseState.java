package fr.ensim.dp.map.player;

public class PauseState extends IllegalStatePlayer {
    @Override
    public void play(IPlayer player) {
        player.play();
    }

    @Override
    public void stop(IPlayer player) {
        player.stop();
    }
}
