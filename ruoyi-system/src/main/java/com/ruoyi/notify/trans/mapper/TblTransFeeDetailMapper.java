package com.ruoyi.notify.trans.mapper;

import com.ruoyi.notify.trans.domain.TblTransFeeDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 交易通知手续费明细Mapper接口
 *
 * @author ruoyi
 * @date 2024-08-15
 */
public interface TblTransFeeDetailMapper {
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
     * 删除交易通知手续费明细
     *
     * @param id 交易通知手续费明细主键
     * @return 结果
     */
    public int deleteTblTransFeeDetailById(Long id);

    /**
     * 批量删除交易通知手续费明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblTransFeeDetailByIds(String[] ids);

    void insertTblTransFeeDetailBatch(@Param("tableName") String tableName, @Param("list") List<TblTransFeeDetail> list);
}
