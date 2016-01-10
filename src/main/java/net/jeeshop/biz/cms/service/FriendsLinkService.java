package net.jeeshop.biz.cms.service;

import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.cms.client.FriendlinkMapper;
import net.jeeshop.biz.cms.model.Friendlink;
import net.jeeshop.biz.cms.model.FriendlinkExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by machenike on 2016/1/7.
 */
@Service
public class FriendsLinkService extends BaseService<Friendlink, FriendlinkExample> {
    @Autowired
    private   FriendlinkMapper friendsLinkMapper;
    @Override
    protected BaseMapper getMapper() {
        return friendsLinkMapper;
    }
}
