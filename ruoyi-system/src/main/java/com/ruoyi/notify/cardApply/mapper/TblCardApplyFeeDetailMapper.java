package com.ruoyi.notify.cardApply.mapper;

import com.ruoyi.notify.cardApply.domain.TblCardApplyFeeDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 卡操作手续费明细通知Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-15
 */
public interface TblCardApplyFeeDetailMapper
{
    /**
     * 查询卡操作手续费明细通知
     * 
     * @param id 卡操作手续费明细通知主键
     * @return 卡操作手续费明细通知
     */
    public TblCardApplyFeeDetail selectTblCardApplyFeeDetailById(Long id);

    /**
     * 查询卡操作手续费明细通知列表
     * 
     * @param tblCardApplyFeeDetail 卡操作手续费明细通知
     * @return 卡操作手续费明细通知集合
     */
    public List<TblCardApplyFeeDetail> selectTblCardApplyFeeDetailList(TblCardApplyFeeDetail tblCardApplyFeeDetail);

    /**
     * 新增卡操作手续费明细通知
     * 
     * @param tblCardApplyFeeDetail 卡操作手续费明细通知
     * @return 结果
     */
    public int insertTblCardApplyFeeDetail(TblCardApplyFeeDetail tblCardApplyFeeDetail);

    /**
     * 修改卡操作手续费明细通知
     * 
     * @param tblCardApplyFeeDetail 卡操作手续费明细通知
     * @return 结果
     */
    public int updateTblCardApplyFeeDetail(TblCardApplyFeeDetail tblCardApplyFeeDetail);

    /**
     * 删除卡操作手续费明细通知
     * 
     * @param id 卡操作手续费明细通知主键
     * @return 结果
     */
    public int deleteTblCardApplyFeeDetailById(Long id);

    /**
     * 批量删除卡操作手续费明细通知
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblCardApplyFeeDetailByIds(String[] ids);

    void insertTblCardApplyFeeDetailBatch(@Param("tableName") String tableName, @Param("list") List<TblCardApplyFeeDetail> list);
}
