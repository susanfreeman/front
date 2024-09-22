package com.ruoyi.notify.trans.service;

import com.ruoyi.notify.trans.domain.TblTransFeeDetail;

import java.util.List;

/**
 * 交易通知手续费明细Service接口
 * 
 * @author ruoyi
 * @date 2024-08-15
 */
public interface ITblTransFeeDetailService
{
    /**
     * 查询交易通知手续费明细
     * 
     * @param id 交易通知手续费明细主键
     * @return 交易通知手续费明细
     */
    public TblTransFeeDetail selectTblTransFeeDetailById(Long id);

    /**
     * 查询交易通知手续费明细列表
     * 
     * @param tblTransFeeDetail 交易通知手续费明细
     * @return 交易通知手续费明细集合
     */
    public List<TblTransFeeDetail> selectTblTransFeeDetailList(TblTransFeeDetail tblTransFeeDetail);

    /**
     * 新增交易通知手续费明细
     * 
     * @param tblTransFeeDetail 交易通知手续费明细
     * @return 结果
     */
    public int insertTblTransFeeDetail(TblTransFeeDetail tblTransFeeDetail);

    /**
     * 修改交易通知手续费明细
     * 
     * @param tblTransFeeDetail 交易通知手续费明细
     * @return 结果
     */
    public int updateTblTransFeeDetail(TblTransFeeDetail tblTransFeeDetail);

    /**
     * 批量删除交易通知手续费明细
     * 
     * @param ids 需要删除的交易通知手续费明细主键集合
     * @return 结果
     */
    public int deleteTblTransFeeDetailByIds(String ids);

    /**
     * 删除交易通知手续费明细信息
     * 
     * @param id 交易通知手续费明细主键
     * @return 结果
     */
    public int deleteTblTransFeeDetailById(Long id);

    void insertTblTransFeeDetailBatch(List<TblTransFeeDetail> list);
}
