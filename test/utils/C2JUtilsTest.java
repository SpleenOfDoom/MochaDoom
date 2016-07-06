package utils;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class C2JUtilsTest {
    @Test
    public void strcpy1() throws Exception {
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

    @Test
    public void strcpy2() throws Exception {
        char[] src = {'\0', 'm', 'o', 'c', 'h', 'a', ' ', 'd', 'o', 'o', 'm', '!', '!'};
        char[] expected = {'m', 'o', 'c', 'h', 'a', ' ', 'd', 'o', 'o', 'm', '\0', '\0', '\0'};
        char[] dst = new char[src.length];
        char[] wrong = {'m', 'o', 'c', 'h', 'a', ' ', 'd', 'o', 'o', 'm', '!', '!', '\0'};
        C2JUtils.strcpy(dst, src, 1, "mocha doom".length());

        assertEquals(Arrays.toString(expected), Arrays.toString(dst));
        assertNotEquals(Arrays.toString(wrong), Arrays.toString(dst));
    }

    @Test
    public void strcpy3() throws Exception {
        char[] src = {'\0', 'm', 'o', 'c', 'h', 'a', ' ', 'd', 'o', 'o', 'm'};
        char[] expected = {'m', 'o', 'c', 'h', 'a', ' ', 'd', 'o', 'o', 'm', '\0'};
        char[] dst = new char[src.length];
        char[] wrong = {'m', 'o', 'c', 'h', 'a', 'a', 'd', 'o', 'o', 'm', ' '};
        C2JUtils.strcpy(dst, src, 1);

        assertEquals(Arrays.toString(expected), Arrays.toString(dst));
        assertNotEquals(Arrays.toString(wrong), Arrays.toString(dst));
    }

    @Test
    public void strcpy4() throws Exception {
        String src = "mocha doom";
        char[] expected = {'m', 'o', 'c', 'h', 'a', ' ', 'd', 'o', 'o', 'm'};
        char[] dst = new char[src.length()];
        char[] wrong = {'m', 'o', 'c', 'h', 'a', 'a', 'd', 'o', 'o', 'm'};
        C2JUtils.strcpy(dst, src);

        assertEquals(Arrays.toString(expected), Arrays.toString(dst));
        assertNotEquals(Arrays.toString(wrong), Arrays.toString(dst));
    }

    @Test
    public void nullTerminatedString() throws Exception {
        char[] src = {'m', 'o', 'c', 'h', 'a', '\0', 'd', 'o', 'o', 'm'};
        String result = C2JUtils.nullTerminatedString(src);
        assertEquals("mocha", result);
        assertNotEquals("mocha doom", result);
    }
}
