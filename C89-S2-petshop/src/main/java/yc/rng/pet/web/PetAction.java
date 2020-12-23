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
	
	@RequestMapping("queryHotPet")
	public List<Pets> queryHotPet(){
		return petdao.selectPetHot();
		
	}
	

}
