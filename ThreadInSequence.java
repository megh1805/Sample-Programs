package program_challenge;
//three thread sto print number in sequence .

public class ThreadInSequence {
	private volatile int count=1;
    private volatile int threadIdToRun = 1;
    private Object object = new Object();

	public static void main(String[] args) {
		ThreadInSequence r= new ThreadInSequence();
       Thread one= new Thread(r.new A(1));
       Thread two=new Thread(r.new A(2));
       Thread three= new Thread(r.new A(3));
       one.start();
       two.start();
       three.start();
       
	      

	}
	class A implements Runnable{
		int threadId;
			
		A(int threadId){
			
			this.threadId=threadId;
		}
		
		public void run() {
			while (count<=20){
				synchronized (object) {
					if (threadId!=threadIdToRun)
						try {
							object.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					else {
						System.out.println("Thread id is "+threadId+ "value is "+count);
						count++;
						if (threadId==1)
							threadIdToRun=2;
						else if (threadId==2)
							threadIdToRun=3;
						else if (threadId==3)
							threadIdToRun=1;
						object.notifyAll();
					}
				}
			}
		}
	}
}
