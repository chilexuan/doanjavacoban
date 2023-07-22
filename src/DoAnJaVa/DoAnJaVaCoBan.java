package DoAnJaVa;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DoAnJaVaCoBan {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
		inMenu();
		int n = nhapSoLuongSinhVien();
		String[] hoten = new String[n];
		double[] dToan = new double[n];
		double[] dVan = new double[n];
		double[] dAnh = new double[n];
		double[] dTB = new double[n];

		char key;
		do {

			Scanner sc = new Scanner(System.in);
			System.out.print("BẠN CHỌN CHỨC NĂNG NÀO: ");
			key = sc.next().charAt(0);

			switch (key) {
			case '1':
				nhapHoTenVaDiem(hoten, dToan, dVan, dAnh);
				break;
			case '2':

				dTB = tinhDTB(dToan, dVan, dAnh);
				inDSSV(hoten, dToan, dVan, dAnh, dTB);
				break;
			case '3':
				inDSSV(hoten, dToan, dVan, dAnh, dTB);
				break;
			case '4':
				sapxepDSSV(hoten, dToan, dVan, dAnh, dTB);
				inDSSV(hoten, dToan, dVan, dAnh, dTB);
				break;
			case '5':
				timkiemDiem(hoten, dToan, dVan, dAnh, dTB);
				break;
			case '6':
				timHoTen(hoten, dToan, dVan, dAnh, dTB);
				break;
			case '7':
				nhapFile(hoten, dToan, dVan, dAnh, dTB);
				break;
			case '8':
				xuatFile(hoten, dToan, dVan, dAnh, dTB);
				break;
			case '9':
				timSVCoDTBCaoNhat(hoten, dToan, dVan, dAnh, dTB);
				break;
			case 'A':
				suaDuLieuSinhVien(hoten, dToan, dVan, dAnh, dTB);
				break;
			case 'Q':
				System.out.println("Đã thoát chương trình");
				System.exit(0);

				break;
			case 'q':
				System.out.println("Đã thoát chương trình");
				System.exit(0);
				break;
			}
		} while (key != 'Q' || key != 'q');
	}

//Ham tao menu
	public static void inMenu() {
		System.out.println("*****************************************************");
		System.out.println("(1): NHẬP DỮ LIỆU SINH VIÊN");
		System.out.println("(2): TÍNH ĐIỂM TRUNG BÌNH");
		System.out.println("(3): IN DANH SÁCH SINH VIÊN");
		System.out.println("(4): SẮP XẾP SINH VIÊN THEO ĐIỂM TRUNG BÌNH");
		System.out.println("(5): TÌM KIẾM THEO ĐIỂM TOÁN");
		System.out.println("(6): TÌM SINH VIÊN THEO HỌ VÀ TÊN");
		System.out.println("(7): GHI FILE VĂN BẢN");
		System.out.println("(8): ĐỌC FILE VĂN BẢN");
		System.out.println("(9): TÌM SINH VIÊN CÓ ĐIỂM TRUNG BÌNH CAO NHẤT");
		System.out.println("(A): SỬA DỮ LIỆU SINH VIÊN");
		System.out.println("(Q/q): THOÁT KHỎI CHƯƠNG TRÌNH");
		System.out.println("*******************************************************");
	}

// Ham nhap so luong sinh vien N nguyen duong
	public static int nhapSoLuongSinhVien() {

		try {
			int n;

			Scanner sc = new Scanner(System.in);
			do {
				System.out.print("Nhập Số lượng sinh viên: ");
				n = sc.nextInt();
				if (n <= 0) {
					System.out.println("Mời bạn nhập lại");
				}
			} while (n <= 0);

			return n;
		} catch (Exception e) {
			System.out.println("Đã sảy ra lỗi trong quá trình nhập dữ liệu");
			return -1;
		}
	}

// Ham nhap ho ten, diem Toan, Van Anh
	public static void nhapHoTenVaDiem(String[] hoten, double[] dToan, double[] dVan, double[] dAnh) {
		System.out.println("*************************************************************");

		try {

			for (int i = 0; i < hoten.length; i++) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Nhập dữ liệu cho sinh viên thứ " + (i + 1));
				System.out.print("Họ và tên sinh viên: ");
				hoten[i] = sc.nextLine();
				do {
					System.out.print("Điểm môn Toán : ");
					dToan[i] = sc.nextDouble();
					if (dToan[i] < 0.0 || dToan[i] > 10.0) {
						System.out.println("Mời bạn nhập lại");
					}
				} while (dToan[i] < 0.0 || dToan[i] > 10.0);

				do {
					System.out.print("Điểm môn Văn : ");
					dVan[i] = sc.nextDouble();
					if (dVan[i] < 0.0 || dVan[i] > 10.0) {
						System.out.println("Mời bạn nhập lại");
					}
				} while (dVan[i] < 0.0 || dVan[i] > 10.0);
				do {
					System.out.print("Điểm môn Anh : ");
					dAnh[i] = sc.nextDouble();
					if (dAnh[i] < 0.0 || dAnh[i] > 10.0) {
						System.out.println("Mời bạn nhập lại");
					}
				} while (dAnh[i] < 0.0 || dAnh[i] > 10.0);

			}

		} catch (Exception e) {
			System.out.println("Đã sảy ra lỗi trong quá trình nhập dữ liệu");
		}
		System.out.println("*************************************************************");
	}

