package pl.edu.agh.automatedgrader.jtp2.lab3.interfaces;

public class DefaultFork implements Fork {
	int id;

	


	public DefaultFork(int id) {
		super();
		this.id = id;
	}




	@Override
	public int getId() {
		return id;
	}
	
}
