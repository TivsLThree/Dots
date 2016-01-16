package threads;

import game.Main;

public class PaintThread implements Runnable {
	private boolean shouldRun = true;
	int delay;

	public PaintThread(int delay) {

		this.delay = delay;
	}

	@Override
	public void run() {
		shouldRun = true;
		while (shouldRun) {
			try {
				Main.msc.repaint();

				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void stop() {
		shouldRun = false;
	}
}