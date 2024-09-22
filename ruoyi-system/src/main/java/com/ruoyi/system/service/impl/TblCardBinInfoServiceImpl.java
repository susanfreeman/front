package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TblCardBinInfoMapper;
import com.ruoyi.system.domain.TblCardBinInfo;
import com.ruoyi.system.service.ITblCardBinInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 卡bin信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-27
 */
@Service
public class TblCardBinInfoServiceImpl implements ITblCardBinInfoService 
{
    @Autowired
    private TblCardBinInfoMapper tblCardBinInfoMapper;

    /**
     * 查询卡bin信息
     * 
     * @param cbId 卡bin信息主键
     * @return 卡bin信息
     */
    @Override
    public TblCardBinInfo selectTblCardBinInfoByCbId(Long cbId)
    {
        return tblCardBinInfoMapper.selectTblCardBinInfoByCbId(cbId);
    }

    /**
     * 查询卡bin信息列表
     * 
     * @param tblCardBinInfo 卡bin信息
     * @return 卡bin信息
     */
    @Override
    public List<TblCardBinInfo> selectTblCardBinInfoList(TblCardBinInfo tblCardBinInfo)
    {
        return tblCardBinInfoMapper.selectTblCardBinInfoList(tblCardBinInfo);
    }

    /**
     * 新增卡bin信息
     * 
     * @param tblCardBinInfo 卡bin信息
     * @return 结果
     */
    @Override
    public int insertTblCardBinInfo(TblCardBinInfo tblCardBinInfo)
    {
        return tblCardBinInfoMapper.insertTblCardBinInfo(tblCardBinInfo);
    }

    /**
     * 修改卡bin信息
     * 
     * @param tblCardBinInfo 卡bin信息
     * @return 结果
     */
    @Override
    public int updateTblCardBinInfo(TblCardBinInfo tblCardBinInfo)
    {
        return tblCardBinInfoMapper.updateTblCardBinInfo(tblCardBinInfo);
    }

    /**
     * 批量删除卡bin信息
     * 
     * @param cbIds 需要删除的卡bin信息主键
     * @return 结果
     */
    @Override
    public int deleteTblCardBinInfoByCbIds(String cbIds)
    {
        return tblCardBinInfoMapper.deleteTblCardBinInfoByCbIds(Convert.toStrArray(cbIds));
    }

    /**
     * 删除卡bin信息信息
     * 
     * @param cbId 卡bin信息主键
     * @return 结果
     */
    @Override
    public int deleteTblCardBinInfoByCbId(Long cbId)
    {
        return tblCardBinInfoMapper.deleteTblCardBinInfoByCbId(cbId);
    }

    @Override
    public TblCardBinInfo selectTblCardBinInfoByCardNo(String cardNo) {
        return tblCardBinInfoMapper.selectTblCardBinInfoByCardNo(cardNo);
    }
}
