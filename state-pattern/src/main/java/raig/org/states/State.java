package raig.org.states;

public interface State {

  void quarterInserted();

  void turnsCrank();

  void gumballsFinished();

  void dispense();

  String statetoString();

  void gumballsNotFinished();

}
