package com.ruoyi.user.service.impl;

import com.ruoyi.user.domain.TblUserCommissionRecord;
import com.ruoyi.user.mapper.TblUserCommissionRecordMapper;
import com.ruoyi.user.service.ITblUserCommissionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

import java.util.List;

/**
 * 用户返佣记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-27
 */
@Service
public class TblUserCommissionRecordServiceImpl implements ITblUserCommissionRecordService 
{
    @Autowired
    private TblUserCommissionRecordMapper tblUserCommissionRecordMapper;

    /**
     * 查询用户返佣记录
     * 
     * @param id 用户返佣记录主键
     * @return 用户返佣记录
     */
    @Override
    public TblUserCommissionRecord selectTblUserCommissionRecordById(Long id)
    {
        return tblUserCommissionRecordMapper.selectTblUserCommissionRecordById(id);
    }

    /**
     * 查询用户返佣记录列表
     * 
     * @param tblUserCommissionRecord 用户返佣记录
     * @return 用户返佣记录
     */
    @Override
    public List<TblUserCommissionRecord> selectTblUserCommissionRecordList(TblUserCommissionRecord tblUserCommissionRecord)
    {
        return tblUserCommissionRecordMapper.selectTblUserCommissionRecordList(tblUserCommissionRecord);
    }

    /**
     * 新增用户返佣记录
     * 
     * @param tblUserCommissionRecord 用户返佣记录
     * @return 结果
     */
    @Override
    public int insertTblUserCommissionRecord(TblUserCommissionRecord tblUserCommissionRecord)
    {
        return tblUserCommissionRecordMapper.insertTblUserCommissionRecord(tblUserCommissionRecord);
    }

    /**
     * 修改用户返佣记录
     * 
     * @param tblUserCommissionRecord 用户返佣记录
     * @return 结果
     */
    @Override
    public int updateTblUserCommissionRecord(TblUserCommissionRecord tblUserCommissionRecord)
    {
        return tblUserCommissionRecordMapper.updateTblUserCommissionRecord(tblUserCommissionRecord);
    }

    /**
     * 批量删除用户返佣记录
     * 
     * @param ids 需要删除的用户返佣记录主键
     * @return 结果
     */
    @Override
    public int deleteTblUserCommissionRecordByIds(String ids)
    {
        return tblUserCommissionRecordMapper.deleteTblUserCommissionRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户返佣记录信息
     * 
     * @param id 用户返佣记录主键
     * @return 结果
     */
    @Override
    public int deleteTblUserCommissionRecordById(Long id)
    {
        return tblUserCommissionRecordMapper.deleteTblUserCommissionRecordById(id);
    }
}
