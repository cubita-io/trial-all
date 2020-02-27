package io.cubita.trial.helidon.config;

import java.net.URI;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

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
public class DemoGitProperties {



    public static void main(String[] args) throws InterruptedException {

        Config config = Config.create(
                GitConfigSourceBuilder
                        .create("application.properties")
                        .uri(URI.create("https://github.com/cubita-io/trial-config.git"))
                        .directory(Paths.get("/Users/apple/Downloads/test-git-config"))
                        .branch("master")
                        .pollingStrategy(PollingStrategies.regular(Duration.ofSeconds(1))));

        for (;;) {
            System.out.println(String.format(
                    "greeting is %s\n"
                            + "web.debug is %b\n"
                            + "web.page-size is %d\n"
                            + "web.ratio is %f\n"
                            + "bl.initial-id is %d\n"
                            + "origin is %s\n"
                            + "java.home is %s",
                    config.get("greeting").asString().orElse("Default greeting"),
                    config.get("web.debug").asBoolean().orElse(false),
                    config.get("web.page-size").asInt().orElse(50),
                    config.get("web.ratio").asDouble().orElse(2.0),
                    config.get("bl.initial-id").asLong().orElse(1L),
                    config.get("origin").asString().orElse("defaults"),
                    config.get("java.home").asString().get()));
            TimeUnit.SECONDS.sleep(60);
        }

//        SubmissionPublisher<PollingStrategy.PollingEvent> ticksSubmitter;
//        Flow.Publisher<PollingStrategy.PollingEvent> ticksPublisher;
//
//
//        final PollingStrategy pollingStrategy = PollingStrategies.regular(Duration.ofSeconds(1)).get();
//
//        pollingStrategy.ticks().subscribe(new Flow.Subscriber<PollingStrategy.PollingEvent>() {
//            @Override
//            public void onSubscribe(Flow.Subscription subscription) {
//                System.out.println("1111");
//                subscription.request(Long.MAX_VALUE);
//            }
//
//            @Override
//            public void onNext(PollingStrategy.PollingEvent item) {
//                System.out.println(item.timestamp());
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                System.out.println(throwable.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("complete");
//            }
//        });


//        ticksSubmitter = new SubmissionPublisher<>(Runnable::run, //deliver events on current thread
//                1); //(almost) do not buffer events
//        ticksPublisher = ConfigHelper.suspendablePublisher(ticksSubmitter,
//                () -> System.out.println("start"),
//                () -> System.out.println("end"));
//
//        ticksPublisher.subscribe(new Flow.Subscriber<PollingStrategy.PollingEvent>() {
//            @Override
//            public void onSubscribe(Flow.Subscription subscription) {
//                System.out.println("111");
//            }
//
//            @Override
//            public void onNext(PollingStrategy.PollingEvent item) {
//                System.out.println("22222");
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                System.out.println("3333");
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("4444");
//            }
//        });
//
//        ticksSubmitter.submit(PollingStrategy.PollingEvent.now());

//        TimeUnit.MINUTES.sleep(60);

    }

}
