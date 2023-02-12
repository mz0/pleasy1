package com.exactpro.web.bean;

import bb.core.PluginManager;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused") // index.xhtml
@ManagedBean(name = "mrBean")
@ViewScoped
public class MrBean implements Serializable {
    private final Map<String, String> proto2plugin = PluginManager.getInstance().getProtocolHandlerNames();

    public List<Mapping> getList() {
        return proto2plugin.entrySet().stream().map(Mapping::new).collect(Collectors.toList());
    }

    public static class Mapping {
        String key;
        String value;

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public Mapping(Map.Entry kv) {
            key = (String) kv.getKey();
            value = (String) kv.getValue();
        }
    }
}
