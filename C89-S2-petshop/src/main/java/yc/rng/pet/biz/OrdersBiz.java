package yc.rng.pet.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yc.rng.pet.bean.Orders;
import yc.rng.pet.dao.CartDao;
import yc.rng.pet.dao.OrderDao;
import yc.rng.pet.util.Utils;


@Service
public class OrdersBiz {

	@Resource
	private CartDao cdao;
	
	@Resource
	private OrderDao odao;
	
	@Transactional
	public void pay(Orders orders) throws BizException{

		// 验证输入值 
		Utils.checkNull(orders.getAddr(), "请填写收货地址");
		Utils.checkNull(orders.getPhone(), "请填写收货人电话");
		
		// 计算总金额
		Double total = cdao.selectTotalByUid(orders.getUid());
		orders.setTotal(total);
		
		// 写入数据库
		// 订单主表  orders
		int oid = odao.insert(orders);
		
		// 订单明细 orderitem
		orders.setOid(oid);
		odao.insertItems(orders);
		
		// 清空购物车 cart ==> uid
		cdao.deleteByUid(orders.getUid());

	}

}
