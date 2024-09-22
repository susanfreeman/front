package com.ruoyi.trans.mapper;

import java.util.List;
import com.ruoyi.trans.domain.TblBalanceTrans;

/**
 * 余额变动Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public interface TblBalanceTransMapper 
{
    /**
     * 查询余额变动
     * 
     * @param btId 余额变动主键
     * @return 余额变动
     */
    public TblBalanceTrans selectTblBalanceTransByBtId(Long btId);

    /**
     * 查询余额变动列表
     * 
     * @param tblBalanceTrans 余额变动
     * @return 余额变动集合
     */
    public List<TblBalanceTrans> selectTblBalanceTransList(TblBalanceTrans tblBalanceTrans);

    /**
     * 新增余额变动
     * 
     * @param tblBalanceTrans 余额变动
     * @return 结果
     */
    public int insertTblBalanceTrans(TblBalanceTrans tblBalanceTrans);

    /**
     * 修改余额变动
     * 
     * @param tblBalanceTrans 余额变动
     * @return 结果
     */
    public int updateTblBalanceTrans(TblBalanceTrans tblBalanceTrans);

    /**
     * 删除余额变动
     * 
     * @param btId 余额变动主键
     * @return 结果
     */
    public int deleteTblBalanceTransByBtId(Long btId);

    /**
     * 批量删除余额变动
     * 
     * @param btIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblBalanceTransByBtIds(String[] btIds);

    int insertTblBalanceTransByUserBalance(TblBalanceTrans tblBalanceTrans);
}
