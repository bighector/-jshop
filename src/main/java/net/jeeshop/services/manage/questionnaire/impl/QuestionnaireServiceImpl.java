package net.jeeshop.services.manage.questionnaire.impl;import net.jeeshop.core.ServersManager;import net.jeeshop.services.manage.questionnaire.QuestionnaireService;import net.jeeshop.services.manage.questionnaire.bean.Questionnaire;import net.jeeshop.services.manage.questionnaire.dao.QuestionnaireDao;import org.apache.commons.lang.StringUtils;import org.springframework.stereotype.Service;import javax.annotation.Resource;@Service("questionnaireServiceManage")public class QuestionnaireServiceImpl extends ServersManager<Questionnaire, QuestionnaireDao>		implements QuestionnaireService {    @Resource(name = "questionnaireDaoManage")    @Override    public void setDao(QuestionnaireDao questionnaireDao) {        this.dao = questionnaireDao;    }	/**	 * 新增问卷	 */	@Override	public long insert(Questionnaire e) {		if(e==null){			throw new NullPointerException("e is null");		}						return super.insert(e);	}	/**	 * 修改问卷	 */	@Override	public int update(Questionnaire e) {				return super.update(e);	}	@Override	public void changeStatus(Long[] ids, String questionnaireStatusY) {		if(ids==null || ids.length==0){			return;		}				for(int i=0;i<ids.length;i++){			if(ids[i] == null){				throw new NullPointerException("id不能为空！");			}						Questionnaire e = new Questionnaire();			e.setId(ids[i]);			e.setStatus(questionnaireStatusY);			dao.update(e);		}			}}