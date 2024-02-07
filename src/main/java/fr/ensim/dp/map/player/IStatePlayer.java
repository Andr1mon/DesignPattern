package fr.ensim.dp.map.player;

public interface IStatePlayer {
  
  void play(IPlayer player);
  
  void stop(IPlayer player);
  
  void pause(IPlayer player);
  
  void forward(IPlayer player);
  
  void backward(IPlayer player);
  
}
