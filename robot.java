/* This Robot interface will be used to create the robots used
in the maze
 */
interface Robot {
  String getName();
  char getType();
}

/* This will create a Bob robot with the necessary abilities to look for
an Alice robot. Since we will only have one Bob robot at a time, the
constructor can make a BobBot with no inputs
 */
class BobBot implements Robot{
  String name;
  char type;

  public BobBot(){
    this.name = "Bob";
    this.type = 'B';
  }

  public String getName() {
    return name;
  }

  public char getType(){
    return type;
  }

  //move function needs to be added

  //count steps function needs to be added

  //look for alice function needs to be added
}

/*
This will create an Alice Robot. Since we will only have one, we only
need a basic constructor
 */
class AliceBot implements Robot{
  String name;
  char type;

  public AliceBot(){
    this.name = "Alice";
    this.type = 'A';
  }

  public String getName() {
    return name;
  }

  public char getType(){
    return type;
  }
}

/*
This will create a policeman type Robot. Since we could have multiple of
these bots, the constructor will require a name for each bot.
 */
class PoliceBot implements Robot{
  String name;
  char type;

  public PoliceBot(String name){
    this.name = name;
    this.type = 'P';
  }

  public String getName() {
    return name;
  }

  public char getType(){
    return type;
  }
}

/*
This will create a Student type Robot. Since we could have multiple of
these bots, the constructor will require a name for each bot.
 */
class StudentBot implements Robot{
  String name;
  char type;

  public StudentBot(String name){
    this.name = name;
    this.type = 'S';
  }

  public String getName() {
    return name;
  }

  public char getType(){
    return type;
  }
}

/*
This will create a Scientist type Robot. Since we could have multiple of
these bots, the constructor will require a name for each bot.
 */
class ScientistBot implements Robot{
  String name;
  char type;

  public ScientistBot(String name){
    this.name = name;
    this.type = 'C';
  }

  public String getName() {
    return name;
  }

  public char getType(){
    return type;
  }
}

/*
This will create a policeman type Robot. Since we could have multiple of
these bots, the constructor will require a name for each bot.
 */
class DoctorBot implements Robot{
  String name;
  char type;

  public DoctorBot(String name){
    this.name = name;
    this.type = 'D';
  }

  public String getName() {
    return name;
  }

  public char getType(){
    return type;
  }
}
