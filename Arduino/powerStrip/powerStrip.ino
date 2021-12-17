#define RLY1 2
#define RLY2 3

byte buff;

void setup()
{
  pinMode(RLY1, OUTPUT);
  pinMode(RLY2, OUTPUT);
  Serial.begin(9600);
  Serial.write(1);
}

void loop()
{
  if(Serial.available() > 0)
  {
    buff = Serial.read();
  }

  if(buff == 1)
  {
    digitalWrite(RLY1, HIGH);
    digitalWrite(RLY2, HIGH);   
  }

  if(buff == 0)
  {
    digitalWrite(RLY1, LOW);
    digitalWrite(RLY2, LOW);    
  }
  
  /*
  Serial.println("HIGH");
  digitalWrite(RLY1, HIGH);
  digitalWrite(RLY2, HIGH);
  delay(2000);
  Serial.println("LOW");
  digitalWrite(RLY1,LOW);
  digitalWrite(RLY2,LOW);
  delay(2000);
  */
}
