package pl.edu.agh.automatedgrader.jtp2.lab3.interfaces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DefaultMain implements Main{
	static int howMany = 10;
	int numberOfPhilosophers  = 3;
	static int maxTimeForEating = 100;
	static int maxTimeForThinking = 100;
	static DefaultWaiter waiter=  new DefaultWaiter();
	List<DefaultFork> forksList = new ArrayList<DefaultFork>();
	List<DefaultPhilosopher> philosophersList = new ArrayList<DefaultPhilosopher>();
	static Set<Fork> usedForks = new HashSet<Fork>();
	static Set<DefaultPhilosopher> waitingPhilosophers = new HashSet<DefaultPhilosopher>();
	List<Thread> workingThreads =  new ArrayList<Thread>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public void eatingThinking(int howMany, int numberOfPhilosophers, int maxTimeForEating, int maxTimeForThinking) {
		for(int i = 0; i < numberOfPhilosophers; i++) {
			DefaultFork df = new DefaultFork();
			forksList.add(df);
		}
		for(int j = 0; j < numberOfPhilosophers; j++) {
			DefaultPhilosopher philo = new DefaultPhilosopher(forksList.get(j), forksList.get(j+1));
			philosophersList.add(philo);
			Thread t =  new Thread(philo);
			t.start();
			workingThreads.add(t);
			if(j == numberOfPhilosophers - 1) {
				DefaultPhilosopher phil = new DefaultPhilosopher(forksList.get(j-1), forksList.get(0));
				philosophersList.add(phil);
				Thread t1 = new Thread(phil);
				workingThreads.add(t1);
				t1.start();
			}
		}
		try {
		for(Thread t : workingThreads) {
			t.join();
		}
		} catch (InterruptedException e ) {
			e.printStackTrace();
		}
	}
	@Override
	public List<DefaultFork> getForks() {
		return forksList;
	}
	@Override
	public List<DefaultPhilosopher> getPhilosophers() {
		return philosophersList;
	}
	@Override
	public DefaultWaiter getDefaultWaiter() {
	return waiter;
	}

}
