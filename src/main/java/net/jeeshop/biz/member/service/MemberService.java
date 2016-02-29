package net.jeeshop.biz.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jeeshop.biz.base.client.BaseMapper;
import net.jeeshop.biz.base.service.BaseService;
import net.jeeshop.biz.member.client.MemberMapper;
import net.jeeshop.biz.member.model.Member;
import net.jeeshop.biz.member.model.MemberExample;

@Service
public class MemberService extends BaseService<Member, MemberExample>{

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	protected BaseMapper<Member, MemberExample> getMapper() {
		return memberMapper;
	}

	
}
