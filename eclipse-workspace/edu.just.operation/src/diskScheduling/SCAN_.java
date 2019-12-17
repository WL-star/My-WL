package diskScheduling;

public class SCAN_ {
	public int m_ = 0; // 用来存放磁头的初始位置
	public boolean Run_ = true;
	public int sum_ = 0;

	public void Check(int p[], int n, int position) {
		int temp;
		for (int i = n; i > 0; i--)// 冒泡排序
		{
			for (int j = 0; j < i; j++) {
				if (p[j] > p[j + 1]) {// 按顺序依次比较大小

					temp = p[j]; // 把大的数字往前面放
					p[j] = p[j + 1];
					p[j + 1] = temp;
				}
			}
		}
		while (Run_) {// 此循环用 来寻找磁头的初始位置被排到了什么位置

			for (int i = 0; i <= n; i++) {
				if (p[i] == position) {
					m_ = i;
					Run_ = false;
				}
			}
		}
		System.out.println(" SCAN算法序列: ");
		for (int i = m_ + 1; i <= n; i++) {// 磁头向大号移动
			sum_ = sum_ + p[i] - p[i - 1];
			System.out.print(p[i] + " ");
		}
		sum_ = sum_ + 200 - p[n];
		sum_ = sum_ + 200 - p[m_ - 1];

		for (int i = m_ - 1; i >= 0; i--) {

			if (i != 0) {

				sum_ = sum_ + p[i] - p[i - 1];

			}

			System.out.print(p[i] + " ");
		}

		System.out.println();

		System.out.println("寻到长度为" + sum_);

		System.out.println("平均寻到长度为" + sum_ / n);
	}

}
