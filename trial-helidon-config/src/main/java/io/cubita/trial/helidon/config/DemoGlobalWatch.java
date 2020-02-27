package io.cubita.trial.helidon.config;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import io.helidon.config.Config;
import io.helidon.config.ConfigSources;
import io.helidon.config.PollingStrategies;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public class DemoGlobalWatch {

    private static final Config config = Config.create(ConfigSources.
            file("/Users/apple/Documents/workspace/java/cubita/trial-all/application.properties").
            pollingStrategy(PollingStrategies::watch));

    public static void main(String[] args) throws InterruptedException {


        config.get("greeting")
            .onChange((changedNode) -> {
                System.out.println(changedNode.asString().get());
                System.out.println("Node " + changedNode.key() + " has changed!");
            });

        Supplier<String> greetingSupplier = config.get("greeting")
                .asString().supplier();


        for (;;) {

            System.out.println("Always actual greeting value: " + greetingSupplier.get());

            TimeUnit.SECONDS.sleep(5);
        }
    }
}
