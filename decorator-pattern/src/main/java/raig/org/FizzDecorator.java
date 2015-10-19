package raig.org;

public class FizzDecorator extends Decorator {

  int numberOfDecorator;
  String soundOfDecorator;

  public FizzDecorator(FizzBuzzComponent fizzBuzzComponent,
                       int numberOfDecorator,String soundOfDecorator) {
    super(fizzBuzzComponent);
    this.numberOfDecorator = numberOfDecorator;
    this.soundOfDecorator = soundOfDecorator;
  }


  public String say(int number) {

    if(number % numberOfDecorator == 0) {
       return soundOfDecorator;
    }

    return super.say(number);
  }

}
