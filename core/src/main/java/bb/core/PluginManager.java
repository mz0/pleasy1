package bb.core;

import bb.api.ProtocolPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider; // since Java 9
import java.util.Set;
import java.util.stream.Collectors;

public class PluginManager {
    private final Map<String, ProtocolPlugin> protocolHandlers = new HashMap<>();

    public PluginManager() {
        List<String> stopList = List.of("bb.spi.pf.ProtocolF");
        long start = System.currentTimeMillis();
        List<ProtocolPlugin> loadPlugins = enabledPlugins(stopList);
        int warnings = 0;
        System.out.println("collecting supported protocol IDs");
        for (ProtocolPlugin pp : loadPlugins) {
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
                loadPlugins.size(), warnings, finish - start);
    }

    public Set<String> getCompatibleIDs() {
        return protocolHandlers.keySet();
    }

    private static List<ProtocolPlugin> enabledPlugins(List<String> stopList) {
        System.out.println("will not load: " + String.join(", ", stopList));
        return ServiceLoader.load(ProtocolPlugin.class)
                .stream()
                .filter((Provider<ProtocolPlugin> p) -> !stopList.contains(p.type().getName()))
                .map(Provider::get)
                .collect(Collectors.toList());
    }
}
