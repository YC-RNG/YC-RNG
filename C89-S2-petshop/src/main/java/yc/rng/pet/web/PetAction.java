package yc.rng.pet.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yc.rng.pet.bean.Pets;
import yc.rng.pet.dao.PetDao;

@RestController
public class PetAction {
	
	@Resource
	private PetDao petdao;
	
	/**
	 * 查询热卖商品
	 * @return
	 */
	@RequestMapping("queryHotPet")
	public List<Pets> queryHotPet(){
		return petdao.selectPetHot();
	}
	@RequestMapping("queryHotPet2")
	public List<Pets> queryHotPet2(){
		return petdao.selectPetHot2();
	}
	
	@RequestMapping("queryById")
	public Pets queryById(int pid) {
		return petdao.selectById(pid);
	}

}
