package org.egreen.seed.impl.utils;

import org.egreen.seed.api.log.LoggerService;
import org.egreen.seed.impl.log.LoggerServiceImpl;
import org.egreen.seed.impl.log.DefaultLogger;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dewmal on 3/21/15.
 */
public class Utils {

    private static final String VAR_REGEXP = "\\$\\{[^}]*}";
    private static final Pattern varPattern = Pattern.compile(VAR_REGEXP);

    // Seed Log Service
    private static LoggerService loggerService;

    public static String getSeedXMLLocation() {
        return getCarbonHome() + File.separator + Constants.CONF_REPO_DIR +
                File.separator + Constants.SEED_CONFIG_XML;
    }

    public static String getCarbonHome() {
        // Assumption. This property is always get validated in the Seed launcher module.
        return System.getProperty(Constants.SEED_HOME);
    }

    /**
     * Replace system property holders in the property values.
     * e.g. Replace ${seed.home} with value of the seed.home system property.
     */
    public static String substituteVars(String value) {
        String newValue = value;

        Matcher matcher = varPattern.matcher(value);
        while (matcher.find()) {
            String sysPropKey = value.substring(matcher.start() + 2, matcher.end() - 1);
            String sysPropValue = System.getProperty(sysPropKey);
            if (sysPropValue == null || sysPropValue.length() == 0) {
                throw new RuntimeException("System property " + sysPropKey + " cannot be null");
            }
            sysPropValue = sysPropValue.replace("\\", "\\\\");
            newValue = newValue.replaceFirst(VAR_REGEXP, sysPropValue);
        }
        return newValue;
    }

    public static LoggerService getDefaultLogger() {
        if (loggerService == null) {
            loggerService = new LoggerServiceImpl();
            loggerService.registerLogger(new DefaultLogger("SEED LOGGER"));// Define Home logger
        }
        return loggerService;
    }


}
