package bb.api;

import java.util.Set;

public interface ProtocolPlugin {
    void init(String iniParam);

    Set<String> getCompatibleIDs();

    IDatabaseCreator getDatabaseCreator();

    Object getInitParameters();
}
