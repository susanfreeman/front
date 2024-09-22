package com.ruoyi.agent.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.agent.mapper.TblAgentInfoMapper;
import com.ruoyi.agent.domain.TblAgentInfo;
import com.ruoyi.agent.service.ITblAgentInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 代理信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
@Service
public class TblAgentInfoServiceImpl implements ITblAgentInfoService 
{
    @Autowired
    private TblAgentInfoMapper tblAgentInfoMapper;

    /**
     * 查询代理信息
     * 
     * @param aiId 代理信息主键
     * @return 代理信息
     */
    @Override
    public TblAgentInfo selectTblAgentInfoByAiId(Long aiId)
    {
        return tblAgentInfoMapper.selectTblAgentInfoByAiId(aiId);
    }

    /**
     * 查询代理信息列表
     * 
     * @param tblAgentInfo 代理信息
     * @return 代理信息
     */
    @Override
    public List<TblAgentInfo> selectTblAgentInfoList(TblAgentInfo tblAgentInfo)
    {
        return tblAgentInfoMapper.selectTblAgentInfoList(tblAgentInfo);
    }

    /**
     * 新增代理信息
     * 
     * @param tblAgentInfo 代理信息
     * @return 结果
     */
    @Override
    public int insertTblAgentInfo(TblAgentInfo tblAgentInfo)
    {
        return tblAgentInfoMapper.insertTblAgentInfo(tblAgentInfo);
    }

    /**
     * 修改代理信息
     * 
     * @param tblAgentInfo 代理信息
     * @return 结果
     */
    @Override
    public int updateTblAgentInfo(TblAgentInfo tblAgentInfo)
    {
        return tblAgentInfoMapper.updateTblAgentInfo(tblAgentInfo);
    }

    /**
     * 批量删除代理信息
     * 
     * @param aiIds 需要删除的代理信息主键
     * @return 结果
     */
    @Override
    public int deleteTblAgentInfoByAiIds(String aiIds)
    {
        return tblAgentInfoMapper.deleteTblAgentInfoByAiIds(Convert.toStrArray(aiIds));
    }

    /**
     * 删除代理信息信息
     * 
     * @param aiId 代理信息主键
     * @return 结果
     */
    @Override
    public int deleteTblAgentInfoByAiId(Long aiId)
    {
        return tblAgentInfoMapper.deleteTblAgentInfoByAiId(aiId);
    }

    @Override
    public TblAgentInfo selectTblAgentInfoByUserId(Long userId) {
        return tblAgentInfoMapper.selectTblAgentInfoByUserId(userId);
    }

    @Override
    public TblAgentInfo selectTblAgentInfoAndLoginNameByAiId(Long aiId) {
        return tblAgentInfoMapper.selectTblAgentInfoAndLoginNameByAiId(aiId);
    }

    @Override
    public List<TblAgentInfo> getAssociatedAgentsByUserId(Long uiId) {
        return tblAgentInfoMapper.getAssociatedAgentsByUserId(uiId);
    }

    @Override
    public TblAgentInfo selectTblAgentInfoByInviteUri(String inviteUri) {
        return tblAgentInfoMapper.selectTblAgentInfoByInviteUri(inviteUri);
    }

    @Override
    public void updateTblAgentInfoBal(Long supPartnerId, BigDecimal profitFee) {
        tblAgentInfoMapper.updateTblAgentInfoBal(supPartnerId,profitFee);
    }
}
