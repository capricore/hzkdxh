package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.RollingPicture;
import com.express.service.BaseService;
import com.express.service.RollingPictureService;

@Service
public class RollingPictureServiceImp extends BaseService implements RollingPictureService{

	public List<RollingPicture> getListBySequence() {
		return getRollingpictureDao().getListBySequence();
	}

	public RollingPicture getById(String id) {
		return getRollingpictureDao().getById(id);
	}

	public boolean addRollingPicture(RollingPicture rollingPicture) {
		return getRollingpictureDao().addRollingPicture(rollingPicture);
	}

	public boolean updateRollingPicture(RollingPicture rollingPicture) {
		return getRollingpictureDao().updateRollingPicture(rollingPicture);
	}

	public boolean deleteRollingPicture(String id) {
		return getRollingpictureDao().deleteRollingPicture(id);
	}


}
