package schedule.utils;

import java.net.URL;

/**
 * @author hwd
 * @date 2021-01-07 8:48 PM
 **/
public class Resources {

    public static URL getURL(String relativePath) {
        ClassLoader classLoader = Resources.class.getClassLoader();
        return classLoader.getResource(relativePath);
    }

}
