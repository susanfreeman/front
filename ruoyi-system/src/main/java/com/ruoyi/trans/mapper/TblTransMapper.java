package com.ruoyi.trans.mapper;

import java.util.List;
import com.ruoyi.trans.domain.TblTrans;

/**
 * 交易流水Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public interface TblTransMapper 
{
    /**
     * 查询交易流水
     * 
     * @param ttId 交易流水主键
     * @return 交易流水
     */
    public TblTrans selectTblTransByTtId(Long ttId);

    /**
     * 查询交易流水列表
     * 
     * @param tblTrans 交易流水
     * @return 交易流水集合
     */
    public List<TblTrans> selectTblTransList(TblTrans tblTrans);

    /**
     * 新增交易流水
     * 
     * @param tblTrans 交易流水
     * @return 结果
     */
    public int insertTblTrans(TblTrans tblTrans);

    /**
     * 修改交易流水
     * 
     * @param tblTrans 交易流水
     * @return 结果
     */
    public int updateTblTrans(TblTrans tblTrans);

    /**
     * 删除交易流水
     * 
     * @param ttId 交易流水主键
     * @return 结果
     */
    public int deleteTblTransByTtId(Long ttId);

    /**
     * 批量删除交易流水
     * 
     * @param ttIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblTransByTtIds(String[] ttIds);
}
