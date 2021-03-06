package p;

import doom.thinker_t;

public interface ThinkerList {

    void AddThinker(thinker_t thinker);
    void RemoveThinker(thinker_t thinker);
    void InitThinkers();
    int getNumThinkers();
    thinker_t getRandomThinker();
    thinker_t getThinkerCap();
}
