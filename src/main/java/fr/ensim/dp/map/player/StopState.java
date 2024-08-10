package fr.ensim.dp.map.player;

public class StopState extends IllegalStatePlayer {
    @Override
    public void play(IPlayer player) {
        player.play();
    }
}
