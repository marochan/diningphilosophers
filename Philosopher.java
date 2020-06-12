package pl.edu.agh.automatedgrader.jtp2.lab3.interfaces;



public interface Philosopher extends Runnable
{
	int getHowMany();

	Fork getLeftFork();

	Fork getRightFork();

	DefaultWaiter getDefaultWaiter();
}
