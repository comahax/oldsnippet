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
 * 从兴公司营账开发部
 * @author yuwenjun
 * @date 2010-06-10
 * @update 2010-06-10
 * 所属项目：PBOSS
 * 所属模块：门户
 * 描述：公共类 - 文件操作汇总
 */
public class FileOperator {
	protected static final Log logger = LogFactory.getLog(FileOperator.class); 
	/**
	 * 删除文件或文件夹
	 * 
	 * @param path
	 *            要删除哪个目录下的文件
	 * @param fileName
	 *            要删除的文件或文件夹名
	 *            <P>
	 *            (Last modified time:2007-1-5 上午11:26:42 )
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
	 * 复制文件或文件夹
	 * 
	 * @param path
	 *            被控制的文件所在路径
	 * @param oldName
	 *            源文件名
	 * @param copyName
	 *            要复制成的文件名
	 *            <P>
	 *            (Last modified time:2007-1-5 下午02:53:20 )
	 */
	public static void copyFile(String path, String srcName, String copyName) {
		File srcFile = new File(path, srcName);
		File copyFile = new File(path, copyName);
		if (srcFile.isFile()) {
			copyOneFile(srcFile, copyFile);
		} else if (srcFile.isDirectory()) {
			copyFolder(srcFile, copyFile);
		} else {
			System.out.println("复制文件类型==无法判断");
		}

	}

	/**
	 * 重命名文件或文件夹
	 * 
	 * @param path
	 *            被控制的文件所在路径
	 * @param oldName
	 *            原文件名
	 * @param newName
	 *            新文件名
	 * @return
	 *            <P>
	 *            (Last modified time:2007-1-5 下午02:53:26 )
	 */
	public static boolean renameFile(String path, String oldName, String newName) {
		File oldFile = new File(path, oldName);
		File newFile = new File(path, newName);
		boolean success = oldFile.renameTo(newFile);
		return success;
	}

	/**
	 * 删除文件
	 * 
	 * @param filePathAndName
	 *            文本文件完整绝对路径及文件名
	 * @return Boolean 成功删除返回true遭遇异常返回false
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
	 * 删除文件夹
	 * 
	 * @param folderPath
	 *            文件夹完整绝对路径
	 * @return
	 */
	public static void delFolder(File folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容

			folderPath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除指定文件夹下所有文件
	 * 
	 * @param path
	 *            文件夹完整绝对路径
	 * @return
	 * @return
	 */
	public static boolean delAllFile(File path) {
		boolean bea = false;

		if (!path.exists()) {
			return bea;
		}
		if (!path.isDirectory()) {// 不是目录
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
				delAllFile(temp);// 先删除文件夹里面的文件
				delFolder(temp);// 再删除空文件夹
				bea = true;
			}
		}
		return bea;
	}

	/**
	 * 复制单个文件
	 * 
	 * @param oldPathFile
	 *            准备复制的文件源
	 * @param newPathFile
	 *            拷贝到新文件
	 * @return
	 */
	public static void copyOneFile(File oldPathFile, File newPathFile) {
		try {
			int bytesum = 0;
			int byteread = 0;
			// File oldfile = new File(oldPathFile);
			if (oldPathFile.exists() && !newPathFile.exists()) { // 原文件存在,新文件不存在时
				FileCopyUtils.copy(oldPathFile, newPathFile);
//				InputStream inStream = new FileInputStream(oldPathFile); // 读入原文件
//				FileOutputStream output = new FileOutputStream(newPathFile);
//				byte[] buffer = new byte[512000];// 固定缓冲区的大小, 避免缓冲区占用太多内存
//
//				while ((byteread = inStream.read(buffer)) != -1) {
//					bytesum += byteread; // 字节数 文件大小
//					output.write(buffer, 0, byteread);
//				}
////				System.out.println("复制单个文件,size=" + bytesum);
//				output.flush();
//				output.close();
//				inStream.close();
			}
		} catch (Exception e) {
			logger.error("复制单个文件操作出错" + e.getMessage());
//			throws e;
		}
	}

	/**
	 * 复制整个文件夹的内容
	 * 
	 * @param oldPath
	 *            准备拷贝的目录
	 * @param newPath
	 *            指定绝对路径的新目录
	 * @return
	 */
	public static void copyFolder(File oldPath, File newPath) {
		try {
			newPath.mkdirs(); // 如果文件夹不存在 则建立新文件夹
			String[] file = oldPath.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				temp = new File(oldPath, file[i]);

				if (temp.isFile()) {
					File copyToPathFile = new File(newPath, temp.getName());
					copyOneFile(temp, copyToPathFile);
				}
				if (temp.isDirectory()) {// 如果是子文件夹
					copyFolder(new File(oldPath, file[i]), new File(newPath,
							file[i]));
				}
			}
		} catch (Exception e) {
			logger.error("复制整个文件夹内容操作出错" + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 压缩文件
	 * 
	 * @param srcfile
	 *            File[] 需要压缩的文件列表
	 * @param zipfile
	 *            File 压缩后的文件
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
	 * 解压缩
	 * 
	 * @param zipfile
	 *            File 需要解压缩的文件
	 * @param descDir
	 *            String 解压后的目标目录(一般是解压到zipfile的当前路径
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

			// 建立与目标文件的输入连接
			ZipInputStream in = new ZipInputStream(new FileInputStream(zipFile));
			ZipEntry file = null;
			try {
				file = in.getNextEntry();
			} catch (IllegalArgumentException e) {// 读取中文文件时出现的异常
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
			System.out.println("不是一个ZIP文件！,文件格式错误");
			zipe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("读取" + zipFile + "时错误！,文件读取错误");
			ioe.printStackTrace();

		}

	}

	/**
	 * 返回解压后的文件路径
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

			// 建立与目标文件的输入连接
			ZipInputStream in = new ZipInputStream(new FileInputStream(zipFile));
			ZipEntry file = null;
			try {
				file = in.getNextEntry();
			} catch (IllegalArgumentException e) {// 读取中文文件时出现的异常
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
			System.out.println("不是一个ZIP文件！,文件格式错误");
			zipe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("读取" + zipFile + "时错误！,文件读取错误");
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
			System.out.println("文件不存在!");
			return false;
		} catch (IOException ioe) {
			System.out.println("上传文件格式错误!");
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
		File file_in = new File(picFrom);// 读入文件

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
		tag.getGraphics().drawImage(src, 0, 0, nw, nh, null);// 绘制缩小后的图
		FileOutputStream out = new FileOutputStream(picTo);// 输出到文件流
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(tag); // 近JPEG编码
		out.close();

	}

	/**
	 * 创建缩略图
	 * 
	 * @param path
	 * @param fileName
	 * @modified: ☆LiuPing(2008-1-31 上午09:24:23): <br>
	 */
	public static void reSize(String path, String fileName) {

		String picFrom = path + "/" + fileName;
		String picTo = path + "/sm_" + fileName;
		// 判断格式能否创建
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
