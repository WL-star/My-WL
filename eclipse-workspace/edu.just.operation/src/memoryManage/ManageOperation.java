package memoryManage;

import java.util.Random;

public class ManageOperation {
	private String[][] dataStrings = new String [33][4];//���ݴ�������

    private int[] Addstream = new int[320] ;//��ַ��
    private int[] Addspage = new int[320];//ҳ ����
    private int[] phyBlock = new int[32];//�������
    private Random random = new Random();//�����
    private int blockNum;//�ڴ����

    private int npageNum;//ȱҳ����ʱ����private float rate;//ȱҳ��

    private int tempK, tempG, tempF;//��ʱ����//���������ַ����ҳ����

    public void setProduceAddstream() {

    int temp;

    for(int i=0;i<320;i+=3){

    temp=random. nextInt(320) % 320 + 0;Addstream[i] = temp + 1;

    temp = random. nextInt (320) % (Addstream[i] + 1);
    Addstream[i+1] = temp + 1;

    temp = random. nextInt (320)%(319 - Addstream[i+1]) +(Addstream[i+1] + 1);

    if (i+2 >= 320) {

    break ;
    }
    Addstream[i+2] = temp;
    }
    for(int i=0;i<320;i++) {

    Addspage[i] = Addstream[i] / 10;
    }
    }
  
    private void initialization() {  //�û��ڴ漰������ݳ�ʼ��
    for(int i=0;i<32;i++){
    phyBlock[i] = -1;

    }
    this. npageNum = 0;
    this. rate = 0;
    this. tempK = 0;
    this. tempG = -1;
    this. tempF = -1;
    }
    public void FIFO() {
    	int[]time=new int[32];  //��������ڴ�ʱ�䳤������
    }
    int max; //max��ʾ�����ڴ�ʱ����õģ������Ƚ�ȥ��

    initialization() ;

    for(int i = 0; i < blockNum ; i++)

          time[i]=i+1;

    for (int i = 0;i < 320; i++){

          this. tempK = 0;

          for (int j = 0; j < blockNum; j++)

          if (phyBlock[j] == Addspage[i])

          { //��ʾ�ڴ������е�ǰҪ�����ҳ��

          this. tempG = j;

          break;



}
