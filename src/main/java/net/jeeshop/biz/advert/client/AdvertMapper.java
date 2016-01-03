package net.jeeshop.biz.advert.client;

import java.util.List;

import net.jeeshop.biz.advert.model.Advert;
import net.jeeshop.biz.advert.model.AdvertExample;
import net.jeeshop.biz.base.client.BaseMapper;

public interface AdvertMapper extends BaseMapper<Advert, AdvertExample> {
	@Override
	int countByExample(AdvertExample example);

    @Override
	int deleteByPrimaryKey(Long id);

    @Override
	int insert(Advert record);

    @Override
	int insertSelective(Advert record);

    @Override
	List<Advert> selectByExample(AdvertExample example);

    @Override
	Advert selectByPrimaryKey(Long id);

    @Override
	int updateByPrimaryKeySelective(Advert record);

    @Override
	int updateByPrimaryKey(Advert record);
}