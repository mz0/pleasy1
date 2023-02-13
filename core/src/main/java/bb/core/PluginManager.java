package bb.core;

import bb.api.ProtocolPlugin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.stream.Collectors;

public class PluginManager {
    private static volatile PluginManager INSTANCE;
    private final Map<String, ProtocolPlugin> protocolHandlers = new HashMap<>();

    public static PluginManager getInstance() {
        if (INSTANCE == null) {
            synchronized (PluginManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PluginManager();
                }
            }
        }
        return INSTANCE;
    }

    public static void init() {
        if (INSTANCE != null) {
            System.out.printf("WARN %s is already initialized%n", PluginManager.class.getName());
        } else {
            getInstance();
        }
    }

    private PluginManager() {
        List<String> stopList = Arrays.asList("bb.spi.pf.ProtocolF");
        System.out.println("will not load: " + String.join(", ", stopList));
        long start = System.currentTimeMillis();
        ServiceLoader<ProtocolPlugin> loader = ServiceLoader.load(ProtocolPlugin.class);
        int warnings = 0;
        System.out.println("collecting supported protocol IDs");
        for (ProtocolPlugin pp : loader) {
            if (stopList.contains(pp.getClass().getName())) {
                System.out.printf("not loading %s%n", pp.getClass().getName());
                continue;
            }
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

	public Map<String, String> getProtocolHandlerNames() {
		return protocolHandlers.entrySet().stream()
			.collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getClass().getName()));
	}
}
