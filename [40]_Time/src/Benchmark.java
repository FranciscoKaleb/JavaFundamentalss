public class Benchmark {
    private long startTime;
    private long endTime;
    private String label;
    
    public Benchmark() {
        this.label = "Operation";
    }
    
    public Benchmark(String label) {
        this.label = label;
    }
    
    /**
     * Start timing
     */
    public void timeStart() {
        startTime = System.nanoTime();
        System.out.println("[" + label + "] Started...");
    }
    
    /**
     * End timing and print results
     */
    public void timeEnd() {
        endTime = System.nanoTime();
        long duration = endTime - startTime;
        
        System.out.println("[" + label + "] Completed");
        System.out.println("Time taken: " + formatDuration(duration));
        System.out.println("---");
    }
    
    /**
     * Get elapsed time in nanoseconds without ending
     */
    public long getElapsedNanos() {
        return System.nanoTime() - startTime;
    }
    
    /**
     * Format duration for readable output
     */
    private String formatDuration(long nanos) {
        if (nanos < 1_000) {
            return nanos + " ns";
        } else if (nanos < 1_000_000) {
            return String.format("%.2f μs", nanos / 1_000.0);
        } else if (nanos < 1_000_000_000) {
            return String.format("%.2f ms", nanos / 1_000_000.0);
        } else {
            return String.format("%.2f s", nanos / 1_000_000_000.0);
        }
    }
    
    // Static utility methods for quick benchmarking
    public static void run(String label, Runnable task) {
        Benchmark bench = new Benchmark(label);
        bench.timeStart();
        task.run();
        bench.timeEnd();
    }
    
    
}