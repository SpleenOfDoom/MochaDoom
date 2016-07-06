package utils;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class C2JUtilsTest {
    @Test
    public void strcpy() throws Exception {
        char[] src = {'m', 'o', 'c', 'h', 'a', ' ', 'd', 'o', 'o', 'm'};
        char[] dst = new char[src.length];
        char[] wrong = {'m', 'o', 'c', 'h', 'a', 'a', 'd', 'o', 'o', 'm'};
        C2JUtils.strcpy(dst, src);

        // toString comparisons are not good enough for everything, but
        // they are good enough arrays of primitives, and they give
        // a nice error message if they fail.

        // assertArrayEquals is NOT good enough because it
        // lacks the symmetric "arrayNotEquals"
        //
        // It's very good when you can test both equality and
        // inequality, to avoid the degenerate case of methods
        // always returning true
        assertEquals(Arrays.toString(src), Arrays.toString(dst));
        assertNotEquals(Arrays.toString(wrong), Arrays.toString(dst));
    }
}