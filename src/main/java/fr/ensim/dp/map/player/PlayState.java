package fr.ensim.dp.map.player;

public class PlayState extends IllegalStatePlayer {
    @Override
    public void stop(IPlayer player) {
        player.stop();
    }

    @Override
    public void forward(IPlayer player) {
        player.forward();
    }

    @Override
    public void backward(IPlayer player) {
        player.backward();
    }

    @Override
    public void pause(IPlayer player) {
        player.pause();
    }
}
