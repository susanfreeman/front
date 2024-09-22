package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TblCardBinInfo;

/**
 * 卡bin信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-27
 */
public interface TblCardBinInfoMapper 
{
    /**
     * 查询卡bin信息
     * 
     * @param cbId 卡bin信息主键
     * @return 卡bin信息
     */
    public TblCardBinInfo selectTblCardBinInfoByCbId(Long cbId);

    /**
     * 查询卡bin信息列表
     * 
     * @param tblCardBinInfo 卡bin信息
     * @return 卡bin信息集合
     */
    public List<TblCardBinInfo> selectTblCardBinInfoList(TblCardBinInfo tblCardBinInfo);

    /**
     * 新增卡bin信息
     * 
     * @param tblCardBinInfo 卡bin信息
     * @return 结果
     */
    public int insertTblCardBinInfo(TblCardBinInfo tblCardBinInfo);

    /**
     * 修改卡bin信息
     * 
     * @param tblCardBinInfo 卡bin信息
     * @return 结果
     */
    public int updateTblCardBinInfo(TblCardBinInfo tblCardBinInfo);

    /**
     * 删除卡bin信息
     * 
     * @param cbId 卡bin信息主键
     * @return 结果
     */
    public int deleteTblCardBinInfoByCbId(Long cbId);

    /**
     * 批量删除卡bin信息
     * 
     * @param cbIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblCardBinInfoByCbIds(String[] cbIds);

    TblCardBinInfo selectTblCardBinInfoByCardNo(String cardNo);
}
