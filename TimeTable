
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

public class TimeTable {
	TimeTable() throws SQLException {
		JFrame mainframe = new JFrame("Time Table");
		mainframe.setVisible(true);
		mainframe.setSize(1500, 1500);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Head Work

		JPanel headpanel = new JPanel();
		headpanel.setBackground(Color.BLACK);

		JPanel logo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		logo.setBounds(0, 0, 200, 200);
		logo.setBackground(Color.BLACK);

		// ImageIcon icon = new ImageIcon(getClass().getResource("msu
		// logo.jpg"));
		// JLabel msulogo = new JLabel(icon);
		// logo.add(msulogo,BorderLayout.WEST);

		JLabel title = new JLabel("COMPUTER SCIENCE DEPARTMENT,MSU", JLabel.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Arial Bold", Font.ITALIC, 42));
		headpanel.add(title, BorderLayout.CENTER);

		// display work
		JPanel displaypanel = new JPanel(new GridLayout(1, 1));
		displaypanel.setBackground(Color.PINK);

		// diffrerent pages

		// homepage
		JPanel phome = new JPanel(new GridLayout(5, 1, 20, 20));
		JLabel home = new JLabel("About", JLabel.CENTER);
		home.setFont(new Font("Times New Roman", Font.BOLD, 40));
		home.setBackground(Color.PINK);
		phome.add(home, BorderLayout.CENTER);
		JTextArea desc = new JTextArea(
				"dsgsgdddddddddddddddddddddddddddddddddddddddddddddddddsssssssssssssssssssssssssssssssssssssaaf");
		desc.setLineWrap(true);
		desc.setWrapStyleWord(true);
		desc.setEditable(false);
		desc.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		JScrollPane sp = new JScrollPane(desc, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		desc.setBackground(Color.PINK);
		desc.setEditable(false);
		phome.add(sp, BorderLayout.SOUTH);
		phome.setBackground(Color.PINK);
		displaypanel.add(phome);

		// Modify timetable
		JPanel mod = new JPanel();
		mod.setBackground(Color.PINK);
		JPanel grp = new JPanel(new GridBagLayout());
		grp.setBackground(Color.PINK);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(20, 20, 20, 20);
		gbc.ipady = 20;
		gbc.weightx = 1;
		JButton gen = new JButton("Generate Time Table");
		JButton upd = new JButton(" Update Time Table ");
		JButton res = new JButton(" Reset Time Table  ");
		res.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JLabel reset = new JLabel("All Datas Are Deleted.", JLabel.CENTER);
				reset.setFont(new Font("Times New Roman", Font.BOLD, 50));
				displaypanel.removeAll();
				displaypanel.add(reset, BorderLayout.CENTER);
				displaypanel.repaint();
				mainframe.setVisible(true);
			}
		});
		grp.add(gen, gbc);
		gbc.gridy = 1;
		grp.add(upd, gbc);
		gbc.gridy = 2;
		grp.add(res, gbc);
		mod.add(grp, BorderLayout.CENTER);
		// displaypanel.add(mod);

		// view timetable
		JPanel mainclass = new JPanel(new GridBagLayout());
		GridBagConstraints classwisegbc = new GridBagConstraints();
		classwisegbc.anchor = GridBagConstraints.NORTH;
		classwisegbc.insets = new Insets(20, 20, 20, 20);
		mainclass.setBackground(Color.PINK);
		JPanel psel = new JPanel();
		psel.setBackground(Color.PINK);
		JLabel sel = new JLabel("", JLabel.CENTER);
		sel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		sel.setBackground(Color.PINK);
		psel.add(sel);
		mainclass.add(psel, classwisegbc);

		JPanel drp = new JPanel();
		drp.setBackground(Color.PINK);
		JComboBox<String> scls = new JComboBox<String>();
		drp.add(scls, BorderLayout.NORTH);
		classwisegbc.gridy = 1;
		classwisegbc.weighty = 2;
		mainclass.add(drp, classwisegbc);

		JPanel ptt = new JPanel(new BorderLayout());
		JTable tt = new JTable();
		// mainclass.add(ptt,classwisegbc);
		// displaypanel.add(mainclass);

