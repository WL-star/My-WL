package diskScheduling;

public class CSCAN_ {
	public int initial = 0; // ������Ŵ�ͷ�ĳ�ʼλ��
	public boolean Run_ = true;  //�����ж��Ƿ���������
	public int sum_ = 0;  

	public void Check(int p[], int n, int position) {
		int temp_;
		for (int i = n; i > 0; i--) { // ð������
			for (int j = 0; j < i; j++) {
				if (p[j] > p[j + 1]) { // ��˳�����αȽϴ�С
					temp_ = p[j]; // �Ѵ��������ǰ���
					p[j] = p[j + 1];
					p[j + 1] = temp_;

				}
			}
		}
		while (Run_) {   //��ѭ������Ѱ�Ҵ�ͷ�ĳ�ʼλ�ñ���������ʲôλ��
			for (int i = 0; i < n; i++) {
				if (p[i] == position) {
					initial = i;
					Run_ = false;
				}
			}
		}
		System.out.println("CSCAN_�㷨����:");

		for (int i = initial + 1; i <= n; i++) {   // ��ͷ�����ƶ�

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
			System.out.println("Ѱ������Ϊ" + sum_);
			System.out.println("ƽ��Ѱ������Ϊ" + sum_ / n);
		}
	}

}