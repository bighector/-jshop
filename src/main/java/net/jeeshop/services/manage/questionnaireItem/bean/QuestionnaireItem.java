package net.jeeshop.services.manage.questionnaireItem.bean;import java.io.Serializable;import java.util.LinkedList;import java.util.List;import net.jeeshop.core.dao.page.PagerModel;import org.apache.commons.lang.StringUtils;/** * 问卷题目对象 * @author huangf * */public class QuestionnaireItem extends PagerModel implements Serializable {	private static final long serialVersionUID = 1L;	private Long id;	private String qid;//问卷ID和题目subject双主键唯一确定一道题目。	private String subject;	private String option1;	private String type;	private int order1;	private String display;//inline：一行显示全部选项;lines:一个选项一行		private String[] optionArr;//多个选项	private List<String> optionList;//页面显示的选项列表	//	public static final String  	public void clear() {		super.clear();		id = null;		qid = null;		subject = null;		option1 = null;		type = null;		order1 = 0;		display = null;		optionArr = null;		clearList(optionList);	}		/**	 * 根据问卷ID获取多个选项对象	 * @param qid 问卷ID	 * @return	 */	public List<QuestionnaireItem> getItemList(String qid){				if(StringUtils.isBlank(qid)){			throw new NullPointerException("qid is null");		}				List<QuestionnaireItem> list = new LinkedList<QuestionnaireItem>();		for(int i=0;i<getOptionArr().length;i++){			if(StringUtils.isBlank(getOptionArr()[i])){				continue;			}						QuestionnaireItem item = new QuestionnaireItem();			item.setQid(qid);			item.setType(type);			item.setSubject(this.subject);			item.setDisplay(this.display);			item.setOption1(getOptionArr()[i]);						list.add(item);		}				return list;	}	public Long getId() {		return id;	}	public void setId(Long id) {		this.id = id;	}	public String getQid() {		return qid;	}	public void setQid(String qid) {		this.qid = qid;	}	public String getSubject() {		return subject;	}	public void setSubject(String subject) {		this.subject = subject;	}	public String getOption1() {		return option1;	}	public void setOption1(String option1) {		this.option1 = option1;	}	public String getType() {		return type;	}	public void setType(String type) {		this.type = type;	}	public String[] getOptionArr() {		return optionArr;	}	public void setOptionArr(String[] optionArr) {		this.optionArr = optionArr;	}		public List<String> getOptionList() {		return optionList;	}	public void setOptionList(List<String> optionList) {		this.optionList = optionList;	}	public int getOrder1() {		return order1;	}	public void setOrder1(int order1) {		this.order1 = order1;	}	public String getDisplay() {		return display;	}	public void setDisplay(String display) {		this.display = display;	}	@Override	public String toString() {		StringBuilder buff = new StringBuilder();		buff.append("subject="+subject+";");		buff.append("type="+type+";");		buff.append("display="+display+";");		if(optionArr!=null && optionArr.length>0){			for(int i=0;i<optionArr.length;i++){				buff.append("optionArr="+optionArr[i]+";");			}		}else{			buff.append("optionArr=null;");		}		return buff.toString();	}	}