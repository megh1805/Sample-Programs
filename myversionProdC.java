package program_challenge;

import java.util.ArrayList;
import java.util.List;
//producer consumer problem using wait , notify
public class myversionProdC {

	public static void main(String[] args) {
		List<Integer> item= new ArrayList<Integer>();
		int size=4;
		new Thread(new Consume(item),"consumer").start();
		new Thread(new Produce(item,size),"producer").start();

	}
}
	class Produce extends Thread {
		private final int size;
		private final List<Integer> item;
		public Produce(List<Integer> item, int size) {
			this.size=size;
			this.item=item;
		}
		
		public void run() {
			synchronized (item) {
				for(int i=0;i<7;i++) {
					while (item.size()==size) {
						try {
							System.out.println("waiting producer ");
							item.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("adding prodcuer "+i);
					item.add(i);
					item.notifyAll();
				}
			}
		}
	}
	class Consume extends Thread {
		
		private final List<Integer> item;
		public Consume(List<Integer> item) {
			
			this.item=item;
		}

		public void run() {
			synchronized (item) {
				while (true) {
					while (item.isEmpty()) {
						try {
							System.out.println("waiting consumer ");
							item.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("removing consumer ");
					item.remove(0);
					item.notifyAll();
				}
			}
		}
	}


