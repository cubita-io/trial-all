//package io.cubita.trial.helidon.config;
//
//import io.helidon.config.Config;
//
///**
// * <p>
// * </p>
// *
// * @author jiawei
// * @since 1.0.0
// */
//public class DemoDefaultProperties {
//
//    public static void main(String[] args) {
//        //application.properties
//        final Config config = Config.create();
//
//        System.out.println(String.format(
//                "greeting is %s\n"
//                        + "web.debug is %b\n"
//                        + "web.page-size is %d\n"
//                        + "web.ratio is %f\n"
//                        + "bl.initial-id is %d\n"
//                        + "origin is %s\n"
//                        + "java.home is %s",
//                config.get("greeting").asString().orElse("Default greeting"),
//                config.get("web.debug").asBoolean().orElse(false),
//                config.get("web.page-size").asInt().orElse(50),
//                config.get("web.ratio").asDouble().orElse(2.0),
//                config.get("bl.initial-id").asLong().orElse(1L),
//                config.get("origin").asString().orElse("defaults"),
//                config.get("java.home").asString().get()));
//
//    }
//
//}
