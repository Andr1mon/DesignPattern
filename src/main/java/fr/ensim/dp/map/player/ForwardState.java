package fr.ensim.dp.map.player;

public class ForwardState extends IllegalStatePlayer {
    @Override
    public void stop(IPlayer player) {
        player.stop();
    }

    @Override
    public void backward(IPlayer player) {
        player.backward();
    }
}
