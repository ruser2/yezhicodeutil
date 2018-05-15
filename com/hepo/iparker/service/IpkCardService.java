package .service.;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import .domain..IpkCard;
import .service.BaseService;
import .mapper..IpkCardMapper;
import .service.impl..IIpkCardService;

/**
 * 
 * <br>
 * <b>功能：</b>IpkCardServiceImpl<br>
 * <b>作者：</b>xxxxx<br>
 * <b>日期：</b> Nov 19, 2014 <br>
 * <b>版权所有： 2014，tech.7.com 第七大道<br>
 */ 
@Service("ipkCardService")
public class IpkCardServiceImpl extends BaseService<IpkCard> implements IIpkCardService{
	private final static Logger log= Logger.getLogger(IpkCardServiceImpl.class);
	

	

	@Autowired
    private IpkCardMapper mapper;

		
	public IpkCardMapper getMapper() {
		return mapper;
	}
	
	@Override
	public long insert(PriMenu record) {
		mapper.insert(record);
		return record.getId();
	}

}
