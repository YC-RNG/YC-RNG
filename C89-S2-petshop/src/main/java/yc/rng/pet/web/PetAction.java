package yc.rng.pet.web;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import yc.rng.pet.bean.Pets;
import yc.rng.pet.bean.Result;
import yc.rng.pet.biz.BizException;
import yc.rng.pet.biz.PetBiz;
import yc.rng.pet.dao.PetDao;

@RestController
public class PetAction {
	
	@Resource
	private PetDao petdao;
	@Resource
	private PetBiz pbiz;
	
	/**
	 * 查询热卖商品
	 * @return
	 */
	@RequestMapping("createProduct")
	public Result create(Pets p) {
		try {
			pbiz.create(p);
			return  Result.success("商品添加成功!");
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage());
		}
	}
	@RequestMapping("queryHotPet")
	public List<Pets> queryHotPet(){
		return petdao.selectPetHot();
	}
	@RequestMapping("queryNewPet")
	public List<Pets> queryNewPet(){
		return petdao.selectPetNew();
	}
	@RequestMapping("queryHotPet2")
	public List<Pets> queryHotPet2(){
		return petdao.selectPetHot2();
	}
	
	@RequestMapping("queryById")
	public Pets queryById(int pid) {
		return petdao.selectById(pid);
	}
	@RequestMapping("queryAllP")
	public List<Pets> queryAllP(){
		return petdao.selectAllP();
	}
	
	@RequestMapping("queryByCid")
	public List<Pets> queryByCid(int cid){
		return petdao.selectByCid(cid);
	}

}
