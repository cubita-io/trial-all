package io.cubita.trial.helidon.config;

import java.net.URI;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import io.helidon.config.Config;
import io.helidon.config.PollingStrategies;
import io.helidon.config.git.GitConfigSourceBuilder;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public class DemoGit {

    public static void main(String[] args) throws InterruptedException {
//        ScheduledPollingStrategy pollingStrategy =

//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
//
//        final PollingStrategy pollingStrategy = PollingStrategies.regular(Duration.ofSeconds(2)).executor(executor).get();
//
//        final ConfigSource configSource = ConfigSources.file("/Users/apple/Documents/workspace/java/cubita/trial-all/application.properties").pollingStrategy(pollingStrategy).get();
//
//        Config config = Config.create(configSource);


        Config config = Config.create(
                GitConfigSourceBuilder
                        .create("application.properties")
                        .uri(URI.create("https://github.com/cubita-io/trial-config.git"))
                        .directory(Paths.get("/Users/apple/Downloads/test-git-config"))
                        .branch("master")
                        .pollingStrategy(PollingStrategies.regular(Duration.ofSeconds(1))));

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
