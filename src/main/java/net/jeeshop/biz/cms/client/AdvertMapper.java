package net.jeeshop.biz.cms.client;

import java.util.List;
import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.cms.model.Advert;
import net.jeeshop.biz.cms.model.AdvertExample;

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