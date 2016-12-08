package yycg.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import yycg.base.dao.mapper.UsergysMapper;
import yycg.base.dao.mapper.UserjdMapper;
import yycg.base.dao.mapper.UseryyMapper;
import yycg.base.pojo.po.Usergys;
import yycg.base.pojo.po.Userjd;
import yycg.base.pojo.po.Useryy;
import yycg.business.dao.mapper.YybusinessMapperCustom;
import yycg.business.pojo.vo.YycgdQueryVo;
import yycg.business.pojo.vo.YycgdmxCustom;
import yycg.business.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private UserjdMapper userjdMapper;

	@Autowired
	private UseryyMapper useryyMapper;

	@Autowired
	private UsergysMapper usergysMapper;

	@Autowired
	private YybusinessMapperCustom yybusinessMapperCustom;

	@Override
	public List<YycgdmxCustom> findYybusinessList(String year, String sysid,
			String groupid, YycgdQueryVo yycgdQueryVo) throws Exception {

		yycgdQueryVo = yycgdQueryVo != null ? yycgdQueryVo : new YycgdQueryVo();

		// 监管单位
		if (groupid.equals("2") || groupid.equals("1")) {
			Userjd userjd = userjdMapper.selectByPrimaryKey(sysid);
			// 监管单位的管理地区
			String dq = userjd.getDq();

			Useryy useryy = yycgdQueryVo.getUseryy();

			useryy = useryy != null ? useryy : new Useryy();
			// 设置管理地区，根据地区查询交易明细
			useryy.setDq(dq);

			yycgdQueryVo.setUseryy(useryy);
		} else if (groupid.equals("3")) {// 医院

			Useryy useryy = yycgdQueryVo.getUseryy();

			useryy = useryy != null ? useryy : new Useryy();
			// 设置医院id，只查询医院的交易明细
			useryy.setId(sysid);
			yycgdQueryVo.setUseryy(useryy);
		} else if (groupid.equals("4")) {// 供货商
			Usergys usergys = yycgdQueryVo.getUsergys();
			usergys = usergys != null ? usergys : new Usergys();
			// 设置供货商id，只查询本供货商相关交易明细
			usergys.setId(sysid);
			yycgdQueryVo.setUsergys(usergys);
		}
		// 设置年份
		yycgdQueryVo.setBusinessyear(year);

		return yybusinessMapperCustom.findYybusinessList(yycgdQueryVo);
	}

	@Override
	public int findYybusinessCount(String year, String sysid, String groupid,
			YycgdQueryVo yycgdQueryVo) throws Exception {
		yycgdQueryVo = yycgdQueryVo != null ? yycgdQueryVo : new YycgdQueryVo();

		// 监管单位
		if (groupid.equals("2") || groupid.equals("1")) {
			Userjd userjd = userjdMapper.selectByPrimaryKey(sysid);
			// 监管单位的管理地区
			String dq = userjd.getDq();

			Useryy useryy = yycgdQueryVo.getUseryy();

			useryy = useryy != null ? useryy : new Useryy();
			// 设置管理地区，根据地区查询交易明细
			useryy.setDq(dq);

			yycgdQueryVo.setUseryy(useryy);
		} else if (groupid.equals("3")) {// 医院

			Useryy useryy = yycgdQueryVo.getUseryy();

			useryy = useryy != null ? useryy : new Useryy();
			// 设置医院id，只查询医院的交易明细
			useryy.setId(sysid);
			yycgdQueryVo.setUseryy(useryy);
		} else if (groupid.equals("4")) {// 供货商
			Usergys usergys = yycgdQueryVo.getUsergys();
			usergys = usergys != null ? usergys : new Usergys();
			// 设置供货商id，只查询本供货商相关交易明细
			usergys.setId(sysid);
			yycgdQueryVo.setUsergys(usergys);
		}
		// 设置年份
		yycgdQueryVo.setBusinessyear(year);

		return yybusinessMapperCustom.findYybusinessCount(yycgdQueryVo);
	}

	@Override
	public List<YycgdmxCustom> findYybusinessGroupbyYpxxList(String year,
			String sysid, String groupid, YycgdQueryVo yycgdQueryVo)
			throws Exception {

		// 监管单位
		if (groupid.equals("2") || groupid.equals("1")) {
			Userjd userjd = userjdMapper.selectByPrimaryKey(sysid);
			// 监管单位的管理地区
			String dq = userjd.getDq();

			Useryy useryy = yycgdQueryVo.getUseryy();

			useryy = useryy != null ? useryy : new Useryy();
			// 设置管理地区，根据地区查询交易明细
			useryy.setDq(dq);

			yycgdQueryVo.setUseryy(useryy);
		} else if (groupid.equals("3")) {// 医院

			Useryy useryy = yycgdQueryVo.getUseryy();

			useryy = useryy != null ? useryy : new Useryy();
			// 设置医院id，只查询医院的交易明细
			useryy.setId(sysid);
			yycgdQueryVo.setUseryy(useryy);
		} else if (groupid.equals("4")) {// 供货商
			Usergys usergys = yycgdQueryVo.getUsergys();
			usergys = usergys != null ? usergys : new Usergys();
			// 设置供货商id，只查询本供货商相关交易明细
			usergys.setId(sysid);
			yycgdQueryVo.setUsergys(usergys);
		}
		// 设置年份
		yycgdQueryVo.setBusinessyear(year);

		return yybusinessMapperCustom
				.findYybusinessGroupbyYpxxList(yycgdQueryVo);
	}

	@Override
	public int findYybusinessGroupbyYpxxCount(String year, String sysid,
			String groupid, YycgdQueryVo yycgdQueryVo) throws Exception {
		// 监管单位
		if (groupid.equals("2") || groupid.equals("1")) {
			Userjd userjd = userjdMapper.selectByPrimaryKey(sysid);
			// 监管单位的管理地区
			String dq = userjd.getDq();

			Useryy useryy = yycgdQueryVo.getUseryy();

			useryy = useryy != null ? useryy : new Useryy();
			// 设置管理地区，根据地区查询交易明细
			useryy.setDq(dq);

			yycgdQueryVo.setUseryy(useryy);
		} else if (groupid.equals("3")) {// 医院

			Useryy useryy = yycgdQueryVo.getUseryy();

			useryy = useryy != null ? useryy : new Useryy();
			// 设置医院id，只查询医院的交易明细
			useryy.setId(sysid);
			yycgdQueryVo.setUseryy(useryy);
		} else if (groupid.equals("4")) {// 供货商
			Usergys usergys = yycgdQueryVo.getUsergys();
			usergys = usergys != null ? usergys : new Usergys();
			// 设置供货商id，只查询本供货商相关交易明细
			usergys.setId(sysid);
			yycgdQueryVo.setUsergys(usergys);
		}
		// 设置年份
		yycgdQueryVo.setBusinessyear(year);

		return yybusinessMapperCustom
				.findYybusinessGroupbyYpxxCount(yycgdQueryVo);
	}

}
