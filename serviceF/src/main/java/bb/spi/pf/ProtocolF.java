package bb.spi.pf;

import bb.api.IDatabaseCreator;
import bb.api.ProtocolPlugin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProtocolF implements ProtocolPlugin { // this one intentionally conflicts with ProtocolB on 4 IDs of 4
    public ProtocolF() {
        System.out.println(ProtocolF.class.getName() + " instantiated");
    }

    private volatile String initStr;
    private static final Set<String> protocolIDs = new HashSet<>(Arrays.asList("bmw", "abc", "mbb", "dkw"));

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
