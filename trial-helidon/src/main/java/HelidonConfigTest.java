import io.helidon.config.Config;
import io.helidon.config.hocon.HoconConfigParserBuilder;

import static io.helidon.config.ConfigSources.classpath;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public class HelidonConfigTest {

    public static void main(String[] args) {
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

        final Config config = Config.create(classpath("aa.json").parser(HoconConfigParserBuilder.buildDefault()));
        System.out.println(config.get("aa").asString().get());
    }

}
