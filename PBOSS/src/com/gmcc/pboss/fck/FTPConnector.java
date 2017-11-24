package com.gmcc.pboss.fck;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;

import net.fckeditor.connector.Connector;
import net.fckeditor.connector.exception.FolderAlreadyExistsException;
import net.fckeditor.connector.exception.InvalidCurrentFolderException;
import net.fckeditor.connector.exception.InvalidNewFolderNameException;
import net.fckeditor.connector.exception.ReadException;
import net.fckeditor.connector.exception.WriteException;
import net.fckeditor.handlers.PropertiesLoader;
import net.fckeditor.handlers.RequestCycleHandler;
import net.fckeditor.handlers.ResourceType;
import net.fckeditor.requestcycle.ThreadLocalData;

import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmcc.pboss.common.ftp.FtpAccess;
import com.gmcc.pboss.common.ftp.FtpInfo;


public class FTPConnector implements Connector{
	private final Logger logger = LoggerFactory.getLogger(FTPConnector.class);
	protected ServletContext servletContext;
//	FtpAccess ftp ; 
	
	public void createFolder(ResourceType type, String currentFolder,
			String newFolder) throws InvalidCurrentFolderException,
			InvalidNewFolderNameException, FolderAlreadyExistsException,
			WriteException {
		// TODO Auto-generated method stub
		String userPath = RequestCycleHandler
		.getUserFilesAbsolutePath(ThreadLocalData.getRequest());
		FtpAccess ftp = null; 
		try{
			ftp = new FtpAccess(FtpInfo.getInstance());
			String typeDir = getOrCreateResourceTypeDir(userPath, type);
			
			if(!ftp.isExitDir(typeDir+currentFolder))
				throw new InvalidCurrentFolderException();
			if(ftp.isExitDir(typeDir+currentFolder+newFolder))
				throw new FolderAlreadyExistsException();
			if (!ftp.createDir(typeDir+currentFolder, newFolder))
				throw new InvalidNewFolderNameException();
		}catch(Exception e){
			e.printStackTrace();
			if(e instanceof InvalidCurrentFolderException)
				throw new InvalidCurrentFolderException();
			if(e instanceof FolderAlreadyExistsException)
				throw new FolderAlreadyExistsException();
			if(e instanceof InvalidNewFolderNameException)
				throw new InvalidNewFolderNameException();
		}finally{
			try {
				ftp.diConnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String fileUpload(ResourceType type, String currentFolder,
			String fileName, InputStream inputStream)
			throws InvalidCurrentFolderException, WriteException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String newFileName = format.format(new Date())+new Random().nextInt(100);
		String userPath = RequestCycleHandler
				.getUserFilesAbsolutePath(ThreadLocalData.getRequest());
		String typeDir = getOrCreateResourceTypeDir(userPath, type);
		FtpAccess ftp = null;
		try {
			ftp = new FtpAccess(FtpInfo.getInstance());
			if(!ftp.isExitDir(typeDir+currentFolder))
				throw new InvalidCurrentFolderException();
			
			if(ftp.uploadFile(typeDir+currentFolder, inputStream, newFileName))
				return newFileName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ftp.diConnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Map<String, Object>> getFiles(ResourceType type, String currentFolder)
			throws InvalidCurrentFolderException, ReadException {
		// TODO Auto-generated method stub
		String userPath = RequestCycleHandler
		.getUserFilesAbsolutePath(ThreadLocalData.getRequest());
		String typeDir = getOrCreateResourceTypeDir(userPath, type);
		FtpAccess ftp = null;
		List<Map<String, Object>> files;
		try{
			ftp = new FtpAccess(FtpInfo.getInstance());
			if( !ftp.isExitDir(typeDir+currentFolder) || currentFolder.contains(".") )
				throw new InvalidCurrentFolderException();
		
		// collect files
		
		Map<String, Object> fileMap;
		
		FTPFile[] fileList = null;
		
			fileList = ftp.getFiles(typeDir+currentFolder);
		
		files = new ArrayList<Map<String, Object>>(fileList.length);
		for (FTPFile file : fileList) {
			if(file.isFile()){
				fileMap = new HashMap<String, Object>(2);
				fileMap.put(Connector.KEY_NAME, file.getName());
				fileMap.put(Connector.KEY_SIZE, file.getSize());
				files.add(fileMap);
			}
		}
		}catch(Exception e){
			throw new InvalidCurrentFolderException();
		}finally{
			try {
				ftp.diConnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return files;
	}

	public List<String> getFolders(ResourceType type, String currentFolder)
			throws InvalidCurrentFolderException, ReadException {
		// TODO Auto-generated method stub
		String userPath = RequestCycleHandler
		.getUserFilesAbsolutePath(ThreadLocalData.getRequest());
		
		String typeDir = getOrCreateResourceTypeDir(userPath, type);
		FtpAccess ftp = null;
		List<String> list = new ArrayList<String>();
		try{
			ftp = new FtpAccess(FtpInfo.getInstance());
			if( !ftp.isExitDir(typeDir+currentFolder) || currentFolder.contains("."))
				throw new InvalidCurrentFolderException();

			FTPFile[] fileList = ftp.getFiles(typeDir+currentFolder);
			for(FTPFile file:fileList){
				if(file.isDirectory() && !".".equals(file.getName()) && !"..".equals(file.getName()))
					list.add(file.getName());
			}
		}catch(Exception e){
			throw new InvalidCurrentFolderException();
		}finally{
			try {
				ftp.diConnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	

	public void init(final ServletContext servletContext) throws Exception {
		this.servletContext = servletContext;
		String defaultAbsolutePath = getRealUserFilesAbsolutePath(PropertiesLoader
				.getUserFilesPath());

		if (defaultAbsolutePath == null) {
			logger.error("The context root cannot be resolved against the local filesystem");
			logger.info("Your servlet container/application server does not expand deployed war files");
			logger.debug("Use another Connector implementation (e.g. LocalConnector) and consult http://www.fckeditor.net/forums/viewtopic.php?f=6&t=11568");
			throw new NullPointerException(
					"The real context root cannot be resolved against the local filesystem");
		}
		
	}

	/**
	 * Resolves the userfiles absolute path against the current context real
	 * path.
	 */
	protected String getRealUserFilesAbsolutePath(String userFilesAbsolutePath) {
		return servletContext.getRealPath(userFilesAbsolutePath);
	}
	
	
	protected  String getOrCreateResourceTypeDir(final String baseDir,
			final ResourceType type) {
		String path = baseDir+type.getPath();
		FtpAccess ftp = null;
		try{
			ftp = new FtpAccess(FtpInfo.getInstance());
			if( !ftp.isExitDir(path))
				ftp.createDir(baseDir, type.getPath());
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}if(ftp != null){
			try {
				ftp.diConnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return path;
	}
}
