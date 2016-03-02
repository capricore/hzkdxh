package com.hzkdxh.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hzkdxh.bean.Advertisement;
import com.hzkdxh.service.AdvertisementService;
import com.hzkdxh.service.BaseService;

@Service
public class AdvertisementServiceImp extends BaseService implements AdvertisementService{

	@Override
	public List<Advertisement> getAdvertisementList() {
		// TODO Auto-generated method stub
		return getAdvertisementDao().getAdvertisementList();
	}

	@Override
	public boolean addAdvertisement(Advertisement add) {
		// TODO Auto-generated method stub
		return getAdvertisementDao().addAdvertisement(add);
	}

	@Override
	public boolean updateAdvertisement(Advertisement add) {
		// TODO Auto-generated method stub
		return getAdvertisementDao().updateAdvertisement(add);
	}

	@Override
	public Advertisement getAdvertisementById(int id) {
		// TODO Auto-generated method stub
		return getAdvertisementDao().getAdvertisementById(id);
	}

	@Override
	public boolean deleteAdvertisement(int id) {
		// TODO Auto-generated method stub
		return getAdvertisementDao().deleteAdvertisement(id);
	}

}
