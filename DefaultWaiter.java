package pl.edu.agh.automatedgrader.jtp2.lab3.interfaces;

import java.util.HashSet;
import java.util.Set;

public class DefaultWaiter implements Waiter{
	static Set<Fork> usedForks = new HashSet<Fork>();
	static Set<DefaultPhilosopher> waitingPhilosophers = new HashSet<DefaultPhilosopher>();
	public synchronized void take(DefaultPhilosopher p) {

		if(usedForks.contains(p.leftFork) || usedForks.contains(p.rightFork)) {
			waitingPhilosophers.add(p);
		} else {
			waitingPhilosophers.remove(p);
			usedForks.add(p.leftFork);
			usedForks.add(p.rightFork);
		}
	}
	public synchronized void put(DefaultPhilosopher p) {
		usedForks.remove(p.leftFork);
		usedForks.remove(p.rightFork);
	}
	@Override
	public Set<Fork> getUsedForks() {
	return usedForks;
	}

	@Override
	public Set<DefaultPhilosopher> getWaitingPhilosophers() {
		return waitingPhilosophers;
	}

}
