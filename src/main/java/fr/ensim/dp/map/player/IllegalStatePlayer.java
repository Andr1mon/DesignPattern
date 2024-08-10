package fr.ensim.dp.map.player;

public class IllegalStatePlayer implements IStatePlayer {
    @Override
    public void play(IPlayer player) {
        throw new IllegalStateException();
    }

    @Override
    public void stop(IPlayer player) {
        throw new IllegalStateException();
    }

    @Override
    public void pause(IPlayer player) {
        throw new IllegalStateException();
    }

    @Override
    public void forward(IPlayer player) {
        throw new IllegalStateException();
    }

    @Override
    public void backward(IPlayer player) {
        throw new IllegalStateException();
    }
}
