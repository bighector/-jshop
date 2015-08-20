package net.jeeshop.services.front.questionnaire.impl;import net.jeeshop.core.ServersManager;import net.jeeshop.services.front.questionnaire.QuestionnaireService;import net.jeeshop.services.front.questionnaire.bean.Questionnaire;import net.jeeshop.services.front.questionnaire.dao.QuestionnaireDao;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;@Servicepublic class QuestionnaireServiceImpl extends ServersManager<Questionnaire, QuestionnaireDao>		implements QuestionnaireService {    @Autowired    @Override    public void setDao(QuestionnaireDao questionnaireDao) {        this.dao = questionnaireDao;    }	/**	 * 新增问卷	 */	@Override	public long insert(Questionnaire e) {		if(e==null){			throw new NullPointerException("e is null");		}						return super.insert(e);	}	/**	 * 修改问卷	 */	@Override	public int update(Questionnaire e) {				return super.update(e);	}}