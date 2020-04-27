package at.fhv.itb6.se.plugin.generators;

import at.fhv.itb6.se.plugin.IIdGenerator;

public class CounterIdGenerator implements IIdGenerator {
    private Long _currentId = 0L;

    public Long nextId() {
        return _currentId += 1L;
    }
}
