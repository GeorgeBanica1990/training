package timers;

import java.util.Date;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;

@Startup
@Singleton
public class ScheduledTimer {

	@Schedule(minute = "*/1", hour = "*", info = "myScheduledTimer", persistent = false)
	public void schedule(Timer timer) {
		System.out.println(
				this + " schedule executed now and every minute " + new Date() + " using timer " + timer.getInfo());
	}
}