// hàm sửa thông tin
	public static void suaDuLieuSinhVien(String[] hoten, double[] dToan, double[] dVan, double[] dAnh, double[] dTB) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên sinh viên cần sửa: ");
		String ten = sc.nextLine();
		int index = -1;
		for (int i = 0; i < hoten.length; i++) {
			if (hoten[i].equals(ten)) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			System.out.println("Không tìm thấy sinh viên có tên " + ten);
		} else {
			System.out.println("Nhập dữ liệu mới cho sinh viên " + ten);
			System.out.print("Họ và tên sinh viên: ");
			hoten[index] = sc.nextLine();
			do {
				System.out.print("Điểm môn Toán : ");
				dToan[index] = sc.nextDouble();
				if (dToan[index] < 0.0 || dToan[index] > 10.0) {
					System.out.println("Mời bạn nhập lại");
				}
			} while (dToan[index] < 0.0 || dToan[index] > 10.0);

			do {
				System.out.print("Điểm môn Văn : ");
				dVan[index] = sc.nextDouble();
				if (dVan[index] < 0.0 || dVan[index] > 10.0) {
					System.out.println("Mời bạn nhập lại");
				}
			} while (dVan[index] < 0.0 || dVan[index] > 10.0);
			do {
				System.out.print("Điểm môn Anh : ");
				dAnh[index] = sc.nextDouble();
				if (dAnh[index] < 0.0 || dAnh[index] > 10.0) {
					System.out.println("Mời bạn nhập lại");
				}
			} while (dAnh[index] < 0.0 || dAnh[index] > 10.0);
			dTB[index] = (dToan[index] + dVan[index] + dAnh[index]) / 3;
		}
	}

// Ham tinh diem trung binh
	public static double[] tinhDTB(double[] dToan, double[] dVan, double[] dAnh) {
		double[] dtb = new double[dToan.length];
		for (int i = 0; i < dtb.length; i++) {
			dtb[i] = Math.round(((dToan[i] + dVan[i] + dAnh[i]) / 3) * 100.0) / 100.0;
		}
		return dtb;
	}

// Ham sap xep sinh vien theo chieu giam dan cua diem trung binh
	public static void sapxepDSSV(String[] hoten, double[] dToan, double[] dVan, double[] dAnh, double[] dTB) {
		for (int i = 0; i < dTB.length - 1; i++) {
			for (int j = i + 1; j < dTB.length; j++) {
				if (dTB[i] < dTB[j]) {
					// hoan vi DTB
					double tam = dTB[i];
					dTB[i] = dTB[j];
					dTB[j] = tam;
					// hoan vi Toan
					tam = dToan[i];
					dToan[i] = dToan[j];
					dToan[j] = tam;
					// hoan vi Van
					tam = dVan[i];
					dVan[i] = dVan[j];
					dVan[j] = tam;
					// hoan vi Anh
					tam = dAnh[i];
					dAnh[i] = dAnh[j];
					dAnh[j] = tam;
					// hoan vi hoten
					String tam2 = hoten[i];
					hoten[i] = hoten[j];
					hoten[j] = tam2;
				}
			}

		}
	}

// Ham in danh sach sinh vien ra man hinh
	public static void inDSSV(String[] hoten, double[] dToan, double[] dVan, double[] dAnh, double[] dTB) {
		System.out.println("*************************************************************");
		System.out.println("\t\t\t DANH SÁCH SINH VIÊN");
		System.out.println("+---------------------+-----------+-----------+-----------+-----------+");
		System.out.printf("| %-20s| %-10s| %-10s| %-10s| %-10s|%n", "Họ và tên", "Toán", "Văn", "Anh", "Điểm TB");
		System.out.println("+---------------------+-----------+-----------+-----------+-----------+");

		for (int i = 0; i < hoten.length; i++) {
			System.out.printf("| %-20s| %-10.2f| %-10.2f| %-10.2f| %-10.2f|%n", hoten[i], dToan[i], dVan[i], dAnh[i],
					dTB[i]);
		}

		System.out.println("*************************************************************");
	}

