package bb.core;

import bb.api.ProtocolPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class PluginManager {
    private static ServiceLoader<ProtocolPlugin> loader = ServiceLoader.load(ProtocolPlugin.class);
    private List<String> compatibleIDs = new ArrayList<>();

    public PluginManager() {
        for (ProtocolPlugin pp : loader) {
            System.out.println("adding ID for " + pp.getClass().getName());
            compatibleIDs.add(pp.getCompatibleID());
        }
    }

    public List<String> getCompatibleIDs() {
        return compatibleIDs;
    }
}
