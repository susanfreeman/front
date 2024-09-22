//package com.ruoyi.agent.service.impl;
//
//import java.util.List;
//
//import cn.hutool.core.date.DateTime;
//import com.ruoyi.agent.domain.TblAgentWithdrawalRecords;
//import com.ruoyi.agent.mapper.TblAgentWithdrawalRecordsMapper;
//import com.ruoyi.agent.service.ITblAgentWithdrawalRecordsService;
//import com.ruoyi.common.utils.ShiroUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.ruoyi.common.core.text.Convert;
//
///**
// * 代理商提现Service业务层处理
// *
// * @author ruoyi
// * @date 2024-08-23
// */
//@Service
//public class TblAgentWithdrawalRecordsServiceImpl implements ITblAgentWithdrawalRecordsService
//{
//    @Autowired
//    private TblAgentWithdrawalRecordsMapper tblAgentWithdrawalRecordsMapper;
//
//    /**
//     * 查询代理商提现
//     *
//     * @param id 代理商提现主键
//     * @return 代理商提现
//     */
//    @Override
//    public TblAgentWithdrawalRecords selectTblAgentWithdrawalRecordsById(Long id)
//    {
//        return tblAgentWithdrawalRecordsMapper.selectTblAgentWithdrawalRecordsById(id);
//    }
//
//    /**
//     * 查询代理商提现列表
//     *
//     * @param tblAgentWithdrawalRecords 代理商提现
//     * @return 代理商提现
//     */
//    @Override
//    public List<TblAgentWithdrawalRecords> selectTblAgentWithdrawalRecordsList(TblAgentWithdrawalRecords tblAgentWithdrawalRecords)
//    {
//        return tblAgentWithdrawalRecordsMapper.selectTblAgentWithdrawalRecordsList(tblAgentWithdrawalRecords);
//    }
//
//    /**
//     * 新增代理商提现
//     *
//     * @param tblAgentWithdrawalRecords 代理商提现
//     * @return 结果
//     */
//    @Override
//    public int insertTblAgentWithdrawalRecords(TblAgentWithdrawalRecords tblAgentWithdrawalRecords)
//    {
//        tblAgentWithdrawalRecords.setCreatedBy(ShiroUtils.getLoginName());
//        tblAgentWithdrawalRecords.setCreatedAt(DateTime.now());
//        return tblAgentWithdrawalRecordsMapper.insertTblAgentWithdrawalRecords(tblAgentWithdrawalRecords);
//    }
//
//    /**
//     * 修改代理商提现
//     *
//     * @param tblAgentWithdrawalRecords 代理商提现
//     * @return 结果
//     */
//    @Override
//    public int updateTblAgentWithdrawalRecords(TblAgentWithdrawalRecords tblAgentWithdrawalRecords)
//    {
//        tblAgentWithdrawalRecords.setUpdatedBy(ShiroUtils.getLoginName());
//        tblAgentWithdrawalRecords.setUpdatedAt(DateTime.now());
//        return tblAgentWithdrawalRecordsMapper.updateTblAgentWithdrawalRecords(tblAgentWithdrawalRecords);
//    }
//
//    /**
//     * 批量删除代理商提现
//     *
//     * @param ids 需要删除的代理商提现主键
//     * @return 结果
//     */
//    @Override
//    public int deleteTblAgentWithdrawalRecordsByIds(String ids)
//    {
//        return tblAgentWithdrawalRecordsMapper.deleteTblAgentWithdrawalRecordsByIds(Convert.toStrArray(ids));
//    }
//
//    /**
//     * 删除代理商提现信息
//     *
//     * @param id 代理商提现主键
//     * @return 结果
//     */
//    @Override
//    public int deleteTblAgentWithdrawalRecordsById(Long id)
//    {
//        return tblAgentWithdrawalRecordsMapper.deleteTblAgentWithdrawalRecordsById(id);
//    }
//}
