package com.asisinfo.common.jdbc.commquery;

import java.util.*;
import java.sql.*;
import java.io.*;
import java.net.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

import com.asisinfo.common.jdbc.*;
import com.asisinfo.common.jdbc.commsave.*;

public class CommQuery {
	private Document xmlDoc;

	private int maxRecNo = Integer.MAX_VALUE; // 100;

	private File f;

	public void init(String fileName) throws Exception {
		f = new File(fileName);
		// File f = new File("commonQueryConfig.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		FileInputStream fileInputStream = new FileInputStream(f);
		this.xmlDoc = builder.parse(new InputSource(fileInputStream));
		fileInputStream.close();
	}

	public String getConfigXml() throws Exception {
		RandomAccessFile ra = new RandomAccessFile(f, "r");
		long i = ra.length();
		byte[] bs = new byte[Integer.parseInt(String.valueOf(i))];
		ra.read(bs);
		String s = new String(bs);
		ra.close();
		return s;
	}

	public String queryOptions(String condXml, Connection connection)
			throws Exception {
		Document condDoc = this.getDocumentOf(condXml);
		String busiId = XmlAid.getAttributeOf(condDoc.getDocumentElement(),
			"code");
		String[] limits;

		Element[] limitNodes = XmlAid.getChildNodesOf(
			condDoc.getDocumentElement(), "parameter");
		limits = new String[limitNodes.length];
		for (int i = 0; i < limitNodes.length; i++) {
			limits[i] = XmlAid.getValueOf(limitNodes[i]);
		}

		return this.queryOptions(busiId, limits, connection);
	}

	public String querySingleRecord(String condXml, Connection connection)
			throws Exception {
		Document condDoc = this.getDocumentOf(condXml);
		String busiId = XmlAid.getAttributeOf(condDoc.getDocumentElement(),
			"table");
		String[] colNames;
		String[] colValues;

		Element[] colNodes = XmlAid.getChildNodesOf(
			condDoc.getDocumentElement(), "column");
		colNames = new String[colNodes.length];
		colValues = new String[colNodes.length];
		for (int i = 0; i < colNodes.length; i++) {
			colNames[i] = XmlAid.getAttributeOf(colNodes[i], "name");
			colValues[i] = XmlAid.getValueOf(XmlAid.getChildNodeOf(colNodes[i],
				"Value"));
		}

		return this.querySingleRecord(busiId, colNames, colValues, connection);
	}

	public String queryRecords(String condXml, Connection connection)
			throws Exception {
		Document condDoc = this.getDocumentOf(condXml);
		String busiId = XmlAid.getAttributeOf(condDoc.getDocumentElement(),
			"table");
		String[] colNames;
		String[] colValues;

		Element[] colNodes = XmlAid.getChildNodesOf(
			condDoc.getDocumentElement(), "column");
		colNames = new String[colNodes.length];
		colValues = new String[colNodes.length];
		for (int i = 0; i < colNodes.length; i++) {
			colNames[i] = XmlAid.getAttributeOf(colNodes[i], "name");
			colValues[i] = XmlAid.getValueOf(XmlAid.getChildNodeOf(colNodes[i],
				"Value"));
		}

		return this.queryRecords(busiId, colNames, colValues, connection);
	}

	public String exportRecords(String busiId, Connection connection)
			throws Exception {

		ArrayList valueNames = new ArrayList();
		// Vector isClobs = new Vector();
		Element procNode = XmlAid.getChildNodeOf(XmlAid.getChildNodeOf(
			this.xmlDoc.getDocumentElement(), "maintenance"), busiId);
		String tableName = XmlAid.getAttributeOf(procNode, "tableName");
		String selectClause = "select ";
		String fromClause = " from " + tableName + " ";
		Element[] colNodes = XmlAid.getChildNodesOf(procNode);
		boolean existColumn = false;
		boolean existCond = false;
		for (int i = 0; i < colNodes.length; i++) {
			String columnName = colNodes[i].getTagName(); // 字段名

			Element refNode = XmlAid.getChildNodeOf(colNodes[i], "ref"); // 引用节点
			if (refNode == null) { // 无引用
				valueNames.add(colNodes[i].getTagName());
				if (!existColumn) {
					selectClause += columnName;
					existColumn = true;
				}
				else {
					selectClause += "," + columnName;
				}
			}
		}

		String sql = selectClause + fromClause;
		// System.out.println("sql is:" + sql);
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		Vector datas = new Vector();

		TableStructure ts = DBSniffer.getTS(connection, tableName);

		while (rs.next()) {
			for (int i = 0; i < valueNames.size(); i++) {
				String valueName = (String) valueNames.get(i);

				String value = rs.getString(valueName);
				if (this.isClobColumn(ts, valueName)) {
					value = this.readClob(rs, valueName);
				}
				if (this.isDateColumn(ts, valueName)) {
					value = value.substring(0, 10);
				}
				datas.addElement(value);
			}
		}
		return this.getExportResult(tableName, valueNames, datas);
	}

