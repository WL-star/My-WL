package bankerAlgorithm;
import java.util.Scanner;
public class Banker_ {
	private int Process_ = 0;     
	int maxResource = 0;     
	// 定义最大资源类数
	private int workResorce[]; 
	// 定义系统可提供给进程继续运行所需的各类资源数目
	private int max[][];           // 定义进程  最大资源需求	
	private int allocation[][]; // 定义进程当前已用资源数目	
	private int need_[][]; 	
	private int request[][]; // 定义进程请求资源向量	
	private boolean FINISH[];// 定义进程完成标志
	private int available[];	
	private int p[];	
	private Scanner in = new Scanner(System.in); //    输入流
	public void close_() {
		in.close();
	}           

	public Banker_() throws Exception {  // 构造函数，初始化各向量

		int a, b;
		System.out.print("输入当前进程的个数:");
		Process_ = in.nextInt();
		System.out.print("输入系统资源种类的类数:");
		maxResource = in.nextInt();
		available = new int[maxResource];    // 初始化各个数组
		workResorce = new int[maxResource];
		max = new int[Process_][maxResource];
		allocation = new int[Process_][maxResource];
		need_ = new int[Process_][maxResource];
		request = new int[Process_][maxResource];
		FINISH = new boolean[Process_];
		p = new int[Process_];
		System.out.println("输入每个进程最大资源需求,按" + Process_ + "*" + maxResource + "矩阵输入: ");
		for (a = 0; a < Process_; a++) {
			System.out.print("输入P" + (a + 1) + "进程各类资源最大需求:");
			for (b = 0; b < maxResource; b++)
				max[a][b] = in.nextInt();

		}
		System.out.println("输入每个进程已分配的各资源数,按照" + Process_ + "*" + maxResource + "矩阵输入: ");
		for (a = 0; a < Process_; a++) {
			System.out.print("请输入P" + (a + 1) + "进程各类资源已分配的资源数:");
			for (b = 0; b < maxResource; b++) {
				allocation[a][b] = in.nextInt();
				need_[a][b] = max[a][b] - allocation[a][b];
				if (need_[a][b] < 0) {
					System.out.println("输入的第" + (a + 1) + "个进程所拥有的第" + (b + 1) + "个资源数错误，请重新输入：");
					b--;
					continue;
				}
			}
		}
		System.out.print("输入系统各类资源可用的数目：");
		for (a = 0; a < maxResource; a++) {

			available[a] = in.nextInt();

		}
	}

	public void Bank1() throws Exception {
	int a, b;
		int tempAvailable[] = new int[maxResource];
		int tempAllocation[] = new int[maxResource];
		int tempNeed[] = new int[maxResource];
		System.out.println("------------------------------" + "--------------------");
		System.out.print("输入要申请资源的进程号(当前共有" + Process_ + "个进程,为" + "进程P1申请，请输入1，以此类推) ");
		b = in.nextInt() - 1;
		System.out.print("输入P”+ (i + 1) +”进程申请的各资源的数量");
		for (a = 0; a < maxResource; a++) {

			request[b][a] = in.nextInt();
		}
		for (a = 0; a < maxResource; a++) {
			if (request[b][a] > need_[b][a]) {
				System.out.println("输入的申请的资源数超过进程的需求量!请重新输入!");
				continue;
			}
			for (a = 0; a < maxResource; a++) {
				tempAvailable[a] = available[a];
				tempAllocation[a] = allocation[b][a];
				tempNeed[a] = need_[b][a];
				available[a] = available[a] - request[b][a];
				allocation[b][a] = allocation[b][a] + request[b][a];
				allocation[b][a] = allocation[b][a] + request[b][a];
				need_[b][a] = need_[b][a] - request[b][a];
				if (Safe()) {
					System.out.println("分配给P"+ a +"进程成功!");
					System.out.print("分配前系统可用资源: ");
					for (int m = 0; m < maxResource; m++)		
						System.out.print(tempAvailable[m] + "");
					System.out.print(" \n分配前进程P"+ b +"各类资源已分配数量:");
					for (int m = 0; m < maxResource; m++)		
						System.out.print(tempAllocation[m] + " ");
					System.out.print("\n分配前进程P”+ i +”各类资源需求数量:");
					for (int m = 0; m < maxResource; m++)						
						System.out.print(tempNeed[m] + " ");
					System.out.print("\n分配后系统可用资源: ");
					for (int m = 0; m < maxResource; m++)
						System.out.print(available[m] + " ");		
					System.out.print("\n分配后进程P”+ i +”各类资源已分配数量:");
					for (int m = 0; m < maxResource; m++)						
						System.out.print(allocation[b][m] + " ");
					System.out.print("\n分配后进程P" + b + "各类资源需求数量:");
					for (int m = 0; m < maxResource; m++)						
						System.out.print(need_[b][m] + " ");
					System.out.println();
				} else {
					System.out.println("申请资源失败!");
					for (a = 0; a < maxResource; a++) {
						available[a] = available[a] + request[b][a];
						allocation[b][a] = allocation[b][a] + request[b][a];
						need_[b][a] = need_[b][a] + request[b][a];
					}
				}
				for (b = 0; b < Process_; b++) {
					FINISH[b] = false;
				} // 安全性算法
			}
		}
	}

	public boolean Safe() {     //检查是否安全
	int a, b, r, c = 0;	
		workResorce = new int[maxResource];		
		for (a = 0; a < maxResource; a++)
		workResorce[a] = available[a];		
		for (a = 0; a < Process_; a++) {
			FINISH[a] = false;			
			for (a = 0; a < Process_; a++) {
				if (FINISH[a] == true) {					
					continue;
				} else {
					for (b = 0; b < maxResource; b++) {
						if (need_[a][b] > workResorce[b]) {
							break;
						}
					}
					if (b == maxResource) {
						FINISH[a] = true;
						
						for (r = 0; r < maxResource; r++) {
							
							workResorce[r] += allocation[a][r];
						}
						p[c++] = a;
						a = -1;
					} else {
						continue;
					}
					if (c == Process_) {
						System.out.print("系统是安全的，存在安全序列:");
						for (a = 0; a < c; a++) {
							System.out.print("P" + p[a]);
							if (a != c - 1) {
								System.out.print("--- ");
							}
						}
						System.out.println();
						return true;
					}
				}
				System.out.println("系统是不安全的，不存在安全序列");
				return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		try {
			Banker_ b = new Banker_();
			b.Safe();
			for (int i = 0; i < 200; i++)
				b.Bank1();
			b.close_();

		} catch (Exception e) {
		}
	}
}
