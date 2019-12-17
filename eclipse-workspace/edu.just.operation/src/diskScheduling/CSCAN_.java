package diskScheduling;

public class CSCAN_ {
	public int initial = 0; // 用来存放磁头的初始位置
	public boolean Run_ = true;  //用来判断是否正在运行
	public int sum_ = 0;  

	public void Check(int p[], int n, int position) {
		int temp_;
		for (int i = n; i > 0; i--) { // 冒泡排序
			for (int j = 0; j < i; j++) {
				if (p[j] > p[j + 1]) { // 按顺序依次比较大小
					temp_ = p[j]; // 把大的数字往前面放
					p[j] = p[j + 1];
					p[j + 1] = temp_;

				}
			}
		}
		while (Run_) {   //此循环用来寻找磁头的初始位置被安排在了什么位置
			for (int i = 0; i < n; i++) {
				if (p[i] == position) {
					initial = i;
					Run_ = false;
				}
			}
		}
		System.out.println("CSCAN_算法序列:");

		for (int i = initial + 1; i <= n; i++) {   // 磁头向大号移动

			sum_ = sum_ + p[i] - p[i - 1];

			System.out.print(p[i] + " ");

			sum_ = sum_ + 200 - p[n];

			sum_ = sum_ + 199;

			sum_ = sum_ + p[0] - 1;

			for (int i1 = 0; i1 <= initial - 1; i1++) {

				if (i1 != initial - 1) {

					sum_ = sum_ + p[i1 + 1] - p[i1];

				}

				System.out.print(p[i1] + " ");
			}
			System.out.println();
			System.out.println("寻道长度为" + sum_);
			System.out.println("平均寻道长度为" + sum_ / n);
		}
	}

}