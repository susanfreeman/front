package com.ruoyi.agent.mapper;

import com.ruoyi.agent.domain.TblAgentWithdrawalRecords;

import java.util.List;

/**
 * 代理商提现Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-23
 */
public interface TblAgentWithdrawalRecordsMapper 
{
    /**
     * 查询代理商提现
     * 
     * @param id 代理商提现主键
     * @return 代理商提现
     */
    public TblAgentWithdrawalRecords selectTblAgentWithdrawalRecordsById(Long id);

    /**
     * 查询代理商提现列表
     * 
     * @param tblAgentWithdrawalRecords 代理商提现
     * @return 代理商提现集合
     */
    public List<TblAgentWithdrawalRecords> selectTblAgentWithdrawalRecordsList(TblAgentWithdrawalRecords tblAgentWithdrawalRecords);

    /**
     * 新增代理商提现
     * 
     * @param tblAgentWithdrawalRecords 代理商提现
     * @return 结果
     */
    public int insertTblAgentWithdrawalRecords(TblAgentWithdrawalRecords tblAgentWithdrawalRecords);

    /**
     * 修改代理商提现
     * 
     * @param tblAgentWithdrawalRecords 代理商提现
     * @return 结果
     */
    public int updateTblAgentWithdrawalRecords(TblAgentWithdrawalRecords tblAgentWithdrawalRecords);

    /**
     * 删除代理商提现
     * 
     * @param id 代理商提现主键
     * @return 结果
     */
    public int deleteTblAgentWithdrawalRecordsById(Long id);

    /**
     * 批量删除代理商提现
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblAgentWithdrawalRecordsByIds(String[] ids);
}
