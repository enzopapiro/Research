package ep.research.falsesharing;

import jdk.internal.vm.annotation.Contended;

public class FalseSharingState {
    @Contended
    public volatile long value = 0;
    // alternative way - pad out with dummy longs to the cache line size
    // public long p1, p2, p3, p4, p5, p6;
}
