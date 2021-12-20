#include "RelayMod.cpp"

#define RLY1 2
#define RLY2 3

byte buff[2]{0};
RelayMod* relays;

void setup()
{
  pinMode(RLY1, OUTPUT);
  pinMode(RLY2, OUTPUT);
  relays = new RelayMod(2);
  Serial.write(1);
  Serial.begin(9600);
}

void loop()
{
  if(Serial.available() > 0)
  {
    Serial.readBytes(buff,2);

    relays->set(buff[0], buff[1]);
  }
    
  /*
  if(Serial.available() > 0)
  {
    buff = Serial.read();

    if(buff == 1)
    {
      digitalWrite(RLY1, HIGH);
      digitalWrite(RLY2, HIGH);       
    }
    else if(buff == 0)
    {
      digitalWrite(RLY1, LOW);
      digitalWrite(RLY2, LOW);          
    }
  }
  */
}
