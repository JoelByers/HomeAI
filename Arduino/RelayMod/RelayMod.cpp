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

    set(int relay, bool state)
    {
      digitalWrite(relay, state)
    }
  private:
    int numRelays;
}
