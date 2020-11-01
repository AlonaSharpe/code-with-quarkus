package org.acme;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@QuarkusMain
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Quarkus.run(MoreThanOnceApp.class, args);
    }


    public static class MoreThanOnceApp implements QuarkusApplication {

        @Override
        public int run(String... args) throws Exception {

            if (args.length>0) {
                logger.debug("Started application with the following args:");
                for (String arg : args) {
                    logger.debug(arg);
                }
            }

            Quarkus.waitForExit();
            return 0;
        }
    }

}
