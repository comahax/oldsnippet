package com.gmcc.pboss.web.resource.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.resource.com.ComDBParam;
import com.gmcc.pboss.business.resource.com.ComVO;
import com.gmcc.pboss.control.resource.com.Com;
import com.gmcc.pboss.control.resource.com.ComBO;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.infrastructure.db.SessionFactoryRouter;
import com.sunrise.jop.ui.User;

public class ComidTree implements Serializable {

	private String value;

	private String name;

	private List childs;

	private List leafs;

	public ComidTree() {

	}

	public ComidTree(String id) {
		this.value = id;
		initTree();
	}

	public void addLeaf(ComVO vo) {
		if (leafs == null) {
			leafs = new ArrayList();
		}
		leafs.add(vo);
	}

	public void addChild(ComidTree childTree) {
		if (childs == null) {
			childs = new ArrayList();
		}
		childs.add(childTree);
	}

	protected void addChildAndLeaf(ComVO vo, User user) {
		boolean flag = true;
		if (haveChilds()) {
			for (Iterator it = childs.iterator(); it.hasNext();) {
				ComidTree cTree = (ComidTree) it.next();
				if (vo.getComtype().toString().equals(cTree.getValue())) {
					cTree.addLeaf(vo);
					flag = false;
					break;
				}
			}
			if (flag) {
				ComidTree childTree = new ComidTree();
				childTree.setValue(vo.getComtype().toString());
				childTree.setName(ComidTreeHelper.getComtypeName(vo.getComtype(), user));
				childTree.addLeaf(vo);
				this.addChild(childTree);
			}
		} else {
			childs = new ArrayList();
			ComidTree childTree = new ComidTree();
			childTree.setValue(vo.getComtype().toString());
			childTree.setName(ComidTreeHelper.getComtypeName(vo.getComtype(), user));
			childTree.addLeaf(vo);
			childs.add(childTree);
		}
	}

	public List getLeafsByCityid(String cityId, String filterFlag) {
		List list = new ArrayList();
		if (haveLeafs()) {
			for (Iterator it = leafs.iterator(); it.hasNext();) {
				ComVO vo = (ComVO) it.next();
				if (SessionFactoryRouter.DB_FLAG_GD.equals(cityId) || (SessionFactoryRouter.DB_FLAG_GD.equals(vo.getCityid()) || cityId.equals(vo.getCityid()))) {
					if (!StringUtils.isBlank(filterFlag)) {
						if (ComidTreeHelper.doFilter(vo, filterFlag)) {
							list.add(vo);
						}
					} else {
						list.add(vo);
					}
				}
			}
		}
		// if (haveChilds()){
		// for (Iterator it = childs.iterator(); it.hasNext();) {
		// List leafList = ((ComidTree)it.next()).getLeafsByCityid(cityId,
		// filterFlag);
		// if (leafList != null && leafList.size() > 0){
		// ((ArrayList)leafList).trimToSize();
		// list.addAll(leafList);
		// }
		// }
		// }
		return list;
	}

	public Object getLeaf(int i) {
		if (leafsLength() > i) {
			return (Object) (leafs.get(i));
		}
		return null;
	}

	public ComVO getLeaf(String value) {
		if (haveLeafs()) {
			for (Iterator it = leafs.iterator(); it.hasNext();) {
				ComVO vo = (ComVO) it.next();
				if (vo.getComid().toString().equals(value)) {
					return vo;
				}
			}
		}
		return null;
	}

	public ComidTree getChild(String value) {
		if (haveChilds()) {
			for (Iterator it = childs.iterator(); it.hasNext();) {
				ComidTree childTree = (ComidTree) (it.next());
				if (childTree.getValue().equals(value)) {
					return childTree;
				}
			}
		}
		return null;
	}

	public Object getChild(int i) {
		if (childsLength() > i) {
			return (Object) (childs.get(i));
		}
		return null;
	}

	//	
	// public boolean containsAnyChild(List values){
	// if (values == null || values.isEmpty()){
	// return false;
	// }
	// for (Iterator it = values.iterator();it.hasNext();){
	// if (containsChild((String)it.next())){
	// return true;
	// }
	// }
	// return false;
	// }

	public boolean containsChild(String value) {
		return (getChild(value) != null) ? true : false;
	}

	private void initTree() {
		try {
			this.setName((String) ComidTreeHelper.comclassidMap.get(this.value));
			User user = new User();
			user.setCityid(CoreConfigInfo.COMMON_DB_NAME);
			ComDBParam listvo = new ComDBParam();
			Com dt = (Com) BOFactory.build(ComBO.class, user);
			listvo.set_ne_comclassid(this.value);
			listvo.set_orderby("comtype");
			listvo.set_pagesize("0");
			listvo.set_ne_comstate("1");
			DataPackage dp = dt.doQuery(listvo);
			List list = (List) dp.getDatas();
			if (list != null && list.size() > 0) {
				for (Iterator it = list.iterator(); it.hasNext();) {
					ComVO vo = (ComVO) it.next();
					this.addChildAndLeaf(vo, user);
				}
			}
			ComidTree.trim2size(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public long leafsLength() {
		return (haveLeafs() == true) ? leafs.size() : 0;
	}

	public long childsLength() {
		return (haveChilds() == true) ? childs.size() : 0;
	}

	public boolean haveChilds() {
		return (childs != null && childs.size() > 0) ? true : false;
	}

	public boolean haveLeafs() {
		return (leafs != null && leafs.size() > 0) ? true : false;
	}

	public boolean haveLeafs(String cityId, String filterFlag) {
		return this.haveLeafsWithConstraint(cityId, filterFlag);
	}

	private boolean haveLeafsWithConstraint(String cityId, String filterFlag) {
		if (haveLeafs()) {
			for (Iterator it = leafs.iterator(); it.hasNext();) {
				ComVO vo = (ComVO) it.next();
				if (SessionFactoryRouter.DB_FLAG_GD.equals(cityId) || (SessionFactoryRouter.DB_FLAG_GD.equals(vo.getCityid()) || cityId.equals(vo.getCityid()))) {
					if (!StringUtils.isBlank(filterFlag)) {
						if (ComidTreeHelper.doFilter(vo, filterFlag)) {
							return true;
						}
					} else {
						return true;
					}
				}
			}
		}
		return false;
	}

	// public boolean allHaveLeafs(){
	// if (haveLeafs()){
	// return true;
	// }
	// if (haveChilds()){
	// for (Iterator it = childs.iterator();it.hasNext();){
	// if (((ComidTree)it.next()).haveLeafs())
	// return true;
	// }
	// }
	// return false;
	// }
	//	
	// public boolean allHaveLeafs(String cityId,String filterFlag){
	// List leafs = this.getLeafsByCityid(cityId, filterFlag);
	// return (leafs != null && leafs.size() > 0)? true : false;
	// }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static void trim2size(ComidTree tree) {
		if (tree.childs != null) {
			((ArrayList) tree.childs).trimToSize();
		}
		if (tree.leafs != null) {
			((ArrayList) tree.leafs).trimToSize();
		}
		if (tree.haveChilds()) {
			for (Iterator it = tree.childs.iterator(); it.hasNext();) {
				trim2size((ComidTree) it.next());
			}
		}
	}
}
