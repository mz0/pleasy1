package bb.spi.pa;

import bb.api.IDatabaseCreator;
import bb.api.ProtocolPlugin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//TODO https://github.com/google/auto/tree/main/service - found not working 2022-02-09
//import com.google.auto.service.AutoService;
//@AutoService(ProtocolPlugin.class)
public class ProtocolA implements ProtocolPlugin {
    public ProtocolA() {
        System.out.println(ProtocolA.class.getName() + " instantiated");
    }
    private volatile String initStr;
    private static final Set<String> protocolIDs = new HashSet<>(Arrays.asList("apx", "agx", "abc"));

    @Override
    public void init(String iniParam) {
        initStr = iniParam;
    }

    @Override
    public Set<String> getCompatibleIDs() {
        return protocolIDs;
    }

    @Override
    public IDatabaseCreator getDatabaseCreator() {
        return null;
    }

    @Override
    public Object getInitParameters() {
        return initStr;
    }
}
