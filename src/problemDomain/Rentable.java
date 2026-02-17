package problemDomain;

public interface Rentable {
	boolean isAvailable();
	
	void rentOne() throws Exception();
}
