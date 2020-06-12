package pl.edu.agh.automatedgrader.jtp2.lab3.interfaces;

import java.util.Set;

public class DefaultWaiter implements Waiter{
	
	@Override
	public Set<Fork> getUsedForks() {
	return DefaultMain.usedForks;
	}

	@Override
	public Set<DefaultPhilosopher> getWaitingPhilosophers() {
		return DefaultMain.waitingPhilosophers;
	}

}
