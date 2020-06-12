package pl.edu.agh.automatedgrader.jtp2.lab3.interfaces;

import java.util.List;

public interface Main
{
	//times are integer in milliseconds
	void eatingThinking(int howMany, int numberOfPhilosophers, int maxTimeForEating, int maxTimeForThinking);

	List<DefaultFork> getForks();

	List<DefaultPhilosopher> getPhilosophers();

	DefaultWaiter getDefaultWaiter();
}
