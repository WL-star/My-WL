package diskScheduling;

public class SSTF_ {
	public int initial; // 用来判断排序后磁头所在的初始位置的下标
	public int s[];
	public int r_flag = 0, l_flag = 0;
	public double sum_ = 0;
	public int m_left, m_right;

	public SSTF_() {

		s = new int[20];
	}

	public void Calculate(int p[], int n, int position) {
		int temp;
		for (int i = n; i > 0; i--)// 冒泡排序
		{
			for (int j = 0; j < i; j++) {
				if (p[j] > p[j + 1]) // 按顺序依次比较大小
				{

					temp = p[j]; // 把大的数字往前面放
					p[j] = p[j + 1];
					p[j + 1] = temp;

				}
			}
		}
		if (p[n] == position) { // 如果 磁头的初始位置在最大号

			System.out.println(" SSTF序列为: ");

			for (int i = 0; i <= n; i++) {

				System.out.print(p[i] + "  ");
			}

		} else if (p[0] == position) {

			System.out.println("SSTF序列为: ");

			for (int i = n; i >= 0; i--) {

				System.out.println(p[i] + "  ");
			}
		} else {
			System.out.println("SSTF序列为：");
			Check(p, n, position);
		}

	}

	public void Check(int a[], int n, int position) {
		boolean Run = true, Running = true;
		while (Run) {// 此循环用 来寻找磁头的初始位置被排到了什么位置
			for (int i = 0; i <= n; i++) {
				if (a[i] == position) {
					initial = i;
					System.out.println(" m的值为" + initial);
					m_left = initial - 1;
					m_right = initial + 1;
					Run = false;
				}
			}
		}
		while (Running) {

			if (a[initial] - a[m_left] >= a[m_right] - a[initial] && r_flag != 1) {

				sum_ = sum_ + (a[m_right] - a[initial]); // 用来统计寻到长度

				initial = m_right;

				m_right++;

				if (m_right > n) {

					r_flag = 1;
				}

				System.out.print(a[initial] + "   ");

			} else if (a[initial] - a[m_left] < a[m_right] - a[initial] && l_flag != 1) {

				sum_ = sum_ + (a[initial] - a[m_left]);

				initial = m_left;

				m_left--;
				if (m_left < 0) {
					l_flag = 1;
				}
				System.out.println(a[initial] + "   ");
			}
			if (m_left != 0 && m_right > n) {
				Running = false;
				sum_ = sum_ + a[n] - a[m_left];
				for (int j = m_left; j >= 0; j--) {
					if (j != 0) {
						sum_ = sum_ + a[j] - a[j - 1];
					}
					System.out.println(a[j] + "   ");
				}
			}
			if (m_right != n && m_left < 0) {
				Running = false;
				sum_ = sum_ + a[m_right] - a[0];
				for (int k = m_right; k <= n; k++) {
					if (k != 0) {
						sum_ = sum_ + a[k + 1] - a[k];
					}
					System.out.print(a[k] + "   ");
				}
			}
		}
		System.out.println();
		System.out.println("sum的值为" + sum_);
		System.out.println("平均寻道长度" + sum_ / n);
	}
}
