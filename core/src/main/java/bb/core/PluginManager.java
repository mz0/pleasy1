package bb.core;

import bb.api.ProtocolPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PluginManager {
    private static ServiceLoader<ProtocolPlugin> loader = ServiceLoader.load(ProtocolPlugin.class);
    private Map<String, ProtocolPlugin> protocolHandlers = new HashMap<>();

    public PluginManager() {
        long start = System.currentTimeMillis();
        int warnings = 0;
        for (ProtocolPlugin pp : loader) {
            for (String id : pp.getCompatibleIDs()) {
                if (protocolHandlers.get(id) == null) {
                    System.out.printf("adding ID '%s' for %s%n", id, pp.getClass().getName());
                    protocolHandlers.put(id, pp);
                } else {
                    warnings++;
                    System.out.printf("WARNING: ID '%s' for %s conflicts with %s%n", id, pp.getClass().getName(),
                            protocolHandlers.get(id).getClass().getName());
                }
            }
        }
        long finish = System.currentTimeMillis();
        System.out.printf("%n%d plugins loaded OK (%d warning[s]) in %d ms%n%n%n",
                protocolHandlers.values().stream().distinct().count(), warnings, finish - start);
    }

    public Set<String> getCompatibleIDs() {
        return protocolHandlers.keySet();
    }
}
