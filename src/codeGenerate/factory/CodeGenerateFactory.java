package codeGenerate.factory;

import codeGenerate.CommonPageParser;
import codeGenerate.CreateBean;
import codeGenerate.def.CodeResourceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.VelocityContext;

import java.util.Date;
import java.util.Map;

public class CodeGenerateFactory
{
  private static final Log log = LogFactory.getLog(CodeGenerateFactory.class);
  private static String url = CodeResourceUtil.URL;
  private static String username = CodeResourceUtil.USERNAME;
  private static String passWord = CodeResourceUtil.PASSWORD;

  private static String buss_package = CodeResourceUtil.bussiPackage;
//  private static String projectPath = getProjectPath();
  private static String projectPath = CodeResourceUtil.projectPath;

  /**
   * @param tableName：表名
   * @param codeName：注释
   * @param entityPackage：实体包 
   * @param keyType：主键生成方式  01:UUID  02:自增
   * @param isGenerateJsp:是否生产jsp页面和js文件
   */
  public static void codeGenerate(String tableName, String codeName,String className, String entityPackage, String keyType,boolean isGenerateJsp)
  {
    CreateBean createBean = new CreateBean();
    createBean.setMysqlInfo(url, username, passWord);

//    String className = createBean.getTablesNameToClassName(tableName);
    String lowerName = className.substring(0, 1).toLowerCase() + className.substring(1, className.length());

    String srcPath = projectPath + CodeResourceUtil.source_root_package + "\\";
    
    String xmlPath = projectPath + CodeResourceUtil.source_xml_package + "\\";

    String pckPath = srcPath + CodeResourceUtil.bussiPackageUrl + "\\";

    String webPath = projectPath + CodeResourceUtil.web_root_package + "\\view\\" + CodeResourceUtil.bussiPackageUrl + "\\";

    //String modelPath = "page\\" + entityPackage + "\\" + className + "Page.java";
    //domain文件路径
    String beanPath = "domain\\" + entityPackage + "\\" + className + ".java";
    //mapper  java文件路径
    String mapperPath = "mapper\\" + entityPackage + "\\" + className + "Mapper.java";
    //service java文件路径
    String servicePath = "service\\" + entityPackage + "\\I" + className + "Service.java";
    //service 实现类文件路径
    String serviceImplPath = "service\\" + entityPackage + "\\impl\\" + className + "ServiceImpl.java";
    //act 文件路径
    String controllerPath = "controller\\" + entityPackage + "\\" + className + "Act.java";
    //自动生成的方法的mapper文件路径
    String sqlMapperPath = "mybatis\\" + entityPackage + "\\mapper1\\" + className + "Mapper.xml";
    //该文件默认为空，供另外扩展的方法使用
    String sqlMapper2Path = "mybatis\\" + entityPackage + "\\mapper2\\" + className + "Mapper.xml";
    //查询参数map
    String pagePath = "param\\" + entityPackage + "\\" + className + "PageParam" + ".java";
    
    
//    webPath = webPath + entityPackage + "\\";

//    String jspPath = lowerName + ".jsp";
//    String jsPath = "page-" + lowerName + ".js";
    
    //将参数传递到模板文件渲染
    VelocityContext context = new VelocityContext();
    context.put("className", className);
    context.put("lowerName", lowerName);
    context.put("codeName", codeName);
    context.put("tableName", tableName);
    context.put("bussPackage", buss_package);
    context.put("entityPackage", entityPackage);
    context.put("keyType", keyType);
    context.put("user", System.getProperty("user.name"));
    context.put("time", new Date());
    context.put("organization",CodeResourceUtil.getOrganization());
    
    try
    {
      //获取数据库表的字段
      context.put("feilds", createBean.getBeanFeilds(tableName));
    } catch (Exception e) {
      e.printStackTrace();
    }

    try
    {
      Map sqlMap = createBean.getAutoCreateSql(tableName);
      context.put("columnDatas", createBean.getColumnDatas(tableName));
      context.put("SQL", sqlMap);
      context.put("isPseudoDelete", createBean.getIsPseudoDelete(tableName));
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }

    //根据模板文件渲染生成对应的文件
    CommonPageParser.WriterPage(context, "EntityTemplate.ftl", pckPath, beanPath);
//    CommonPageParser.WriterPage(context, "PageTemplate.ftl", pckPath, modelPath);
    CommonPageParser.WriterPage(context, "DaoTemplate.ftl", pckPath, mapperPath);
    CommonPageParser.WriterPage(context, "ServiceTemplate.ftl", pckPath, servicePath);
    CommonPageParser.WriterPage(context, "ServiceImplTemplate.ftl", pckPath, serviceImplPath);
    CommonPageParser.WriterPage(context, "MapperTemplate.xml", xmlPath, sqlMapperPath);
    CommonPageParser.WriterPage(context, "MapperTemplate2.xml", xmlPath, sqlMapper2Path);
    CommonPageParser.WriterPage(context, "ControllerTemplate.ftl", pckPath, controllerPath);
    CommonPageParser.WriterPage(context, "EntityPageTemplate.ftl", pckPath, pagePath);
//    if(isGenerateJsp){
//	    CommonPageParser.WriterPage(context, "jspTemplate.ftl", webPath, jspPath);
//	    CommonPageParser.WriterPage(context, "jsTemplate.ftl", webPath, jsPath);
//    }

    log.info("----------------------------代码生成完毕---------------------------");
  }

  public static String getProjectPath()
  {
    String path = System.getProperty("user.dir").replace("\\", "/") + "/";
    return path;
  }
  
}