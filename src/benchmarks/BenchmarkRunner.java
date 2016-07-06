package benchmarks;

public class BenchmarkRunner {
    public void runBenchmarks(HasBenchmarks benchmarks) {
        for (Benchmark benchmark: benchmarks.getBenchmarks()) {
            long startTime = System.currentTimeMillis();
            benchmark.runBenchmark();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            System.out.println("Benchmark " + benchmark.getBenchmarkName() + " took " + runTime + " milliseconds");
        }
    }

    public static void main(String[] args) {
        BenchmarkRunner benchmarkRunner = new BenchmarkRunner();
        benchmarkRunner.runBenchmarks(new C2JUtilsBenchmarks());
    }
}
