package diskScheduling;

public class SCAN_ {
	public int m_ = 0; // ������Ŵ�ͷ�ĳ�ʼλ��
	public boolean Run_ = true;
	public int sum_ = 0;

	public void Check(int p[], int n, int position) {
		int temp;
		for (int i = n; i > 0; i--)// ð������
		{
			for (int j = 0; j < i; j++) {
				if (p[j] > p[j + 1]) {// ��˳�����αȽϴ�С

					temp = p[j]; // �Ѵ��������ǰ���
					p[j] = p[j + 1];
					p[j + 1] = temp;
				}
			}
		}
		while (Run_) {// ��ѭ���� ��Ѱ�Ҵ�ͷ�ĳ�ʼλ�ñ��ŵ���ʲôλ��

			for (int i = 0; i <= n; i++) {
				if (p[i] == position) {
					m_ = i;
					Run_ = false;
				}
			}
		}
		System.out.println(" SCAN�㷨����: ");
		for (int i = m_ + 1; i <= n; i++) {// ��ͷ�����ƶ�
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

		System.out.println("Ѱ������Ϊ" + sum_);

		System.out.println("ƽ��Ѱ������Ϊ" + sum_ / n);
	}

}
