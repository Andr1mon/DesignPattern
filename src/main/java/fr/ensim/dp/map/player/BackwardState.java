package fr.ensim.dp.map.player;

public class BackwardState extends IllegalStatePlayer {
    @Override
    public void stop(IPlayer player) {
        player.stop();
    }

    @Override
    public void forward(IPlayer player) {
        player.forward();
    }
}
