package com.ruoyi.user.service;

import java.util.List;
import com.ruoyi.user.domain.TblUserCommissionRecord;
/**
 * 用户返佣记录Service接口
 * 
 * @author ruoyi
 * @date 2024-08-27
 */
public interface ITblUserCommissionRecordService 
{
    /**
     * 查询用户返佣记录
     * 
     * @param id 用户返佣记录主键
     * @return 用户返佣记录
     */
    public TblUserCommissionRecord selectTblUserCommissionRecordById(Long id);

    /**
     * 查询用户返佣记录列表
     * 
     * @param tblUserCommissionRecord 用户返佣记录
     * @return 用户返佣记录集合
     */
    public List<TblUserCommissionRecord> selectTblUserCommissionRecordList(TblUserCommissionRecord tblUserCommissionRecord);

    /**
     * 新增用户返佣记录
     * 
     * @param tblUserCommissionRecord 用户返佣记录
     * @return 结果
     */
    public int insertTblUserCommissionRecord(TblUserCommissionRecord tblUserCommissionRecord);

    /**
     * 修改用户返佣记录
     * 
     * @param tblUserCommissionRecord 用户返佣记录
     * @return 结果
     */
    public int updateTblUserCommissionRecord(TblUserCommissionRecord tblUserCommissionRecord);

    /**
     * 批量删除用户返佣记录
     * 
     * @param ids 需要删除的用户返佣记录主键集合
     * @return 结果
     */
    public int deleteTblUserCommissionRecordByIds(String ids);

    /**
     * 删除用户返佣记录信息
     * 
     * @param id 用户返佣记录主键
     * @return 结果
     */
    public int deleteTblUserCommissionRecordById(Long id);
}
