package com.asisinfo.common;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.*;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.dom4j.*;
import java.text.*;

/**
 * 
 * @author chenhm
 * @created 2006-10-20 ����05:41:06
 * @version 1.0
 */
public class DBsyn {
	static Logger logger = Logger.getLogger(DBsyn.class);

	private static String cfg = "DBTasks.xml";

	public void init() {
		logger.debug("configPath:" + cfg);
		Document doc = null;
		try {
			doc = new SAXReader().read(cfg);
		}
		catch (Exception ex) {
			logger.fatal(ex);
			System.exit(-1);
		}
		Timer taskTimer = new Timer();
		List tasks = doc.selectNodes("tasks/task");
		for (int i = 0; i < tasks.size(); i++) {
			Element task = (Element) tasks.get(i);
			long period = 0L;
			try {
				period = Long.parseLong(task.attributeValue("period"));
			}
			catch (Exception ex1) {
				logger.error("parsePeriod error,skip this task.");
				continue;
			}
			period = period * 60 * 1000;
			Date next = null;
			try {
				String firsttime = task.attributeValue("time").trim();
				if ("now".equals(firsttime)) {
					next = new Date();
				}
				else {
					SimpleDateFormat year2day = new java.text.SimpleDateFormat(
							"yyyyMMdd");
					SimpleDateFormat year2min = new java.text.SimpleDateFormat(
							"yyyyMMddHH:mm");
					Date now = new Date();
					next = year2min.parse(year2day.format(now) + firsttime);
					if (next.getTime() < now.getTime()) {
						next = new Date(next.getTime() + 86400000L);
					}
				}
			}
			catch (ParseException ex2) {
			}

			String exportdb = task.element("export").attributeValue("db");
			String importdb = task.element("import").attributeValue("db");

			String exportsql = task.elementText("export");
			String importsql = task.elementText("import");

			DayTask taskThread = new DayTask(exportdb, importdb, exportsql,
					importsql);
			taskTimer.schedule(taskThread, next, period);
		}
		logger.info("Synchronize Server Start Successful.");
	}

	private static Connection getConnectionFromXML(String name)
			throws Exception {
		Connection connection = null;
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(cfg);
		org.dom4j.Element node = (org.dom4j.Element) doc.selectSingleNode("/tasks/resource[@id='"
				+ name + "']");
		String url = node.attributeValue("url");
		Class.forName(node.attributeValue("JDBCProvider")).newInstance();
		List PropertiesList = node.selectNodes("resourceProperties");
		java.util.Properties prop = new Properties();
		for (int i = 0; i < PropertiesList.size(); i++) {
			org.dom4j.Element p = (org.dom4j.Element) PropertiesList.get(i);
			prop.setProperty(p.attributeValue("name"),
				p.attributeValue("value"));
			// System.out.println(p.attributeValue("name")+","+p.attributeValue("value"));
		}
		connection = DriverManager.getConnection(url, prop);
		return connection;
	}

	public static void main(String args[]) throws Exception {
		String resource = "log.properties";

		// URL configFileResource = HttpDownload.class.getResource(resource);
		PropertyConfigurator.configure(resource);

		logger.info("DB Synchronize Server Start...");
		DBsyn hd = new DBsyn();
		hd.init();
	}

	/**
	 * ÿ��ִ�е�����
	 * 
	 * @author chenhm
	 * @version 1.0
	 */
	class DayTask extends TimerTask {
		private String exportdb, importdb, exportsql, importTable;

		public DayTask(String exportdb, String importdb, String exportsql,
				String importsql) {
			this.exportdb = exportdb;
			this.importdb = importdb;
			this.exportsql = exportsql;
			this.importTable = importsql;
		}

		public void run() {
			Connection exdb = null;
			Connection imdb = null;
			Statement st = null;
			PreparedStatement pst = null;
			try {
				exdb = DBsyn.getConnectionFromXML(exportdb);
				imdb = DBsyn.getConnectionFromXML(importdb);

				st = exdb.createStatement();
				ResultSet rs = st.executeQuery(exportsql);
				ResultSetMetaData rsmd = rs.getMetaData();

				pst = imdb.prepareStatement("delete from " + importTable);
				pst.execute();
				pst.close();

				String importsql = "insert into " + importTable + " values(";
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					importsql += "?,";
				}
				importsql = importsql.substring(0, importsql.length() - 1)
						+ ")";
				pst = imdb.prepareStatement(importsql);

				Statement stim = imdb.createStatement();
				int count = 0;
				while (rs.next()) {
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						int type = rsmd.getColumnType(i);
						if (rs.getObject(i) == null) {
							pst.setNull(i, type);
						}
						else if(rsmd.getColumnName(i).equalsIgnoreCase("vc_comment")){
							//�����ֶγ��ȶ��岻һ�£��ᵼ������쳣���˴����Ը��ֶΡ�
							pst.setNull(i,type);
						}
						else {
							pst.setObject(i, rs.getObject(i), type);
						}
					}
					pst.execute();
					count++;
				}
				logger.info("Table " + importTable + " updated " + count
						+ " rows");

			}
			catch (Exception e) {
//				e.printStackTrace();
				logger.error(e.getMessage(),e);
			}
			finally {
				if (st != null) {
					try {
						st.close();
					}
					catch (SQLException e) {
					}
				}
				if (exdb != null) {
					try {
						exdb.close();
					}
					catch (SQLException e) {
					}
				}

				if (pst != null) {
					try {
						pst.close();
					}
					catch (SQLException e) {
					}
				}
				if (imdb != null) {
					try {
						imdb.close();
					}
					catch (SQLException e) {
					}
				}
			}
		}
	}

}
