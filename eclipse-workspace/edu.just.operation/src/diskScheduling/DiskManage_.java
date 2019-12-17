package diskScheduling;
import java.util.Scanner;
public class DiskManage_ {
	public static void main (String []args) {
	int r[]=new int [20];
	int n_=0;
	int m_=0;
	double sum_=0;
	double temp_=0;
	int position_=0;
	SSTF_ sstf=new SSTF_() ;
	SCAN_ scan = new SCAN_() ;

	CSCAN_ cscan = new CSCAN_() ;

	System. out. println("请输入磁盘请求的个数: ");

	try{

	      Scanner reader=new Scanner (System. in) ;

	      n_=reader. nextInt() ;}

	catch(Exception e) {

	}

	System. out. println("请输入磁盘请求序列: ");

	Scanner reader = new Scanner (System. in) ;
	for(int i=1;i<=n_;i++){

	      try{

	      r[i]=reader. nextInt();
	      }catch(Exception e) {
	    	  
	      }
	}
	System.out.println("请输入磁头的初始位置：");
	try {
		
	    Scanner re = new Scanner (System. in) ;
	    r[0]=re. nextInt();
	    position_=r[0];

	}catch(Exception e) {
	
	
	for (int i = 1; i <= n_; i++) {
	 System.out.println("磁头的初始位置:"  + r[0]);
	      System. out. print(r[i]  + "   ");

	      }
	}

	      System. out. println(" *********************************"+

	"****************************");
	      System. out. println("提示:磁头的序列范围1 ~200!磁头从小号到大号寻道! ");
	      System. out. println("请输入相应的选择操作: : ");
	      System. out. println("1、先来先服务算法(FCFS) ");
	      System. out. println("2、最短寻道时间优先算法(SSTF) ");
	      System. out. println("3、扫描算法(SCAN) ") ;
	      System. out. println("4、循环扫描算法(CSCAN) ");
	      Scanner read = new Scanner (System. in) ;
	      try {
	    	  m_=read.nextInt();
	      }
	    	  catch(Exception e) {
	    		  
	    	  }
	      System.out.println("m的值为"+m_);
	      read.close();
	      switch (m_) {
	      case  1:
	      sum_=0;
	      System. out. println("FCFS算法序列: ");
	      for(int i=1;i<=n_;i++) {
	      System. out. print(r[i] + "   ");
	      temp_=r[i]-r[i-1];
	      if (temp_ >= 0);
	      else if (temp_ < 0) {
	      temp_=- temp_;
	      }
	      sum_=sum_+temp_ ;

	      }

	      System. out. println();

	      System. out. println(" sum的值为" + sum_) ;

	      System. out. println("平均寻道长度" + sum_ / n_);

	      break;

	      case 2:

	      sstf. Calculate(r, n_, position_) ;

	      break;
	      case 3:

	      scan. Check(r, n_, position_) ;

	      break ;

	      case 4:

	      cscan. Check(r, n_, position_) ;

	      break;

	      }
	}
}

