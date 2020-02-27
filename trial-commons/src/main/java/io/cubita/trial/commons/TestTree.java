package io.cubita.trial.commons;

import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public class TestTree {

    public static void main(String[] args) {

        Map<String, String> newHeaders = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        newHeaders.put("aa", "1");
        newHeaders.put("AAb", "2");
        newHeaders.put("ba2", "3");
        newHeaders.put("da", "4");
        newHeaders.put("oa", "5");

        System.out.println(newHeaders);

    }
}