		scls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "";
				String[][] d = null;
				Table t = new Table();
				ptt.removeAll();
				if (scls.getSelectedIndex() > 0) {
					data = "Time Table:" + scls.getItemAt(scls.getSelectedIndex());
					switch (scls.getItemAt(scls.getSelectedIndex())) {
					case "Impact":
						try {
							d = t.getTimeTableForLab(scls.getSelectedIndex());
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						break;
					case "BE-I":
					case "BE_II":
					case "BE_III":
						try {
							d = t.getTimeTable("class", scls.getSelectedIndex());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case "a":
						try {
							d = t.getTimeTable("teacher", scls.getSelectedIndex());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;

					}
					ptt.removeAll();

					String dq[][] = { { "10", "11", "12", "13", "14", "15", "16" },
							{ "20", "21", "22", "23", "24", "25", "26" }, { "30", "31", "32", "33", "34", "35", "36" },
							{ "40", "41", "42", "43", "44", "45", "46" }, { "50", "51", "52", "53", "54", "55", "56" },
							{ "60", "61", "62", "63", "64", "65", "66" } };
					t.closeAll();
					try {
						d = t.getTimeTable("class", scls.getSelectedIndex());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String col[] = { "NO", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
					JTable tt = new JTable(d, col);
					tt.setFillsViewportHeight(true);
					tt.setEnabled(false);
					tt.setBackground(Color.black);
					tt.setForeground(Color.WHITE);
					tt.getTableHeader().setForeground(Color.red);
					tt.getTableHeader().setBackground(Color.BLACK);
					ptt.add(tt.getTableHeader(), BorderLayout.PAGE_START);
					ptt.add(tt, BorderLayout.CENTER);
					classwisegbc.gridy = 2;
					classwisegbc.weighty = 20;
					sel.setText(data);
					displaypanel.repaint();
					mainclass.add(ptt, classwisegbc);
				}
				mainframe.setVisible(true);
			}
		});

		// class wise,lab wise,teacher wise
		JPanel view = new JPanel();
		view.setBackground(Color.PINK);
		JPanel grpv = new JPanel(new GridBagLayout());
		grpv.setBackground(Color.PINK);
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.anchor = GridBagConstraints.CENTER;
		gbcv.fill = GridBagConstraints.HORIZONTAL;
		gbcv.insets = new Insets(20, 20, 20, 20);
		gbcv.ipady = 20;
		gbcv.weightx = 1;
		JButton cls = new JButton("  Class Wise Time Table   ");
		cls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainclass.remove(ptt);
				sel.setText("Please Select One Class From Dropdown.");
				scls.removeAllItems();
				scls.addItem("-Select-");
				scls.addItem("BE-I");
				scls.addItem("BE-II");
				scls.addItem("BE-III");
				scls.addItem("MCA-I");
				scls.addItem("MCA-II");
				scls.addItem("MCA-III");

				displaypanel.removeAll();
				displaypanel.repaint();
				displaypanel.add(mainclass);
				mainframe.setVisible(true);
			}
		});

		JButton lab = new JButton("   LAB Wise Time Table    ");
		lab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainclass.remove(ptt);
				sel.setText("Please Select One Lab From Dropdown.");
				scls.removeAllItems();
				scls.addItem("-Select-");
				scls.addItem("Impact");
				scls.addItem("Compact");
				scls.addItem("HP");
				scls.addItem("New");
				displaypanel.removeAll();
				// ptt.removeAll();
				// Table t=new Table();
				// String
				// dq[][]={{"10","11","12","13","14","15","16"},{"20","21","22","23","24","25","26"},{"30","31","32","33","34","35","36"},{"40","41","42","43","44","45","46"},{"50","51","52","53","54","55","56"},{"60","61","62","63","64","65","66"}};
				// String[][] d = null;
				// try {
				// d = t.getTimeTableForLab(scls.getSelectedIndex());
				// } catch (SQLException e1) {
				// // TODO Auto-generated catch block
				// e1.printStackTrace();
				// }
				// String
				// col[]={"NO","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
				// JTable tt= new JTable(d,col);
				// tt.setFillsViewportHeight(true);
				// tt.setEnabled(false);
				// tt.setBackground(Color.black);
				// tt.setForeground(Color.WHITE);
				// tt.getTableHeader().setForeground(Color.red);
				// tt.getTableHeader().setBackground(Color.BLACK);
				// ptt.add(tt.getTableHeader(),BorderLayout.PAGE_START);
				// ptt.add(tt,BorderLayout.CENTER);
				// classwisegbc.gridy=2;
				// classwisegbc.weighty=20;
				displaypanel.repaint();
				displaypanel.add(mainclass);
				mainframe.setVisible(true);
			}
		});

		JButton tea = new JButton("  Teacher Wise Time Table ");
		tea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainclass.remove(ptt);
				sel.setText("Please Select One Teacher From Dropdown.");
				scls.removeAllItems();
				ArrayList<String> arr = Table.getTeacher();
				// scls.addItem("-Select-");scls.addItem("Dr.Anjali
				// Jivani");scls.addItem("Dr.Bhuvan
				// Parekh");scls.addItem("Dr.Bhavsar");scls.addItem("Dr.Mamta
				// Padole");scls.addItem("Dr.Apurv
				// Shah");scls.addItem("Dr.Vishwas
				// Raval");scls.addItem("Dr.Viral Kapdia");
				int len = arr.size();
				scls.addItem("-Select-");
				//scls.addItem(""+);
				for (int i = 0; i < 3; i++) {
					scls.addItem(arr.get(i));
				}
				displaypanel.removeAll();
				// ptt.removeAll();
				// Table t=new Table();
				// String
				// dq[][]={{"10","11","12","13","14","15","16"},{"20","21","22","23","24","25","26"},{"30","31","32","33","34","35","36"},{"40","41","42","43","44","45","46"},{"50","51","52","53","54","55","56"},{"60","61","62","63","64","65","66"}};
				// String[][] d = null;
				// try {
				// d = t.getTimeTable("teacher",scls.getSelectedIndex());
				// } catch (SQLException e1) {
				// // TODO Auto-generated catch block
				// e1.printStackTrace();
				// }
				// String
				// col[]={"NO","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
				// JTable tt= new JTable(d,col);
				// tt.setFillsViewportHeight(true);
				// tt.setEnabled(false);
				// tt.setBackground(Color.black);
				// tt.setForeground(Color.WHITE);
				// tt.getTableHeader().setForeground(Color.red);
				// tt.getTableHeader().setBackground(Color.BLACK);
				// ptt.add(tt.getTableHeader(),BorderLayout.PAGE_START);
				// ptt.add(tt,BorderLayout.CENTER);
				// classwisegbc.gridy=2;
				// classwisegbc.weighty=20;
				displaypanel.repaint();
				displaypanel.add(mainclass);
				mainframe.setVisible(true);
			}
		});

		grpv.add(cls, gbcv);
		gbcv.gridy = 1;
		grpv.add(lab, gbcv);
		gbcv.gridy = 2;
		grpv.add(tea, gbcv);
		view.add(grpv, BorderLayout.CENTER);
		// displaypanel.add(view);

		// generate time table
		gen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buttons[] = { "Add Details", "Delete Details" };
				int r = JOptionPane.showOptionDialog(null, "Choose One Option ", "Confirm Operation",
						JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons[1]);
				// add details

				displaypanel.removeAll();
				displaypanel.repaint();
				if (r == 0 || r == 1) {

					JPanel gmainclass = new JPanel(new GridBagLayout());
					GridBagConstraints gclasswisegbc = new GridBagConstraints();
					gclasswisegbc.anchor = GridBagConstraints.NORTH;
					gclasswisegbc.insets = new Insets(20, 20, 20, 20);
					gmainclass.setBackground(Color.PINK);
					JPanel gpsel = new JPanel();
					gpsel.setBackground(Color.PINK);
					JLabel gsel = new JLabel("Select One Table", JLabel.CENTER);
					gsel.setFont(new Font("Times New Roman", Font.BOLD, 40));
					gsel.setBackground(Color.PINK);
					gpsel.add(gsel);
					gmainclass.add(gpsel, gclasswisegbc);

					JPanel gdrp = new JPanel();
					gdrp.setBackground(Color.PINK);
					String i[] = { "-Select-", "Class", "Subject", "LabD", "teacher", "Lecture", "Lab" };
					JComboBox<String> gscls = new JComboBox<String>(i);
					gdrp.add(gscls, BorderLayout.NORTH);
					gclasswisegbc.gridy = 1;
					gclasswisegbc.weighty = 2;
					gmainclass.add(gdrp, gclasswisegbc);
					displaypanel.add(gmainclass);
					mainframe.setVisible(true);
					JPanel entdet = new JPanel(new GridBagLayout());

					gscls.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String data = "";
							if (gscls.getSelectedIndex() > 0) {
								data = "Enter Details Of " + gscls.getItemAt(gscls.getSelectedIndex());
								gsel.setText(data);
							}

							GridBagConstraints ent = new GridBagConstraints();
							ent.insets = new Insets(5, 5, 5, 5);
							entdet.setBackground(Color.PINK);
							String i = (String) gscls.getItemAt(gscls.getSelectedIndex());

							if (r == 0) {
								entdet.removeAll();

								switch (i) {
								case "Class":
									String cvar[] = { "Class Id", "Class Name", "Max Student", "No Of Subject",
											"No Of Lab" };
									ent.anchor = GridBagConstraints.WEST;
									for (int x = 0; x < cvar.length; x++) {
										JLabel v = new JLabel("", JLabel.LEFT);
										v.setText(cvar[x]);
										v.setFont(new Font("Times New Roman", Font.PLAIN, 30));
										ent.gridx = 0;
										ent.gridy = x;
										entdet.add(v, ent);
									}
									ent.anchor = GridBagConstraints.EAST;
									for (int x = 0; x < cvar.length; x++) {
										ent.gridx = 1;
										ent.gridy = x;
										JTextField tex = new JTextField(30);
										entdet.add(tex, ent);
									}
									break;
								case "Subject":
									String svar[] = { "Subject Id", "Subject Name" };
									ent.anchor = GridBagConstraints.WEST;
									for (int x = 0; x < svar.length; x++) {
										JLabel v = new JLabel("", JLabel.LEFT);
										v.setText(svar[x]);
										v.setFont(new Font("Times New Roman", Font.PLAIN, 30));
										ent.gridx = 0;
										ent.gridy = x;
										entdet.add(v, ent);
									}
									ent.anchor = GridBagConstraints.EAST;
									for (int x = 0; x < svar.length; x++) {
										ent.gridx = 1;
										ent.gridy = x;
										JTextField tex = new JTextField(30);
										entdet.add(tex, ent);
									}
									break;
								case "LabD":
									String ldvar[] = { "Lab Id", "Lab Name" };
									ent.anchor = GridBagConstraints.WEST;
									for (int x = 0; x < ldvar.length; x++) {
										JLabel v = new JLabel("", JLabel.LEFT);
										v.setText(ldvar[x]);
										v.setFont(new Font("Times New Roman", Font.PLAIN, 30));
										ent.gridx = 0;
										ent.gridy = x;
										entdet.add(v, ent);
									}
									ent.anchor = GridBagConstraints.EAST;
									for (int x = 0; x < ldvar.length; x++) {
										ent.gridx = 1;
										ent.gridy = x;
										JTextField tex = new JTextField(30);
										entdet.add(tex, ent);
									}
									break;
								case "teacher":
									String tvar[] = { "Teacher Id", "Name", "Phone", "Email", "Department" };
									ent.anchor = GridBagConstraints.WEST;
									for (int x = 0; x < tvar.length; x++) {
										JLabel v = new JLabel("", JLabel.LEFT);
										v.setText(tvar[x]);
										v.setFont(new Font("Times New Roman", Font.PLAIN, 30));
										ent.gridx = 0;
										ent.gridy = x;
										entdet.add(v, ent);
									}
									ent.anchor = GridBagConstraints.EAST;
									for (int x = 0; x < tvar.length; x++) {
										ent.gridx = 1;
										ent.gridy = x;
										JTextField tex = new JTextField(30);
										entdet.add(tex, ent);
									}
									break;
								case "Lecture":
									String lcvar[] = { "Lecture Id", "Class Id", "Teacher Id", "Sub Id" };
									ent.anchor = GridBagConstraints.WEST;
									for (int x = 0; x < lcvar.length; x++) {
										JLabel v = new JLabel("", JLabel.LEFT);
										v.setText(lcvar[x]);
										v.setFont(new Font("Times New Roman", Font.PLAIN, 30));
										ent.gridx = 0;
										ent.gridy = x;
										entdet.add(v, ent);
									}
									ent.anchor = GridBagConstraints.EAST;
									for (int x = 0; x < lcvar.length; x++) {
										ent.gridx = 1;
										ent.gridy = x;
										JTextField tex = new JTextField(30);
										entdet.add(tex, ent);
									}
									break;
								case "Lab":
									String lvar[] = { "TLab Id", "Class Id", "Teacher Id", "Lab Id", "Subject Id",
											"Number Of Group" };
									ent.anchor = GridBagConstraints.WEST;
									for (int x = 0; x < lvar.length; x++) {
										JLabel v = new JLabel("", JLabel.LEFT);
										v.setText(lvar[x]);
										v.setFont(new Font("Times New Roman", Font.PLAIN, 30));
										ent.gridx = 0;
										ent.gridy = x;
										entdet.add(v, ent);
									}
									ent.anchor = GridBagConstraints.EAST;
									for (int x = 0; x < lvar.length; x++) {
										ent.gridx = 1;
										ent.gridy = x;
										JTextField tex = new JTextField(30);
										entdet.add(tex, ent);
									}
									break;
								}

								JButton sub = new JButton("Add");
								ent.anchor = GridBagConstraints.CENTER;
								ent.gridy = 7;
								entdet.add(sub, ent);
								gclasswisegbc.gridy = 2;
								gclasswisegbc.weighty = 20;
								gmainclass.add(entdet, gclasswisegbc);

							} else if (r == 1) {

								entdet.removeAll();
								gsel.repaint();
								ent.anchor = GridBagConstraints.WEST;
								switch (i) {
								case "Class":
									ent.gridx = 0;
									JLabel delcls = new JLabel("Class ID");
									delcls.setFont(new Font("Times New Roman", Font.PLAIN, 30));
									entdet.add(delcls, ent);
									ent.gridx = 1;
									JTextField entcls = new JTextField(30);
									entdet.add(entcls, ent);
									break;
								case "Subject":
									ent.gridx = 0;
									JLabel delsub = new JLabel("Subject ID");
									delsub.setFont(new Font("Times New Roman", Font.PLAIN, 30));
									entdet.add(delsub, ent);
									ent.gridx = 1;
									JTextField entsub = new JTextField(30);
									entdet.add(entsub, ent);
									break;
								case "LabD":
									ent.gridx = 0;
									JLabel dellabd = new JLabel("Lab ID");
									dellabd.setFont(new Font("Times New Roman", Font.PLAIN, 30));
									entdet.add(dellabd, ent);
									ent.gridx = 1;
									JTextField entlabd = new JTextField(30);
									entdet.add(entlabd, ent);
									break;
								case "teacher":
									ent.gridx = 0;
									JLabel deltch = new JLabel("Teacher ID");
									deltch.setFont(new Font("Times New Roman", Font.PLAIN, 30));
									entdet.add(deltch, ent);
									ent.gridx = 1;
									JTextField enttch = new JTextField(30);
									entdet.add(enttch, ent);
									break;
								case "Lecture":
									ent.gridx = 0;
									JLabel dellec = new JLabel("Lecture ID");
									dellec.setFont(new Font("Times New Roman", Font.PLAIN, 30));
									entdet.add(dellec, ent);
									ent.gridx = 1;
									JTextField entlec = new JTextField(30);
									entdet.add(entlec, ent);
									break;
								case "Lab":
									ent.gridx = 0;
									JLabel dellab = new JLabel("TLab ID");
									dellab.setFont(new Font("Times New Roman", Font.PLAIN, 30));
									entdet.add(dellab, ent);
									ent.gridx = 1;
									JTextField entlab = new JTextField(30);
									entdet.add(entlab, ent);
									break;

								}
								JButton delete = new JButton("Delete");
								ent.anchor = GridBagConstraints.CENTER;
								ent.gridy = 7;
								entdet.add(delete, ent);
								gclasswisegbc.gridy = 2;
								gclasswisegbc.weighty = 20;
								gmainclass.add(entdet, gclasswisegbc);
							}

						}

					});

				}
			}

		});

		// menu work
		JPanel men = new JPanel(new GridBagLayout());
		JPanel menupanel = new JPanel();
		GridBagConstraints mgbc = new GridBagConstraints();
		mgbc.insets = new Insets(15, 10, 30, 15);
		mgbc.anchor = GridBagConstraints.CENTER;
		mgbc.fill = GridBagConstraints.HORIZONTAL;
		mgbc.ipady = 20;
		men.setBackground(Color.CYAN);
		menupanel.setBackground(Color.CYAN);

		JButton bhome = new JButton("Home");
		men.add(bhome, mgbc);
		bhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displaypanel.removeAll();
				displaypanel.repaint();
				displaypanel.add(phome);
				mainframe.setVisible(true);
			}
		});

		JButton gtimetable = new JButton("Modify Time Table");
		mgbc.gridy = 1;
		men.add(gtimetable, mgbc);
		gtimetable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displaypanel.removeAll();
				displaypanel.repaint();
				displaypanel.add(mod);
				mainframe.setVisible(true);
			}
		});

		JButton vtimetable = new JButton("View Time Table");
		mgbc.gridy = 2;
		men.add(vtimetable, mgbc);
		vtimetable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displaypanel.removeAll();
				displaypanel.repaint();
				displaypanel.add(view);
				mainframe.setVisible(true);
			}
		});

		menupanel.add(men, BorderLayout.NORTH);

		JSplitPane headpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, logo, headpanel);
		JSplitPane lowerpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menupanel, displaypanel);
		JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, headpane, lowerpane);
		headpane.setEnabled(false);
		lowerpane.setEnabled(false);
		splitpane.setEnabled(false);
		mainframe.add(splitpane);

		// Table.closeAll();

	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				try {
					new TimeTable();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
	}
}
