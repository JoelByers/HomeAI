#include <Arduino.h>

class RelayMod
{
  public:
    RelayMod(int num)
    {
      numRelays = num;

      for(int i = 2; i < numRelays; i++)
      {
        pinMode(i, OUTPUT);
      }
    }

    void set(int relay, bool state)
    {
      digitalWrite(relay + 2, state);   
    }

  private:
    int numRelays;
};
