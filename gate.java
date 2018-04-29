import java.io.*;

public class gate {
	RandomAccessFile admin;
  
 public void counter(){
	 int j =0;
	 int i=0;

	 try{
			admin = new RandomAccessFile("admin.txt", "rw");
         
			for (i = 0; i < 50; i++) {

				admin.seek(0);
				j = admin.read();

				j = j + 1;
			
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				admin.seek(0);
				admin.write((byte) j);

				System.out.println("Local count: " + i + " Shared Counter:" + j);
			}
			admin.close();
        }
        catch (IOException e){
           System.out.println("something wrong with file access" + e);
        }
	 }
}