package yc.rng.pet.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yc.rng.pet.bean.Result;
import yc.rng.pet.bean.User;
import yc.rng.pet.dao.CartDao;

@RestController
public class CartAction {
	
	@Resource
	private CartDao cdao;
	
	@RequestMapping("deleteCart")
	public Result deleteCart(int pid, HttpSession session) {
		cdao.deleteCart(pid);
		// 返回结果
		return Result.success("删除成功!");
	}
	/**
	 * 添加购物车
	 * @param pid 商品id
	 * @param count 商品数量
	 * @param session 会话对象
	 * @return
	 */
	@RequestMapping("addCart")
	public Result addCart(int pid, int count, HttpSession session) {
		// 获取当前的登录的用户
		User user = (User) session.getAttribute("loginedUser");
		// 添加购物车记录, 注意:这里没有判断,是否有添加过商品,请自行移植
		cdao.insert(user.getUid(),pid,count);
		// 返回结果
		return Result.success("添加购物车成功!");
	}
	
	/**
	 * 查询购物车
	 * @param session
	 * @return
	 */
	@RequestMapping(path="queryCart")
	public List<?> queryCart(HttpSession session){
		User user = (User) session.getAttribute("loginedUser");
		return cdao.selectCart(user.getUid());
	}

}
