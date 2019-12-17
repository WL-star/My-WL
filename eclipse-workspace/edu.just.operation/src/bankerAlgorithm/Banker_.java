package bankerAlgorithm;
import java.util.Scanner;
public class Banker_ {
	private int Process_ = 0;     
	int maxResource = 0;     
	// ���������Դ����
	private int workResorce[]; 
	// ����ϵͳ���ṩ�����̼�����������ĸ�����Դ��Ŀ
	private int max[][];           // �������  �����Դ����	
	private int allocation[][]; // ������̵�ǰ������Դ��Ŀ	
	private int need_[][]; 	
	private int request[][]; // �������������Դ����	
	private boolean FINISH[];// ���������ɱ�־
	private int available[];	
	private int p[];	
	private Scanner in = new Scanner(System.in); //    ������
	public void close_() {
		in.close();
	}           

	public Banker_() throws Exception {  // ���캯������ʼ��������

		int a, b;
		System.out.print("���뵱ǰ���̵ĸ���:");
		Process_ = in.nextInt();
		System.out.print("����ϵͳ��Դ���������:");
		maxResource = in.nextInt();
		available = new int[maxResource];    // ��ʼ����������
		workResorce = new int[maxResource];
		max = new int[Process_][maxResource];
		allocation = new int[Process_][maxResource];
		need_ = new int[Process_][maxResource];
		request = new int[Process_][maxResource];
		FINISH = new boolean[Process_];
		p = new int[Process_];
		System.out.println("����ÿ�����������Դ����,��" + Process_ + "*" + maxResource + "��������: ");
		for (a = 0; a < Process_; a++) {
			System.out.print("����P" + (a + 1) + "���̸�����Դ�������:");
			for (b = 0; b < maxResource; b++)
				max[a][b] = in.nextInt();

		}
		System.out.println("����ÿ�������ѷ���ĸ���Դ��,����" + Process_ + "*" + maxResource + "��������: ");
		for (a = 0; a < Process_; a++) {
			System.out.print("������P" + (a + 1) + "���̸�����Դ�ѷ������Դ��:");
			for (b = 0; b < maxResource; b++) {
				allocation[a][b] = in.nextInt();
				need_[a][b] = max[a][b] - allocation[a][b];
				if (need_[a][b] < 0) {
					System.out.println("����ĵ�" + (a + 1) + "��������ӵ�еĵ�" + (b + 1) + "����Դ���������������룺");
					b--;
					continue;
				}
			}
		}
		System.out.print("����ϵͳ������Դ���õ���Ŀ��");
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
		System.out.print("����Ҫ������Դ�Ľ��̺�(��ǰ����" + Process_ + "������,Ϊ" + "����P1���룬������1���Դ�����) ");
		b = in.nextInt() - 1;
		System.out.print("����P��+ (i + 1) +����������ĸ���Դ������");
		for (a = 0; a < maxResource; a++) {

			request[b][a] = in.nextInt();
		}
		for (a = 0; a < maxResource; a++) {
			if (request[b][a] > need_[b][a]) {
				System.out.println("������������Դ���������̵�������!����������!");
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
					System.out.println("�����P"+ a +"���̳ɹ�!");
					System.out.print("����ǰϵͳ������Դ: ");
					for (int m = 0; m < maxResource; m++)		
						System.out.print(tempAvailable[m] + "");
					System.out.print(" \n����ǰ����P"+ b +"������Դ�ѷ�������:");
					for (int m = 0; m < maxResource; m++)		
						System.out.print(tempAllocation[m] + " ");
					System.out.print("\n����ǰ����P��+ i +��������Դ��������:");
					for (int m = 0; m < maxResource; m++)						
						System.out.print(tempNeed[m] + " ");
					System.out.print("\n�����ϵͳ������Դ: ");
					for (int m = 0; m < maxResource; m++)
						System.out.print(available[m] + " ");		
					System.out.print("\n��������P��+ i +��������Դ�ѷ�������:");
					for (int m = 0; m < maxResource; m++)						
						System.out.print(allocation[b][m] + " ");
					System.out.print("\n��������P" + b + "������Դ��������:");
					for (int m = 0; m < maxResource; m++)						
						System.out.print(need_[b][m] + " ");
					System.out.println();
				} else {
					System.out.println("������Դʧ��!");
					for (a = 0; a < maxResource; a++) {
						available[a] = available[a] + request[b][a];
						allocation[b][a] = allocation[b][a] + request[b][a];
						need_[b][a] = need_[b][a] + request[b][a];
					}
				}
				for (b = 0; b < Process_; b++) {
					FINISH[b] = false;
				} // ��ȫ���㷨
			}
		}
	}

	public boolean Safe() {     //����Ƿ�ȫ
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
						System.out.print("ϵͳ�ǰ�ȫ�ģ����ڰ�ȫ����:");
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
				System.out.println("ϵͳ�ǲ���ȫ�ģ������ڰ�ȫ����");
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
