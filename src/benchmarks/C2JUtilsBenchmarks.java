package benchmarks;

import utils.C2JUtils;

import java.util.Arrays;
import java.util.Collection;

class C2JUtilsBenchmarks implements HasBenchmarks {
    @Override
    public Collection<Benchmark> getBenchmarks() {
        return Arrays.asList(
                new strcpyBenchmark(),
                new arraycopyBenchmark()
        );
    }

    public static final int ELEMENTS_TO_TEST = 10;
    public static final int RUNS_TO_TRY = 10 * 1000 * 1000;

    private static void initializeArrayTestData(char[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) ('a' + (int) (Math.random() * 26));
        }
    }

    private static class strcpyBenchmark implements Benchmark {
        private char[] src1 = new char[ELEMENTS_TO_TEST];
        private char[] src2 = new char[ELEMENTS_TO_TEST];
        private char[] dst = new char[ELEMENTS_TO_TEST];

        public strcpyBenchmark() {
            initializeArrayTestData(src1);
            initializeArrayTestData(src2);
        }

        @Override
        public String getBenchmarkName() {
            return "strcpy benchmark";
        }

        @Override
        public void runBenchmark() {
            for (int i = 0; i < RUNS_TO_TRY; i++) {
                C2JUtils.strcpy(dst, src1);
                C2JUtils.strcpy(dst, src2);
            }
        }
    }

    private static class arraycopyBenchmark implements Benchmark {
        private char[] src1 = new char[ELEMENTS_TO_TEST];
        private char[] src2 = new char[ELEMENTS_TO_TEST];
        private char[] dst = new char[ELEMENTS_TO_TEST];

        public arraycopyBenchmark() {
            initializeArrayTestData(src1);
            initializeArrayTestData(src2);
        }

        @Override
        public String getBenchmarkName() {
            return "arraycopy benchmark";
        }

        @Override
        public void runBenchmark() {
            for (int i = 0; i < RUNS_TO_TRY; i++) {
                System.arraycopy(src1, 0, dst, 0, src1.length);
                System.arraycopy(src2, 0, dst, 0, src2.length);
            }
        }
    }
}
