package raig.org.states;

public interface GumballState {
  void quarterInserted();
  void turnsCrank();
  void gumballsFinished();
  void dispense();
  String statetoString();

}
