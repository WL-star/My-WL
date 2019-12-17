package memoryManage;

import java.util.Random;

public class ManageOperation {
	private String[][] dataStrings = new String [33][4];//数据传递数组

    private int[] Addstream = new int[320] ;//地址流
    private int[] Addspage = new int[320];//页 面流
    private int[] phyBlock = new int[32];//物理块数
    private Random random = new Random();//随机数
    private int blockNum;//内存块数

    private int npageNum;//缺页数临时变量private float rate;//缺页率

    private int tempK, tempG, tempF;//临时变量//产生随机地址流和页面流

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
  
    private void initialization() {  //用户内存及相关数据初始化
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
    	int[]time=new int[32];  //定义进入内存时间长度数组
    }
    int max; //max表示进入内存时间最久的，即最先进去的

    initialization() ;

    for(int i = 0; i < blockNum ; i++)

          time[i]=i+1;

    for (int i = 0;i < 320; i++){

          this. tempK = 0;

          for (int j = 0; j < blockNum; j++)

          if (phyBlock[j] == Addspage[i])

          { //表示内存中已有当前要调入的页面

          this. tempG = j;

          break;



}
