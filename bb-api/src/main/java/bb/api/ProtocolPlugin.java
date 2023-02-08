package bb.api;

public interface ProtocolPlugin {
    void init(String iniParam);

    String getCompatibleID();

    IDatabaseCreator getDatabaseCreator();

    Object getInitParameters();
}