// Ham tim kiem sinh vien theo diem mon Toan
	public static void timkiemDiem(String[] hoten, double[] dToan, double[] dVan, double[] dAnh, double[] dTB) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		double diemcantim;

		try {
			do {
				System.out.print("Điểm toán cần tìm: ");
				diemcantim = sc.nextDouble();
				for (int i = 0; i < dToan.length; i++) {
					if (dToan[i] == diemcantim) {
						if (count == 0) {
							System.out
									.println("+---------------------+-----------+-----------+-----------+-----------+");
							System.out.printf("| %-20s| %-10s| %-10s| %-10s| %-10s|%n", "Họ và tên", "Toán", "Văn",
									"Anh", "Điểm TB");
							System.out
									.println("+---------------------+-----------+-----------+-----------+-----------+");
						}
						System.out.printf("| %-20s| %-10.2f| %-10.2f| %-10.2f| %-10.2f|%n", hoten[i], dToan[i], dVan[i],
								dAnh[i], dTB[i]);
						count = count + 1;
					}
				}
				if (count == 0) {
					System.out.println("Không tìm thấy. Mời bạn nhập lại.");
				}
			} while (count == 0);
		} catch (Exception e) {
			System.out.println("Đã sảy ra lỗi trong quá trình nhập dữ liệu");
		}
	}

// Ham tim kiem sinh vien theo ho ten
	public static void timHoTen(String[] hoten, double[] dToan, double[] dVan, double[] dAnh, double[] dTB) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		String x;
		try {
			do {
				System.out.print("Họ và tên cần tìm: ");
				x = sc.nextLine();
				for (int i = 0; i < hoten.length; i++) {
					if (hoten[i].equals(x)) {
						if (count == 0) {
							System.out
									.println("+---------------------+-----------+-----------+-----------+-----------+");
							System.out.printf("| %-20s| %-10s| %-10s| %-10s| %-10s|%n", "Họ và tên", "Toán", "Văn",
									"Anh", "Điểm TB");
							System.out
									.println("+---------------------+-----------+-----------+-----------+-----------+");
						}
						System.out.printf("| %-20s| %-10.2f| %-10.2f| %-10.2f| %-10.2f|%n", hoten[i], dToan[i], dVan[i],
								dAnh[i], dTB[i]);
						count = count + 1;
					}
				}
				if (count == 0) {
					System.out.println("Không tìm thấy. Mời bạn nhập lại.");
				}
			} while (count == 0);
		} catch (Exception e) {
			System.out.println("DA XAY RA LOI TRONG QUA TRINH NHAP DU LIEU");
		}

	}

	public static void timSVCoDTBCaoNhat(String[] hoten, double[] dToan, double[] dVan, double[] dAnh, double[] dTB) {
		double max = dTB[0];
		for (int i = 1; i < dTB.length; i++) {
			if (dTB[i] > max) {
				max = dTB[i];
			}
		}
		System.out.println("Sinh viên có điểm trung bình cao nhất: ");
		for (int i = 0; i < dTB.length; i++) {
			if (dTB[i] == max) {
				System.out.println("+---------------------+-----------+-----------+-----------+-----------+");
				System.out.printf("| %-20s| %-10s| %-10s| %-10s| %-10s|%n", "Họ và tên", "Toán", "Văn", "Anh",
						"Điểm TB");
				System.out.println("+---------------------+-----------+-----------+-----------+-----------+");

				System.out.printf("| %-20s| %-10.2f| %-10.2f| %-10.2f| %-10.2f|%n", hoten[i], dToan[i], dVan[i],
						dAnh[i], dTB[i]);
			}
		}
	}

	public static void xuatFile(String[] hoten, double[] dToan, double[] dVan, double[] dAnh, double[] dTB) {
		try {
			FileWriter fw = new FileWriter("danhsachsinhvien.txt");
			for (int i = 0; i < hoten.length; i++) {
				fw.write(hoten[i] + " - Điểm Toán: " + dToan[i] + " - Điểm Văn: " + dVan[i] + " - Điểm Anh: " + dAnh[i]
						+ " - Điểm trung bình: " + dTB[i] + "\n");
			}
			fw.close();
			System.out.println("Đã xuất file thành công!");
		} catch (IOException e) {
			System.out.println("Đã sảy ra lỗi trong quá trình xuất file!");
		}
	}

	public static void nhapFile(String[] hoten, double[] dToan, double[] dVan, double[] dAnh, double[] dTB) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("danhsachsinhvien.txt"));
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(" - ");
				hoten[i] = data[0];
				dToan[i] = Double.parseDouble(data[1].split(": ")[1]);
				dVan[i] = Double.parseDouble(data[2].split(": ")[1]);
				dAnh[i] = Double.parseDouble(data[3].split(": ")[1]);
				dTB[i] = Double.parseDouble(data[4].split(": ")[1]);
				i++;
			}
			br.close();
			System.out.println("Đã nhập file thành công!");
		} catch (IOException e) {
			System.out.println("Đã sảy ra lỗi trong quá trình nhập file!");
		}
	}
}