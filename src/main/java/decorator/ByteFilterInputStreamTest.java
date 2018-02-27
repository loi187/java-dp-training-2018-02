package decorator;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ByteFilterInputStreamTest {

    public static String findFirstWithCondition(List<String> items, Predicate<String> predicate) {
        for (String item: items) {
            if (predicate.test(item)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Not found!");
    }

    public static void main(String[] args) {
        List<String> items = Arrays.asList("aaa", "bbbccc", "cccddd");
        System.out.println(findFirstWithCondition(items, s -> s.endsWith("c")));
    }

    private boolean test(int i) {
        System.out.println("Alma");
        return i != 'a';
    }

    @Test
    public void testFilter() throws IOException {
        ByteFilterInputStreamTest t = new ByteFilterInputStreamTest();
        InputStream is = new ByteFilterInputStream(new ByteArrayInputStream("abacda".getBytes(StandardCharsets.UTF_8)),
                t::test);
        byte[] chars = new byte[10];
        int i = is.read(chars);
        assertThat(i, equalTo(3));
        assertThat(new String(chars, 0, 3), equalTo("bcd"));
    }
}
