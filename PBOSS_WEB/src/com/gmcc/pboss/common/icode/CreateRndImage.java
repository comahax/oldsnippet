
package com.gmcc.pboss.common.icode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.dictionary.CommonConfig;
import com.gmcc.pboss.common.dictionary.FileDictionary;
import com.gmcc.pboss.common.config.FileConfigAdapter;



/**
 * @author tangzhu
 *
 */
public class CreateRndImage {
	
	private static int WIDTH = 51; 
	private static int HEIGHT = 21;
	
	public char [] generateCheckCode() 
	{
		// 定义验证码的字符表 
		String chars = "123456789"; 
		char [] rands = new char[4]; 
		for(int i=0; i<4; i++) 
		{ 
			int rand = (int)(Math.random() * chars.length()); 
			rands[i] = chars.charAt(rand);
		}
		return rands; 
	} 

	public void drawRands(Graphics g , char [] rands) 
	{ 
		g.setColor(new Color(0x0000));
		int[] size=new int[] {15,14,13,14};
		//int[]size =  new int[]{30,28,26,28};
		Random ramd=new Random();
		//System.out.println("aaaa==>"+Font.BOLD+" "+Font.PLAIN+" "+Font.LAYOUT_NO_START_CONTEXT);
		//g.setFont(new Font(null,Font.BOLD|Font.ITALIC|Font.LAYOUT_NO_LIMIT_CONTEXT,size[ramd.nextInt(4)])); 
   	   	g.setFont(new Font(null,Font.PLAIN|Font.BOLD|Font.ITALIC,size[ramd.nextInt(4)])); 
        // 在不同的高度上输出验证码的每个字符          

   	   	/*  g.drawString("" + rands[0],1,17); 
   	   		g.drawString("" + rands[1],8,15); 
        	g.drawString("" + rands[2],28,18); 
        	g.drawString("" + rands[3],36,16); */
        
   	   	//String chars="1234";
        for(int i=0;i<rands.length;i++) {
        	//int rand=(int)(Math.random()*chars.length());
       	 	// g.drawString(rands[i]+"", 10 * i + 4,   15);
            /*switch(i) {
			case 0:g.drawString(rands[i]+"", rand+2,   11+rand);break;
			case 1:g.drawString(""+rands[i], 12+ rand, 11+rand);break;
			case 2:g.drawString(rands[i]+"", 20+ rand,11+rand);break;
			case 3:g.drawString(""+rands[i], 32 +rand, 11+rand);break;
			}  */
        	switch(i) {
				case 0:g.drawString(rands[i]+"", 10 * i +2,   14);break;
				case 1:g.drawString(rands[i]+"",10 * i +5 ,   14);break;
				case 2:g.drawString(rands[i]+"", 10 * i +7,   14);break;
				case 3:g.drawString(rands[i]+"", 10 * i + 8,   14);break;
			}
        }
   } 

   

   public void drawBackground(Graphics g) 

   { 

         // 画背景 

          g.setColor(new Color(0xDCDCDC)); 

          g.fillRect(0, 0, WIDTH, HEIGHT); 

          // 随机产生 120 个干扰点 

          for(int i=0; i<10; i++) 

          { 

                 int x = (int)(Math.random() * WIDTH); 

                 int y = (int)(Math.random() * HEIGHT); 

                 int red = (int)(Math.random() * 255); 

                 int green = (int)(Math.random() * 255); 

                 int blue = (int)(Math.random() * 255); 

                 g.setColor(new Color(red,green,blue));        

                 g.drawOval(x,y,1,0); 

          } 

   } 
  
   public static void main(String[] args) throws Exception {
   	CreateRndImage createRndImage=new CreateRndImage();
       // 创建内存图象并获得其图形上下文 

   	
   	List list=new ArrayList();
   	List listCode=new ArrayList();
   	 char[] code = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
   			   'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'V','W',
   			   'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9','a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 
   			   'k', 'l', 'm', 'n', 'o', 'p', 'q', 's', 't', 'u', 'v', 'w',
   			   'x', 'y', 'z'};
   	 StringBuffer strCode=null;
   	 Random rand=new Random();

   	int size = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, 
	           CommonConfig.ICODE_SIZE));
   	
   	for(int j=0;j<size;j++){
   		strCode=new StringBuffer();
	   	 for(int i=0;i<4;i++){
	   		 strCode.append(code[rand.nextInt(code.length)]);
	   	 }
	   	 listCode.add(strCode);
   	}
   	
   	String[] imgbuf=new String[listCode.size()];
   	
   	for(int i=0;i<listCode.size();i++){
   		imgbuf[i]=listCode.get(i).toString();
   	}
   	
   	for(int a=0;a<imgbuf.length;a++) {
       BufferedImage image = 

              new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB); 

       Graphics g = image.getGraphics(); 

       

       // 产生随机的认证码 

      // char [] rands = createRndImage.generateCheckCode(); 
       char[] rands=new char[4];
       
       
       String randStr=String.valueOf(imgbuf[a]);
       
       for(int i=0;i<randStr.length();i++) {
       	rands[i]=randStr.charAt(i);
       }
        
       StringBuffer str=new StringBuffer();
       for(int i=0;i<rands.length;i++) {
       	str.append(rands[i]);
       }
      
      String path = FileConfigAdapter.getImagePath();
      
      File file=new File(path + str.toString() + ".jpg");
      list.add(str.toString());
      if(!file.exists()) {
   	   file.createNewFile();
      }
      FileOutputStream out=new FileOutputStream(file);
      
       // 产生图像 

       createRndImage.drawBackground(g); 

       createRndImage.drawRands(g,rands); 

       

       // 结束图像 的绘制 过程， 完成图像 

       g.dispose(); 

       

       
           // 将图像输出到客户端 

       ByteArrayOutputStream bos = new ByteArrayOutputStream(); 

       ImageIO.write(image, "JPEG", bos); 

       byte [] buf = bos.toByteArray(); 



       // 下面的语句也可写成： bos.writeTo(sos); 

       out.write(buf); 

       bos.close(); 

       out.close();
       //System.out.println(a);
   	}
    
   	
     Iterator it=list.iterator();
     
    /* File file=new File("e:\\tt\\arrary.txt");
     
     if(file.exists()) {
   	  file.createNewFile();
     }*/
     String path = FileConfigAdapter.getImagePath() + "arrary.txt";
     
     RandomAccessFile rf=new RandomAccessFile(path,"rw");
     rf.seek(rf.length());
     StringBuffer buf=new StringBuffer();
     while(it.hasNext()) {
   	  buf.append(it.next().toString()+"\n");
     }
     byte[] byt=buf.toString().getBytes();
	    rf.write(byt);
	  rf.close();
	  System.out.println("==ss>"+list.size());
	  
	 /* it=listCode.iterator();
	  buf=new StringBuffer();
	  rf=new RandomAccessFile("e:\\tt\\codeSequence.txt","rw");
	  rf.seek(rf.length());
	  while(it.hasNext()) {
   	  buf.append(it.next().toString()+",");
     }
     
       byt=buf.toString().getBytes();
	    rf.write(byt);
	  rf.close();
	  System.out.println("==Code>"+listCode.size());
	  */
   }
   
   
}
