package code;

import codeGenerate.def.FtlDef;
import codeGenerate.factory.CodeGenerateFactory;


public class CodeUtil {

	public static void main(String[] args) {
		/** 此处修改成你的 表名 和 中文注释***/
		 String tableName="HuaDan"; //表名称
		 String codeName ="HuaDan";//中文注释  当然你用英文也是可以的
		 String className = "HuaDan";//domain 的class名称
		 String entityPackage ="shanmi";//模块包
		 String keyType = FtlDef.KEY_TYPE_02;//主键生成方式 01:UUID  02:自增  目前没用
		 CodeGenerateFactory.codeGenerate(tableName, codeName,className, entityPackage,keyType,false);//false为是否生成界面。目前没界面，也没写对应的界面模板
	}
	
}