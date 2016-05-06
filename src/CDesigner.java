 import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class CDesigner extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtExpresie;
	public JTextPane txtConv;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					CDesigner frame = new CDesigner();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	public CDesigner() {
		
		
		setBackground(Color.WHITE);
		setTitle("Roman Calculator");
		//Image img = new ImageIcon(this.getClass().getResource("/img/Roman_Helmet_1.png")).getImage();
		//setIconImage(img);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setFont(new Font("Shruti", Font.PLAIN, 12));
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 540, 370);
		contentPane.add(tabbedPane);
		
		JPanel panel_Calculator = new JPanel();
		panel_Calculator.setBackground(Color.WHITE);
		tabbedPane.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=15 marginheight=5><font size=\"4\">Calculator</font></body></html>", null, panel_Calculator, null);
		panel_Calculator.setLayout(null);
		
		JPanel panel_Expr = new JPanel();
		panel_Expr.setBackground(new Color(255, 255, 255));
		panel_Expr.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Expression", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Expr.setBounds(10, 11, 412, 100);
		panel_Calculator.add(panel_Expr);
		panel_Expr.setLayout(null);
		
		final JTextField txtExpresie = new JTextField();

		txtExpresie.setFont(new Font("Shruti", Font.PLAIN, 12));
		txtExpresie.setBounds(15, 30, 380, 26);
		txtExpresie.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Expr.add(txtExpresie);
		txtExpresie.setColumns(10);
		
		JButton btnReady = new JButton("Ready");
		btnReady.setBackground(new Color(204, 102, 102));		
		btnReady.setBounds(151, 66, 89, 23);
		panel_Expr.add(btnReady);
		
		JPanel panel_Conv = new JPanel();
		panel_Conv.setLayout(null);
		panel_Conv.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Conversion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Conv.setBackground(Color.WHITE);
		panel_Conv.setBounds(10, 150, 412, 82);
		panel_Calculator.add(panel_Conv);
		
		final JTextPane txtConv = new JTextPane();
		txtConv.setFont(new Font("Shruti", Font.PLAIN, 12));
		txtConv.setEditable(false);
		txtConv.setBounds(15, 30, 380, 26);
		panel_Conv.add(txtConv);
		
		JPanel panel_Result = new JPanel();
		panel_Result.setLayout(null);
		panel_Result.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Result", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Result.setBackground(Color.WHITE);
		panel_Result.setBounds(10, 260, 412, 82);
		panel_Calculator.add(panel_Result);
		
		final JTextPane txtResult = new JTextPane();
		txtResult.setFont(new Font("Shruti", Font.PLAIN, 13));
		txtResult.setEditable(false);
		txtResult.setBounds(15, 30, 380, 26);
		panel_Result.add(txtResult);
		tabbedPane.setForegroundAt(0, Color.BLACK);
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setBackgroundAt(0, new Color(204, 102, 102));
		
		JPanel panel_History = new JPanel();
		panel_History.setForeground(Color.BLACK);
		panel_History.setBackground(Color.WHITE);
		tabbedPane.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=15 marginheight=5><font size=\"4\">History</font></body></html>", null, panel_History, null);
		panel_History.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Roman Numerals");
		lblNewLabel.setFont(new Font("Shruti", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 22, 404, 37);
		panel_History.add(lblNewLabel);
		
		JTextPane txtpnRomanNumeralsThe = new JTextPane();
		txtpnRomanNumeralsThe.setEditable(false);
		txtpnRomanNumeralsThe.setFont(new Font("Shruti", Font.BOLD, 13));
		txtpnRomanNumeralsThe.setText("       Roman numerals, the numeric system used in ancient Rome, employs combinations of letters from the Latin alphabet to signify values. The numbers 1 to 10 can be expressed in Roman numerals as follows:\r\n              \tI, II, III, IV, V, VI, VII, VIII, IX, X.\r\n       The Roman numeral system is a cousin of Etruscan numerals. Use of Roman numerals continued after the decline of the Roman Empire. From the 14th century on, Roman numerals began to be replaced in most contexts by more convenient Hindu-Arabic numerals; however, this process was gradual, and the use of Roman numerals in some minor applications continues to this day.");
		txtpnRomanNumeralsThe.setBounds(10, 70, 404, 284);
		panel_History.add(txtpnRomanNumeralsThe);
		tabbedPane.setForegroundAt(1, Color.BLACK);
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setBackgroundAt(1, new Color(204, 102, 102));
		
		JPanel panel_Help = new JPanel();
		panel_Help.setForeground(Color.BLACK);
		panel_Help.setBackground(Color.WHITE);
		tabbedPane.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=15 marginheight=5><font size=\"4\">Help</font></body></html>", null, panel_Help, null);
		panel_Help.setLayout(null);
		
		JTextPane txtpnMathExpressionsThat = new JTextPane();
		txtpnMathExpressionsThat.setEditable(false);
		txtpnMathExpressionsThat.setText("Math expressions that you can use:\r\n( , ) , + , - , * , /\r\n\r\nRoman Numerals must respect the followings:\r\n- I , X, C, M can appear for maximum 3 times in a numeral ( small exceptions )\r\n- V, L, D can appear just 1 time in a numeral\r\n- I can be followed only by I, V, X\r\n- V can be followed only by I\r\n- X and D can be followed only by I, V, X, L, C\r\n- L can be followed only by I, V, X,\r\n");
		txtpnMathExpressionsThat.setFont(new Font("Shruti", Font.BOLD, 13));
		txtpnMathExpressionsThat.setBounds(10, 52, 394, 302);
		panel_Help.add(txtpnMathExpressionsThat);
		
		JLabel lblRomanHelp = new JLabel("Roman Help");
		lblRomanHelp.setFont(new Font("Shruti", Font.BOLD | Font.ITALIC, 17));
		lblRomanHelp.setHorizontalAlignment(SwingConstants.CENTER);
		lblRomanHelp.setBounds(10, 11, 394, 30);
		panel_Help.add(lblRomanHelp);
		tabbedPane.setForegroundAt(2, Color.BLACK);
		tabbedPane.setBackgroundAt(2, new Color(204, 102, 102));
		tabbedPane.setEnabledAt(2, true);
		
		JPanel panel_About = new JPanel();
		panel_About.setBackground(Color.WHITE);
		tabbedPane.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=15 marginheight=5><font size=\"4\">About</font></body></html>", null, panel_About, null);
		panel_About.setLayout(null);
		
		JTextPane txtpnRomancalculatorIsA = new JTextPane();
		txtpnRomancalculatorIsA.setText("RomanCalculator is a small program where you can calculate different Roman Expressions.\r\n\r\nAttention: The program may have some bugs.");
		txtpnRomancalculatorIsA.setBounds(10, 102, 394, 162);
		txtpnRomancalculatorIsA.setFont(new Font("Shruti", Font.BOLD, 14));
		panel_About.add(txtpnRomancalculatorIsA);
		
		JTextPane txtpncCopyrightTo = new JTextPane();
		txtpncCopyrightTo.setEditable(false);
		txtpncCopyrightTo.setFont(new Font("Shruti", Font.BOLD, 13));
		txtpncCopyrightTo.setText("  (c) Copyright to Caciuc Diana Andreea\r\nStudent at University ''Dunarea De Jos\", Galati");
		txtpncCopyrightTo.setBounds(72, 290, 282, 64);
		panel_About.add(txtpncCopyrightTo);
		tabbedPane.setEnabledAt(3, true);
		tabbedPane.setBackgroundAt(3, new Color(204, 102, 102));
		
		JPanel panel_Pic = new JPanel();
		tabbedPane.addTab("", null, panel_Pic, null);
		//Image img2 = new ImageIcon(this.getClass().getResource("/Roman_Helmet_2.png")).getImage();
		//tabbedPane.setDisabledIconAt(4, new ImageIcon(img2));
		tabbedPane.setEnabledAt(4, false);

		/*Transform all types of characters in UpperCase to avoid nested cases.*/
		txtExpresie.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char key = arg0.getKeyChar();
				if(Character.isLowerCase(key)){
					arg0.setKeyChar(Character.toUpperCase(key));
				}
			}
		});
		
		/*Return the transformed expression in real time.*/
		txtExpresie.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {			
				if("".equals(txtExpresie.getText())){
					txtConv.setText("");
					return;
				}
				String expr = RomanConversion.convertExpression(txtExpresie.getText());
				if(!expr.equals("")){
					txtConv.setText(String.valueOf(expr));
				}else
					txtConv.setText("");
				
			}
		});
		/*When the expression is ready, on click it will calculate it.*/
		btnReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = RomanCalculator.calculate(txtExpresie.getText());
					txtResult.setText(String.valueOf(ArabConversion.ArabToRoman(Integer.parseInt(result))));
			}
		});
	}
}
