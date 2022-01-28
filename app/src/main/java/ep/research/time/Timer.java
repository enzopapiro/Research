package ep.research.time;

import java.io.Closeable;
import java.io.IOException;

public abstract class Timer implements Closeable {

    protected long time;

    abstract public Timer start();

    public void stop() {
        try {
            close();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public long elapsedTime(){
        return time;
    }
}
