//用于设置打印参数
function printBase() {
    factory.printing.header = ""                 //页眉
    factory.printing.footer = ""                 //页脚
    factory.printing.portrait = true             //true为纵向打印，flase为横向打印
    factory.printing.leftMargin =19.5            //左页边距
    factory.printing.topMargin =19.5             //上页边距
    factory.printing.rightMargin =19.5           //右页边距
    factory.printing.bottomMargin =19.5          //下页边距
    }
//打印函数
function printnow(){
    printBase();
    factory.printing.Print(true)   //控件打印函数	
    }
//打印预览
function printview(){
    printBase();
    factory.printing.Preview();    //控件打印预览函数
    }
//打印设置
function printsetup(){
    factory.printing.PageSetup()    //控件打印设置函数
    }