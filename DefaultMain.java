package pl.edu.agh.automatedgrader.jtp2.lab3.interfaces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DefaultMain implements Main{
	static int howMany = 10;
static	int numberOfPhilosophers  = 3;
	static int maxTimeForEating = 100;
	static int maxTimeForThinking = 100;
	static DefaultWaiter waiter=  new DefaultWaiter();
	 List<DefaultFork> forksList = new ArrayList<DefaultFork>();
	 List<DefaultPhilosopher> philosophersList = new ArrayList<DefaultPhilosopher>();
	static Set<Fork> usedForks = new HashSet<Fork>();
	static Set<DefaultPhilosopher> waitingPhilosophers = new HashSet<DefaultPhilosopher>();
	List<Thread> workingThreads =  new ArrayList<Thread>();
	public static void main(String[] args) {
		DefaultMain dm =  new DefaultMain();
		dm.eatingThinking(howMany, numberOfPhilosophers, maxTimeForEating, maxTimeForThinking);
		System.out.println(dm.philosophersList.size());
		System.out.println(dm.forksList.size());
	}
	@Override
	public void eatingThinking(int howMany, int numberOfPhilosophers, int maxTimeForEating, int maxTimeForThinking) {
		for(int i = 0; i < numberOfPhilosophers; i++) {
			DefaultFork df = new DefaultFork(i);
			forksList.add(df);
		}
		DefaultPhilosopher[] philosophers = new DefaultPhilosopher[numberOfPhilosophers]; 
		for(int j = 0; j < philosophers.length; j++) {
				DefaultFork leftFork = forksList.get(j);
				DefaultFork rightFork = forksList.get((j+1)%numberOfPhilosophers);
				if (j == philosophers.length -1) {
					philosophers[j] = new DefaultPhilosopher(rightFork, leftFork);
					philosophersList.add(philosophers[j]);
				} else {
					philosophers[j] = new DefaultPhilosopher(leftFork, rightFork);
					philosophersList.add(philosophers[j]);
				}
				philosophersList.add(philosophers[j]);
				Thread thread = new Thread(philosophers[j], "Philosopher " + (j+1));
				thread.start();
				workingThreads.add(thread);
				
					}
			
		
		for(DefaultPhilosopher p : philosophersList) {
			waitingPhilosophers.add(p);
		} 
		for(DefaultFork fork : forksList) {
			usedForks.add(fork);
		}
		try {
		for(Thread t : workingThreads) {
			t.join();
			
		}
		for(int i = 0; i < philosophersList.size(); i++) {
			philosophersList.remove(i);
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
