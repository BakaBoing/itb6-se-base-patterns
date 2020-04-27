package at.fhv.itb6.se.plugin;

public interface IIdGenerator {

    IIdGenerator INSTANCE = (IIdGenerator) PluginFactory.getPlugin(IIdGenerator.class);

    Long nextId();
}
