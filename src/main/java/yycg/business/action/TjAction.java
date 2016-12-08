package yycg.business.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yycg.base.pojo.po.Dictinfo;
import yycg.base.pojo.vo.ActiveUser;
import yycg.base.pojo.vo.PageQuery;
import yycg.base.process.result.DataGridResultInfo;
import yycg.base.service.SystemConfigService;
import yycg.business.pojo.vo.YycgdQueryVo;
import yycg.business.pojo.vo.YycgdmxCustom;
import yycg.business.service.BusinessService;
import yycg.util.MyUtil;

/**
 * 
 * <p>
 * Title: TjAction
 * </p>
 * <p>
 * Description: 统计分析
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 苗润土
 * @date 2014年12月7日下午3:01:25
 * @version 1.0
 */
@Controller
@RequestMapping("/tj")
public class TjAction {

	@Autowired
	private SystemConfigService systemConfigService;

	@Autowired
	private BusinessService businessService;

	// 交易明细查询
	@RequestMapping("/businesslist")
	public String businesslist(Model model) throws Exception {

		// 采购状态字典
		/*List<Dictinfo> cgztlist = systemConfigService.findDictinfoByType("011");
		model.addAttribute("cgztlist", cgztlist);*/

		// 默认当前年份
		model.addAttribute("year", MyUtil.get_YYYY(MyUtil.getDate()));

		return "/business/tj/businesslist";
	}

	@RequestMapping("/businesslist_result")
	public @ResponseBody
	DataGridResultInfo businesslist_result(ActiveUser activeUser, String year,// 查询年份
			YycgdQueryVo yycgdQueryVo, int page, int rows

	) throws Exception {
		// 单位id
		String sysid = activeUser.getSysid();
		// 用户类型
		String groupid = activeUser.getGroupid();

		// 列表总数
		int total = businessService.findYybusinessCount(year, sysid, groupid,
				yycgdQueryVo);

		// 分页参数
		PageQuery pageQuery = new PageQuery();

		pageQuery.setPageParams(total, rows, page);
		// 设置分页参数
		yycgdQueryVo.setPageQuery(pageQuery);

		List<YycgdmxCustom> list = businessService.findYybusinessList(year,
				sysid, groupid, yycgdQueryVo);

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		dataGridResultInfo.setTotal(total);
		dataGridResultInfo.setRows(list);
		return dataGridResultInfo;
	}

	// 按药品统计
	@RequestMapping("/groupbyypxx")
	public String groupbyypxx(Model model) throws Exception {

		// 采购状态字典
		List<Dictinfo> cgztlist = systemConfigService.findDictinfoByType("011");
		model.addAttribute("cgztlist", cgztlist);

		// 默认当前年份
		model.addAttribute("year", MyUtil.get_YYYY(MyUtil.getDate()));

		return "/business/tj/groupbyypxx";
	}

	@RequestMapping("/groupbyypxx_result")
	public @ResponseBody
	DataGridResultInfo groupbyypxx_result(ActiveUser activeUser, String year,// 查询年份
			YycgdQueryVo yycgdQueryVo, int page, int rows

	) throws Exception {
		// 单位id
		String sysid = activeUser.getSysid();
		// 用户类型
		String groupid = activeUser.getGroupid();

		// 列表总数
		int total = businessService.findYybusinessGroupbyYpxxCount(year, sysid, groupid, yycgdQueryVo);

		// 分页参数
		PageQuery pageQuery = new PageQuery();

		pageQuery.setPageParams(total, rows, page);
		// 设置分页参数
		yycgdQueryVo.setPageQuery(pageQuery);

		List<YycgdmxCustom> list = businessService.findYybusinessGroupbyYpxxList(year, sysid, groupid, yycgdQueryVo);

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		dataGridResultInfo.setTotal(total);
		dataGridResultInfo.setRows(list);
		return dataGridResultInfo;
	}

}
