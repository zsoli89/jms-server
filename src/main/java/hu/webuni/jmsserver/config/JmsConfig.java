package hu.webuni.jmsserver.config;

import org.apache.activemq.artemis.api.core.TransportConfiguration;
import org.apache.activemq.artemis.core.remoting.impl.netty.NettyAcceptorFactory;
import org.apache.activemq.artemis.core.remoting.impl.netty.NettyConnectorFactory;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisConfigurationCustomizer;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class JmsConfig {

    @Configuration
    public class ArtemisConfig implements ArtemisConfigurationCustomizer {
        @Override
        public void customize(org.apache.activemq.artemis.core.config.Configuration configuration) {
            Map<String, Object> params = Map.of(
                    "host", "localhost",
                    "port", 61617);
            configuration.addConnectorConfiguration("nettyConnector", new TransportConfiguration(NettyConnectorFactory.class.getName()));
            configuration.addAcceptorConfiguration(new TransportConfiguration(NettyAcceptorFactory.class.getName(), params));
        }
    }
}
