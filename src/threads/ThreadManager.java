package threads;

public class ThreadManager {
	PaintThread paint = new PaintThread(60);
	UpdateThread update = new UpdateThread(100);

	public ThreadManager() {

	}

	public void wakeUp() {
		start();

	}

	private void start() {

		new Thread(paint, "Paint").start();
		new Thread(update, "Update").start();

	}

	@SuppressWarnings("unused")
	private void stop() {
		paint.stop();
		update.stop();
	}

}