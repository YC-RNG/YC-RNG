package yc.rng.pet.biz;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yc.rng.pet.bean.Pets;
import yc.rng.pet.dao.PetDao;
import yc.rng.pet.util.Utils;

@Service
public class PetBiz {
	
	@Resource
	private PetDao pdao;
	
	@Transactional
	public void create(Pets p) throws BizException{
		// 验证输入
		Utils.checkNull(p.getPname(), "商品名称不能为空");
		Utils.checkNull(p.getImage(), "商品图片不能为空");
		Utils.checkNull(p.getPrice(), "商品商城价不能为空");
		Utils.checkNull(p.getPdesc(), "商品描述不能为空");
		// ...其他字段请自行扩展: 2价格,图片,说明
		
		// 添加到数据库
		pdao.insert(p);
	}
	
}
