package ep.research.time;

import org.agrona.concurrent.SystemEpochMicroClock;

public class MicroTimer extends Timer {

	private final SystemEpochMicroClock nanoClock = new SystemEpochMicroClock();

	public Timer start() {
		time=nanoClock.microTime();
		return this;
	}
	
	@Override
	public void close() {
		time=nanoClock.microTime()-time;
	}
}