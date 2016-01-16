package threads;

import game.Main;

public class UpdateThread implements Runnable {
	private boolean shouldRun = true;
	int delay;

	public UpdateThread(int delay) {
		Main.ts.add(this);
		this.delay = delay;
	}

	public void stop() {
		shouldRun = false;
	}

	@Override
	public void run() {

		shouldRun = true;
		while (shouldRun) {
			try {
				Main.updater.tick();
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
