
public class CubbyHole {
	private int content  = -1;
	
	public void get(int consumer) {
		try {
			Lock.semCon.acquire();
			System.err.printf("Cosumidor %d consumiu %d \n", consumer, content);
			Lock.semProd.release();
		} catch (InterruptedException e) {}
	}
	
	public void set(int producer, int value) {
		try {
			Lock.semCon.acquire();
			content = value;
			System.out.printf("Pordutor %d produziu %d \n", producer, content);
			Lock.semProd.release();
		} catch (InterruptedException e) {}
	}
}