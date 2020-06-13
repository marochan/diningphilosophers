package pl.edu.agh.automatedgrader.jtp2.lab3.interfaces;

public class DefaultPhilosopher implements Philosopher {
	public DefaultPhilosopher(DefaultFork leftFork, DefaultFork rightFork) {
		super();
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}

	DefaultFork leftFork;
	DefaultFork rightFork;
	@Override
	public void run() {
		int meals = 0;
		try {
			while(meals < getHowMany()) {
				doSomething(": thinking ");
				Thread.currentThread().sleep(DefaultMain.maxTimeForThinking);
				synchronized(getLeftFork()) {
					doSomething(": picked the left fork");
				DefaultMain.usedForks.remove(getLeftFork());
					synchronized (getRightFork()) {
						doSomething(": picked the right fork");
						DefaultMain.usedForks.remove(getRightFork());
						DefaultMain.waitingPhilosophers.remove(this);
						Thread.currentThread().sleep(DefaultMain.maxTimeForEating);
						meals++;
						doSomething(": eating meal nr: " + meals);
						doSomething(": put down the right fork");

						DefaultMain.waitingPhilosophers.add(this);
						DefaultMain.usedForks.add(getRightFork());
					}
					doSomething(": put down the left fork");
					DefaultMain.usedForks.add(getLeftFork());
				}
			}
		} catch (InterruptedException e ) {
			Thread.currentThread().interrupt();
		}
	}
		
	



	@Override
	public int getHowMany() {
		return DefaultMain.howMany;
	}

	@Override
	public Fork getLeftFork() {
		return leftFork;
	}

	@Override
	public Fork getRightFork() {
		return rightFork;
	}

	@Override
	public DefaultWaiter getDefaultWaiter() {
		return DefaultMain.waiter;
	}
	
	private void doSomething(String action) throws InterruptedException{
		System.out.println(Thread.currentThread().getName() + " " + action);
	
		
	}
}
