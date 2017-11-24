1.提交svn的时候请不要把 WEB-INF/classes下面的编译文件进行提交，否则拉svn代码的时候会经常报错
2.使用tomcat5.5做容器的时候记得在conf/server.xml端口连接那里设置多一个参数 URIEncoding="GBK"
  否则会出现主键为中文的乱码问题 
3.index.jsp的title暂时不要改成中文,因为我用的jboss-5.0.1.GA会变成乱码导致首页刷不出来,看以后能否改正
4.使用jboss做容器一样要在server.xml端口连接那里设置多一个参数 URIEncoding="UTF-8"
  并且将jbossall-client.jar包去掉,用tomcat当容器则应该加上该jar包
5.2009-08-06,PBOSS项目最好只使用jboss-4.2.3.GA作为统一容器,一来避免作为不同容器大家出现不同的问题,二来tomcat容器不支持JTA事务,之前BOSS都是模拟多数据库
  将项目中的oracle-xa-ds.xml拷贝到容器的jboss-4.2.3.GA\server\default\deploy即实现了JTA多数据源,里面配了两个数据源COMMON跟ZS
  在jboss-4.2.3.GA\server\default\deploy\jboss-web.deployer的server.xml可以修改端口跟外机访问
      <Connector port="9999" address="0.0.0.0"    
         maxThreads="250" maxHttpHeaderSize="8192"
         emptySessionPath="true" protocol="HTTP/1.1"
         enableLookups="false" redirectPort="8443" acceptCount="100"
         connectionTimeout="20000" disableUploadTimeout="true" URIEncoding="GBK"/>
  以上为准
  还有记得将ojdbc14.jar放到jboss-4.2.3.GA\server\default\lib作为默认连接 ^_^祝配置愉快~
6.由于ajaxAnywhere的AAFilter.class类里面使用了UTF-8字符,经测试所有页面使用UTF-8字符可以正确使用,所以以后页面都改为UTF-8  --已解决,改回GBK
7._nnm,_nnl这种数字类型查询条件应该使用相应的数字类型,而不该用String,否则后台会报错  --已解决,替换PBOSS的hibernate3.0包
8._sql_带中文参数的话会导致hibernate后台查询的时候乱码,在cfg配置文件添加<property name="hibernate.query.factory_class">org.hibernate.hql.classic.ClassicQueryTranslatorFactory</property>
9.报表管理的登录方式
连接报表库report_test/report@boss15test
首先用户表tn_user必须存在该用户
select * from tn_user where user_id = 'pboss';
然后根据用户角色表SA_REO_OPERATOR查该用户属于什么角色
select * from SA_REO_OPERATOR where oprcode = 'pboss';
select * from SA_WP_ROLE where roleid = '0';
然后角色可以看到什么菜单
select * from tn_menu_of_role where role_id = '0';
这样的关系便可以登录报表管理

linli@revenco.com
2009-09-17

2010-03-23
引入FCKEDITOR 2.6富文本编辑器
新引入类包有：
imageinfo-1.9.jar
jakarta-oro-2.0.8.jar
java-core-2.6.jar
slf4j-simple-1.5.8.jar
替换commons-io-1.2jar为commons-io-1.3.2.jar
修改FCKEDITOR原有文件操作方式为FTP处理方式：处理实现类为实现net.fckeditor.connector.Connector
接口的com.gmcc.pboss.fck.FTPConnector类
修改原来从本地服务取文件方式为通过SERVLET从FTP服务器取文件，
修改fck_image.js 中的方法SetUrl( url, width, height, alt ) 在方法内第一行增加url = FCKConfig.FtpServletUrl+url;
修改fck_flash.js 中的方法SetUrl( url, width, height, alt ) 在方法内第一行增加url = FCKConfig.FtpServletUrl+url;
其中FCKConfig.FtpServletUrl 为在fckconfig.js 中新增的一个配置项（从TTP取文件的SERVLET的映射URL）FCKConfig.FtpServletUrl
在CLASSPATH中新增一个fckeitor.properties 内容如下：
#文件相关的根目录
connector.userFilesPath=/UserUploadFile
connector.userFilesAbsolutePath = /UserUploadFile
connector.resourceType.file.extensions.allowed=|jpg|gif|png|rar|zip|txt|doc|wma|wmv|mp3|flv|swf|
connector.resourceType.media.extensions.allowed=|wma|wmv|mp3|flv|swf|
connector.resourceType.image.extensions.allowed=|jpg|png|gif|
connector.resourceType.flash.extensions.allowed=|swf|
connector.userActionImpl=net.fckeditor.requestcycle.impl.EnabledUserAction
#(fck资源所在webapp中的目录)
fckeditor.basePath =/js/fckeditor
#(fck样式,这里可选默认和office2003的样式)
fckeditor.skinPath =/js/fckeditor/editor/skins/office2003/
#(fck编辑器的高度) 
#fckeditor.height =630
#文件操作相关实现类
#connector.impl = net.fckeditor.connector.impl.ContextConnector
connector.impl = com.gmcc.pboss.fck.FTPConnector


// 获取编辑器中HTML内容
function getEditorHTMLContents(EditorName) { 
    var oEditor = FCKeditorAPI.GetInstance(EditorName); 
    return(oEditor.GetXHTML(true)); 
}

// 获取编辑器中文字内容
function getEditorTextContents(EditorName) { 
    var oEditor = FCKeditorAPI.GetInstance(EditorName); 
    return(oEditor.EditorDocument.body.innerText); 
}

// 设置编辑器中内容
function SetEditorContents(EditorName, ContentStr) { 
    var oEditor = FCKeditorAPI.GetInstance(EditorName) ; 
    oEditor.SetHTML(ContentStr) ; 
}





