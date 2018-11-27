import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RandomTest {

    @Test
    public void listTest() {
        List<String> strings1 = new ArrayList<>();
        strings1.add("Hallo");
        strings1.add("Hallo2");

        List<String> strings2 = strings1;

        Assert.assertEquals(strings1, strings2);
    }

    @Test
    public void listTestDifferentInstancesSameContent() {
        List<String> strings1 = new ArrayList<>();
        strings1.add("Hallo");
        strings1.add("Hallo2");

        List<String> strings2 = new ArrayList<>();
        strings2.add("Hallo");
        strings2.add("Hallo2");

        Assert.assertEquals(strings1, strings2);
    }

    @Test
    public void listTestDifferentInstancesSameContentDifferentOrder() {
        List<String> strings1 = new ArrayList<>();
        strings1.add("Hallo");
        strings1.add("Hallo2");

        List<String> strings2 = new ArrayList<>();
        strings2.add("Hallo2");
        strings2.add("Hallo");

        Assert.assertEquals(strings1, strings2);
    }
}
