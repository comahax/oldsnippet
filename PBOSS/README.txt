1.�ύsvn��ʱ���벻Ҫ�� WEB-INF/classes����ı����ļ������ύ��������svn�����ʱ��ᾭ������
2.ʹ��tomcat5.5��������ʱ��ǵ���conf/server.xml�˿������������ö�һ������ URIEncoding="GBK"
  ������������Ϊ���ĵ��������� 
3.index.jsp��title��ʱ��Ҫ�ĳ�����,��Ϊ���õ�jboss-5.0.1.GA�������뵼����ҳˢ������,���Ժ��ܷ����
4.ʹ��jboss������һ��Ҫ��server.xml�˿������������ö�һ������ URIEncoding="UTF-8"
  ���ҽ�jbossall-client.jar��ȥ��,��tomcat��������Ӧ�ü��ϸ�jar��
5.2009-08-06,PBOSS��Ŀ���ֻʹ��jboss-4.2.3.GA��Ϊͳһ����,һ��������Ϊ��ͬ������ҳ��ֲ�ͬ������,����tomcat������֧��JTA����,֮ǰBOSS����ģ������ݿ�
  ����Ŀ�е�oracle-xa-ds.xml������������jboss-4.2.3.GA\server\default\deploy��ʵ����JTA������Դ,����������������ԴCOMMON��ZS
  ��jboss-4.2.3.GA\server\default\deploy\jboss-web.deployer��server.xml�����޸Ķ˿ڸ��������
      <Connector port="9999" address="0.0.0.0"    
         maxThreads="250" maxHttpHeaderSize="8192"
         emptySessionPath="true" protocol="HTTP/1.1"
         enableLookups="false" redirectPort="8443" acceptCount="100"
         connectionTimeout="20000" disableUploadTimeout="true" URIEncoding="GBK"/>
  ����Ϊ׼
  ���мǵý�ojdbc14.jar�ŵ�jboss-4.2.3.GA\server\default\lib��ΪĬ������ ^_^ף�������~
6.����ajaxAnywhere��AAFilter.class������ʹ����UTF-8�ַ�,����������ҳ��ʹ��UTF-8�ַ�������ȷʹ��,�����Ժ�ҳ�涼��ΪUTF-8  --�ѽ��,�Ļ�GBK
7._nnm,_nnl�����������Ͳ�ѯ����Ӧ��ʹ����Ӧ����������,��������String,�����̨�ᱨ��  --�ѽ��,�滻PBOSS��hibernate3.0��
8._sql_�����Ĳ����Ļ��ᵼ��hibernate��̨��ѯ��ʱ������,��cfg�����ļ����<property name="hibernate.query.factory_class">org.hibernate.hql.classic.ClassicQueryTranslatorFactory</property>
9.�������ĵ�¼��ʽ
���ӱ����report_test/report@boss15test
�����û���tn_user������ڸ��û�
select * from tn_user where user_id = 'pboss';
Ȼ������û���ɫ��SA_REO_OPERATOR����û�����ʲô��ɫ
select * from SA_REO_OPERATOR where oprcode = 'pboss';
select * from SA_WP_ROLE where roleid = '0';
Ȼ���ɫ���Կ���ʲô�˵�
select * from tn_menu_of_role where role_id = '0';
�����Ĺ�ϵ����Ե�¼�������

linli@revenco.com
2009-09-17

2010-03-23
����FCKEDITOR 2.6���ı��༭��
����������У�
imageinfo-1.9.jar
jakarta-oro-2.0.8.jar
java-core-2.6.jar
slf4j-simple-1.5.8.jar
�滻commons-io-1.2jarΪcommons-io-1.3.2.jar
�޸�FCKEDITORԭ���ļ�������ʽΪFTP����ʽ������ʵ����Ϊʵ��net.fckeditor.connector.Connector
�ӿڵ�com.gmcc.pboss.fck.FTPConnector��
�޸�ԭ���ӱ��ط���ȡ�ļ���ʽΪͨ��SERVLET��FTP������ȡ�ļ���
�޸�fck_image.js �еķ���SetUrl( url, width, height, alt ) �ڷ����ڵ�һ������url = FCKConfig.FtpServletUrl+url;
�޸�fck_flash.js �еķ���SetUrl( url, width, height, alt ) �ڷ����ڵ�һ������url = FCKConfig.FtpServletUrl+url;
����FCKConfig.FtpServletUrl Ϊ��fckconfig.js ��������һ���������TTPȡ�ļ���SERVLET��ӳ��URL��FCKConfig.FtpServletUrl
��CLASSPATH������һ��fckeitor.properties �������£�
#�ļ���صĸ�Ŀ¼
connector.userFilesPath=/UserUploadFile
connector.userFilesAbsolutePath = /UserUploadFile
connector.resourceType.file.extensions.allowed=|jpg|gif|png|rar|zip|txt|doc|wma|wmv|mp3|flv|swf|
connector.resourceType.media.extensions.allowed=|wma|wmv|mp3|flv|swf|
connector.resourceType.image.extensions.allowed=|jpg|png|gif|
connector.resourceType.flash.extensions.allowed=|swf|
connector.userActionImpl=net.fckeditor.requestcycle.impl.EnabledUserAction
#(fck��Դ����webapp�е�Ŀ¼)
fckeditor.basePath =/js/fckeditor
#(fck��ʽ,�����ѡĬ�Ϻ�office2003����ʽ)
fckeditor.skinPath =/js/fckeditor/editor/skins/office2003/
#(fck�༭���ĸ߶�) 
#fckeditor.height =630
#�ļ��������ʵ����
#connector.impl = net.fckeditor.connector.impl.ContextConnector
connector.impl = com.gmcc.pboss.fck.FTPConnector


// ��ȡ�༭����HTML����
function getEditorHTMLContents(EditorName) { 
    var oEditor = FCKeditorAPI.GetInstance(EditorName); 
    return(oEditor.GetXHTML(true)); 
}

// ��ȡ�༭������������
function getEditorTextContents(EditorName) { 
    var oEditor = FCKeditorAPI.GetInstance(EditorName); 
    return(oEditor.EditorDocument.body.innerText); 
}

// ���ñ༭��������
function SetEditorContents(EditorName, ContentStr) { 
    var oEditor = FCKeditorAPI.GetInstance(EditorName) ; 
    oEditor.SetHTML(ContentStr) ; 
}





