package pl.edu.agh.automatedgrader.jtp2.lab3.interfaces;



import java.util.Set;



public interface Waiter
{
	Set<Fork> getUsedForks();

	Set<DefaultPhilosopher> getWaitingPhilosophers();
}
