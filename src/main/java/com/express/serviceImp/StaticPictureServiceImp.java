package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.StaticPicture;
import com.express.service.BaseService;
import com.express.service.StaticPictureService;

@Service
public class StaticPictureServiceImp extends BaseService implements StaticPictureService{

	public List<StaticPicture> getPicturetList() {
		return getStaticpictureDao().getPicturetList();
	}

	public StaticPicture getById(String id) {
		return getStaticpictureDao().getById(id);
	}

	public boolean addStaticPicture(StaticPicture staticPicture) {
		return getStaticpictureDao().addStaticPicture(staticPicture);
	}

	public boolean updateStaticPicture(StaticPicture staticPicture) {
		return getStaticpictureDao().updateStaticPicture(staticPicture);
	}

	public boolean deleteStaticPicture(String id) {
		return getStaticpictureDao().deleteStaticPicture(id);
	}

}
