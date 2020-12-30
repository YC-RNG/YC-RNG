package yc.rng.pet.web;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yc.rng.pet.bean.Orderitem;
import yc.rng.pet.bean.Orders;
import yc.rng.pet.bean.Pets;
import yc.rng.pet.bean.Result;
import yc.rng.pet.bean.User;
import yc.rng.pet.biz.OrdersBiz;
import yc.rng.pet.dao.OrderDao;

@RestController
public class OrderAction {
	
	@Resource
	private OrderDao odao;
	
	@Resource
	private OrdersBiz obiz;
	

	
	@RequestMapping("insertOrders")
	public Result insertOrders(Orders orders, HttpSession session ,String addr,String phone) {

		try {
			User user = (User) session.getAttribute("loginedUser");
			orders.setUid(user.getUid());
			orders.setPhone(phone);
			orders.setAddr(addr); 
			obiz.pay(orders);
			return new Result(1, "提交成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, e.getMessage());		
		}
	}
	  
	/**
	 * 查询用户订单
	 * @param session
	 * @return
	 */
	@RequestMapping("queryOrders")
	public List<?> queryOrders(HttpSession session){
		User user = (User) session.getAttribute("loginedUser");
		return odao.selectOrders(user.getUid());
	}
	
	
	
	
	
	
	
	
}
