package net.jeeshop.web.action.front.questionnaire;import net.jeeshop.core.Services;import net.jeeshop.services.front.questionnaire.QuestionnaireService;import net.jeeshop.services.front.questionnaire.bean.Questionnaire;import net.jeeshop.services.front.questionnaireItem.QuestionnaireItemService;import net.jeeshop.services.front.questionnaireItem.bean.QuestionnaireItem;import net.jeeshop.web.action.front.FrontBaseController;import net.jeeshop.web.util.RequestHolder;import org.apache.commons.lang.StringUtils;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.RequestMapping;import java.io.IOException;import java.util.LinkedHashMap;import java.util.LinkedList;import java.util.List;/** * 问卷调查 * @author huangf * */@Controller("frontQuestionnaireController")@RequestMapping("questionnaire")public class QuestionnaireAction extends FrontBaseController<Questionnaire> {	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(QuestionnaireAction.class);	private static final long serialVersionUID = 1L;	@Autowired	private QuestionnaireService questionnaireService;	@Autowired	private QuestionnaireItemService questionnaireItemService;	public void setQuestionnaireItemService(			QuestionnaireItemService questionnaireItemService) {		this.questionnaireItemService = questionnaireItemService;	}		public void setQuestionnaireService(			QuestionnaireService questionnaireService) {		this.questionnaireService = questionnaireService;	}	private String getEditUrl(String id){		return "questionnaire!toEdit2.action?e.id="+id;	}	@Override	public Services<Questionnaire> getService() {		return questionnaireService;	}	/**	 * 查看问卷	 * @return	 * @throws Exception	 */	public String show(@ModelAttribute("e")Questionnaire e) throws Exception {		Long id = e.getId();				logger.error("QuestionnaireAction show id = " + id);		if(id == null){			throw new NullPointerException("问卷ID不能为空！");		}				e = questionnaireService.selectById(id);		if(e==null){			throw new NullPointerException("根据问卷ID查询不到问卷信息！");		}				//加载问卷题目列表		QuestionnaireItem qItem = new QuestionnaireItem();		qItem.setQid(e.getId());				List<QuestionnaireItem> list = questionnaireItemService.selectList(qItem);		if(list!=null && list.size()>0){			if(e.getQuestionnaireItemMap()==null){				e.setQuestionnaireItemMap(new LinkedHashMap<String, QuestionnaireItem>());			}						for(int i=0;i<list.size();i++){				QuestionnaireItem item = list.get(i);								QuestionnaireItem mapItem = e.getQuestionnaireItemMap().get(item.getSubject());				if(mapItem==null){					if(item.getOptionList()==null){						item.setOptionList(new LinkedList<String>());					}					item.getOptionList().add(item.getOption1());					e.getQuestionnaireItemMap().put(item.getSubject(),item);				}else{					mapItem.getOptionList().add(item.getOption1());//为指定的题目添加选项				}			}		}				logger.error("e.getQuestionnaireItemMap() = " + e.getQuestionnaireItemMap());		return "show";	}		/**	 * 用户提交问卷	 * @return	 * @throws IOException 	 */	public String submitQuestion() throws IOException{		logger.error("submitQuestion...");		//		getResponse().sendRedirect("success.html");//		return null;		return "SUCCESS";	}		}