	private Document getDocumentOf(String xml) throws Exception {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new InputSource(new StringReader(
					xml)));
			document.normalize();
			return document;
		}
		catch (Exception e) {
			throw new Exception("查询参数condXml不符合XML规范！" + e.toString());
		}
	}

	private String queryOptions(String busiId, String[] limits,
			Connection connection) throws Exception {
		Element optionBusiNode = XmlAid.getChildNodeOf(XmlAid.getChildNodeOf(
			this.xmlDoc.getDocumentElement(), "option"), busiId);

		String sql = "select ";
		if (optionBusiNode == null) { // 是固定参数
			sql += "vc_valueId, vc_valueName from guip0_inf_busiDetail where vc_busiId = '"
					+ busiId + "'";

			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String rtXml = "<Items>";
			while (rs.next()) {
				rtXml += "<Item>";
				String valueId = rs.getString("vc_valueId");
				rtXml += "<id><![CDATA[" + valueId + "]]></id>";
				String valueName = rs.getString("vc_valueName");
				rtXml += "<name><![CDATA[" + valueName + "]]></name>";
				rtXml += "</Item>";
			}
			rtXml += "</Items>";
			// System.out.println("==============="+rtXml);
			return rtXml;
		}
		else { // 是外键
			sql += " " + XmlAid.getAttributeOf(optionBusiNode, "idColumnName")
					+ " ";
			sql += ", "
					+ XmlAid.getAttributeOf(optionBusiNode, "descColumnName")
					+ " ";

			String tableName = XmlAid.getAttributeOf(optionBusiNode,
				"tableName");
			sql += " from " + tableName + " ";

			Element[] optionLimitColumnNameNodes = XmlAid.getChildNodesOf(optionBusiNode);
			for (int i = 0; i < optionLimitColumnNameNodes.length; i++) { // 处理每个limitColumnName
				// 处理where子句
				if (i == 0) {
					sql += " where "
							+ XmlAid.getValueOf(optionLimitColumnNameNodes[i])
							+ "= ? ";
				}
				else {
					sql += " and "
							+ XmlAid.getValueOf(optionLimitColumnNameNodes[i])
							+ "= ? ";
				}
			}
			// System.out.println(sql);
			TableStructure tableStructure = DBSniffer.getTS(connection,
				tableName);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			for (int i = 0; i < optionLimitColumnNameNodes.length; i++) { // 给每个limit赋值
				int columnType = tableStructure.getColumnType(XmlAid.getValueOf(optionLimitColumnNameNodes[i]));
				this.setPstmtValue(pstmt, i + 1, columnType, limits[i]);
			}
			ResultSet rs = pstmt.executeQuery();
			String rtXml = "<Items>";

			for (; rs.next();) {
				rtXml += "<Item>";
				String valueId = rs.getString(XmlAid.getAttributeOf(
					optionBusiNode, "idColumnName"));
				rtXml += "<id><![CDATA[" + valueId + "]]></id>";
				String valueName = rs.getString(XmlAid.getAttributeOf(
					optionBusiNode, "descColumnName"));
				rtXml += "<name><![CDATA[" + valueName + "]]></name>";
				rtXml += "</Item>";

			}

			rtXml += "</Items>";
			// System.out.println("==============="+rtXml);
			return rtXml;
		}
	}

	private String querySingleRecord(String busiId, String[] colNames,
			String[] colValues, Connection connection) throws Exception {

		Vector valueNames = new Vector();
		Element procNode = XmlAid.getChildNodeOf(XmlAid.getChildNodeOf(
			this.xmlDoc.getDocumentElement(), "maintenance"), busiId);
		String tableName = XmlAid.getAttributeOf(procNode, "tableName");
		String selectClause = "select ";
		String fromClause = " from " + tableName + " ";
		String whereClause = " ";
		Element[] colNodes = XmlAid.getChildNodesOf(procNode);
		boolean existColumn = false;
		boolean existCond = false;
		for (int i = 0; i < colNodes.length; i++) {
			String columnName = colNodes[i].getTagName(); // 字段名

			Element refNode = XmlAid.getChildNodeOf(colNodes[i], "ref"); // 引用节点
			if (refNode == null) { // 无引用
				valueNames.addElement(colNodes[i].getTagName());
				if (!existColumn) {
					selectClause += columnName;
					existColumn = true;
				}
				else {
					selectClause += "," + columnName;
				}
			}
		}

		for (int i = 0; i < colNames.length; i++) {
			if (!existCond) {
				whereClause += " where " + colNames[i] + "=? ";
				existCond = true;
			}
			else {
				whereClause += " and " + colNames[i] + "=? ";
			}
		}

		String sql = selectClause + fromClause + whereClause;
		// System.out.println("sql is:" + sql);
		TableStructure ts = DBSniffer.getTS(connection, tableName);
		PreparedStatement pstmt = connection.prepareStatement(sql);
		for (int i = 0; i < colNames.length; i++) {
			int columnType = ts.getColumnType(colNames[i]);
			this.setPstmtValue(pstmt, i + 1, columnType, colValues[i]);
		}
		ResultSet rs = pstmt.executeQuery();
		String rtXml = "<" + tableName + ">";
		if (rs.next()) {
			for (int i = 0; i < valueNames.size(); i++) {
				String valueName = (String) valueNames.elementAt(i);
				String value = rs.getString(valueName);
				if (value != null) {
					if (this.isClobColumn(ts, valueName)) {
						value = this.readClob(rs, valueName);
					}
					if (this.isDateColumn(ts, valueName)) {
						value = value.substring(0, 10);
					}
				}
				else {
					value = "";
				}
				rtXml += "<" + (String) valueNames.elementAt(i) + "><![CDATA["
						+ value + "]]></" + (String) valueNames.elementAt(i)
						+ ">";
			}
		}
		rtXml += "</" + tableName + ">";
		// System.out.println("==============="+rtXml);
		return rtXml;
	}

	private String queryRecords(String busiId, String[] colNames,
			String[] colValues, Connection connection) throws Exception {
		ArrayList headNames = new ArrayList();
		ArrayList keyNames = new ArrayList();
		ArrayList valueNames = new ArrayList();
		Element procNode = XmlAid.getChildNodeOf(XmlAid.getChildNodeOf(
			this.xmlDoc.getDocumentElement(), "maintenance"), busiId);
		String tableName = XmlAid.getAttributeOf(procNode, "tableName");
		String selectClause = "select ";
		String fromClause = " from " + tableName + " ";
		String whereClause = " ";
		String orderClause = " ";
		Element[] colNodes = XmlAid.getChildNodesOf(procNode);
		boolean existColumn = false;
		boolean existCond = false;
		boolean existOrder = false;
		int tableCount = 0;
		for (int i = 0; i < colNodes.length; i++) {
			String columnName = colNodes[i].getTagName(); // 字段名
			// System.out.println(columnName);
			Element refNode = XmlAid.getChildNodeOf(colNodes[i], "ref"); // 引用节点
			boolean isPk = false;
			if (refNode == null) {
				isPk = DBSniffer.isPK(connection, tableName, columnName);
				if (isPk) {
					keyNames.add(columnName);
				}
			}

			Element headNameNode = XmlAid.getChildNodeOf(colNodes[i],
				"headName"); // 标题节点
			if (headNameNode != null) {
				headNames.add(columnName);
				headNames.add(XmlAid.getValueOf(headNameNode));
			}

			Element orderNode = XmlAid.getChildNodeOf(colNodes[i], "order"); // 排序
			if (orderNode != null) {
				if (!existOrder) {
					orderClause += " order by " + tableName + "." + columnName
							+ " " + XmlAid.getValueOf(orderNode);
					existOrder = true;
				}
				else {
					orderClause += "," + tableName + "." + columnName + " "
							+ XmlAid.getValueOf(orderNode);
				}
			}

			if (isPk || headNameNode != null) { // 是主键 或者 有headName
				valueNames.add(colNodes[i].getTagName());

				if (refNode == null) { // 无引用
					if (!existColumn) {
						selectClause += tableName + "." + columnName;
						existColumn = true;
					}
					else {
						selectClause += "," + tableName + "." + columnName;
					}
				}
				else { // 有引用
					String busiName = XmlAid.getAttributeOf(refNode, "busiName"); // 引用的业务名
					// 引用的业务节点
					Element optionBusiNode = XmlAid.getChildNodeOf(
						XmlAid.getChildNodeOf(this.xmlDoc.getDocumentElement(),
							"option"), busiName);

					if (optionBusiNode == null) { // 是固定参数
						String tableAlias = "guip0_inf_busiDetail" + tableCount;
						tableCount++;

						fromClause += ",guip0_inf_busiDetail " + tableAlias;
						if (!existColumn) {
							selectClause += tableAlias + ".vc_valueName "
									+ columnName;
							existColumn = true;
						}
						else {
							selectClause += "," + tableAlias + ".vc_valueName "
									+ columnName;
						}

						String valueIdColumn = XmlAid.getAttributeOf(refNode,
							"valueIdColumn");
						if (!existCond) {
							whereClause += " where " + tableAlias
									+ ".vc_busiId ='" + busiName + "' ";
							whereClause += " and " + tableName + "."
									+ valueIdColumn + "=" + tableAlias
									+ ".vc_valueId ";
							existCond = true;
						}
						else {
							whereClause += " and " + tableAlias
									+ ".vc_busiId ='" + busiName + "' ";
							whereClause += " and " + tableName + "."
									+ valueIdColumn + "=" + tableAlias
									+ ".vc_valueId ";
						}
					}
					else { // 是外键
						String refTableName = XmlAid.getAttributeOf(
							optionBusiNode, "tableName");
						// System.out.println(optionBusiNode + refTableName
						// +"|"+ refNode);
						String refTableAlias = refTableName + tableCount; // 给关联的表取别名
						tableCount++;

						fromClause += "," + refTableName + " " + refTableAlias; // 处理from子句
						Element[] procLimitColumnNameNodes = XmlAid.getChildNodesOf(refNode);
						Element[] optionLimitColumnNameNodes = XmlAid.getChildNodesOf(optionBusiNode);
						// System.out.println(procLimitColumnNameNodes.length);
						for (int j = 0; j < procLimitColumnNameNodes.length; j++) { // 处理每个limitColumnName
							if (j == procLimitColumnNameNodes.length - 1) { // 是最后一个
								// 处理select子句
								if (!existColumn) {
									selectClause += " "
											+ refTableAlias
											+ "."
											+ XmlAid.getAttributeOf(
												optionBusiNode,
												"descColumnName") + " "
											+ columnName + "";
									existColumn = true;
								}
								else {
									selectClause += " ,"
											+ refTableAlias
											+ "."
											+ XmlAid.getAttributeOf(
												optionBusiNode,
												"descColumnName") + " "
											+ columnName + "";
								}

								// 处理where子句
								if (!existCond) {
									whereClause += " where "
											+ tableName
											+ "."
											+ XmlAid.getValueOf(procLimitColumnNameNodes[j])
											+ "="
											+ refTableAlias
											+ "."
											+ XmlAid.getAttributeOf(
												optionBusiNode, "idColumnName")
											+ " ";
									existCond = true;
								}
								else {
									whereClause += " and "
											+ tableName
											+ "."
											+ XmlAid.getValueOf(procLimitColumnNameNodes[j])
											+ "="
											+ refTableAlias
											+ "."
											+ XmlAid.getAttributeOf(
												optionBusiNode, "idColumnName")
											+ " ";
								}
							}
							else { // 不是最后一个
								// 处理where子句
								if (!existCond) {
									whereClause += " where "
											+ tableName
											+ "."
											+ XmlAid.getValueOf(procLimitColumnNameNodes[j])
											+ "="
											+ refTableAlias
											+ "."
											+ XmlAid.getValueOf(optionLimitColumnNameNodes[j])
											+ " ";
									existCond = true;
								}
								else {
									whereClause += " and "
											+ tableName
											+ "."
											+ XmlAid.getValueOf(procLimitColumnNameNodes[j])
											+ "="
											+ refTableAlias
											+ "."
											+ XmlAid.getValueOf(optionLimitColumnNameNodes[j])
											+ " ";
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < colNames.length; i++) {
			if (!existCond) {
				whereClause += " where " + tableName + "." + colNames[i]
						+ "=? ";
				existCond = true;
			}
			else {
				whereClause += " and " + tableName + "." + colNames[i] + "=? ";
			}
		}

		String sql = selectClause + fromClause + whereClause + orderClause;
		System.out.println("sql is:" + sql);
		PreparedStatement pstmt = connection.prepareStatement(sql);
		TableStructure tableStructure = DBSniffer.getTS(connection, tableName);
		for (int i = 0; i < colNames.length; i++) {
			int columnType = tableStructure.getColumnType(colNames[i]);
			this.setPstmtValue(pstmt, i + 1, columnType, colValues[i]);
		}
		ResultSet rs = pstmt.executeQuery();
		ArrayList datas = new ArrayList();

		int[] valueType = new int[valueNames.size()];
		for (int i = 0; i < valueNames.size(); i++) {
			String valueName = (String) valueNames.get(i);
			int columnType = 0;
			try {
				columnType = tableStructure.getColumnType(valueName);
			}
			catch (NoColumnException ex) {
				columnType = java.sql.Types.OTHER;
			}
			valueType[i] = columnType;
		}

		for (; rs.next();) {
			for (int i = 0; i < valueNames.size(); i++) {
				String valueName = (String) valueNames.get(i);
				// System.out.println(valueName);
				String value = rs.getString(valueName);
				if (value != null) {
					if (valueType[i] == java.sql.Types.CLOB) {
						value = this.readClob(rs, valueName);
					}
					if (valueType[i] == java.sql.Types.DATE
							|| valueType[i] == java.sql.Types.TIMESTAMP) {
						value = value.substring(0, 10);
					}
				}
				datas.add(value);
			}
		}

		return getRecordsResult(tableName, headNames, keyNames, valueNames,
			datas);
	}

	private boolean isDateColumn(TableStructure ts, String column)
			throws Exception {
		try {
			int columnType = ts.getColumnType(column);
			return (columnType == java.sql.Types.DATE || columnType == java.sql.Types.TIMESTAMP);
		}
		catch (NoColumnException e) {
			return false;
		}
	}

	private boolean isClobColumn(TableStructure ts, String column)
			throws Exception {
		try {
			int columnType = ts.getColumnType(column);

			return (columnType == java.sql.Types.CLOB);
		}
		catch (NoColumnException e) {
			return false;
		}
	}

	public String readClob(ResultSet rs, String colName) throws Exception {
		java.io.InputStream r1 = rs.getAsciiStream(colName);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[128];
		for (int read = -1; (read = r1.read(buf)) != -1;) {
			baos.write(buf, 0, read);
		}
		return baos.toString();
	}

	private String getRecordsResult(String tableName, ArrayList headNames,
			ArrayList keyNames, ArrayList valueNames, ArrayList datas) {
		StringBuffer rtXml = new StringBuffer(4 * 1024);
		// rtXml.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
		rtXml.append("<data>");
		rtXml.append("<headName>");
		for (int i = 0; i < headNames.size() / 2; i++) {
			rtXml.append("<" + (String) headNames.get(i * 2) + "><![CDATA[");
			rtXml.append((String) headNames.get(i * 2 + 1));
			rtXml.append("]]></" + (String) headNames.get(i * 2) + ">");
		}
		rtXml.append("</headName>");

		rtXml.append("<keyNames>");
		for (int i = 0; i < keyNames.size(); i++) {
			rtXml.append("<keyName><![CDATA[");
			rtXml.append((String) keyNames.get(i));
			rtXml.append("]]></keyName>");
		}
		rtXml.append("</keyNames>");

		rtXml.append("<content>");
		for (int i = 0, size = datas.size() / valueNames.size(); i < size; i++) {
			rtXml.append("<" + tableName + ">");
			for (int j = 0; j < valueNames.size(); j++) {
				rtXml.append("<" + (String) valueNames.get(j) + "><![CDATA[");
				rtXml.append((String) datas.get(i * valueNames.size() + j));
				rtXml.append("]]></" + (String) valueNames.get(j) + ">");
			}
			rtXml.append("</" + tableName + ">");
		}
		rtXml.append("</content>");

		rtXml.append("</data>");
		// System.out.println("==============="+rtXml);
		return rtXml.toString();
	}

	private String getExportResult(String tableName, List valueNames, List datas) {
		String rtXml = "<data>";

		rtXml += "<content>";
		for (int i = 0; i < datas.size() / valueNames.size(); i++) {
			rtXml += "<" + tableName + ">";
			for (int j = 0; j < valueNames.size(); j++) {
				rtXml += "<" + (String) valueNames.get(j) + "><![CDATA[";
				rtXml += (String) datas.get(i * valueNames.size() + j);
				rtXml += "]]></" + (String) valueNames.get(j) + ">";
			}
			rtXml += "</" + tableName + ">";
		}
		rtXml += "</content>";

		rtXml += "</data>";
		// System.out.println("==============="+rtXml);
		return rtXml;
	}

	private void setPstmtValue(PreparedStatement pstmt, int position,
			int columnType, String columnValue) throws Exception {

		if (columnType == java.sql.Types.CHAR
				|| columnType == java.sql.Types.LONGVARCHAR
				|| columnType == java.sql.Types.VARCHAR) {
			if (columnValue == null || columnValue.trim().equals("")) {
				pstmt.setNull(position, Types.VARCHAR);
			}
			else {
				pstmt.setString(position, columnValue);
			}
		}
		if (columnType == java.sql.Types.DATE
				|| columnType == java.sql.Types.TIMESTAMP) {
			if (columnValue == null || columnValue.trim().equals("")) {
				pstmt.setNull(position, Types.DATE);
			}
			else {
				try {
					java.sql.Timestamp dt = java.sql.Timestamp.valueOf(columnValue.trim());
					pstmt.setTimestamp(position, dt);
				}
				catch (Exception ex) {
					java.sql.Date dt = java.sql.Date.valueOf(columnValue.trim());
					pstmt.setDate(position, dt);
				}
				// System.out.println(dt.toString());
			}
		}
		if (columnType == java.sql.Types.CLOB) {
			// String data = URLEncoder.encode( columnValue );
			String data = columnValue;
			ByteArrayInputStream bisData = new ByteArrayInputStream(
					data.getBytes());
			pstmt.setAsciiStream(position, bisData, bisData.available());
		}
		if (columnType == java.sql.Types.DECIMAL
				|| columnType == java.sql.Types.NUMERIC
				|| columnType == java.sql.Types.FLOAT) {
			if (columnValue == null || columnValue.trim().equals("")) {
				pstmt.setNull(position, Types.FLOAT);
			}
			else {
				pstmt.setFloat(position, Float.parseFloat(columnValue));
			}
		}
		if (columnType == java.sql.Types.INTEGER
				|| columnType == java.sql.Types.SMALLINT) {
			if (columnValue == null || columnValue.trim().equals("")) {
				pstmt.setNull(position, Types.INTEGER);
			}
			else {
				pstmt.setInt(position, Integer.parseInt(columnValue));
			}
		}
	}

	public static void main(String[] args) throws Exception {
//		CommQuery cq = new CommQuery();
//		Connection con = treeapplet.Database.getConnection();
//		String conXml = "<?xml version='1.0' encoding='GB2312'?><query table='kpi_type'></query>";
//		cq.init("F:\\boss_front\\commonQueryConfig.xml");
//		System.out.println(cq.queryRecords(conXml, con));
	}

}
