/**
 * 
 */
package com.gmcc.pboss.common.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.FileCopyUtils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * ���˹�˾Ӫ�˿�����
 * @author yuwenjun
 * @date 2010-06-10
 * @update 2010-06-10
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż�
 * ������������ - �ļ���������
 */
public class FileOperator {
	protected static final Log logger = LogFactory.getLog(FileOperator.class); 
	/**
	 * ɾ���ļ����ļ���
	 * 
	 * @param path
	 *            Ҫɾ���ĸ�Ŀ¼�µ��ļ�
	 * @param fileName
	 *            Ҫɾ�����ļ����ļ�����
	 *            <P>
	 *            (Last modified time:2007-1-5 ����11:26:42 )
	 */
	public static void delFileORFolder(String path, String fileName) {

		File file = new File(path, fileName);
		if (file == null)
			return;
		if (file.isFile())
			delFile(file);
		if (file.isDirectory())
			delFolder(file);

	}

	/**
	 * �����ļ����ļ���
	 * 
	 * @param path
	 *            �����Ƶ��ļ�����·��
	 * @param oldName
	 *            Դ�ļ���
	 * @param copyName
	 *            Ҫ���Ƴɵ��ļ���
	 *            <P>
	 *            (Last modified time:2007-1-5 ����02:53:20 )
	 */
	public static void copyFile(String path, String srcName, String copyName) {
		File srcFile = new File(path, srcName);
		File copyFile = new File(path, copyName);
		if (srcFile.isFile()) {
			copyOneFile(srcFile, copyFile);
		} else if (srcFile.isDirectory()) {
			copyFolder(srcFile, copyFile);
		} else {
			System.out.println("�����ļ�����==�޷��ж�");
		}

	}

	/**
	 * �������ļ����ļ���
	 * 
	 * @param path
	 *            �����Ƶ��ļ�����·��
	 * @param oldName
	 *            ԭ�ļ���
	 * @param newName
	 *            ���ļ���
	 * @return
	 *            <P>
	 *            (Last modified time:2007-1-5 ����02:53:26 )
	 */
	public static boolean renameFile(String path, String oldName, String newName) {
		File oldFile = new File(path, oldName);
		File newFile = new File(path, newName);
		boolean success = oldFile.renameTo(newFile);
		return success;
	}

