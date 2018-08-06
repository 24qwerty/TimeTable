import java.sql.*;
import java.util.ArrayList;
import java.math.*;

public class Table {
	String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	ResultSet rs;
	static Connection connect;
	Statement stat;

	Table() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connect = DriverManager.getConnection(URL, "system", "qwerty");

		} catch (Exception e)

		{
			System.out.println("ERROR 1.");
			System.exit(1);
		}

	}

	static String select(String var, String tab, String x, String y) {
		return "Select " + var + " from " + tab + " where " + x + "=" + y;
	}

	void scheduleLab() throws SQLException {
		try {

			stat = connect.createStatement();

			String sql = "select * from lab";

			rs = stat.executeQuery(sql);

			while (rs.next()) {

				int l = getNumberOfLab(rs.getInt("class_id"));
				int yy = l;

				if (l > 0) {

					int m = rs.getInt("number_of_group");
					int d = 1;
					for (int j = 1; j <= m; j++) {
						boolean b = false;
						while (!b) {
							b = checkLab(rs.getInt("TLab_id"), l, d);
							if (b) {
								updateForLab(rs.getInt("TLab_id"), l, d);

								if ((d + 5) % 6 == 0) {
									d += 6;
								} else {
									d += 3;
								}
							} else {
								d += 3;
							}
						}
					}

					do {
						if (!rs.isAfterLast()) {
							rs.next();

						}
						yy--;
					} while (yy > 1);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			// connect.close();
		}
	}
	static ArrayList<String> getTeacher() {
		ResultSet rss = null;
		ArrayList<String> str=new ArrayList<>();
		try{
		Statement ss = connect.createStatement();
		String sql;
		sql = "select name from teacher";
		rss=ss.executeQuery(sql);
		while(rss.next()){
			str.add(rss.getString("name"));
		}
		}
		catch(Exception e){
			
		}
		return str;
		
	}
	String[][] getTimeTable(String tb, int id) throws SQLException {

		String[][] tt = new String[7][7];
		tt[0][0] = "" + 0;
		tt[1][0] = "" + 0;
		tt[2][0] = "" + 0;
		tt[3][0] = "" + 0;
		tt[4][0] = "" + 0;
		tt[5][0] = "" + 0;
		tt[6][0] = "" + 0;
		tt[0][0] = "" + 0;
		tt[0][1] = "" + 0;
		tt[0][2] = "" + 0;
		tt[0][3] = "" + 0;
		tt[0][4] = "" + 0;
		tt[0][5] = "" + 0;
		tt[0][6] = "" + 0;
		ResultSet rss = null;
		Statement ss = connect.createStatement(), ss2 = connect.createStatement();
		try {
			String sql;
			sql = "select * from " + tb + " where " + tb + "_id=" + id;
			rss = ss.executeQuery(sql);

			int k = 0;
			while (rss.next()) {
				for (int i = 0; i < 6; i++) {

					for (int j = 0; j < 6; j++) {
						k++;
						String str = "slot" + k;
						int h = rss.getInt(str);
						ResultSet rss2 = null;
						if (h != 0 && h < 100) {
							String sql2 = "select * from lab where tlab_id=" + h;
							rss2 = ss2.executeQuery(sql2);
							while (rss2.next()) {
								tt[j + 1][i + 1] = "lab";
								int jp = rss2.getInt("lab_id");
								ResultSet rr1 = null;
								Statement st = connect.createStatement();
								rr1 = st.executeQuery("select * from labd where lab_id=" + jp);
								while (rr1.next()) {
									tt[j + 1][i + 1] = rr1.getString("lab_name");
								}
							}

						} else {
							tt[j + 1][i + 1] = "" + h;
							ResultSet r1, r2;
							Statement s1 = connect.createStatement();
							Statement s2 = connect.createStatement();
							r1 = s1.executeQuery("select * from lecture where TLec_id=" + (h - 100));
							while (r1.next()) {
								int sid = r1.getInt("subject_id");
								r2 = s2.executeQuery("select * from subject where subject_id=" + sid);
								while (r2.next()) {
									tt[j + 1][i + 1] = r2.getString("subject_name");
								}
							}
						}
						// System.out.println(i + "" + j);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss2.close();
			ss.close();
			//connect.close();
		}
		return tt;

	}
	 void closeAll(){
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	String[][] getTimeTableForLab(int id) throws SQLException {
		String tb = "labd";
		String[][] tt = new String[7][7];
		tt[0][0] = "" + 0;
		tt[1][0] = "" + 0;
		tt[2][0] = "" + 0;
		tt[3][0] = "" + 0;
		tt[4][0] = "" + 0;
		tt[5][0] = "" + 0;
		tt[6][0] = "" + 0;
		tt[0][0] = "" + 0;
		tt[0][1] = "" + 0;
		tt[0][2] = "" + 0;
		tt[0][3] = "" + 0;
		tt[0][4] = "" + 0;
		tt[0][5] = "" + 0;
		tt[0][6] = "" + 0;
		ResultSet rss = null;
		Statement ss = connect.createStatement(), ss2 = connect.createStatement();
		try {
			String sql;
			sql = "select * from " + tb + " where lab_id=" + id;
			rss = ss.executeQuery(sql);

			int k = 0;
			while (rss.next()) {
				for (int i = 0; i < 6; i++) {

					for (int j = 0; j < 6; j++) {
						k++;
						String str = "slot" + k;
						int h = rss.getInt(str);
						ResultSet rss2 = null;
						String sql2 = "select * from lab where tlab_id=" + h;
						rss2 = ss2.executeQuery(sql2);
						while (rss2.next()) {
							int jp = rss2.getInt("class_id");
							ResultSet rr1 = null;
							Statement st = connect.createStatement();
							rr1 = st.executeQuery("select * from class where class_id=" + jp);
							while (rr1.next()) {
								tt[j + 1][i + 1] = rr1.getString("class_name");
							}
						}

					}
				}
			}

		} catch (Exception e){
			e.printStackTrace();
		} finally{
			ss.close();
			ss2.close();
		//	connect.close();
		}
		return tt;

	}

	void scheduleLecture() throws SQLException {
		try {
			stat = connect.createStatement();
			String sql = "select * from lecture";
			rs = stat.executeQuery(sql);
			while (rs.next()) {

				int m = rs.getInt("slot");
				int d = 1;
				for (int j = 1; j <= m; j++) {
					boolean b = false;
					while (!b) {
						b = checkForLecture(rs.getInt("class_id"), rs.getInt("teacher_id"), d);
						if (b) {
							updateForLecture(rs.getInt("TLec_id"), rs.getInt("class_id"), rs.getInt("teacher_id"), d);
							if (d <= 6)
								d = 7;
							else if (d <= 12)
								d = 13;
							else if (d <= 18)
								d = 19;
							else if (d <= 24)
								d = 25;
							else
								d = 31;
						} else {
							d += 1;
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			// connect.close();
		}
	}

	private void updateForLecture(int id, int c, int t, int d) throws SQLException {
		// TODO Auto-generated method stub

		Statement s = connect.createStatement(), s1 = connect.createStatement(), s2 = connect.createStatement();
		ResultSet r1 = null;
		try {
			connect.setAutoCommit(true);
			r1 = s.executeQuery("select * from lecture where TLec_id=" + id);
			while (r1.next()) {
				int pp = r1.getInt("TLec_id") + 100;
				s1.executeUpdate("update class set slot" + d + "=" + pp + " where class_id=" + c);
				s2.executeUpdate("update teacher set slot" + d + "=" + pp + " where teacher_id=" + t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			r1.close();
		}
	}

	boolean checkForLecture(int c, int t, int sl) throws SQLException {
		Statement s = connect.createStatement(), s1 = connect.createStatement();
		ResultSet r1 = null, r2 = null;
		try {
			r1 = s.executeQuery("select slot" + sl + " from class where class_id=" + c);
			r2 = s1.executeQuery("select slot" + sl + " from teacher where teacher_id=" + t);
			while (r1.next() && r2.next())
				if (r1.getInt("slot" + sl) != 0 || r2.getInt("slot" + sl) != 0)
					return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			r1.close();
			r2.close();
			s.close();
			s1.close();
		}
		return true;
	}

	void updateForLab(int id, int l, int d) throws SQLException {
		Statement s = connect.createStatement();
		Statement s4 = connect.createStatement(), s2 = connect.createStatement(), s3 = connect.createStatement();
		ResultSet r1 = null;
		try {
			connect.setAutoCommit(true);
			for (int i = 0; i < l; i++) {
				r1 = s.executeQuery("select * from lab where TLab_id=" + (id + i));

				while (r1.next()) {
					int f = r1.getInt("slot");
					int h = r1.getInt("TLab_id");
					int z = r1.getInt("lab_id"), x = r1.getInt("class_id"), q = r1.getInt("teacher_id");
					for (int j = d; j < (d + f); j++) {

						s2.executeUpdate("update teacher set slot" + j + "=" + h + " where teacher_id=" + q);
						s3.executeUpdate("update labd set slot" + j + "=" + h + " where lab_id=" + z);
						s4.executeUpdate("update class set slot" + j + "=" + h + " where class_id=" + x);

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			r1.close();
			s.close();
			s2.close();
			s3.close();
			s4.close();
		}
	}

	boolean checkLab(int id, int l, int d) throws SQLException {
		// TODO Auto-generated method stub
		Statement s = connect.createStatement();
		Statement s4 = connect.createStatement(), s2 = connect.createStatement(), s3 = connect.createStatement();

		ResultSet r1 = null, r2 = null, r3 = null, r4 = null;
		try {
			for (int i = 0; i < l; i++) {

				r1 = s.executeQuery("select * from lab where TLab_id=" + (id + i));
				while (r1.next()) {

					int x = r1.getInt("lab_id");
					int v = r1.getInt("slot");
					int z = r1.getInt("class_id");
					r2 = s2.executeQuery("select * from teacher where teacher_id=" + r1.getInt("teacher_id"));
					r3 = s3.executeQuery("select * from LabD where lab_id=" + x);
					r4 = s4.executeQuery("select * from class where class_id=" + z);
					while ((r2.next() && r3.next() && r4.next())) {

						for (int y = d; y < (d + v) && y <= (36 - v); y++) {

							int a = r2.getInt("slot" + y);
							int b = r3.getInt("slot" + y);
							int c = r4.getInt("slot" + y);
							if (a != 0 || b != 0 || c != 0) {

								return false;
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			r1.close();
			r2.close();
			r3.close();
			r4.close();
		}
		return true;
	}

	void reset(String tab) {
		ResultSet r1 = null;
		try {
			Statement s = connect.createStatement();
			r1 = s.executeQuery("select * from " + tab);
			while (r1.next()) {
				for (int i = 1; i <= 36; i++) {
					s.executeUpdate("update " + tab + " set slot" + i + "=0");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	int getNumberOfLab(int int1) throws SQLException {

		// TODO Auto-generated method stub
		ResultSet r1 = null;
		int y = 0;
		try {
			Statement s = connect.createStatement();

			r1 = s.executeQuery("select number_of_labs from Class where class_id=" + int1);
			while (r1.next())
				y = r1.getInt("number_of_labs");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			r1.close();
		}

		return y;
	}
}
