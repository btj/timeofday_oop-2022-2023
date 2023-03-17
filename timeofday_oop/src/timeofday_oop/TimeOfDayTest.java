package timeofday_oop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeOfDayTest {

	@Test
	void test() {
		TimeOfDay oopStart = new TimeOfDay(10, 0);
		assertEquals(10, oopStart.getHours());
		assertEquals(0, oopStart.getMinutes());
		oopStart.setMinutes(30);
		TimeOfDay oopEnd = new TimeOfDay(12, 0);
		oopStart.setHours(11);
		oopStart.setMinutesSinceMidnight(13 * 60);
		int oopLength = oopEnd.getMinutesSinceMidnight() - oopStart.getMinutesSinceMidnight();
		assertEquals(150, oopLength);
	}

}
