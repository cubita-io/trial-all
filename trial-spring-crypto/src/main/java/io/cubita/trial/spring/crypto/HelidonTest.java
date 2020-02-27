package io.cubita.trial.spring.crypto;

import io.helidon.config.Config;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public class HelidonTest {

    public static void main(String[] args) {
//        final ConfigParser configParser =
//                ConfigParsers.properties();
//        final ConfigSource aa =
//                ConfigSources.classpath("aa.json")
//                        .parser(configParser)
//                        .build();
//        final Config config = Config.loadSourcesFrom(aa);
        final Config config = Config.create();
        System.out.println(config.get("aa").asString().get());
    }

}
