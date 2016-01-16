package threads;

public class ThreadManager {
	PaintThread paint = new PaintThread(60);
	UpdateThread update = new UpdateThread(1000);
	public ThreadManager() {
		wakeUp();
	}

	public void wakeUp() {
		start();

	}

	private void start() {

		new Thread(paint).start();
		 new Thread(update).start();

	}

	private void stop() {
		paint.stop();
		 update.stop();
	}

}