package basicparser.emu;

import basicparser.programflow.MultiNumber;

import java.util.Random;

public class BasicEmu {
	private Random random = new Random(System.currentTimeMillis());

	private double lastRnd;
	public MultiNumber rnd(int x) {
		if(x == 0) {
			return new MultiNumber(lastRnd);
		}
		lastRnd = (double)random.nextInt(101) / 100;
		return new MultiNumber(lastRnd);
	}

	private static BasicEmu instance;

	public static BasicEmu instance() {
		if(instance == null) {
			instance = new BasicEmu();
		}
		return instance;
	}
}
