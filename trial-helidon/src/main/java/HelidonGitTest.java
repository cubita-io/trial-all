import java.net.URI;
import java.time.Duration;

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
public class HelidonGitTest {

    private static final Config config = Config.create(
            GitConfigSourceBuilder
                    .create("application.conf")
                    .uri(URI.create("https://github.com/okosatka/test-config.git"))
//                    .directory(Paths.get("/"))
                    .branch("master")
                    .pollingStrategy(PollingStrategies.regular(Duration.ofMinutes(5))));

    public static void main(String[] args) {

//        PollingStrategies.watch(Paths.get("/"));
//        final ConfigParser configParser =
//                ConfigParsers.properties();
//        final ConfigSource aa =
//                ConfigSources.classpath("aa.json")
//                        .parser(configParser)
//                        .build();
//        final Config config = Config.loadSourcesFrom(aa);
//        final Config config = Config.create();
//        System.out.println(config.get("aa").asString().get());
//        final Config config = Config.create(classpath("aa.json").mediaType("application/json"));
//        System.out.println(config.get("aa").asString().get());

//        final Config config = Config.create(classpath("aa.json").parser(HoconConfigParserBuilder.buildDefault()));
//        System.out.println(config.get("aa").asString().get());
        System.out.println(config.get("greeting").asString().get());
    }

}
