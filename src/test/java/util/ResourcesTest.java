package util;

import org.junit.Test;
import schedule.utils.Resources;

import static org.junit.Assert.assertEquals;

/**
 * @author hwd
 * @date 2021-01-07 8:51 PM
 **/
public class ResourcesTest {

    @Test
    public void urlTest() {
        assertEquals(
                "file:/D:/iFiles/workspaces/code/schedule/target/classes/schedule/empty.xml",
                Resources.getURL("schedule/empty.json").toString());
    }

}
