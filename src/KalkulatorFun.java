import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class KalkulatorFun {
	static int angka1 = 0;
	static int angka2 = 0;
	static String operator = "";
	static JLabel label = new JLabel("0", SwingConstants.CENTER);

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		label.setFont(new Font("Arial", Font.BOLD, 30));

		for (int i = 0; i < 10; i++) {
			JButton button = new JButton(String.valueOf(i));
			button.setFont(new Font("Arial", Font.BOLD, 14));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tampilan = label.getText();
					String angkaBaru = ((JButton) e.getSource()).getText();
					if (tampilan.equals("0")) {
						label.setText(angkaBaru);
					} else {
						label.setText(tampilan + angkaBaru);
					}
				}
			});
			panel.add(button);
		}
		JButton btnTambah = new JButton("+");
		btnTambah.setFont(new Font("Arial", Font.BOLD, 14));
		btnTambah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				angka1 = Integer.parseInt(label.getText());
				operator = "+";
				label.setText("0");
			}
		});
		panel.add(btnTambah);

		JButton btnKurang = new JButton("-");
		btnKurang.setFont(new Font("Arial", Font.BOLD, 14));
		btnKurang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				angka1 = Integer.parseInt(label.getText());
				operator = "-";
				label.setText("0");
			}
		});
		panel.add(btnKurang);

		JButton btnKali = new JButton("x");
		btnKali.setFont(new Font("Arial", Font.BOLD, 14));
		btnKali.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				angka1 = Integer.parseInt(label.getText());
				operator = "x";
				label.setText("0");
			}
		});
		panel.add(btnKali);

		JButton btnBagi = new JButton("/");
		btnBagi.setFont(new Font("Arial", Font.BOLD, 14));
		btnBagi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				angka1 = Integer.parseInt(label.getText());
				operator = "/";
				label.setText("0");
			}
		});
		panel.add(btnBagi);

		JButton btnSamaDengan = new JButton("=");
		btnSamaDengan.setFont(new Font("Arial", Font.BOLD, 14));
		btnSamaDengan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				angka2 = Integer.parseInt(label.getText());
				int hasil = 0;
				switch (operator) {
				case "+":
					hasil = tambah(angka1, angka2);
					break;
				case "-":
					hasil = kurang(angka1, angka2);
					break;
				case "x":
					hasil = kali(angka1, angka2);
					break;
				case "/":
					hasil = bagi(angka1, angka2);
					break;
				}
				label.setText(String.valueOf(hasil));
			}
		});
		panel.add(btnSamaDengan);

		JButton btnClear = new JButton("C");
		btnClear.setFont(new Font("Arial", Font.BOLD, 14));
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				angka1 = 0;
				angka2 = 0;
				operator = "";
				label.setText("0");
			}
		});
		panel.add(btnClear);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 50, 10));
		panel.setPreferredSize(new Dimension(400, 400));
		panel.setLayout(new GridLayout(4, 4));

		JPanel panel2 = new JPanel();
		panel2.add(label, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setTitle("Kalkulator Valen");
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static int tambah(int angka1, int angka2) {
		return angka1 + angka2;
	}

	public static int kurang(int angka1, int angka2) {
		return angka1 - angka2;
	}

	public static int kali(int angka1, int angka2) {
		return angka1 * angka2;
	}

	public static int bagi(int angka1, int angka2) {
		if (angka2 == 0)
			return 0;
		return angka1 / angka2;
	}
}
