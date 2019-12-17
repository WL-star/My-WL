package diskScheduling;

public class SSTF_ {
	public int initial; // �����ж�������ͷ���ڵĳ�ʼλ�õ��±�
	public int s[];
	public int r_flag = 0, l_flag = 0;
	public double sum_ = 0;
	public int m_left, m_right;

	public SSTF_() {

		s = new int[20];
	}

	public void Calculate(int p[], int n, int position) {
		int temp;
		for (int i = n; i > 0; i--)// ð������
		{
			for (int j = 0; j < i; j++) {
				if (p[j] > p[j + 1]) // ��˳�����αȽϴ�С
				{

					temp = p[j]; // �Ѵ��������ǰ���
					p[j] = p[j + 1];
					p[j + 1] = temp;

				}
			}
		}
		if (p[n] == position) { // ��� ��ͷ�ĳ�ʼλ��������

			System.out.println(" SSTF����Ϊ: ");

			for (int i = 0; i <= n; i++) {

				System.out.print(p[i] + "  ");
			}

		} else if (p[0] == position) {

			System.out.println("SSTF����Ϊ: ");

			for (int i = n; i >= 0; i--) {

				System.out.println(p[i] + "  ");
			}
		} else {
			System.out.println("SSTF����Ϊ��");
			Check(p, n, position);
		}

	}

	public void Check(int a[], int n, int position) {
		boolean Run = true, Running = true;
		while (Run) {// ��ѭ���� ��Ѱ�Ҵ�ͷ�ĳ�ʼλ�ñ��ŵ���ʲôλ��
			for (int i = 0; i <= n; i++) {
				if (a[i] == position) {
					initial = i;
					System.out.println(" m��ֵΪ" + initial);
					m_left = initial - 1;
					m_right = initial + 1;
					Run = false;
				}
			}
		}
		while (Running) {

			if (a[initial] - a[m_left] >= a[m_right] - a[initial] && r_flag != 1) {

				sum_ = sum_ + (a[m_right] - a[initial]); // ����ͳ��Ѱ������

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
		System.out.println("sum��ֵΪ" + sum_);
		System.out.println("ƽ��Ѱ������" + sum_ / n);
	}
}
