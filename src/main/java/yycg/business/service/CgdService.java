package yycg.business.service;

import java.util.List;

import yycg.business.pojo.po.Yycgdmx;
import yycg.business.pojo.po.Yycgdrk;
import yycg.business.pojo.vo.YycgdCustom;
import yycg.business.pojo.vo.YycgdQueryVo;
import yycg.business.pojo.vo.YycgdmxCustom;
import yycg.business.pojo.vo.YycgdrkCustom;

/**
 * 
 * <p>
 * Title: CgdService
 * </p>
 * <p>
 * Description: 采购单管理
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 苗润土
 * @date 2014年12月3日上午10:07:22
 * @version 1.0
 */
public interface CgdService {

	// 创建采购单基本信息，返回采购单id
	public String insertYycgd(String useryyid, String year,
			YycgdCustom yycgdCustom) throws Exception;

	// 根据采购单id查询采购单信息
	public YycgdCustom findYycgdById(String id) throws Exception;

	// 更新采购单基本信息
	public void updateYycgd(String id, YycgdCustom yycgdCustom)
			throws Exception;

	// 查询采购单下明细信息
	public List<YycgdmxCustom> findYycgdmxListByYycgdid(String yycgdid,
			YycgdQueryVo yycgdQueryVo) throws Exception;

	public int findYycgdmxCountByYycgdid(String yycgdid,
			YycgdQueryVo yycgdQueryVo) throws Exception;

	// 采购药品添加查询
	/**
	 * 
	 * <p>
	 * Title: findAddYycgdmxList
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param useryyid
	 *            医院id
	 * @param yycgdid
	 *            采购单id
	 * @param yycgdQueryVo
	 *            查询条件
	 * @return
	 * @throws Exception
	 */
	public List<YycgdmxCustom> findAddYycgdmxList(String useryyid,
			String yycgdid, YycgdQueryVo yycgdQueryVo) throws Exception;

	public int findAddYycgdmxCount(String useryyid, String yycgdid,
			YycgdQueryVo yycgdQueryVo) throws Exception;

	// 采购药品添加
	/**
	 * 
	 * <p>
	 * Title: insertYycgdmx
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param yycgdid
	 *            采购单id
	 * @param ypxxid
	 *            采购药品id
	 * @param usergysid
	 *            供货商id，供应此药品的供货商id
	 * @throws Exception
	 */
	public void insertYycgdmx(String yycgdid, String ypxxid, String usergysid)
			throws Exception;

	// 根据采购单id和药品id查询采购单明细
	public Yycgdmx findYycgdmxByYycgdidAndYpxxid(String yycgdid, String ypxxid)
			throws Exception;

	// 根据采购单id和药品id更新采购单明细表中采购量、采购金额
	public void updateYycgdmx(String yycgdid, String ypxxid, Integer cgl)
			throws Exception;

	// 采购单列表
	/**
	 * 
	 * <p>
	 * Title: findYycgdList
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param useryyid
	 *            医院id
	 * @param year
	 *            年份
	 * @param yycgdQueryVo
	 *            查询条件
	 * @return
	 * @throws Exception
	 */
	public List<YycgdCustom> findYycgdList(String useryyid, String year,
			YycgdQueryVo yycgdQueryVo) throws Exception;

	public int findYycgdCount(String useryyid, String year,
			YycgdQueryVo yycgdQueryVo) throws Exception;
	
	/**
	 * 
	 * <p>Title: saveYycgdSubmitStatus</p>
	 * <p>Description:采购单提交 </p>
	 * @param yycgid 采购单id
	 * @throws Exception
	 */
	public void saveYycgdSubmitStatus(String yycgdid)throws Exception;
	
	/**
	 * 
	 * <p>Title: findCheckYycgdList</p>
	 * <p>Description: </p>
	 * @param year 年份
	 * @param userjdid 监管单位id
	 * @param yycgdQueryVo 查询条件
	 * @return
	 * @throws Exception
	 */
	public List<YycgdCustom> findCheckYycgdList(String year,String userjdid,YycgdQueryVo yycgdQueryVo)throws Exception;
	public int findCheckYycgdCount(String year,String userjdid,YycgdQueryVo yycgdQueryVo)throws Exception;
	
	/**
	 * 
	 * <p>Title: saveYycgdCheckStatus</p>
	 * <p>Description: </p>
	 * @param yycgdid 采购单id
	 * @param yycgdCustom 审核信息（包括审核结果和审核意见 ）
	 * @throws Exception
	 */
	public void saveYycgdCheckStatus(String yycgdid,YycgdCustom yycgdCustom)throws Exception;
	
	/**
	 * 
	 * <p>Title: findDisposeYycgdList</p>
	 * <p>Description: </p>
	 * @param usergysid 供货商id
	 * @param year 年份
	 * @param yycgdQueryVo 查询条件
	 * @return
	 * @throws Exception
	 */
	public List<YycgdmxCustom> findDisposeYycgdList(String usergysid,String year,YycgdQueryVo yycgdQueryVo) throws Exception;
	public int findDisposeYycgdCount(String usergysid,String year,YycgdQueryVo yycgdQueryVo) throws Exception;
	
	/**
	 * 
	 * <p>Title: saveSendStatus</p>
	 * <p>Description: </p>
	 * @param yycgdid 采购单id
	 * @param ypxxid 药品id
	 * @throws Exception
	 */
	public void saveSendStatus(String yycgdid,String ypxxid)throws Exception;
	
	/**
	 * 
	 * <p>Title: findYycgdReceivceList</p>
	 * <p>Description:入库列表 </p>
	 * @param useryyid 医院id
	 * @param year年份
	 * @param yycgdQueryVo查询条件
	 * @return
	 * @throws Exception
	 */
	public List<YycgdmxCustom> findYycgdReceivceList(String useryyid,String year,YycgdQueryVo yycgdQueryVo) throws Exception;
	public int findYycgdReceivceCount(String useryyid,String year,YycgdQueryVo yycgdQueryVo) throws Exception;
	
	/**
	 * 
	 * <p>Title: saveYycgdrk</p>
	 * <p>Description:入库提交 </p>
	 * @param yycgdid 采购单id
	 * @param ypxxid药品id
	 * @param yycgdrkCustom入库信息
	 * @throws Exception
	 */
	public void saveYycgdrk(String yycgdid,String ypxxid,YycgdrkCustom yycgdrkCustom) throws Exception;
	
	/**
	 * 
	 * <p>Title: findYycgdmxListSum</p>
	 * <p>Description:采购单明细总计(采购量、采购金额) </p>
	 * @param yycgdid采购单id
	 * @param yycgdQueryVo查询条件
	 * @return
	 * @throws Exception
	 */
	public List<YycgdmxCustom> findYycgdmxListSum(String yycgdid,YycgdQueryVo yycgdQueryVo) throws Exception;
		
	
}
