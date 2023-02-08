package bb.spi.pa;

import bb.api.IDatabaseCreator;
import bb.api.ProtocolPlugin;

public class ProtocolA implements ProtocolPlugin {
    private volatile String initStr;
    private static final String protocolID = "apx";

    @Override
    public void init(String iniParam) {
        initStr = iniParam;
    }

    @Override
    public String getCompatibleID() {
        return protocolID;
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
