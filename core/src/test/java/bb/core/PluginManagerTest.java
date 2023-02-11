package bb.core;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PluginManagerTest {
	@Test
	void getProtocolHandlerNames() {
		Map<String, String> phn = PluginManager.getInstance().getProtocolHandlerNames();
		assertThat(phn.keySet().size()).isEqualTo(0); // oops! no plugins in core
	}
}
