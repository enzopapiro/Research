package ep.research.time;

import org.agrona.concurrent.SystemEpochNanoClock;

public class NanoTimer extends Timer {

	private final SystemEpochNanoClock nanoClock = new SystemEpochNanoClock();

	public NanoTimer start() {
		time=nanoClock.nanoTime();
		return this;
	}
	
	@Override
	public void close() {
		time=nanoClock.nanoTime()-time;
	}
}