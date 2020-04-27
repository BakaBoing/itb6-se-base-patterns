package at.fhv.itb6.se.plugin.generators;

import at.fhv.itb6.se.plugin.IIdGenerator;

import java.util.Random;

public class RandomIdGenerator implements IIdGenerator {
    private Random _rand = new Random();

    public Long nextId() {
        return _rand.nextLong();
    }
}
