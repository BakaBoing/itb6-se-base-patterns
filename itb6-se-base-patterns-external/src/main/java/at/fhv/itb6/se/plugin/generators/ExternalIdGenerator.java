package at.fhv.itb6.se.plugin.generators;

import at.fhv.itb6.se.plugin.IIdGenerator;

public class ExternalIdGenerator implements IIdGenerator {
    private Long _currentId = 990L;

    @Override
    public Long nextId() {
        return _currentId += 3L;
    }
}
