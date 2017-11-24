package com.gmcc.pboss.BgProcess.resource.resource;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.compacklog.CompacklogVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleDBParam;
import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleVO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.compacklog.Compacklog;
import com.gmcc.pboss.control.resource.compacklog.CompacklogBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.resource.numtyperule.Numtyperule;
import com.gmcc.pboss.control.resource.numtyperule.NumtyperuleBO;
import com.gmcc.pboss.control.resource.resource.Resource;
import com.gmcc.pboss.control.resource.resource.ResourceBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;



/**
 * 套卡发布
 * @author wefrogll
 * @version 1.0 2009-10-28
 */
public class ComressmpProcess extends BaseProcess{
	private Logger log = Logger.getLogger(ComressmpProcess.class);
	private User user;
	private String defaultState;
	private String resourceUser;
	private String storage;
	private String operator;
	private Map<String,CompackVO> map = new HashMap<String,CompackVO>();//MAP<商品批次|包号,商品包对象>
	private static String split_sybm = "|";
	List<NumtyperuleVO> typeruleList = null;
	
	
	public ComressmpProcess(User user,String defaultState,String resourceUser,String storage,String operator){
		this.user = user;
		this.defaultState = defaultState;
		this.resourceUser = resourceUser;
		this.storage = storage;
		this.operator = operator;
	}

	
	@Override
	public void processFile(File file, String errorDir) throws Exception {
		// TODO Auto-generated method stub
		String fileName = file.getName();
		fileName = fileName.substring(0, fileName.lastIndexOf("."));
		errorDir = errorDir.replace('/', File.separatorChar).replace('\\', File.separatorChar);
		if(!errorDir.endsWith(""+File.separatorChar));
		errorDir = errorDir+File.separatorChar;
		String outputFile = errorDir+fileName+".ERR";
		Numtyperule numtyperuleBO = (Numtyperule)BOFactory.build(NumtyperuleBO.class,user);
		NumtyperuleDBParam typeruleParam = new NumtyperuleDBParam();
		typeruleParam.setDataOnly(true);
		typeruleParam.setQueryAll(true);
		typeruleList = numtyperuleBO.doGetNumtyperuleList(typeruleParam);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
		int rowCount = 0;
		String line = null;
		ResultVO resultVO = null;
		try{
			while((line = reader.readLine()) != null && !line.contains(ResourceDeploy.LINE_END_FLAG)){
				rowCount++;
				try{
					resultVO = processLine(line,rowCount);
					if(!resultVO.isOk()){//
						fail++;
						log.error("错误:"+resultVO.getInfo()+"\n");
						writer.write(resultVO.getInfo()+"\n");
					}else{
						success++;
					}
				}catch(Exception e){
					fail++;
					writer.write(rowCount+"|"+line+"|"+e.getCause() != null ?e.getCause().getMessage():e.getMessage()+"\n");
					LoggerUtils.error(e, log);				
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			LoggerUtils.error(e, log);
		}finally{
			if( null != reader )
				reader.close();
			if( null != writer )
				writer.close();
		}
		
		//文件内容处理完毕后，对商品包MAP逐条处理：
			
			if(map != null){
				Set<String> keySet = map.keySet();
				Comressmp comressmpBO = (ComressmpBO)BOFactory.build(ComressmpBO.class,user);
				ComressmpDBParam comressmpParam = new ComressmpDBParam();
				Compack compackBO = (CompackBO)BOFactory.build(CompackBO.class,user);
				CompackVO compackVO = new CompackVO();
				Compacklog compacklogBO = (CompacklogBO)BOFactory.build(CompacklogBO.class,user);
				CompacklogVO compacklogVO = new CompacklogVO();
				
				for(String key:keySet){
					try{
						CompackVO tempCompackVO = map.get(key);
//					a)	根据商品批次、包号为条件，对套卡资源表进行统计，获取商品数量。
						long count = 0; 
						comressmpParam.setQueryAll(true);
						comressmpParam.setCountOnly(true);
						comressmpParam.set_se_batchno(tempCompackVO.getBatchno());
						comressmpParam.set_se_boxnum(tempCompackVO.getBoxnum());
						DataPackage comressmpDP = comressmpBO.doQuery(comressmpParam);
						if( null != comressmpDP )
						count = comressmpDP.getRowCount();
//					b)	根据商品批次、包号查询商品包表（IM_PR_COMPACK），如果存在则更新商品数量；否则新增记录到商品包表，商品包标识取序列（IM_PR_COMPACK_SEQ），商品数量取上一步获取数据，打包时间取当前时间。
						compackVO = compackBO.doFindByPk(tempCompackVO);
						
						if(compackVO == null){
							tempCompackVO.setAmount(Short.valueOf(""+count));
							tempCompackVO.setPacktime(new Date());
							compackBO.doCreate(tempCompackVO);
						}else{
							compackVO.setAmount(Short.valueOf(""+count));
							compackBO.doUpdate(compackVO);
						}
			/***********************系统自动记录(SPRING)*************************/				
//					c)	新增一条记录到商品包日志表（IM_PR_COMPACKLOG），“日志标识”取序列（IM_FX_COMRESSMPLOG_SEQ），“操作日期”取当前时间，“操作工号”取系统后台工号，“日志操作类型”取“create”（即新增）或“update”（即修改），“操作状态”取“0”（即成功），其他字段按照商品包表的记录
//						BeanUtils.copyProperties(compacklogVO, tempCompackVO);
//						compacklogVO.setOptime(new Date());
//						compacklogVO.setOprcode(this.operator);
//						if(compackVO == null){
//							compacklogVO.setOprtype("create");
//						}else{
//							compacklogVO.setOprtype("update");
//						}
//						compacklogVO.setSuccess("success");
//						
//						compacklogBO.doCreate(compacklogVO);
					}catch(Exception e){
						e.printStackTrace();
						log.error(e.getMessage());
					}
				}
			}		
	}

	@Override
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try{
				Resource resourceBO = (ResourceBO)BOFactory.build(ResourceBO.class, user);
				resourceBO.doComressmDeploy(line, map, defaultState, resourceUser, storage, operator,typeruleList);
				resultVO.setInfo(line);
				resultVO.setOk(true);
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			line =  rowCount+"|"+line+"|"+e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
	
	public static void main(String[] args){
		String aa="aa&&bb&&cc&&&&ee&&&&&&";
		System.out.println(aa.replaceAll("&&", "|"));
		String[] items = StringUtils.splitPreserveAllTokens(aa.replaceAll("&&", "|"),"|");
		System.out.println(items.length);
	}
}
