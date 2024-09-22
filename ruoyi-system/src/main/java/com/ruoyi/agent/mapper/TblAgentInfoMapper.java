package com.ruoyi.agent.mapper;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.agent.domain.TblAgentInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 代理信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public interface TblAgentInfoMapper 
{
    /**
     * 查询代理信息
     * 
     * @param aiId 代理信息主键
     * @return 代理信息
     */
    public TblAgentInfo selectTblAgentInfoByAiId(Long aiId);

    /**
     * 查询代理信息列表
     * 
     * @param tblAgentInfo 代理信息
     * @return 代理信息集合
     */
    public List<TblAgentInfo> selectTblAgentInfoList(TblAgentInfo tblAgentInfo);

    /**
     * 新增代理信息
     * 
     * @param tblAgentInfo 代理信息
     * @return 结果
     */
    public int insertTblAgentInfo(TblAgentInfo tblAgentInfo);

    /**
     * 修改代理信息
     * 
     * @param tblAgentInfo 代理信息
     * @return 结果
     */
    public int updateTblAgentInfo(TblAgentInfo tblAgentInfo);

    /**
     * 删除代理信息
     * 
     * @param aiId 代理信息主键
     * @return 结果
     */
    public int deleteTblAgentInfoByAiId(Long aiId);

    /**
     * 批量删除代理信息
     * 
     * @param aiIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblAgentInfoByAiIds(String[] aiIds);

    TblAgentInfo selectTblAgentInfoByUserId(Long userId);

    TblAgentInfo selectTblAgentInfoAndLoginNameByAiId(Long aiId);

    List<TblAgentInfo> getAssociatedAgentsByUserId(Long uiId);

    TblAgentInfo selectTblAgentInfoByInviteUri(String inviteUri);

    void updateTblAgentInfoBal(@Param("supPartnerId") Long supPartnerId, @Param("profitFee")BigDecimal profitFee);
}
