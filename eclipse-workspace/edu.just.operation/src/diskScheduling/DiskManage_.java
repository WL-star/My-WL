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

	System. out. println("�������������ĸ���: ");

	try{

	      Scanner reader=new Scanner (System. in) ;

	      n_=reader. nextInt() ;}

	catch(Exception e) {

	}

	System. out. println("�����������������: ");

	Scanner reader = new Scanner (System. in) ;
	for(int i=1;i<=n_;i++){

	      try{

	      r[i]=reader. nextInt();
	      }catch(Exception e) {
	    	  
	      }
	}
	System.out.println("�������ͷ�ĳ�ʼλ�ã�");
	try {
		
	    Scanner re = new Scanner (System. in) ;
	    r[0]=re. nextInt();
	    position_=r[0];

	}catch(Exception e) {
	
	
	for (int i = 1; i <= n_; i++) {
	 System.out.println("��ͷ�ĳ�ʼλ��:"  + r[0]);
	      System. out. print(r[i]  + "   ");

	      }
	}

	      System. out. println(" *********************************"+

	"****************************");
	      System. out. println("��ʾ:��ͷ�����з�Χ1 ~200!��ͷ��С�ŵ����Ѱ��! ");
	      System. out. println("��������Ӧ��ѡ�����: : ");
	      System. out. println("1�������ȷ����㷨(FCFS) ");
	      System. out. println("2�����Ѱ��ʱ�������㷨(SSTF) ");
	      System. out. println("3��ɨ���㷨(SCAN) ") ;
	      System. out. println("4��ѭ��ɨ���㷨(CSCAN) ");
	      Scanner read = new Scanner (System. in) ;
	      try {
	    	  m_=read.nextInt();
	      }
	    	  catch(Exception e) {
	    		  
	    	  }
	      System.out.println("m��ֵΪ"+m_);
	      read.close();
	      switch (m_) {
	      case  1:
	      sum_=0;
	      System. out. println("FCFS�㷨����: ");
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

	      System. out. println(" sum��ֵΪ" + sum_) ;

	      System. out. println("ƽ��Ѱ������" + sum_ / n_);

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

