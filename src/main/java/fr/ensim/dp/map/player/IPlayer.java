package fr.ensim.dp.map.player;

public interface IPlayer {

  void play();

  void stop();

  void pause();

  void forward();

  void backward();

  void firechangeState(IStatePlayer state);
}
