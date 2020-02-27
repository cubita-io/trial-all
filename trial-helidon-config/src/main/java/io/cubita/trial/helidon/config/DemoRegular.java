package io.cubita.trial.helidon.config;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
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
public class DemoRegular {

    public static void main(String[] args) throws InterruptedException {
//        ScheduledPollingStrategy pollingStrategy =

//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
//
//        final PollingStrategy pollingStrategy = PollingStrategies.regular(Duration.ofSeconds(2)).executor(executor).get();
//
//        final ConfigSource configSource = ConfigSources.file("/Users/apple/Documents/workspace/java/cubita/trial-all/application.properties").pollingStrategy(pollingStrategy).get();
//
//        Config config = Config.create(configSource);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);


        Config config = Config.create(ConfigSources.
                file("/Users/apple/Documents/workspace/java/cubita/trial-all/application.properties").
                pollingStrategy(PollingStrategies.
                        regular(Duration.ofSeconds(2)).
                        executor(executor)));

        config.get("greeting")
            .onChange((changedNode) -> {
                System.out.println(changedNode.asString().get());
                System.out.println("Node " + changedNode.key() + " has changed!");
            });

        Supplier<String> greetingSupplier = config.get("greeting")
                .asString().supplier();



//        config.get("greeting")
//                .changes()
//                .subscribe(new Flow.Subscriber<Config>() {
//                    Flow.Subscription subscription;
//
//                    @Override
//                    public void onSubscribe(Flow.Subscription subscription) {
//                        this.subscription = subscription;
//                        subscription.request(1);
//                    }
//
//                    @Override
//                    public void onNext(Config changedNode) {
//                        System.out.println("Node " + changedNode.key() + " has changed!");
//                        subscription.request(1);
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//                    }
//
//                    @Override
//                    public void onComplete() {
//                    }
//                });

        for (;;) {

            System.out.println("Always actual greeting value: " + greetingSupplier.get());

            //System.out.println(config.get("greeting").asString().get());

            TimeUnit.SECONDS.sleep(5);
        }
    }
}
