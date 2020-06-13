package pl.edu.agh.automatedgrader.jtp2.lab3.interfaces;

public class DefaultPhilosopher implements Philosopher {
	int id;
	public DefaultPhilosopher(int id,DefaultFork leftFork, DefaultFork rightFork) {
		super();
		this.id=id;
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}

	DefaultFork leftFork;
	DefaultFork rightFork;

	@Override
	public void run() {
		int meals = 0;
		try {
			while (meals < getHowMany()) {
				doSomething(": thinking ");
				Thread.currentThread().sleep(DefaultMain.maxTimeForThinking);
				DefaultMain.waiter.take(this);

				Thread.currentThread().sleep(DefaultMain.maxTimeForEating);
				meals++;
				doSomething(": eating meal nr: " + meals);
				DefaultMain.waiter.put(this);

			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	@Override
	public int getHowMany() {
		return DefaultMain.howMany;
	}

	@Override
	public Fork getLeftFork() {
		return this.leftFork;
	}

	@Override
	public Fork getRightFork() {
		return this.rightFork;
	}

	@Override
	public DefaultWaiter getDefaultWaiter() {
		return DefaultMain.waiter;
	}

	private void doSomething(String action) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + action);

	}

	
	
}
