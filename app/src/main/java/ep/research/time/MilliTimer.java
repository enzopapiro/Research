package ep.research.time;

import org.agrona.concurrent.SystemEpochMicroClock;

public class MilliTimer extends Timer {

	private final SystemEpochMicroClock nanoClock = new SystemEpochMicroClock();

	public Timer start() {
		time=System.currentTimeMillis();
		return this;
	}
	
	@Override
	public void close() {
		time=System.currentTimeMillis()-time;
	}
}