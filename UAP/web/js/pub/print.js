//�������ô�ӡ����
function printBase() {
    factory.printing.header = ""                 //ҳü
    factory.printing.footer = ""                 //ҳ��
    factory.printing.portrait = true             //trueΪ�����ӡ��flaseΪ�����ӡ
    factory.printing.leftMargin =19.5            //��ҳ�߾�
    factory.printing.topMargin =19.5             //��ҳ�߾�
    factory.printing.rightMargin =19.5           //��ҳ�߾�
    factory.printing.bottomMargin =19.5          //��ҳ�߾�
    }
//��ӡ����
function printnow(){
    printBase();
    factory.printing.Print(true)   //�ؼ���ӡ����	
    }
//��ӡԤ��
function printview(){
    printBase();
    factory.printing.Preview();    //�ؼ���ӡԤ������
    }
//��ӡ����
function printsetup(){
    factory.printing.PageSetup()    //�ؼ���ӡ���ú���
    }