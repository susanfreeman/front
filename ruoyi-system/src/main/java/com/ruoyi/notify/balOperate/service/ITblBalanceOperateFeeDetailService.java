package com.ruoyi.notify.balOperate.service;

import com.ruoyi.notify.balOperate.domain.TblBalanceOperateFeeDetail;

import java.util.List;

/**
 * 资金变动手续费明细通知Service接口
 * 
 * @author ruoyi
 * @date 2024-08-15
 */
public interface ITblBalanceOperateFeeDetailService
{
    /**
     * 查询资金变动手续费明细通知
     * 
     * @param id 资金变动手续费明细通知主键
     * @return 资金变动手续费明细通知
     */
    public TblBalanceOperateFeeDetail selectTblBalanceOperateFeeDetailById(Long id);

    /**
     * 查询资金变动手续费明细通知列表
     * 
     * @param tblBalanceOperateFeeDetail 资金变动手续费明细通知
     * @return 资金变动手续费明细通知集合
     */
    public List<TblBalanceOperateFeeDetail> selectTblBalanceOperateFeeDetailList(TblBalanceOperateFeeDetail tblBalanceOperateFeeDetail);

    /**
     * 新增资金变动手续费明细通知
     * 
     * @param tblBalanceOperateFeeDetail 资金变动手续费明细通知
     * @return 结果
     */
    public int insertTblBalanceOperateFeeDetail(TblBalanceOperateFeeDetail tblBalanceOperateFeeDetail);

    /**
     * 修改资金变动手续费明细通知
     * 
     * @param tblBalanceOperateFeeDetail 资金变动手续费明细通知
     * @return 结果
     */
    public int updateTblBalanceOperateFeeDetail(TblBalanceOperateFeeDetail tblBalanceOperateFeeDetail);

    /**
     * 批量删除资金变动手续费明细通知
     * 
     * @param ids 需要删除的资金变动手续费明细通知主键集合
     * @return 结果
     */
    public int deleteTblBalanceOperateFeeDetailByIds(String ids);

    /**
     * 删除资金变动手续费明细通知信息
     * 
     * @param id 资金变动手续费明细通知主键
     * @return 结果
     */
    public int deleteTblBalanceOperateFeeDetailById(Long id);

    void insertTblBalanceOperateFeeDetailBatch(List<TblBalanceOperateFeeDetail> list);
}
