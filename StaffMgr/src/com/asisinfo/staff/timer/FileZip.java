package com.asisinfo.staff.timer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileZip {

	public static void main(String[] args) throws Exception {
		zip("E:/students", "E:/students.zip");
	}

	/**
	 * ѹ��Ŀ¼
	 * @param dir ��Ҫѹ����Ŀ¼
	 * @param outZip ����ѹ���ļ�ȫ��
	 * @throws Exception
	 */
	public static void zip(String dir, String outZip) throws Exception {
		File dirFile = new File(dir);
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outZip));
		zip(out, dirFile, null);
		out.close();
	}

	public static void zip(ZipOutputStream out, File dir, String base)
			throws Exception {
		if (dir.isDirectory()) {
			File[] fc = dir.listFiles();
			if (base != null)
				out.putNextEntry(new ZipEntry(base + "/"));
			base = base == null ? "" : base + "/";
			for (int i = 0; i < fc.length; i++) {
				zip(out, fc[i], base + fc[i].getName());
			}
		} else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(dir);
			int b;
			while ((b = in.read()) != -1)
				out.write(b);
			in.close();
		}
	}
}