	/**
	 * ɾ���ļ�
	 * 
	 * @param filePathAndName
	 *            �ı��ļ���������·�����ļ���
	 * @return Boolean �ɹ�ɾ������true�����쳣����false
	 */
	public static void delFile(File filePathAndName) {
		try {
			File myDelFile = filePathAndName;
			if (myDelFile.exists())
				myDelFile.delete();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * ɾ���ļ���
	 * 
	 * @param folderPath
	 *            �ļ�����������·��
	 * @return
	 */
	public static void delFolder(File folderPath) {
		try {
			delAllFile(folderPath); // ɾ����������������

			folderPath.delete(); // ɾ�����ļ���
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ɾ��ָ���ļ����������ļ�
	 * 
	 * @param path
	 *            �ļ�����������·��
	 * @return
	 * @return
	 */
	public static boolean delAllFile(File path) {
		boolean bea = false;

		if (!path.exists()) {
			return bea;
		}
		if (!path.isDirectory()) {// ����Ŀ¼
			return bea;
		}
		String[] tempList = path.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {

			temp = new File(path, tempList[i]);

			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(temp);// ��ɾ���ļ���������ļ�
				delFolder(temp);// ��ɾ�����ļ���
				bea = true;
			}
		}
		return bea;
	}

	/**
	 * ���Ƶ����ļ�
	 * 
	 * @param oldPathFile
	 *            ׼�����Ƶ��ļ�Դ
	 * @param newPathFile
	 *            ���������ļ�
	 * @return
	 */
	public static void copyOneFile(File oldPathFile, File newPathFile) {
		try {
			int bytesum = 0;
			int byteread = 0;
			// File oldfile = new File(oldPathFile);
			if (oldPathFile.exists() && !newPathFile.exists()) { // ԭ�ļ�����,���ļ�������ʱ
				FileCopyUtils.copy(oldPathFile, newPathFile);
//				InputStream inStream = new FileInputStream(oldPathFile); // ����ԭ�ļ�
//				FileOutputStream output = new FileOutputStream(newPathFile);
//				byte[] buffer = new byte[512000];// �̶��������Ĵ�С, ���⻺����ռ��̫���ڴ�
//
//				while ((byteread = inStream.read(buffer)) != -1) {
//					bytesum += byteread; // �ֽ��� �ļ���С
//					output.write(buffer, 0, byteread);
//				}
////				System.out.println("���Ƶ����ļ�,size=" + bytesum);
//				output.flush();
//				output.close();
//				inStream.close();
			}
		} catch (Exception e) {
			logger.error("���Ƶ����ļ���������" + e.getMessage());
//			throws e;
		}
	}

	/**
	 * ���������ļ��е�����
	 * 
	 * @param oldPath
	 *            ׼��������Ŀ¼
	 * @param newPath
	 *            ָ������·������Ŀ¼
	 * @return
	 */
	public static void copyFolder(File oldPath, File newPath) {
		try {
			newPath.mkdirs(); // ����ļ��в����� �������ļ���
			String[] file = oldPath.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				temp = new File(oldPath, file[i]);

				if (temp.isFile()) {
					File copyToPathFile = new File(newPath, temp.getName());
					copyOneFile(temp, copyToPathFile);
				}
				if (temp.isDirectory()) {// ��������ļ���
					copyFolder(new File(oldPath, file[i]), new File(newPath,
							file[i]));
				}
			}
		} catch (Exception e) {
			logger.error("���������ļ������ݲ�������" + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * ѹ���ļ�
	 * 
	 * @param srcfile
	 *            File[] ��Ҫѹ�����ļ��б�
	 * @param zipfile
	 *            File ѹ������ļ�
	 */
	public static void zipFiles(java.io.File[] srcfile, java.io.File zipfile) {
		byte[] buf = new byte[1024];
		try {
			// Create the ZIP file
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
					zipfile));
			// Compress the files
			for (int i = 0; i < srcfile.length; i++) {
				FileInputStream in = new FileInputStream(srcfile[i]);
				// Add ZIP entry to output stream.
				out.putNextEntry(new ZipEntry(srcfile[i].getName()));
				// Transfer bytes from the file to the ZIP file
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				// Complete the entry
				out.closeEntry();
				in.close();
			}
			// Complete the ZIP file
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ѹ��
	 * 
	 * @param zipfile
	 *            File ��Ҫ��ѹ�����ļ�
	 * @param descDir
	 *            String ��ѹ���Ŀ��Ŀ¼(һ���ǽ�ѹ��zipfile�ĵ�ǰ·��
	 */
	public static void unZipFiles(File zipFile, String descDir) {
		if (descDir == null || descDir.equals(""))
			descDir = zipFile.getParent() + "/";

		try {

			int i = 0;
			String dirname = descDir;
			File newdir = new File(dirname);
			newdir.mkdir();

			byte[] c = new byte[1024];
			int slen;

			// ������Ŀ���ļ�����������
			ZipInputStream in = new ZipInputStream(new FileInputStream(zipFile));
			ZipEntry file = null;
			try {
				file = in.getNextEntry();
			} catch (IllegalArgumentException e) {// ��ȡ�����ļ�ʱ���ֵ��쳣
				file = in.getNextEntry();
			}
			while (file != null) {

				i = file.getName().replace('/', '\\').lastIndexOf('\\');
				if (i != -1) {
					File dirs = new File(dirname + File.separator
							+ file.getName().substring(0, i));
					dirs.mkdirs();
					dirs = null;
				}

				if (file.isDirectory()) {
					File dirs = new File(file.getName());
					dirs.mkdir();
					dirs = null;
				} else {
					FileOutputStream out = new FileOutputStream(dirname
							+ File.separator + file.getName());
					while ((slen = in.read(c, 0, c.length)) != -1)
						out.write(c, 0, slen);
					out.close();
				}
				try {
					file = in.getNextEntry();
				} catch (IllegalArgumentException e) {
					file = in.getNextEntry();
				}
			}
			in.close();
		} catch (ZipException zipe) {
			System.out.println("����һ��ZIP�ļ���,�ļ���ʽ����");
			zipe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("��ȡ" + zipFile + "ʱ����,�ļ���ȡ����");
			ioe.printStackTrace();

		}

	}

	/**
	 * ���ؽ�ѹ����ļ�·��
	 * 
	 * @param zipFile
	 * @param descDir
	 * @return
	 */
	public static List<String> unZip(File zipFile, String descDir) {
		List<String> filelist = new ArrayList<String>(10);

		if (descDir == null || descDir.equals(""))
			descDir = zipFile.getParent() + "/";

		try {

			int i = 0;
			String dirname = descDir;
			File newdir = new File(dirname);
			newdir.mkdir();

			byte[] c = new byte[1024];
			int slen;

			// ������Ŀ���ļ�����������
			ZipInputStream in = new ZipInputStream(new FileInputStream(zipFile));
			ZipEntry file = null;
			try {
				file = in.getNextEntry();
			} catch (IllegalArgumentException e) {// ��ȡ�����ļ�ʱ���ֵ��쳣
				file = in.getNextEntry();
			}
			while (file != null) {

				i = trans(file.getName()).replace('/', '\\').lastIndexOf('\\');
				if (i != -1) {
					File dirs = new File(dirname + File.separator
							+ trans(file.getName()).substring(0, i));
					dirs.mkdirs();
					dirs = null;
				}

				if (file.isDirectory()) {
					File dirs = new File(trans(file.getName()));
					dirs.mkdir();
					dirs = null;
				} else {
					String path = dirname + File.separator + trans(file.getName());
					filelist.add(path);
					FileOutputStream out = new FileOutputStream(path);
					while ((slen = in.read(c, 0, c.length)) != -1)
						out.write(c, 0, slen);
					out.close();
				}
				try {
					file = in.getNextEntry();
				} catch (IllegalArgumentException e) {
					file = in.getNextEntry();
				}
			}
			in.close();
		} catch (ZipException zipe) {
			System.out.println("����һ��ZIP�ļ���,�ļ���ʽ����");
			zipe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("��ȡ" + zipFile + "ʱ����,�ļ���ȡ����");
			ioe.printStackTrace();
		}
		return filelist;
	}

	public static boolean isZip(File zipFile) {
		ZipInputStream in = null;
		try {
			in = new ZipInputStream(new FileInputStream(zipFile));
			in.getNextEntry();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�������!");
			return false;
		} catch (IOException ioe) {
			System.out.println("�ϴ��ļ���ʽ����!");
			return false;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					
				}
			}
		}

	}

	public static String trans(String str) {
		try {
			String str8859 = new String(str.getBytes("8859_1"), "GB2312");
			return str8859;
		} catch (UnsupportedEncodingException ioe) {
			return str;
		}
	}

	public static final void resizeWithMaxSize(String picFrom, String picTo,
			int maxSize) throws IOException {
		File file_in = new File(picFrom);// �����ļ�

		Image src = ImageIO.read(file_in);

		int w = src.getWidth(null);
		int h = src.getHeight(null);
		// double scale = (double)w/h;

		int nw = maxSize;
		int nh = (nw * h) / w;
		if (nh > maxSize) {
			nh = maxSize;
			nw = (nh * w) / h;
		}
		BufferedImage tag = new BufferedImage(nw, nh,
				BufferedImage.TYPE_INT_RGB);
		tag.getGraphics().drawImage(src, 0, 0, nw, nh, null);// ������С���ͼ
		FileOutputStream out = new FileOutputStream(picTo);// ������ļ���
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(tag); // ��JPEG����
		out.close();

	}

	/**
	 * ��������ͼ
	 * 
	 * @param path
	 * @param fileName
	 * @modified: ��LiuPing(2008-1-31 ����09:24:23): <br>
	 */
	public static void reSize(String path, String fileName) {

		String picFrom = path + "/" + fileName;
		String picTo = path + "/sm_" + fileName;
		// �жϸ�ʽ�ܷ񴴽�
		try {
			FileOperator.resizeWithMaxSize(picFrom, picTo, 96);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
	public static String parseName(String gbkString) {
		try	{
            if (gbkString == null) {
                return null;
            }
      		String rStr = new String(gbkString.getBytes("GBK"), "ISO8859_1");
      		return rStr;
      	} catch (Exception e) {
      		return gbkString;
      	}
	}

	public static void main(String[] args) {

		// FileUtils.UnZipFiles(new File("E:/temp/BBS/blueOS20070531.zip"),
		// null);
	}
}
