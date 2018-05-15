package .controller.;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import .controller.BaseAction;
import com.road7.vrm.util.HtmlUtil;
import .entity.BaseEntity.DELETED;
import .entity..IpkCard;
import .page..IpkCardPage;
import .service..IpkCardService;
 
/**
 * 
 * <br>
 * <b>功能：</b>IpkCardController<br>
 * <b>作者：</b>Administrator<br>
 * <b>日期：</b> Wed Nov 18 10:26:26 CST 2015 <br>
 * <b>版权所有： 2014，tech.7.com<br>
 */ 
@Controller
@RequestMapping("/ipkCard") 
public class IpkCardController extends BaseAction{
	
	private final static Logger log= Logger.getLogger(IpkCardController.class);
	
	@Autowired
	private IpkCardService ipkCardService; 
	
	
	/**
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(IpkCardPage page,HttpServletRequest request) throws Exception{
		Map<String,Object>  context = getRootMap();
		return forword("//ipkCard",context); 
	}
	
	
	/**
	 * ilook 首页
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(IpkCardPage page,HttpServletResponse response) throws Exception{
		List<IpkCard> dataList = ipkCardService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public void save(IpkCard entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = new HashMap<String,Object>();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			ipkCardService.add(entity);
		}else{
			ipkCardService.update(entity);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	
	@RequestMapping("/getId")
	public void getId(String id,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = new HashMap();
		IpkCard entity  = ipkCardService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		HtmlUtil.writerJson(response, context);
	}
	
	
	
	@RequestMapping("/delete")
	public void delete(String[] id,HttpServletResponse response) throws Exception{
		ipkCardService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}

}
